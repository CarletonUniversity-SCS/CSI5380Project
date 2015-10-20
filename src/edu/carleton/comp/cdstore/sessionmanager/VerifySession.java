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


public class VerifySession extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		PrintWriter out=resp.getWriter();
		String email=(String)session.getAttribute("account");
		Map<String, Object> result=new HashMap<String,Object>();
		if(email!=null){
		result.put("code","yes");
		String resultstring=JSON.toJSONString(result);
		out.print(resultstring);	
		}else{
			result.put("code","no");
			String resultstring=JSON.toJSONString(result);
			out.print(resultstring);
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
