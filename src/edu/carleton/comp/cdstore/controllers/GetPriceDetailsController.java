package edu.carleton.comp.cdstore.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
		float price=ship.getPrice();
		float tax=(float) (t*0.13);
		float subtotal=t+tax;
		dao.destory();
		
		result.put("purchase", String.valueOf(t));
		result.put("tax",String.valueOf(tax));
		result.put("subtotal",String.valueOf(subtotal));
		result.put("shippingfee",String.valueOf(price));
		result.put("totalfee",String.valueOf(subtotal+price));
		String result_str = JSON.toJSONString(result,SerializerFeature.DisableCircularReferenceDetect);
		out.print(result_str);
		

		
		
		
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			this.doGet(req, resp);

}

}
