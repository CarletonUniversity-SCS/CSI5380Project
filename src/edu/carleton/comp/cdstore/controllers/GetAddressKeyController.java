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

import edu.carleton.comp.cdstore.dao.AddressDAO;

public class GetAddressKeyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String addridstr=req.getParameter("addrid");
		int addrid=Integer.valueOf(addridstr);
		Map<String, Object> result = new HashMap<String, Object>();
		PrintWriter out = resp.getWriter();
		
		AddressDAO adao=new AddressDAO();
		Object address=adao.findByPrimaryKey(addrid);
		adao.destory();
		result.put("address", address);
		String result_str = JSON.toJSONString(result);
		out.print(result_str);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
}

}
