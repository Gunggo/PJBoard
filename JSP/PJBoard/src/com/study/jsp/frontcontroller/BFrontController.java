package com.study.jsp.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.command.BCommand;
import com.study.jsp.command.BContentCommand;
import com.study.jsp.command.BDeleteCommand;
import com.study.jsp.command.BListCommand;
import com.study.jsp.command.BModifyCommand;
import com.study.jsp.command.BReplyCommand;
import com.study.jsp.command.BReplyViewCommand;
import com.study.jsp.command.BWriteCommand;
import com.study.jsp.command.joinOk;
import com.study.jsp.command.loginOk;
import com.study.jsp.command.modifyOk;

@WebServlet("*.bo")
public class BFrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BFrontController() {
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
        System.out.println(com);

        if (com.equals("/write_view.bo")) {
            viewPage = "write_view.jsp";
        } else if (com.equals("/write.bo")) {
            command = new BWriteCommand();
            command.execute(request, response);
            viewPage = "list.bo";
        } else if (com.equals("/list.bo")) {
            command = new BListCommand();
            command.execute(request, response);
            viewPage = "list.jsp";
        } else if (com.equals("/content_view.bo")) {
            command = new BContentCommand();
            command.execute(request, response);
            viewPage = "content_view.jsp";
        } else if (com.equals("/modify_view.bo")) {
            command = new BContentCommand();
            command.execute(request, response);
            viewPage = "modify_view.jsp";
        } else if (com.equals("/modify.bo")) {
            command = new BModifyCommand();
            command.execute(request, response);

            command = new BContentCommand();
            command.execute(request, response);
            viewPage = "content_view.jsp";
        } else if (com.equals("/delete.bo")) {
            command = new BDeleteCommand();
            command.execute(request, response);
            viewPage = "list.bo";
        } else if (com.equals("/reply_view.bo")) {
            command = new BReplyViewCommand();
            command.execute(request, response);
            viewPage = "reply_view.jsp";
        } else if (com.equals("/reply.bo")) {
            command = new BReplyCommand();
            command.execute(request, response);
            viewPage = "list.bo";
        }

        if (viewPage != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
            dispatcher.forward(request, response);
        }
    }
}
