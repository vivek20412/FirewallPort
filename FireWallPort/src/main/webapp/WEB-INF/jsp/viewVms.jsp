<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
	<%-- <marquee class="marqueeText"> Welcome ${sessionScope.name}</marquee> --%>
	<fieldset>
	<legend>Service Request Details:</legend>
	<table class="table">
	<tr><th>ID</th><th>Service Request</th><th>Ticket Status</th></tr>
	<c:forEach items="${tickets}" var="ticket">
	<tr><td>${ticket.id }</td><td><a href="${pageContext.request.contextPath}/customer/showServiceDetails/${ticket.service_no}">${ticket.service_no }</a></td><td>
	 <c:if test="${ticket.ticketStatus eq 'pending'}">  
    <span class="btn btn-danger">Pending</span>  
    </c:if> 
	<c:if test="${ticket.ticketStatus eq 'approved'}">  
    <span class="btn btn-success">Approved</span>  
    </c:if> 
    <c:if test="${ticket.ticketStatus eq 'hold'}">  
    <span class="btn btn-primary">Hold</span>  
    </c:if> 
    <c:if test="${ticket.ticketStatus eq 'completed'}">  
    <span class="btn btn-success">Completed</span>  
    </c:if> 
    <c:if test="${ticket.ticketStatus eq 'rejected'}">  
    <span class="btn btn-danger">Rejected</span>  
    </c:if>  
    </td></tr>
	</c:forEach>
	</table>
	</fieldset>
	<fieldset>
	<legend>VMs</legend>
<table class="table table-bordered" style="margin-top:50px;margin-bottom:50px;">
<tr><th>Host Name</th><th>OS</th><th>Private IP</th><th>Public IP</th><th>Action</th></tr>
<c:forEach items="${vmsDetails}" var="vms">
<c:forEach items="${vms.serverDetails}" var="obj">

<tr><td>${obj.hostname}</td><td>${obj.os}</td><td>${obj.privateip}</td><td>${obj.publicip}</td><td><a href="raiseRequest/${obj.id}" class="btn btn-success">Raise Request</a></td></tr>

</c:forEach>
</table>
</c:forEach>


</fieldset>
<div style="margin-top: 200px;">
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>