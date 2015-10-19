package edu.carleton.comp.cdstore.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;

import edu.carleton.comp.cdstore.cookies.Cart;
import edu.carleton.comp.cdstore.dao.AddressDAO;
import edu.carleton.comp.cdstore.dao.BillDAO;
import edu.carleton.comp.cdstore.dao.CDDAO;
import edu.carleton.comp.cdstore.dao.CustomerDAO;
import edu.carleton.comp.cdstore.models.CD;
import edu.carleton.comp.cdstore.models.Customer;


public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cjson=req.getParameter("cjson");
		String account=(String)req.getSession().getAttribute("Account");
		PrintWriter out=resp.getWriter();
		
		CustomerDAO customerdao=new CustomerDAO();
		Customer customer=(Customer)(customerdao.findByPrimaryKey(account));
		int userid=customer.getUserid();
		customerdao.destory();
		AddressDAO addressdao=new AddressDAO();
		int addrid=addressdao.getaddrid(userid);
		addressdao.destory();
		BillDAO billdao=new BillDAO();
		int billid=billdao.getbillid(userid);
		billdao.destory();
		/*setting format for the timestamp*/
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS",Locale.ENGLISH);
		/*partially ignore the input format*/
		dateFormat.setLenient(false);   
		Map<String, Object> result =new HashMap<String, Object>();		
		if(cjson!=""){
			List<Cart> cartList = JSONArray.parseArray(cjson, Cart.class);
			for(int i=0;i<cartList.size();i++){
			if(this.checkstock(cartList.get(i), userid)){
				Timestamp date=new java.sql.Timestamp(new Date().getTime());
			}
			else
			{
				
			}
			
			}
		}
		
		
	}

	private Boolean checkstock(Cart cart, int userid){
		int cdid=cart.getCdid();
		CDDAO cddao=new CDDAO();
		CD cd=(CD)(cddao.findByPrimaryKey(cdid));
		int orginstock=cd.getStock();
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
