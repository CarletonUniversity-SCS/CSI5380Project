package edu.carleton.comp.cdstore.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.carleton.comp.cdstore.dao.CustomerDAO;
import edu.carleton.comp.cdstore.models.Customer;

public class LoginController extends HttpServlet{

	/**
	 * 
	 */
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
		Customer customer=(Customer)dao.findByPrimaryKey(email);
		if(customer!=null){
			if(customer.getPassword().equals(password)){
				session.setAttribute("email", email);
				String result="{code:Login Successs!}";
				out.println(result);
			} else {
				String result="{code:incorrect account or password!}";
				out.println(result);
			}
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);

	}
}
