<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	
	
	<!- custom files-->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css">
</head>
<body>
<%@ include file="header.jsp"%>

<table class="table">
<tr><th>ID</th><td>${serviceDetails.id}</td></tr>
<tr><th>Service Request Number</th><td>${serviceDetails.service_no}</td></tr>
<tr><th>E-mail</th><td>${serviceDetails.email}</td></tr>
<tr><th>Mob</th><td>${serviceDetails.mob}</td></tr>
<tr><th>Status</th><td>${serviceDetails.ticketStatus}</td></tr>
<tr><th>ID</th><th>Hostname</th><th>OS</th><th>Private IP</th><th>Public IP</th><th>NAT</th></tr>
<c:forEach items="${serviceDetails.serverDetailsForTicket}" var="service">
<tr><td>${service.id}</td><td>${service.hostname}</td><td>${service.os}</td><td>${service.privateip}</td><td>${service.publicip}</td><td>${service.nat}</td></tr>
</c:forEach>

</table>
<table class="table">
<tr><th>ID</th><th>Action</th><th>Activation Time</th><th>Deactivation Time</th><th>Direction</th><th>IPEntry</th><th>Source IP</th><th>Port</th><th>Comments</th></tr>
<c:forEach items="${serviceDetails.iplist}" var="l">
<tr><td>${l.id }</td><td>${l.action }</td><td>${l.activationTime }</td><td>${l.deactivationTime }</td><td>${l.direction }</td><td>${l.ipentry }</td><td>${l.sourceIp }</td><td>${l.port }</td><td>${l.comments }</td></tr>
</c:forEach>
</table>
<%@ include file="footer.jsp"%>
</body>
</html>