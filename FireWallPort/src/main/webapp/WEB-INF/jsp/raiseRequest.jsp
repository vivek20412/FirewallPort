<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/form.css">

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#add")
								.click(
										function() {
											//alert("hi");

											$('#ipTable')
													.append(
															"<tr><td><input class='TF' type='checkbox' placeholder='Source Ip' name='record' /></td><td>Activation Time:<input class='TF' type='datetime-local' name='activationtime' /></td><td>Deactivation Time:<input class='TF' type='datetime-local'  name='deactivationtime' /></td></tr>"
														   +"<tr><td></td><td>Source Ip<select name='sourceIp'><option>---select---</option><option>192.168.23.12</option><option>192.168.23.12</option><option>192.168.23.12</option></select></td><td>IP Entry<input class='TF' type='text' name='ipentry' placeholder='IP Entry' /></td></tr>"
														   +"<tr><td></td><td>Destination Ip<select name='destinationip'><option value='select'>---Select---</option><option>192.168.23.12</option><option>192.168.23.12</option><option>192.168.23.12</option></select></td><td><input class='TF' type='text' name='ipentry' placeholder='IP Entry' /></td></tr>"
														   +"<tr><td></td><td>Direction<select name='direction'><option value='select'>---Select---</option><option>In Bound</option><option>Out Bound</option></select></td><td>Port:<input class='TF' type='text' name='port' placeholder='Port'' /></td></tr>"
														   +"<tr><td></td><td>Action<select name='action'><option value='select'>---Select---</option><option value='allow'>Allow</option><option value='deny'>Deny</option></select></td><td>Comment<textarea class='TF' name='comments' placeholder='Comment' rows='5' cols='10' ></textarea></td></tr>");

										});
						/* $(".removeRow").click(function(){

						   alert("remove");

						}); */

					});

	function removeRow() {
		//alert("remove");
		/* $('#ipTable tr:last').remove(); */
		$("table tbody").find('input[name="record"]').each(function() {
			if ($(this).is(":checked")) {
				$(this).parents("tr").remove();
			}
		});

	}
</script>
</head>
<body>



	<%@ include file="header.jsp"%>
	<%-- <marquee class="marqueeText"> Welcome ${sessionScope.name}</marquee> --%>
	<div class="container">
	<div class="tickest">
	  <%-- <table class="table">
	  <tr><th>ID</th><th>ID</th><th>ID</th><th>ID</th><th>ID</th><th>ID</th></tr>
	  <tr>
	  <c:forEach items="${tickets}" var="l">
	  <td>${l.id}</td>
	  <td>${l.customername}</td>
	  
	  </c:forEach>
	  </tr>
	  
	  </table> --%>
	</div>
		<center>
			<div class="main">
				<div class="form-caption" style="color: white;">
					<h2>Raise Request</h2>
				</div>
				<div class="form-body">
					<form:form
						action="${pageContext.request.contextPath}/customer/doRequest"
						modelAttribute="customerDetails" id="usrform">
						<span style="color: green; font-weight: bold;">${msg }</span>
						<div class="form-group">
							<label for="email">Customer Name:</label>
							<form:input type="text" class="form-control"
								placeholder="Customer Name" id="customername"
								path="customername"  value="${user.username}" />
							<form:errors path="customername" cssClass="error" />
							
						</div>
						<div class="form-group">
							<label for="email">Mobile Number:</label>
							<form:input type="text" class="form-control"
								placeholder="Mobile Number" id="mob"
								path="mob"  value="${user.mob}" />
							<form:errors path="customername" cssClass="error" />
							
						</div>
						<div class="form-group">
							<label for="email">E-Mail:</label>
							<form:input type="text" class="form-control"
								placeholder="E-Mail" id="email"
								path="email"  value="${user.email}" />
							<form:errors path="customername" cssClass="error" />
							
						</div>
						<table class="table">
						<tr><th>Hostname</th><th>OS</th><th>Private IP</th><th>Public IP</th><th>NAT</th></tr>
						<tr><td><input type="text" name="hostname" value="${server.hostname }"/></td><td><input type="text" name="os" value="${server.os }" /></td><td><input type="text" value="${server.privateip }" name="privateip"/></td><td><input type="text" value="${server.publicip}" name="publicip"/></td><td><input type="text" value="${server.nat }" name="nat"/></td></tr>
						</table>
						<a id="add" class="btn btn-primary">Add</a>
						<a id="remove" onclick="removeRow()" class="btn btn-danger">Remove</a>
                         <%-- ${customerdetails.iplist.source_ip} list --%>
						<table class="table" id="ipTable">
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