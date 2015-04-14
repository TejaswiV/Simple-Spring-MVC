<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello Teju, Welcome to Home page</h2>
	<c:set var="number" value="12345234.56445" />
	<fmt:formatNumber value="${number}" var="formattedNo" type="CURRENCY" groupingUsed="FALSE" ></fmt:formatNumber>
	<c:out value="${formattedNo}"></c:out>
</body>
</html>