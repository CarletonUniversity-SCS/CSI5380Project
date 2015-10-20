package edu.carleton.comp.cdstore.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;

import edu.carleton.comp.cdstore.cookies.Cart;
import edu.carleton.comp.cdstore.dao.ShippingDAO;
import edu.carleton.comp.cdstore.models.Shipping;

public class GetPriceDetailsController extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		Map<String, Object> result = new HashMap<String, Object>();
		PrintWriter out = resp.getWriter();
		
		String cjson=req.getParameter("cjson");
		String shipidstr=req.getParameter("shipping");
		Integer shipid=Integer.valueOf(shipidstr);
		
		List<Cart> cartList = JSONArray.parseArray(cjson, Cart.class);
		float p=0;
		int q=0;
		int tq=0;
		float s=0;
		float t=0;
		for(int i=0;i<cartList.size();i++){
			q=cartList.get(i).getQuantity();
			p=cartList.get(i).getPrice();
			tq=q+tq;
			s=p*q;
			t=t+s;	
		}
		
		ShippingDAO dao=new ShippingDAO();
		Object shipping=dao.findByPrimaryKey(shipid);
		Shipping ship=(Shipping) shipping;
		BigDecimal priceb=new BigDecimal(ship.getPrice());  
		double pricef=priceb.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		BigDecimal tb=new BigDecimal(t);  
		double tf=tb.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		BigDecimal taxb=new BigDecimal(t*0.13);  
		double tax=taxb.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		BigDecimal subtotalb=new BigDecimal(t+tax);  
		double subtotal=subtotalb.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		BigDecimal totalfeeb=new BigDecimal(t+tax+ship.getPrice());  
		double totalfee=totalfeeb.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		dao.destory();
		
		result.put("purchase", String.valueOf(tf));
		result.put("tax",String.valueOf(tax));
		result.put("subtotal",String.valueOf(subtotal));
		result.put("shippingfee",String.valueOf(pricef));
		result.put("totalfee",String.valueOf(totalfee));
		String result_str = JSON.toJSONString(result,SerializerFeature.DisableCircularReferenceDetect);
		out.print(result_str);
		

		
		
		
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			this.doGet(req, resp);

}

}
