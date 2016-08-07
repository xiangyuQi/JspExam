package com.hand.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session =httpRequest.getSession();
		String context = httpRequest.getServletPath();
		Object obj  = session.getAttribute("user");
		if(context!=null &&context.equals("/index.jsp") ||context.equals("/login.jsp")||
				context.equals("/LoginServlet")
				){
				chain.doFilter(request, response);
		}else if(obj !=null){
			chain.doFilter(request, response);
		}else{
			request.setAttribute("msg", "您尚未登录,请登录后操作");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(httpRequest, httpResponse);
		}
		
		

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
