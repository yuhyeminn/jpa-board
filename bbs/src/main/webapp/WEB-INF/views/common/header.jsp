<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
</head>
<body>
<div id="container">
    <header>
        <div id="header-container">
            <h2>${param.pageTitle }</h2>
        </div>
        <!-- https://getbootstrap.com/docs/4.0/components/navbar/ -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">
                JPA 게시판
            </a>
            <div class="login-form row g-2">
                <form action="#" class="d-flex" method="post">
                    <label for="memberId" class="col-form-label col-auto">아이디</label>
                    <input type="text" class="form-control" id="memberId" name="memberId">

                    <label for="password" class="col-form-label col-auto"">비밀번호</label>
                    <input type="password" class="form-control" id="password" name="password">

                    <button type="submit" class="btn col-auto btn-dark" style="margin-left:10px">로그인</button>
                </form>
            </div>
        </nav>
    </header>
    <section id="content">