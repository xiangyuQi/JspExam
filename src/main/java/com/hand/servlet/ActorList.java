package com.hand.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.Actor;
import com.hand.web.ActorAction;

public class ActorList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ActorAction action = new ActorAction();
	
    public ActorList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Actor> lists = action.listPage(request);
		request.setAttribute("actors", lists);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/JSP/show.jsp");
		rd.forward(request, response);
	}

}
