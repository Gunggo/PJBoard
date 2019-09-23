package com.study.jsp.frontcontroller;

import com.study.jsp.command.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("*.mo")
public class MFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MFrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String viewPage = null;
		BCommand command = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		// 조인
		if (com.equals("/loginOk.mo")) {
			command = new loginOk();
			command.execute(request, response);
		} else if (com.equals("/joinOk.mo")) {
			command = new joinOk();
			command.execute(request, response);
			viewPage = "login.jsp";
		} else if (com.equals("/modifyOk.mo")) {
			command = new modifyOk();
			command.execute(request, response);
			viewPage = "main.jsp";
		} else if (com.equals("/logout.mo")) {
			logout(request, response);
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");

			response.setContentType("text/html; charset=UTF-8");
			HttpSession session = request.getSession();

			session.invalidate();
			response.sendRedirect("login.jsp");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
