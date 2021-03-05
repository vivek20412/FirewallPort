<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="header.jsp"%>

<table class="table table-bordered" style="margin-top:50px;margin-bottom:50px;">
<tr><th>Fields</th><th>Description</th></tr>
<tr><td>ID</td><td><c:out value="${data.id}"/></td></tr>
<tr ><td style="background-color:red;font-weight=bold;">Service Request Number</td><td style="background-color:red;font-weight:bold;"><c:out value="${data.service_no}"/></td></tr>
<tr><td>Customer Name</td><td><c:out value="${data.customername}"/></td></tr>
<tr><td>Activation Date & Time</td><td><c:forEach items="${data.iplist}" var="l">${l.activationTime }<br></c:forEach></td></tr>
<tr><td>Deactivation Date & Time</td><td><c:forEach items="${data.iplist}" var="l">${l.deactivationTime }<br></c:forEach></td></tr>
<tr><td>Direction</td><td><c:forEach items="${data.iplist}" var="l">${l.direction }<br></c:forEach></td></tr>
<tr><td>Port</td><td><c:forEach items="${data.iplist}" var="l">${l.port }<br></c:forEach></td></tr>
<tr><td>Action</td><td><c:forEach items="${data.iplist}" var="l">${l.action }<br></c:forEach></td></tr>
<tr><td>Comments</td><td><c:forEach items="${data.iplist}" var="l">${l.comments }<br></c:forEach></td></tr>
</table>

<%@ include file="footer.jsp"%>
  
</body>
</html>