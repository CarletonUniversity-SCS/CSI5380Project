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

import edu.carleton.comp.cdstore.dao.CDDAO;

public class GetProductListController extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		Map<String, Object> result = new HashMap<String, Object>();
		PrintWriter out = resp.getWriter();
		
		String menu=req.getParameter("menu");
		String content=req.getParameter("content");
		String key=req.getParameter("key");
		
		CDDAO dao=new CDDAO();
		if(content!="" && key!="" && menu!=""){
			//advanced search and by order
			List<Object> cdList=dao.advancesearch(menu,content,key);
			dao.destory();
			result.put("cdList", cdList);
			String result_str = JSON.toJSONString(result);
			out.print(result_str);
		}else if(content!="" && key=="" && menu!=""){
			//only advanced search
			List<Object> cdList=dao.advancesearch(content,menu);
			dao.destory();
			result.put("cdList", cdList);
			String result_str = JSON.toJSONString(result);
			out.print(result_str);
		}else if(content=="" && key!="" && menu!=""){
			//advanced query by order
			List<Object> cdList=dao.findorderbymenu(menu,key);
			dao.destory();
			result.put("cdList", cdList);
			String result_str = JSON.toJSONString(result);
			out.print(result_str);
			
		}else if(content=="" && key=="" && menu!=""){
			//normal query by menu and order by title
			List<Object> cdList=dao.findbymenu(menu);
			dao.destory();
			result.put("cdList", cdList);
			String result_str = JSON.toJSONString(result);
			out.print(result_str);
		}else if (menu=="" && content=="" && key!=""){
			//query all order by key on index
			List<Object> cdList=dao.findorderall(key);
			dao.destory();
			result.put("cdList", cdList);
			String result_str = JSON.toJSONString(result);
			out.print(result_str);
		}else if (menu=="" && content!="" && key==""){
			//search all by content on index
			List<Object> cdList=dao.defaultsearch(content);
			dao.destory();
			result.put("cdList", cdList);
			String result_str = JSON.toJSONString(result);
			out.print(result_str);
		}
			
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			this.doGet(req, resp);

}

}
