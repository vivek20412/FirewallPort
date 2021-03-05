<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::Login::</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file = "header.jsp" %>
	<div class="container"
		style="background-color: #808080; margin-top: 100px; width: 500px">
		<div>
			<h2>Upload Logs</h2>
		</div>
		<h3 class="success">${msg}</h3>
		<form action="upload" method="post" enctype="multipart/form-data">
			<div class="form-group">

				<select class="form-control" name="client">
					<option value="select">Select Client</option>
					<c:forEach items="${clients}" var="client">

						<option value="${client.name}">${client.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="upload">Upload File:</label> <input type="file"
					class="form-control" id="upload" 
					name="upload">
			</div>
			<!--  <div class="form-group form-check">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember"> Remember me
      </label>
    </div> -->
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<div style="margin-top:200px;">
<%@ include file = "footer.jsp" %>
</div>
</body>
</html>