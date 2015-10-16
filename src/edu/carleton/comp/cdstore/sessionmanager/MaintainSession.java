package edu.carleton.comp.cdstore.sessionmanager;

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

public class MaintainSession extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		PrintWriter out=resp.getWriter();
		String email=(String)session.getAttribute("account");
		if(email!=null){
		CustomerDAO dao=new CustomerDAO();
		Customer customer=(Customer)dao.findByPrimaryKey(email);
		Map<String, Object> result=new HashMap<String,Object>();
		result.put("account",customer);
		String resultstring=JSON.toJSONString(result);
		out.print(resultstring);	
		}else{
			out.print("null");
		}
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);

	}

}
