<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    


<html>
<head>
<meta charset=UTF-8">
<title>게시판</title>
</head>
<body>
<table border="1"  align="center"  width="80%">
    <tr align="center">
      <td ><b>글번호</b></td>
      <td><b>제목</b></td>
      <td><b>글쓴이</b></td>
      <td><b>글쓴시각</b></td>
      <td><b>조회수</b></td>
   </tr>
   
 <c:forEach var="board" items="${boardList}" >     
   <tr align="center">
      <td>${board.board_no}</td>
      <td>${board.title}</td>
      <td>${board.write_id}</td>
      <td>${board.write_dt}</td>
      <td>${board.hits}</td>
    </tr>
  </c:forEach>   
</table>
<a  href="${contextPath}/board/boardForm.do"><h1 style="text-align:center">글쓰기</h1></a>
</body>
</html>
