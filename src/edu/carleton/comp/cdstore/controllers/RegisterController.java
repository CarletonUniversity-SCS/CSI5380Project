package edu.carleton.comp.cdstore.controllers;

import java.io.IOException;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.carleton.comp.cdstore.dao.CustomerDAO;
import edu.carleton.comp.cdstore.models.Customer;

	public class RegisterController extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			resp.setContentType("text/html;charset=utf-8");
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
//			String firstname = req.getParameter("firstname");
//			String lastname = req.getParameter("lastname");
//			String email=req.getParameter("email");
//			String sex = req.getParameter("sex");
//			String password = req.getParameter("password");
//			String repassword = req.getParameter("repassword");
			
			String firstname="wenqian";
			String lastname="wang";
			String email="wenqianwang@yahoo.com";
			String sex="male";
			String password="123";
			String repassword="123";
			
			PrintWriter out = resp.getWriter();
			

				if (password.equals(repassword)){
					Customer c =new Customer(password,firstname,lastname,email,sex);
					CustomerDAO cd=new CustomerDAO();
					boolean flag=cd.create(c);
					
					if(flag==true){
							String result="{code:Successs!}";
							out.println(result);
						
					}else{
						    String result="{code:User Already Existed!}";
							out.println(result);
					}
				
				}else{
					resp.setContentType("text/html;charset=UTF-8");
					String result="{code:Password Not Match£¡}";
					out.print(result);
				}

		}

		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			this.doGet(req, resp);

		}
}
