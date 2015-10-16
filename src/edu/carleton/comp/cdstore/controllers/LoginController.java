package edu.carleton.comp.cdstore.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import edu.carleton.comp.cdstore.dao.CustomerDAO;
import edu.carleton.comp.cdstore.models.Customer;

public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CustomerDAO dao=new CustomerDAO();
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		session.setMaxInactiveInterval(7200);	
		PrintWriter out = resp.getWriter();		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Map<String, Object> result = new HashMap<String, Object>();
		String result_str;
		Customer customer=(Customer)dao.findByPrimaryKey(email);
		dao.destory();
		if(customer==null){
			result.put("code", "Invalid account!");
			result_str = JSON.toJSONString(result);
			out.print(result_str);
		}else if(!password.equals(customer.getPassword())){
			result.put("code", "Invalid Password. Please try again!");
			result_str = JSON.toJSONString(result);
			out.print(result_str);
		}else{
		result.put("code", "success");
		result_str = JSON.toJSONString(result);
		out.print(result_str);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);

	}
}
