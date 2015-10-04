package org.carleton.comp.servlet.filters;
import java.io.*;
import java.net.URLEncoder;
import java.util.regex.Pattern;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.lang3.StringUtils;
public class SessionFilter implements Filter{
	private String sessionKey;	/*sessionkey inspect*/
	private Pattern exceptURLPattern; /*unblocked URL*/
	private String forwardURL;/*forward to this url*/
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(StringUtils.isBlank(sessionKey)){
			chain.doFilter(req, res);
			return;
		}
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) res;
		String servletPath=request.getServletPath();
		
		if(servletPath.equals(forwardURL)||exceptURLPattern.matcher(servletPath).matches()){
			chain.doFilter(req, res);
			return;
		}
		
		Object sessionObject=request.getSession().getAttribute(sessionKey);
		if(sessionObject==null){
			String contextPath=request.getContextPath();
			String redirect=servletPath+"?"+StringUtils.defaultString(request.getQueryString());
			response.sendRedirect(contextPath+StringUtils.defaultIfEmpty(forwardURL, "/")+ "?redirect=" + URLEncoder.encode(redirect, "ISO-8859-1"));
			}
		else{
			chain.doFilter(req, res);
		}
		
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		sessionKey=filterConfig.getInitParameter("sessionKey");
		String exceptURLRegex=filterConfig.getInitParameter("exceptURlRegex");
		if(!StringUtils.isBlank(exceptURLRegex)){
			exceptURLPattern=Pattern.compile(exceptURLRegex);
		}
		forwardURL=filterConfig.getInitParameter("forwardURL");
		}
	

}
