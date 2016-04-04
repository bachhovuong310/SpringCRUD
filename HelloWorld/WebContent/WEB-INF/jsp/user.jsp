<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Demo</h2>
	<a href="user/register">Register New User</a>
	<p>
		Hello <b><c:out value="${pageContext.request.remoteUser}" /></b><br>
	</p>
	<table border="1">
		<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.username}</td>
				<td>${user.fullname}</td>
				<td>${user.email}</td>
				<td>${user.job}</td>
				<td>${user.department}</td>
				<td>${user.userRoles }</td>
				<td><a href="user/${user.username}">Profile</a> <input
					type="button" value="delete"
					onclick="window.location='user/delete/${user.username}'" /></td>
			</tr>
		</c:forEach>
	</table>

	<c:url value="/logout" var="logoutUrl" />
	<form id="logout" action="${logoutUrl}" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>
</body>
</html>

