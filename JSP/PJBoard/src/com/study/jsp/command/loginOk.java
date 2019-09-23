package com.study.jsp.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.dao.BDao;
import com.study.jsp.dao.MDao;
import com.study.jsp.dto.BDto;
import com.study.jsp.dto.MDto;


public class loginOk implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");

			String id = request.getParameter("id");
			String pw = request.getParameter("pw");

			MDao dao = new MDao();
			int checkNum = dao.userCheck(id, pw);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();

			if (checkNum == -1) {
				writer.println("<html><head></head><body>");
				writer.println("<script language=\"javascript\">");
				writer.println("	alert(\"아이디가 존재하지 않습니다.\");");
				writer.println("	history.go(-1);");
				writer.println("</script>");
				writer.println("<body></html>");
				writer.close();
			}
			HttpSession session = request.getSession();
			if (checkNum == 1) {
				MDto dto = dao.getMember(id);
				dto = dao.getMember(id);

				String name = dto.getName();
				session.setAttribute("id", id);
				session.setAttribute("name", name);
				session.setAttribute("ValidMem", "yes");

				writer.println("<html><head></head><body>");
				writer.println("<script language=\"javascript\">");
				writer.println("	document.location.href=\'list.jsp\';");
				writer.println("</script>");
				writer.println("<body></html>");
				writer.close();
			} else if (checkNum == 0) {
				writer.println("<html><head></head><body>");
				writer.println("<script language=\"javascript\">");
				writer.println("	alert(\"비밀번호가 틀립니다..\");");
				writer.println("	history.go(-1);");
				writer.println("</script>");
				writer.println("<body></html>");
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
