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
import edu.carleton.comp.cdstore.dao.BillDAO;
import edu.carleton.comp.cdstore.dao.CustomerDAO;
import edu.carleton.comp.cdstore.dao.OrderDAO;
import edu.carleton.comp.cdstore.models.Address;
import edu.carleton.comp.cdstore.models.Bill;
import edu.carleton.comp.cdstore.models.Customer;
import edu.carleton.comp.cdstore.models.Order;

public class ConfirmAddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String account=(String) req.getSession().getAttribute("account");
		PrintWriter out=resp.getWriter();
		CustomerDAO customerdao=new CustomerDAO();
		CustomerDAO dao=new CustomerDAO();
		Customer customer=(Customer)dao.findByPrimaryKey(account);
		int userid=customer.getUserid();
		customerdao.destory();
		
		OrderDAO odao=new OrderDAO();
		List<Object> orderList=odao.getrecentorder(userid);
		int addrid=((Order)orderList.get(0)).getAddrid();
		int billid=((Order)orderList.get(0)).getBillid();
		odao.destory();
		
		AddressDAO adao=new AddressDAO();
		BillDAO bdao=new BillDAO();
		Address address= (Address) adao.findByPrimaryKey(addrid);
		Bill bill=(Bill) bdao.findByPrimaryKey(billid);
		adao.destory();
		bdao.destory();
		
		Map<String, Object> result =new HashMap<String, Object>();
		result.put("address", address);
		result.put("bill", bill);
		String result_str = JSON.toJSONString(result,SerializerFeature.DisableCircularReferenceDetect);
		out.print(result_str);
	
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
}

}
