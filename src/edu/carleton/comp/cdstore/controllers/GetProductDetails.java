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
import edu.carleton.comp.cdstore.models.CD;

/**
 * Servlet implementation class GetProductDetails
 */
/*@WebServlet("/GetProductDetails")*/
public class GetProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  /*  public GetProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }
    	
    */
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		Map<String, Object> result=new HashMap<String,Object>();
		int cdid=Integer.parseInt(req.getParameter("cdid"));
		CDDAO dao=new CDDAO();
		CD cd=(CD)(dao.findByPrimaryKey(cdid));
		result.put("productdetail", cd);
		dao.destory();
		String result_str=JSON.toJSONString(result);
		out.print(result_str);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
