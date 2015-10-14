package edu.carleton.comp.cdstore.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import edu.carleton.comp.cdstore.dao.CustomerDAO;
import edu.carleton.comp.cdstore.models.Customer;

	public class RegisterController extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			resp.setContentType("text/html;charset=utf-8");
			req.setCharacterEncoding("utf-8");
			String firstname = req.getParameter("firstname");
			String lastname = req.getParameter("lastname");
			String email=req.getParameter("email");
			String sex = req.getParameter("sex");
			String password = req.getParameter("password");
			
			Map<String, Object> result = new HashMap<String, Object>();
			
			PrintWriter out = resp.getWriter();
					Customer c =new Customer(password,firstname,lastname,email,sex);
					CustomerDAO cd=new CustomerDAO();
					boolean flag=cd.create(c);		
					if(flag==true){
							result.put("code", "success");
							String result_str = JSON.toJSONString(result);
							out.print(result_str);
					}else{
						result.put("code", "User Already Existed!");
						String result_str = JSON.toJSONString(result);
						out.print(result_str);    
					}

		}

		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			this.doGet(req, resp);

		}
}
