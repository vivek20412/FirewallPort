<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
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
	
	
	<script type="text/javascript">

	$(document).ready(function(){
		  $("#add").click(function(){
		    //alert("hi");
		    
		    $('#ipTable').append("<tr><td><input class='TF' type='checkbox' placeholder='Source Ip' name='record' /></td><td><input class='TF' type='text' placeholder='Host Name' name='hostname' /></td><td><select name='os'><option value='windows'>Windows</option><option value='linux'>Linux</option><option value='mac'>Mac</option></select></td><td><input class='TF' type='text' placeholder='Private IP' name='privateip' /></td></tr>");
          
			  });
		  /* $(".removeRow").click(function(){

           alert("remove");

		  }); */
		  
		});



	function removeRow()
	{
       //alert("remove");
        /* $('#ipTable tr:last').remove(); */ 
       $("table tbody").find('input[name="record"]').each(function(){
           if($(this).is(":checked")){
               $(this).parents("tr").remove();
           }
       });
       
		}


	</script>
	
	
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div>
<%@ include file="adminheader.jsp"%>
</div>


	<marquee class="marqueeText"> Welcome ${sessionScope.name}</marquee>
	<div class="container">
	<center>
		<div class="main">
		
			<div class="form-caption" style="color:white;"><h2>Fill Details</h2></div>
			<div class="form-body">
				<form:form action="${pageContext.request.contextPath}/admin/saveDetails" modelAttribute="customer">
				     <span style="color:green;font-weight:bold;">${msg }</span>
				     <input type="hidden" name="username" value="${customerDetails.username_cust_details}"/>
				     <input type="hidden" name="id" value="${customerDetails.id}" readonly="true"/>
					<div class="form-group">
						<label for="email">Customer Name:</label> <form:input type="text"
							class="form-control" placeholder="Customer Name" id="customername" path="customername" value="${customerDetails.customername }" readonly="true"/>
							<form:errors path="customername" cssClass="error"/>
					</div>
					<div class="form-group">
						<label for="email">Service Request Number:</label> <form:input type="text"
							class="form-control" placeholder="Service Request Number" id="service_no" path="service_no" value="${customerDetails.service_no }" readonly="true"/>
							<form:errors path="customername" cssClass="error"/>
					</div>
					<div class="form-group">
						<label for="email">Mobile Number:</label> <form:input  type="number"
							class="form-control" placeholder="Mobile Number" id="mob" path="mob" value="${customerDetails.mob }" readonly="true"/>
							<form:errors path="mob" cssClass="error"/>
					</div>
					<div class="form-group">
						<label for="email">E-Mail:</label> <form:input  type="email"
							class="form-control" placeholder="E-Mail" id="email" path="email" value="${customerDetails.email }" readonly="true"/>
							<form:errors path="email" cssClass="error"/>
					</div>
					
					<!-- <a id="add" class="btn btn-primary">Add</a><a id="remove" onclick="removeRow()" class="btn btn-danger">Remove</a> -->
					<table class="table" id="ipTable">
					
					 <tr><th>Host Name</th><th>OS</th><th>Private IP</th><th>Public IP</th><th>NAT</th></tr>
					
					
					<%-- <td><c:forEach items="${customerDetails.serverDetailsForTicket}" var="l"><input class='TF' type='text' placeholder='Host Name' name='hostname' value="${l.hostname}" readonly="true"/></c:forEach></td>
					<td><c:forEach items="${customerDetails.serverDetailsForTicket}" var="l"><input class='TF' type='text' placeholder='Host Name' name='os' value="${l.os}" readonly="true"/></c:forEach></td>
					<td><c:forEach items="${customerDetails.serverDetailsForTicket}" var="l"><input class='TF' type='text' placeholder='Host Name' name='privateip' value="${l.privateip}" readonly="true"/></c:forEach></td>
					<td><c:forEach items="${customerDetails.serverDetailsForTicket}" var="l"><input class='TF' type='text' placeholder='Host Name' name='publicip' value="${l.publicip}" readonly="true"/></c:forEach></td>
					<td><c:forEach items="${customerDetails.serverDetailsForTicket}" var="l"><input class='TF' type='text' placeholder='Host Name' name='publicip' value="${l.nat}" readonly="true"/></c:forEach></td> --%>
					<td><c:forEach items="${customerDetails.serverDetailsForTicket}" var="l"> ${l.hostname}</c:forEach></td>
					<td><c:forEach items="${customerDetails.serverDetailsForTicket}" var="l">${l.os} </c:forEach></td>
					<td><c:forEach items="${customerDetails.serverDetailsForTicket}" var="l"> ${l.privateip}</c:forEach></td>
					<td><c:forEach items="${customerDetails.serverDetailsForTicket}" var="l">${l.publicip}</c:forEach></td>
					<td><c:forEach items="${customerDetails.serverDetailsForTicket}" var="l">${l.nat}</c:forEach></td>
					</tr> 
					<!-- <tr><td></td><td><input class='TF' type='text' placeholder='Host Name' name='hostname' /></td>
					<td>
					<select name='os'>
					<option value='windows'>Windows</option>
					<option value='linux'>Linux</option>
					<option value='mac'>Mac</option>
					</select></td><td><input class='TF' type='text' placeholder='Private IP' name='privateip' /></td></tr>
					<tr> -->
					
					
					</table>
					  <table class="table">
<tr><th>ID</th><th>Action</th><th>Activation Time</th><th>Deactivation Time</th><th>Direction</th><th>IPEntry</th><th>Source IP</th><th>Port</th><th>Comments</th></tr>
<c:forEach items="${customerDetails.iplist}" var="l">
<tr><td>${l.id }</td><td>${l.action }</td><td>${l.activationTime }</td><td>${l.deactivationTime }</td><td>${l.direction }</td><td>${l.ipentry }</td><td>${l.sourceIp }</td><td>${l.port }</td><td>${l.comments }</td></tr>
</c:forEach>
<tr><td>Comment</td><td><form:input  type="text"
							class="form-control" placeholder="Comment" id="adminComment" path="adminComment" value="${customerDetails.adminComment }"/></td></tr>
<tr><td>Action</td> <td><select name="action"><option value="action">--Action--</option><option value="approved">Approve</option><option value="rejected">Reject</option><option value="hold">Hold</option></select></td></tr>
</table>
					<button type="submit" class="btn btn-primary">Submit</button>
					
				</form:form>
			</div>
		</div>
		</center>
	</div>




<div>
<%@ include file="adminfooter.jsp"%>
</div>
</body>
</html>