<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
    <jsp:param value="게시판-게시글 상세보기" name="pageTitle"/>
</jsp:include>
<style>
    #board-container {
        /* margin: 70px; */
        text-align: center;
        padding:30px;
        margin-bottom:100px;
    }
    .content-row{
        border-top:2px solid rgb(161, 161, 161);
        border-bottom: 2px solid rgb(161, 161, 161);
        font-size:20px;
        padding:12px;
        text-align: initial;
    }
    #board-date, #board-write{
        float:right;
        font-size:16px;
        margin:0px 5px;
    }
    #board-date{
        color:#666;
    }
    #board-content{
        padding:30px;
        /* background:black; */
        color:black;
        text-align: initial;
        min-height: 500px;
    }
    #board-file{
        font-size:17px;
    }
    #file-image{
        width:27px;
        margin-right:15px;
    }
    #board-title{font-weight: bold;}
    #boardNo{
        text-align: initial;
        font-style:italic;
        margin:5px;
        color:#666;
    }
    #btn-group{
        padding-top:20px;
        text-align:right;
    }
    #btn-group button{
        margin:0px 5px;
        width:70px;
    }
    #list-button{
        height:60px;
        font-size:20px;
        float: left;
    }
</style>

<div id="board-container">
    <p id="boardNo"><span>NO.</span><span id="board-no">게시글번호</span></p>

    <div id="board-titlebox" class="content-row">
        <span id="board-title">게시글 타이틀</span>
        <span id="board-date">날짜 부분</span>
        <span id="board-write">작성자 : 날짜 부분 </span>
    </div>
    <div id="board-content">ddddddddddddddddddddddddddddddddddddddddddd<br>dddddddddddddddddddddddddddddd</div>
    <div id="board-file" class="content-row"><img src="${pageContext.request.contextPath}/resources/images/file.png" id="file-image" style="width:20px">첨부파일.txt</div>
    <div id="btn-group">
        <button type="button" class="btn btn-dark">수정</button>
        <button type="button" class="btn btn-dark">삭제</button>
        <button type="button" id="list-button" class="btn btn-dark" style="width:150px;" onclick = "location.href = '${pageContext.request.contextPath}' ">목록</button>
    </div>
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>