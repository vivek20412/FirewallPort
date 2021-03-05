<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::Login::</title>
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
	
	<script type="text/javascript">

	$(document).ready(function(){
		  $("#add").click(function(){
		    //alert("hi");
		    
		    $('#ipTable').append("<tr><td><input class='TF' type='checkbox' placeholder='Source Ip' name='record' /></td><td><input class='TF' type='text' placeholder='Source Ip' name='sourceip' /></td><td><input class='TF' type='text' placeholder='Source Port' name='sorceport' /></td><td><input class='TF' type='text' placeholder='Dest. Ip' name='destinationip' /></td><td><input class='TF' type='text' placeholder='Dest.Port' name='destinationport' /></td></tr>");
            
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
</head>
<body>
	<%@ include file="header.jsp"%>
	<marquee class="marqueeText"> Welcome ${sessionScope.name}</marquee>
	<div class="container">
	<center>
		<div class="main">
		
			<div class="form-caption" style="color:white;"><h2>Fill Details</h2></div>
			<div class="form-body">
				<form:form action="${pageContext.request.contextPath}/customer/saveCustomerDetails" modelAttribute="customerDetails">
				     <span style="color:green;font-weight:bold;">${msg }</span>
					<div class="form-group">
						<label for="email">Customer Name:</label> <form:input type="text"
							class="form-control" placeholder="Customer Name" id="customername" path="customername" value="${user.name }" readonly="true"/>
							<form:errors path="customername" cssClass="error"/>
					</div>
					<div class="form-group">
						<label for="email">Company Name:</label> <form:input  type="text"
							class="form-control" placeholder="Company Name" id="companyname" path="companyname" value="${user.companyname }" readonly="true"/>
							<form:errors path="companyname" cssClass="error"/>
					</div>
					<div class="form-group">
						<label for="email">Service Request Title:</label> <form:input  type="text"
							class="form-control" placeholder="Service Request Title" id="service_request_title" path="service_request_title" />
							<form:errors path="service_request_title" cssClass="error"/>
					</div>
					<div class="form-group">
						<label for="email">Service Request Description:</label> <form:textarea  rows="5" cols="5"
							class="form-control" placeholder="Service Request Description" id="serverip_destination" path="service_request_desc"  />
							<form:errors path="service_request_desc" cssClass="error"/>
					</div>
					<div class="form-group">
						<label for="email">Choose Date:</label> <form:input  type="date"
							class="form-control" placeholder="Source Ip Port" id="serverip_souirce_port" path="date" />
							<form:errors path="date" cssClass="error"/>
					</div>
					
					<a id="add" class="btn btn-primary">Add</a><a id="remove" onclick="removeRow()" class="btn btn-danger">Remove</a>
					<table class="table" id="ipTable">
					
					<tr><td>Select</td><td>Source IP</td><td>Source Port</td><td>Destination IP</td><td>Destination Port</td></tr>
					<tr><td></td><td><input class='TF' type='text' placeholder='Source Ip' name='sourceip' /></td><td><input class='TF' type='text' placeholder='Source Port' name='sorceport' /></td><td><input class='TF' type='text' placeholder='Dest. Ip' name='destinationip' /></td><td><input class='TF' type='text' placeholder='Dest.Port' name='destinationport' /></td></tr>
					
					</table>
					<button type="submit" class="btn btn-primary">Save</button>
					<button type="reset" class="btn btn-primary">Reset</button>
				</form:form>
			</div>
		</div>
		</center>
	</div>
	<div style="margin-top: 200px;">
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>