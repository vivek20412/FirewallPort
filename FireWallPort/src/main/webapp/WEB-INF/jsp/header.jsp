<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<!-- Brand/logo -->
		<a class="navbar-brand" href="#"><img id="myImg" height="50"
			width="50" src="/img/railtellogo.jpg"
			style="border: 1px solid; border-radius: 20px;"></a>

		<!-- Links -->
		<ul class="navbar-nav">
			<!-- <li class="nav-item">
      <a class="nav-link " href="addCustomerDetails" style="color:white;border:solid white 2px;border-radius:20px;">Add Customer Details</a>
    </li> -->
			<%--  <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/customer/viewOldRequests" style="color:white;border:solid white 2px;border-radius:20px;">View Old Requests</a>
    </li> --%>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/customer/viewVms"
				style="color: white; border: solid white 2px; border-radius: 20px;">View
					VMs</a></li>

			<!-- <li class="nav-item">
      <a class="nav-link" href="viewLogs">View Logs</a>
    </li> -->
			<li class="nav-item" style="margin-left: 950px;"><form:form
					action="/logout" method="post">
					<input type="submit" value="Logout" />
				</form:form></li>
		</ul>
	</nav>


</body>
</html>