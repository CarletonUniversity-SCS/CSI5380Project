package edu.carleton.comp.cdstore.cookies;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class CookieController extends HttpServlet  {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cjson=req.getParameter("cjson");
		PrintWriter out = resp.getWriter();
		Map<String, String> result = new HashMap<String, String>();
		
		if(cjson!=""){
			List<Cart> cartList = JSONArray.parseArray(cjson, Cart.class);
			float p=0;
			int q=0;
			int tq=0;
			float s=0;
			float t=0;
			for(int i=0;i<cartList.size();i++){
				q=cartList.get(i).getQuantity();
				p=cartList.get(i).getPrice();
				tq=q+tq;
				s=p*q;
				t=t+s;	
			}
			result.put("totalprice", String.valueOf(t));
			result.put("quantity",String.valueOf(tq));
			String result_str = JSON.toJSONString(result,SerializerFeature.DisableCircularReferenceDetect);
			out.print(result_str);

		}else{
			result.put("totalprice","0.0");
			result.put("quantity","0");
			String result_str = JSON.toJSONString(result,SerializerFeature.DisableCircularReferenceDetect);
			out.print(result_str);
		}

		    
		    

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);

	}
}
