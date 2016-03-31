<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Register</h2>
	<form action="register" method="post">
		<input type="hidden" name="id"> 
		<label for="username">UserName</label> 
		<input type="text" id="username" name="username" /> 
		<br/>
		
		<label for="password">Password</label> 
		<input type="password" id="password" name="password" /> 
		<br/>
		
		<label for="firstname">FirstName</label> 
		<input type="text" id="firstname" name="firstname" /> 
		
		<label for="middlename">MiddleName</label> 
		<input type="text" id="middlename" name="middlename" /> 
		
		<label for="lastname">LastName</label> 
		<input type="text" id="lastname" name="lastname" /> 
		<br/>
		
		<label for="job">Job</label> 
		<input type="text" id="job" name="job" /> 
		<br/>
		
		<label for="email">Email</label> 
		<input type="email" id="email" name="email" /> 
		<br/>
		<label for="department">Department</label> 
		<input type="text" id="department" name="department" /> 
		<br/>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>