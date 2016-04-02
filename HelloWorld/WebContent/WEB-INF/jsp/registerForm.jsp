<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Register</h2>
	
	<form:form commandName="user" action="register" method="post">
	<form:errors path="*" element="div"></form:errors>
		<form:hidden path="id"/> 
		<label for="username">UserName</label> 
		<form:input type="text" id="username" path="username" /> 
		<form:errors path="username" cssClass="error"/>
		<br/>
		
		<label for="password">Password</label> 
		<form:input type="password" id="password" path="password" /> 
		<form:errors path="password" cssClass="error"/>
		<br/>
		<label for="password_confirmation">Password</label> 
		<form:input type="password" id="password_confirmation" path="password_confirmation" /> 
		<form:errors path="password_confirmation" cssClass="error"/>
		<br/>
		<label for="firstname">FirstName</label> 
		<form:input type="text" id="firstname" path="firstname" /> 
		<form:errors path="firstname" cssClass="error"/>
		
		<label for="middlename">MiddleName</label> 
		<form:input type="text" id="middlename" path="middlename" /> 
		<form:errors path="middlename" cssClass="error"/>
		
		<label for="lastname">LastName</label> 
		<form:input type="text" id="lastname" path="lastname" /> 
		<form:errors path="lastname" cssClass="error"/>
		<br/>
		
		<label for="job">Job</label> 
		<form:input type="text" id="job" path="job" /> 
		<form:errors path="job" cssClass="error"/>
		<br/>
		
		<label for="email">Email</label> 
		<form:input type="email" id="email" path="email" /> 
		<form:errors path="email" cssClass="error"/>
		<br/>
		<label for="department">Department</label> 
		<form:input type="text" id="department" path="department" /> 
		<form:errors path="department" cssClass="error"/>
		<br/>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>