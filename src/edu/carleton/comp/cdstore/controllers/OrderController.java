package edu.carleton.comp.cdstore.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;

import edu.carleton.comp.cdstore.cookies.Cart;
import edu.carleton.comp.cdstore.dao.CDDAO;
import edu.carleton.comp.cdstore.dao.CustomerDAO;
import edu.carleton.comp.cdstore.dao.ItemDAO;
import edu.carleton.comp.cdstore.dao.OrderDAO;
import edu.carleton.comp.cdstore.dao.ShippingDAO;
import edu.carleton.comp.cdstore.dao.TaxDAO;
import edu.carleton.comp.cdstore.models.Customer;
import edu.carleton.comp.cdstore.models.Item;
import edu.carleton.comp.cdstore.models.Order;
import edu.carleton.comp.cdstore.models.Shipping;
import edu.carleton.comp.cdstore.models.Tax;


public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int requesttime=0;
		requesttime=Integer.parseInt(req.getParameter("requesttime"));
		
		
		
		String cjson=req.getParameter("cjson");
		String account=(String) req.getSession().getAttribute("account");
		PrintWriter out=resp.getWriter();
		
		int shipid=Integer.parseInt(req.getParameter("shipping"));
		ShippingDAO shipdao =new ShippingDAO();
		Shipping shipping=(Shipping)(shipdao.findByPrimaryKey(shipid));
		shipdao.destory();
		float shippingfee=shipping.getPrice();
		String method=shipping.getMethod();
		
		TaxDAO taxdao=new TaxDAO();
		Tax tax=(Tax)(taxdao.findByPrimaryKey(1));
		taxdao.destory();
		float taxrate=tax.getTaxrate();
		
		CustomerDAO customerdao=new CustomerDAO();
		CustomerDAO dao=new CustomerDAO();
		Customer customer=(Customer)dao.findByPrimaryKey(account);
		int userid=customer.getUserid();
		customerdao.destory();


		List <Cart> successfulone=new ArrayList<Cart>();
		List<Cart> unsuccessfulone=new ArrayList<Cart>();
		//generate output
		Map<String, Object> result =new HashMap<String, Object>();
		if(requesttime==5){
			result.put("errormessage", String.valueOf("request reaches 5"));
			String result_str = JSON.toJSONString(result,SerializerFeature.DisableCircularReferenceDetect);
			out.print(result_str);
			//reset requesttime into 0; 
		}else{
		float sum=0;
		if(cjson!=""){
			List<Cart> cartList = JSONArray.parseArray(cjson, Cart.class);
			for(int i=0;i<cartList.size();i++){
				if(this.checkstock(cartList.get(i))){
					successfulone.add(cartList.get(i));
					sum+=(cartList.get(i).getPrice())*(cartList.get(i).getQuantity());
				}
				else
				{
					unsuccessfulone.add(cartList.get(i));
				}
			
			}
		}
		
		float total=(sum*(1+taxrate))+shippingfee;
		float taxtopay=sum*taxrate;
		//crate order in datebase
		
		/*setting format for the timestamp*/
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS",Locale.ENGLISH);
		/*partially ignore the input format*/
		dateFormat.setLenient(false);   
		String date=dateFormat.format(new Date());
		Order order;
		int orderid=0;
		OrderDAO orderdao=new OrderDAO();
		order=new Order(date, "1", total, userid,0,0,shipid,1);
		orderid=orderdao.createandgetkeynull(order);
		orderdao.destory();
		//create item;
		if(orderid<0){
			System.out.println("error");
		}
		else
		{
			//create items and update stock
			for(int i=0;i<successfulone.size();i++){
				ItemDAO itemdao=new ItemDAO();
				Item item=new Item(successfulone.get(i).getQuantity(), orderid, successfulone.get(i).getCdid());
				itemdao.create(item);
				itemdao.destory();
				CDDAO cddao1=new CDDAO();
				//update stock
				int cdid=successfulone.get(i).getCdid();
				int orign=cddao1.getstock(cdid);
				int newstock=orign-successfulone.get(i).getQuantity();
				cddao1.updatestock(newstock, cdid);
				cddao1.destory();
			}
		}
		//fomat output
		BigDecimal sumb=new BigDecimal(sum);  
		double sumf=sumb.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		BigDecimal taxtopayb=new BigDecimal(taxtopay);  
		double taxtopayf=taxtopayb.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		BigDecimal totalb=new BigDecimal(total);  
		double totalf=totalb.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		BigDecimal shippingfeeb=new BigDecimal(shippingfee);  
		double shippingfeef=shippingfeeb.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		BigDecimal subtotalb=new BigDecimal(total-shippingfee);  
		double subtotalf=subtotalb.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		
	
		result.put("successfulpaymentcartlist", successfulone);
		result.put("beforetax", String.valueOf(sumf));
		result.put("HST", String.valueOf(taxtopayf));
		result.put("total", String.valueOf(totalf));
		result.put("shippingfee", String.valueOf(shippingfeef));
		result.put("method", method);
		result.put("subtotal", String.valueOf(subtotalf));
		result.put("orderid", orderid);
		result.put("userid", String.valueOf(userid));
		result.put("unsuccessfulpaymentcartlist", unsuccessfulone);
		String result_str = JSON.toJSONString(result,SerializerFeature.DisableCircularReferenceDetect);
		out.print(result_str);
		}
	}

	private Boolean checkstock(Cart cart){
		int cdid=cart.getCdid();
		CDDAO cddao=new CDDAO();
		int orginstock=cddao.getstock(cdid);
		cddao.destory();
		int sold=cart.getQuantity();
		if(orginstock-sold<0){
			return false;
		}
		else
			return true;
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
	}

}
