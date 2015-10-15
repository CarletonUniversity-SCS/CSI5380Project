package edu.carleton.comp.cdstore.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//HttpSession session=req.getSession();
		//session.setMaxInactiveInterval(7200);	
		PrintWriter out = resp.getWriter();		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Customer customer=(Customer)dao.findByPrimaryKey(email);
		dao.destory();
		if(customer==null){
			String result="{code:Invalid account!}";
			out.println(result);
		}
		if(!password.equals(customer.getPassword())){
		String result="{code: Invalid Password. Please try again!}";	
			out.println(result);
		}
		String result="{code: Login Success!}";
		//session.setAttribute("account", email);;
		out.println(result);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);

	}
}
