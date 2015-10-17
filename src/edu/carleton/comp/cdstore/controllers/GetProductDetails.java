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

import edu.carleton.comp.cdstore.dao.CDDAO;
import edu.carleton.comp.cdstore.dao.CategoryDAO;
import edu.carleton.comp.cdstore.models.CD;
import edu.carleton.comp.cdstore.models.Category;

public class GetProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		Map<String, Object> result=new HashMap<String,Object>();
		int cdid=Integer.parseInt(req.getParameter("cdid"));
		CDDAO dao=new CDDAO();
		CD cd=(CD)(dao.findByPrimaryKey(cdid));
		dao.destory();
		CategoryDAO dao1=new CategoryDAO();
		Category cate=(Category)(dao1.findByPrimaryKey(cd.getCateid()));
		dao1.destory();
		Object[] cdfinal={cd.getCdid(),cd.getTitle(),cd.getArtist(),cd.getDate(),cd.getIntro(),cd.getPrice(),cd.getStock(),cd.getImgurl(),cate.getCatename()};
		result.put("result", cdfinal);
		String result_str=JSON.toJSONString(result);
		out.print(result_str);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
