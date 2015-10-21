package edu.carleton.comp.cdstore.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import edu.carleton.comp.cdstore.dao.AddressDAO;
import edu.carleton.comp.cdstore.dao.OrderDAO;
import edu.carleton.comp.cdstore.models.Address;

public class AddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String orderidstr=req.getParameter("orderid");
			int orderid=Integer.valueOf(orderidstr);
			String useridstr=req.getParameter("userid");
			int userid=Integer.valueOf(useridstr);
			String fullname=req.getParameter("fullname");
			String addr1=req.getParameter("addr1");
			String addr2=req.getParameter("addr2");
			String city=req.getParameter("city");
			String province=req.getParameter("province");
			String zipcode=req.getParameter("zipcode");
			String phone=req.getParameter("phone");
			Map<String, Object> result = new HashMap<String, Object>();
			PrintWriter out=resp.getWriter();
			
			Address address=new Address(fullname,addr1,addr2,city,province,zipcode,"Canada",phone,userid);
			//create new address
			AddressDAO adao=new AddressDAO();
			int addrid=adao.createandgetkey(address);
			adao.destory();
			
			//update order
			OrderDAO odao=new OrderDAO();
			odao.updateaddr(orderid,addrid);
			odao.destory();
			
			result.put("orderid", orderid);
			result.put("addrid", addrid);
			
			String result_str = JSON.toJSONString(result,SerializerFeature.DisableCircularReferenceDetect);
			out.print(result_str);
	
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
}

}
