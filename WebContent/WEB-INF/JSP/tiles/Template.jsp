<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title><tiles:getAsString name="title"/> </title>

<script type="text/javascript" src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css"/>"/>
<script type="text/javascript" src="<c:url value="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"/>"></script>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/CSS/registration.css"/>"/>
<script type="text/javascript" src="<c:url value="/resources/JS/registration.js"/>"></script>




</head>
<body>
   	<div id="mainDiv">
   		<div id="Header">
        	<tiles:insertAttribute name="header"/>
        </div>
        <div id="Menu">
        	<tiles:insertAttribute name="menu"/>
        </div>
         <div id="Content">
        	<tiles:insertAttribute name="content"/>
        </div> 
         <div id="Footer">
        	<tiles:insertAttribute name="footer"/>
        </div>
     </div>   
</body>
</html>