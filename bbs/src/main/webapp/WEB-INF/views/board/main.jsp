<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
    <jsp:param value="게시판-메인" name="pageTitle"/>
</jsp:include>
<div id="table-container">
    <table class="table board" style="border-bottom:1px solid #dee2e6;width:80%; margin:0 auto;">
        <thead>
        <tr>
            <th scope="col">no.</th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">첨부파일</th>
            <th scope="col">작성일</th>
            <%--<th scope="col" width="10%">조회수</th>--%>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>gg</td>
            <td>Otto</td>
            <td>
            <c:if test="1=1">
                <img src="${pageContext.request.contextPath}/resources/images/file.png" alt="" style="width:20px">
            </c:if>
            </td>
            <td>2019-12-25</td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>Jacob</td>
            <td>Thornton</td>
            <td>2019-12-25</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>Larry</td>
            <td>the Bird</td>
            <td>2019-12-25</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>Larry</td>
            <td>the Bird</td>
            <td>2019-12-25</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>Larry</td>
            <td>the Bird</td>
            <td>2019-12-25</td>
        </tr>
        </tbody>

    </table>
    <div id="writebtnbox" style="text-align:right;padding-right:110px;"><button class="btn btn-dark" id="writeBtn">글쓰기</button></div>
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>