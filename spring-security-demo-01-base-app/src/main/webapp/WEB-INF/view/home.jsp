<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page - Yaaa!</h2>
	<hr>

	<p>Welcome to the luv2code company home page!</p>
	
	<hr>
	
	<!-- display username and role -->
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role(s): <security:authentication property="principal.authorities"/>
	</p>
	
	
	<security:authorize access="hasRole('MANAGER')">

		<!-- Add a link to point to /leaders... only for maganers-->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			(Only for Manager peeps)
	 	</p>
	 	
 	</security:authorize>
 	
 	<hr>
 	
 	<security:authorize access="hasRole('ADMIN')">
 	
	 	<!-- Add a link to point to /system.... only for admins  -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT System Meeting</a>
			(Only for Admin peeps)
	 	</p>
 	
 	</security:authorize>
 	
	<hr>
	
	
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">
		
		<input type="submit" value="Logout" />
		
	</form:form>
	
</body>

</html>