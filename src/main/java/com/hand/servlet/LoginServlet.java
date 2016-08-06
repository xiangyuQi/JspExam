package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.service.CustomerService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomerService service = new CustomerService();
	
    public LoginServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		RequestDispatcher rd = null;
		String forward = "";
		if(name !=null){
			if(service.existUser(name)){
				forward = "index.jsp";
			}else{
				request.setAttribute("msg", "用户不存在，请重新输入");
				forward = "login.jsp";
			}
		}else{
			request.setAttribute("msg", "用户名不能为空！");
			forward = "login.jsp";
		}
		rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
