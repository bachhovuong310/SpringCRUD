<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Demo</h2>
	<a href="user/register">Register New User</a>
	<table border="1">
		<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.username}</td>
				<td>${user.fullname}</td>
				<td>${user.email}</td>
				<td>${user.job}</td>
				<td>${user.department}</td>
				<td>
					<a href="user/${user.username}">Profile</a>
					<input type="button" value="delete" onclick="window.location='user/delete/${user.username}'" />
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

