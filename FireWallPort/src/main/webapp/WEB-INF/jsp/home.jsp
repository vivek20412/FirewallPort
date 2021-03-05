<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
	<form method="POST"  action="/register">
		<table border="1">
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" id="name" /></td>
			</tr>
			<tr>
				<td>Aadhaar</td>
				<td><input type="text" name="aadhaar" id="aadhaar" /></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type="text" name="mob" id="mob" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input  type="text" name="add" id="add" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register" /></td>
			</tr>




		</table>





	</form>
</body>
</html>