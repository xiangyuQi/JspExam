package com.hand.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.Actor;
import com.hand.entity.Film;
import com.hand.web.FilmAction;

/**
 * Servlet implementation class FilmList
 */
public class FilmList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FilmAction action = new FilmAction();
    public FilmList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Film> lists = action.listPage(request);
		request.setAttribute("films", lists);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/filmList.jsp");
		rd.forward(request, response);
	}

}
