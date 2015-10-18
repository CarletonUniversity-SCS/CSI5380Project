package edu.carleton.comp.cdstore.cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;

import edu.carleton.comp.cdstore.dao.CDDAO;
import edu.carleton.comp.cdstore.models.CD;

public class AddToCart extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cdid=req.getParameter("cdid");
		String quantity=req.getParameter("quantity");
		String cookie=req.getParameter("aj");
		PrintWriter out = resp.getWriter();
		Map<String, String> result = new HashMap<String, String>();
		
		if(!cdid.equals("")){
		CDDAO dao=new CDDAO();
		Object cdob=dao.findByPrimaryKey(Integer.parseInt(cdid));
		CD cd=(CD) cdob;
		dao.destory();
		Cart cart = null;
		
		if(cookie!=""){
			List<Cart> cartList = JSONArray.parseArray(cookie, Cart.class);
			for(int i=0;i<cartList.size();i++){
				int oldcdid=cartList.get(i).getCdid();
				if(oldcdid==Integer.parseInt(cdid)){
					int oldq=cartList.get(i).getQuantity();
					cart=new Cart(cd.getCdid(), cd.getTitle(), cd.getArtist(), cd.getPrice(), cd.getStock(), cd.getImgurl(),oldq+Integer.parseInt(quantity));
					cartList.remove(i);
					break;
				}else{
					cart=new Cart(cd.getCdid(), cd.getTitle(), cd.getArtist(), cd.getPrice(), cd.getStock(), cd.getImgurl(),Integer.parseInt(quantity));
					
				}
			}
			cartList.add(cart);
			
			result.put("cookies", JSON.toJSONString(cartList,SerializerFeature.DisableCircularReferenceDetect));
			String result_str = JSON.toJSONString(result,SerializerFeature.DisableCircularReferenceDetect);
			out.print(result_str);

		}else{
			List<Cart> cartList =new ArrayList<Cart>();
			cart=new Cart(cd.getCdid(), cd.getTitle(), cd.getArtist(), cd.getPrice(), cd.getStock(), cd.getImgurl(),Integer.parseInt(quantity));
			cartList.add(cart);
			result.put("cookies", JSON.toJSONString(cartList,SerializerFeature.DisableCircularReferenceDetect));
			String result_str = JSON.toJSONString(result,SerializerFeature.DisableCircularReferenceDetect);
			out.print(result_str);
		}
		}

}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);

	}
}