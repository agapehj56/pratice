<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page.jsp</title>

<!-- code_assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>
<c:set var="dept"		value="${page.dept}"/>
<c:set var="paging"		value="${page.paging}"/>
<h1>Dept Page List pageNo = ${paging.pageNo}</h1>

<c:forEach var="d" items="${dept}" varStatus="status">
	<b>${status.index}</b>
	${d.deptno} <a href="/dept/item/${d.deptno}">${d.dname}</a>${d.loc}<br>
</c:forEach>

<hr>

<a href="/dept/page/${paging.firstPage - 1}">Prev</a>
<c:forEach var="i" begin="${paging.firstPage}" end="${paging.lastPage}">
	<a href="/dept/page/${i}">${i}</a>
</c:forEach>
<a href="/dept/page/${paging.lastPage + 1}">Next</a>
</body>
</html>