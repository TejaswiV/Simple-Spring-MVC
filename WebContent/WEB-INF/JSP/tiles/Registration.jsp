<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<br/><br/>	
	<div>
		<h3>Registration form</h3>
		<sf:form modelAttribute="user" method="POST" action="./register" enctype="multipart/form-data">
			<fieldset>
				<table>
					<tr>
						<th><label for="firstName">First Name :</label></th>
						<td><sf:input path="firstName" id="firstName" size="25" maxlength="25"/>
							<small>Only Alphabets</small>
							<sf:errors path="firstName" delimiter=",  "/>
						</td>						
					</tr>
					<tr>
						<th><label for="lastName">Last Name :</label></th>
						<td>
							<sf:input path="lastName" id="lastName" size="25" maxlength="25"/>
							
							<sf:errors path="lastName" delimiter=",  "/>
						</td>
					</tr>
					<tr>
						<th><label for="password">Password :</label></th>
						<td>
							<sf:password path="password" id="password" size="25" maxlength="25"/>
							<small>At least 7 characters long</small>
							<sf:errors path="password" delimiter=",  "/>
						</td>
					</tr>
					<tr>
						<th><label for="email">Email :</label></th>
						<td>
							<sf:input path="email" id="email" size="25" maxlength="25"/>	
							<sf:errors path="email"  delimiter=",  "/>						
						</td>
					</tr>
					
					<tr>
						<th><label for="gender">Gender :</label></th>
						<td>
							<sf:radiobutton path="gender" value="male"/>Male
							<sf:radiobutton path="gender" value="female"/>Female					
						</td>
					</tr>
					
					<tr>
						<th><label >Upload photo :</label></th>
						<td><input type="file" name="image"></td>
					</tr>
					<tr>
						
						<td>
							<input type="submit" value="Submit"/>				
						</td>
					</tr>
					
				</table>
			</fieldset>
		</sf:form>
		
	</div>
</body>
</html>