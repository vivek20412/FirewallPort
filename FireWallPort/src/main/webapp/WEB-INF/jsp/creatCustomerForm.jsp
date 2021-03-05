<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>



<!- custom files-->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/form.css">
</head>
<body>
<div>
<%@ include file="adminheader.jsp"%>
</div>

<div class="container">
	<center>
		<div class="main">
			<div class="form-caption" style="color:white;"><h2>Create User</h2></div>
			<div class="form-body">
				<form:form action="${pageContext.request.contextPath}/admin/createUser" modelAttribute="user">
				     <span style="color:green;font-weight:bold;">${msg }</span>
				     <form:input type="hidden" path="id" value="${customer.id}"/>
					<div class="form-group">
						<label for="email">Name:</label> <form:input type="text"
							class="form-control" placeholder="Customer Name" id="name" path="name" value="${customer.customername }" />
							<form:errors path="name" cssClass="error"/>
					</div>
					<div class="form-group">
						<label for="email">E-mail:</label> <form:input  type="email"
							class="form-control" placeholder="E-Mail" id="email" path="email" value="${customer.email}" />
							<form:errors path="email" cssClass="error"/>
					</div>
					<div class="form-group">
						<label for="email">Mobile Number:</label> <form:input  type="number"
							class="form-control" placeholder="Mobile Number" id="mob" path="mob" value="${customer.mob}"/>
							<form:errors path="mob" cssClass="error"/>
					</div>
					
					<div class="form-group">
						<label for="email">Role:<p></label> Customer<form:radiobutton  
							class="form-control radiobtn"  id="role" path="role" value="ROLE_USER" /></p>
							<p>DC Team<form:radiobutton   
							class="form-control radiobtn"  id="role" path="role" value="ROLE_DCTEAM"/>
							<form:errors path="role" cssClass="error"/></p>
							<p>Fire Wall Team<form:radiobutton   
							class="form-control radiobtn" id="role" path="role" value="ROLE_EMP"/>
							<form:errors path="role" cssClass="error"/></p>
							<p>Admin<form:radiobutton   
							class="form-control radiobtn"  id="role" path="role" value="ROLE_ADMIN"/>
							<form:errors path="role" cssClass="error"/></p>
					</div>
					<div class="form-group">
						<label for="email">Username:</label> <form:input  type="text"
							class="form-control" placeholder="User Name" id="username" path="username" />
							<form:errors path="mob" cssClass="error"/>
					</div>
					<div class="form-group">
						<label for="email">Password:</label> <form:input  type="password"
							class="form-control" placeholder="Password" id="password" path="password" />
							<form:errors path="mob" cssClass="error"/>
					</div>
					
					<button type="submit" class="btn btn-primary">Save</button>
					<button type="reset" class="btn btn-primary">Reset</button>
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