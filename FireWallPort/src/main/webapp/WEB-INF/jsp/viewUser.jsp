<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
  <div>
		<%@ include file="adminheader.jsp"%>
	</div>
	<div class="container">
	<div class="main" >
		<div class="form-caption" style="color: white;">
			<h2>Activate/Deactivate</h2>
		</div>
		<div class="form-body">
		  <span>${msg}</span>
			<form:form action="${pageContext.request.contextPath}/admin/updateUser" modelAttribute="user">
				<div class="form-group">
						<label for="email">User Name:</label> <form:input  type="text"
							class="form-control"  id="username" path="username" value="${user.username }" />
							<form:errors path="mob" cssClass="error"/>
					</div>
					<div class="form-group">
						<label for="email">Name:</label> <form:input  type="text"
							class="form-control"  id="name" path="name" value="${user.name }" />
							<form:errors path="name" cssClass="error"/>
					</div>
					<div class="form-group">
						<label for="email">E-Mail:</label> <form:input  type="text"
							class="form-control"  id="email" path="email" value="${user.email }" />
							<form:errors path="mob" cssClass="error"/>
					</div>
					<div class="form-group">
						<label for="email">Mobile Number:</label> <form:input  type="text"
							class="form-control"  id="mob" path="mob" value="${user.mob }" />
							<form:errors path="mob" cssClass="error"/>
					</div>
					<div class="form-group">
						<label for="email">Role:</label> User<form:radiobutton  
							class="form-control" placeholder="Source Ip Port" id="role" path="role" value="ROLE_USER"/>
							Employee<form:radiobutton  
							class="form-control" placeholder="Source Ip Port" id="role" path="role" value="ROLE_EMP"/>
							<form:errors path="role" cssClass="error"/>
					</div>
					<div class="form-group">
					   <span>Current Status:
					   <c:choose>
                          <c:when test="${user.enabled}">
                             <p style="background-color:green;">Active</p>
                          </c:when>
                           <c:otherwise>
                          <p style="background-color:red;">Inactive</p>
                         </c:otherwise>
                       </c:choose>
					   </span>
						<label for="email">User Status:</label> Active
						<div class="radio">
						<form:radiobutton  
							class="form-control"  id="enabled" path="enabled" value="1" checked="false"/>
						</div>
						<div class="radio">
							Inactive<form:radiobutton  
							class="form-control" id="enabled" path="enabled" value="0" checked="false"/>
							<form:errors path="enabled" cssClass="error"/>
							</div>
					</div>
					
				<button type="submit" class="btn btn-primary">Update</button>

			</form:form>
		</div>
	</div>
	
	</div>
	
	<div style="margin-top:50px;">
		<%@ include file="adminfooter.jsp"%>
	</div>
</body>
</html>