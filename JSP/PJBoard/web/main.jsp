<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--<%--%>
<%--    if (session.getAttribute("ValidMem") == null) {--%>
<%--%>--%>
<%--<jsp:forward page="login.jsp"/>--%>
<%
//    }

    String name = (String) session.getAttribute("name");
    String id = (String) session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Insert title here</title>
    <link rel="stylesheet" href="default.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        .wrap {
            position: relative;
            overflow: hidden;
            background-color: #f2f4f7;
            width: 1903px;
            height: 1966px;
        }
        .header {
            z-index: 100;
            border-bottom: 1px solid #d1d8e4;
            background-color: #fff;
            height: 100px;
            line-height: 100px;
        }

        .container {
            margin: 0 auto;
            padding: 8px 10px 0;
            text-align: left;
            width: 1100px;
        }

        .container_left {
            float: left;
            width: 740px;
        }

        .container_right {
            position: relative;
            float: right;
            width: 332px;
        }

        .footer {
            margin: 0 auto;
            text-align: center;
            width: 1100px;
        }

        .section_login {
            position: relative;
            height: 118px;
            border: 1px solid #dee3eb;
            background-color: #fff;
        }

        .lg_btm {
            width: 280px;
            padding: 15px 25px;
        }

        .btn-primary {
            width: 280px;
        }

        .lg_links {
            width: 280px;
            padding-left: 25px;
        }

        .lg_links a {
            text-decoration: none;
        }
        .form-inline {
            margin-left: 520px;
        }
        .navbar-collapse {
            margin-left: 400px;
        }


    </style>
</head>
<body>
<div class="header">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">자유게시판</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">자료게시판</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>
<div class="wrap">
    <div class="container">
        <div class="container_left">
            <table width="500" cellpadding="0" cellspacing="0" border="1">
                <tr>
                    <td>번호</td>
                    <td>이름</td>
                    <td>제목</td>
                    <td>날짜</td>
                    <td>히트</td>
                </tr>
                <c:forEach items="${list }" var="dto">
                    <tr>
                        <td>${dto.bId }</td>
                        <td>${dto.bName }</td>
                        <td><c:forEach begin="1" end="${dto.bIndent }">-</c:forEach> <a
                                href="content_view.bo?bId=${dto.bId }">${dto.bTitle }</a></td>
                        <td>${dto.bDate}</td>
                        <td>${dto.bHit}</td>
                    </tr>
                </c:forEach>

                <tr>
                    <td colspan="3"><a href="write_view.bo">글작성</a>
                </tr>
            </table>
        </div>

        <div class="container_right">
            <div class="section_login">
                <div class="lg_btm">
                    <button class="btn btn-primary" type="submit">로그인</button>
                </div>
                <div class="lg_links">
                    <a href="login.jsp" class="id_find">아이디</a>
                    /
                    <a href="#" class="pw_find">비밀번호 찾기</a>
                    <input type="button" value="회원가입" onclick="javascript:window.location='join.jsp'">
                </div>
            </div>
        </div>
    </div>
    <div class="footer">

    </div>
</div>

<%--	<h1><%=name%>님 안녕하세요.--%>
<%--	</h1>--%>
<%--	<br>--%>
<%--	<form action="logout.do" method="post">--%>
<%--		<input type="submit" value="로그아웃">&nbsp;&nbsp;&nbsp; <input--%>
<%--			type="button" value="정보수정"--%>
<%--			onclick="javascript:window.location='modify.jsp'">--%>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>