<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<style>
   .text_center{
     text-align:center;
   }
</style>
</head>
<body>
	<form method="post"   action="${contextPath}/board/addBoard.do">
	<h1  class="text_center">글쓰기</h1>
	<table  align="center">
	   <tr>
	      <td width="200"><p align="right">제목</td>
	      <td width="400"><input type="text" name="title"></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">내용</td>
	      <td width="400"><input type="text" name="contents"></td>
	    </tr>


	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="저장"><input type="reset" value="다시입력"></td>
	    </tr>
	</table>
	</form>
</body>
