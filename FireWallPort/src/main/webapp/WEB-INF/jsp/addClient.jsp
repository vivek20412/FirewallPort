<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::Login::</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file = "header.jsp" %>
<div class="container" style="background-color:#808080;margin-top:100px;width:500px">
<div>
  <h2>Add Client</h2>
  </div>
  <form:form action="saveClient"  modelAttribute="client"  method="post">
    <div class="form-group">
      <label for="name">Client Name:</label><div >
  <strong>${msg}</strong> 
</div>
      <form:input type="text" class="form-control" id="name" placeholder="Enter Name" path="name" />
    </div>
    <!-- <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd">
    </div>
    <div class="form-group form-check">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember"> Remember me
      </label>
    </div> -->
    <button type="submit" class="btn btn-primary">Submit</button>
  </form:form>
</div>
<div style="margin-top:200px;">
<%@ include file = "footer.jsp" %>
</div>
</body>
</html>