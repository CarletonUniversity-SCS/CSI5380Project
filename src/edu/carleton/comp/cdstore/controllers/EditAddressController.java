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
import com.alibaba.fastjson.serializer.SerializerFeature;

import edu.carleton.comp.cdstore.dao.AddressDAO;
import edu.carleton.comp.cdstore.dao.CustomerDAO;
import edu.carleton.comp.cdstore.dao.OrderDAO;
import edu.carleton.comp.cdstore.models.Address;
import edu.carleton.comp.cdstore.models.Customer;
import edu.carleton.comp.cdstore.models.Order;

public class EditAddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String account=(String) req.getSession().getAttribute("account");
		String fullname=req.getParameter("fullname");
		String addr1=req.getParameter("addr1");
		String addr2=req.getParameter("addr2");
		String city=req.getParameter("city");
		String province=req.getParameter("province");
		String zipcode=req.getParameter("zipcode");
		String phone=req.getParameter("phone");
		PrintWriter out=resp.getWriter();
		CustomerDAO customerdao=new CustomerDAO();
		CustomerDAO dao=new CustomerDAO();
		Customer customer=(Customer)dao.findByPrimaryKey(account);
		int userid=customer.getUserid();
		customerdao.destory();
		
		OrderDAO odao=new OrderDAO();
		List<Object> orderList=odao.getrecentorder(userid);
		int orderid=((Order)orderList.get(0)).getOrderid();
		
		Address address=new Address(fullname,addr1,addr2,city,province,zipcode,"Canada",phone,userid);
		//create new address
		AddressDAO adao=new AddressDAO();
		int addrid=adao.createandgetkey(address);
		Address addressf= (Address) adao.findByPrimaryKey(addrid);
		adao.destory();
		
		//update order
		odao.updateaddr(orderid,addrid);
		odao.destory();
		
		Map<String, Object> result =new HashMap<String, Object>();
		result.put("address", addressf);
		String result_str = JSON.toJSONString(result,SerializerFeature.DisableCircularReferenceDetect);
		out.print(result_str);
	
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
}

}
