<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::View Logs::</title>
<meta charset="utf-8">	
 
 <!--Import jQuery before export.js-->
   <!-- bootstrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> 


    <!--Data Table-->
    <script type="text/javascript"  src=" https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript"  src=" https://cdn.datatables.net/buttons/1.2.4/js/dataTables.buttons.min.js"></script>

    <!--Export table buttons-->
    <!-- <script type="text/javascript"  src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
    <script type="text/javascript" src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/pdfmake.min.js" ></script>
    <script type="text/javascript"  src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/vfs_fonts.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.2.4/js/buttons.html5.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.2.1/js/buttons.print.min.js"></script> -->

	
	
	
<script type="text/javascript">

	$(document).ready(function() {
	    $('#viewLog').DataTable( {
	        order: [[2, 'asc']],
	        rowGroup: {
	            dataSrc: 2
	        }
	    } );
	} );
</script>
<style>
* {
	box-sizing: border-box;
}

#myInput {
	background-image: url('/css/searchicon.png');
	background-position: 10px 10px;
	background-repeat: no-repeat;
	width: 100%;
	font-size: 16px;
	padding: 12px 20px 12px 40px;
	border: 1px solid #ddd;
	margin-bottom: 12px;
}

#viewLog {
	width: 100%;
	/*border: 1px solid #ddd;
	font-size: 18px; */
}

#viewLog th, #viewLog td {
	text-align: left;
	padding: 12px;
}

#viewLog tr {
	border-bottom: 1px solid #ddd;
}

#viewLog tr.header, #viewLog tr:hover {
	background-color: #f1f1f1;
}

.navbar
{
background-color: green;
}



</style>
</head>
<body>
  
 <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#"><img id="myImg" height="50" src=./img/railtellogo.jpg></a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="addClient">Add Cient</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="uploadLogs">Upload Logs</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="viewLogs">View Logs</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="logout" style="margin-left:900px;">Log Out</a>
    </li>
  </ul>
</nav>
<table class="table table-striped table-bordered table-sm"  id="viewLog">
<thead>
<tr><th>ID</th><th>File Name</th><th>Date & Time</th><th>Client Name</th><th>Download</th></tr>
</thead>
<tbody>
<c:forEach items="${logFiles}" var="logFile">
<tr><td>${logFile.id}</td><td>${logFile.fileName}</td><td>${logFile.date}</td><td>${logFile.client}</td><td><a href="download/${logFile.id}" class="btn btn-success">Download</a></td></tr>

</c:forEach>
</tbody>
</table>
<div style="margin-top:200px;">
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  @Copyright
</nav>
 
</div>
</body>
</html>