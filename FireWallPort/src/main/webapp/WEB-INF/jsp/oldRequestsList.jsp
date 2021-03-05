<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
  
  <!- custom files-->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css">
</head>
<body>
<%@ include file="header.jsp"%>
<marquee class="marqueeText"> Welcome ${sessionScope.name}</marquee>

<table class="table table-bordered" style="margin-top:50px;margin-bottom:50px;">
<thead class="thead-dark" id="recordTable">
   <tr><th>ID</th><th>Service Request No</th><th>Customer Name</th><th>Company Name</th><th>Service Request Title</th><th>Service Request Description</th><th>Date</th><th>Server IP(Source)</th><th>Server IP(Destination)</th><th>Server Port(Source)</th><th>Server Port(Destination)</th><th>Action</th></tr>
</thead>
<c:forEach items="${oldRequestsList}" var="requests">
<tbody>
<tr><td>${requests.id}</td><td><a href="${requests.service_no}">${requests.service_no}</a></td><td>${requests.customername}</td><td>${requests.companyname}</td><td>${requests.service_request_title}</td><td>${requests.service_request_desc}</td><td>${requests.date}</td>
<td><c:forEach items="${requests.iplist}" var="l">${l.source_ip }<br></c:forEach></td>
<td><c:forEach items="${requests.iplist}" var="l">${l.destination_ip }<br></c:forEach></td>
<td><c:forEach items="${requests.iplist}" var="l">${l.source_port }<br></c:forEach></td>
<td><c:forEach items="${requests.iplist}" var="l">${l.destination_port }<br></c:forEach></td>
<td><a href="changeRequest/${ requests.service_no}" class="btn btn-success">Change Request</a></td>
</tr>

</tbody>
</c:forEach>
</table>

    
<%@ include file="footer.jsp"%>


</body>
</html>