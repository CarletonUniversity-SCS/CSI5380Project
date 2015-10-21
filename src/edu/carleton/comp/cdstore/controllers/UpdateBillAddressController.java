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
import edu.carleton.comp.cdstore.dao.BillDAO;
import edu.carleton.comp.cdstore.dao.OrderDAO;
import edu.carleton.comp.cdstore.models.Address;
import edu.carleton.comp.cdstore.models.Bill;

public class UpdateBillAddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String orderidstr=req.getParameter("orderid");
		int orderid=Integer.valueOf(orderidstr);
		String addridstr=req.getParameter("addrid");
		int addrid=Integer.valueOf(addridstr);
		Map<String, Object> result = new HashMap<String, Object>();
		PrintWriter out=resp.getWriter();
		
		AddressDAO adao=new AddressDAO();
		Address address=(Address) adao.findByPrimaryKey(addrid);
		adao.destory();
		
		Bill bill=new Bill(address.getFullname(),address.getAddrline1(),address.getAddrline2(),address.getCity(),address.getProvince(),address.getZipcode(),address.getCountry(),address.getUserid());
		//create new bill address
		BillDAO bdao=new BillDAO();
		int billid=bdao.createandgetkey(bill);
		bdao.destory();
		
		OrderDAO odao=new OrderDAO();
		odao.updatebilladdr(orderid,billid);
		odao.destory();
		
		result.put("orderid", orderid);
		result.put("billid", billid);
		
		String result_str = JSON.toJSONString(result,SerializerFeature.DisableCircularReferenceDetect);
		out.print(result_str);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
}

}
