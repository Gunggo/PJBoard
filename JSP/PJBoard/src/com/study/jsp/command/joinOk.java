package com.study.jsp.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.dao.BDao;
import com.study.jsp.dto.BDto;

public class joinOk implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String eMail = request.getParameter("eMail");
			String address = request.getParameter("address");

			BDao dao = new BDao();
			BDto dto = new BDto();

			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.seteMail(eMail);
			dto.setAddress(address);
			dto.setrDate(new Timestamp(System.currentTimeMillis()));

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();

			if (dao.confirmId(dto.getId()) == BDao.MEMBER_EXISTENT) {
				writer.println("<html><head></head><body>");
				writer.println("<script language=\"javascript\">");
				writer.println("	alert(\"아이디가 이미 존재 합니다.\");");
				writer.println("	history.back();");
				writer.println("</script>");
				writer.println("<body></html>");
				writer.close();
			} else {
				int ri = dao.insertMember(dto);
				if (ri == BDao.MEMBER_JOIN_SUCCESS) {
					HttpSession session = request.getSession();
					session.setAttribute("id", dto.getId());

					writer.println("<html><head></head><body>");
					writer.println("<script language=\"javascript\">");
					writer.println("	alert(\"회원가입을 축하 합니다..\");");
					writer.println("	document.location.href=\"login.jsp\");");
					writer.println("</script>");
					writer.println("<body></html>");
					writer.close();
				} else {
					writer.println("<html><head></head><body>");
					writer.println("<script language=\"javascript\">");
					writer.println("	alert(\"회원가입에 실패했습니다..\");");
					writer.println("	document.location.href=\"login.jsp\");");
					writer.println("</script>");
					writer.println("<body></html>");
					writer.close();
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
