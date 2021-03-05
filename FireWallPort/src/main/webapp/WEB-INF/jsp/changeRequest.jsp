<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>




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
															"<tr><td><input class='TF' type='checkbox' placeholder='Source Ip' name='record' /></td><td><input class='TF' type='text' placeholder='Source Ip' name='sourceip' /></td><td><input class='TF' type='text' placeholder='Source Port' name='sorceport' /></td><td><input class='TF' type='text' placeholder='Dest. Ip' name='destinationip' /></td><td><input class='TF' type='text' placeholder='Dest.Port' name='destinationport' /></td></tr>");

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
	<marquee class="marqueeText"> Welcome ${sessionScope.name}</marquee>
	<div class="container">
		<center>
			<div class="main">
				<div class="form-caption" style="color: white;">
					<h2>Update Details</h2>
				</div>
				<div class="form-body">
					<form:form
						action="${pageContext.request.contextPath}/customer/updateCustomerDetails"
						modelAttribute="customerDetailsUpdate" id="usrform">
						<span style="color: green; font-weight: bold;">${msg }</span>
						<div class="form-group">
							<label for="email">Service Request Number:</label>
							<form:input type="text" class="form-control"
								placeholder="Customer Name" id="customername" path="service_no"
								value="${customerdetails.service_no}" readonly="true" />
							<form:errors path="customername" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="email">Customer Name:</label>
							<form:input type="text" class="form-control"
								placeholder="Customer Name" id="customername"
								path="customername" value="${customerdetails.customername}" />
							<form:errors path="customername" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="email">Company Name:</label>
							<form:input type="text" class="form-control"
								placeholder="Company Name" id="companyname" path="companyname"
								value="${customerdetails.companyname}" />
							<form:errors path="companyname" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="email">Service Request Title:</label>
							<form:input type="text" class="form-control"
								placeholder="Source Server Ip" id="service_request_title"
								path="service_request_title"
								value="${customerdetails.service_request_title}" />
							<form:errors path="service_request_title" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="email">Service Request Description:</label>
							<form:input rows="5" cols="10" class="form-control"
								id="service_request_desc" path="service_request_desc"
								value="${customerdetails.service_request_desc}" />
							<form:errors path="service_request_desc" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="email">Choose Date:</label>
							<form:input type="date" class="form-control"
								placeholder="Source Ip Port" id="serverip_souirce_port"
								path="date" value="${customerdetails.date}" />
							<form:errors path="date" cssClass="error" />
						</div>

						<a id="add" class="btn btn-primary">Add</a>
						<a id="remove" onclick="removeRow()" class="btn btn-danger">Remove</a>
                         ${customerdetails.iplist.source_ip} list
						<table class="table" id="ipTable">
    
							<tr>
								<td>Select</td>
								<td>Source IP</td>
								<td>Source Port</td>
								<td>Destination IP</td>
								<td>Destination Port</td>
							</tr>
							<tr>
							
							    <td><c:forEach items="${customerdetails.iplist}" var="l"><input class='TF' type='checkbox' placeholder='Source Ip' name='record' /></c:forEach></td>
							    
								<td><c:forEach items="${customerdetails.iplist}" var="l"><input class='TF' type='text' placeholder='Source Ip' name='sourceip' value="${l.source_ip }" />
									</c:forEach></td>
								<td><c:forEach items="${customerdetails.iplist}" var="l"><input class='TF' type='text' placeholder='Source Ip' name='sorceport' value="${l.destination_ip }" />
									</c:forEach></td>
								<td><c:forEach items="${customerdetails.iplist}" var="l"><input class='TF' type='text' placeholder='Source Ip' name='destinationip' value="${l.source_port }" />
									</c:forEach></td>
								<td><c:forEach items="${customerdetails.iplist}" var="l"><input class='TF' type='text' placeholder='Source Ip' name='destinationport' value="${l.destination_port }" /><br>
									</c:forEach></td>

							</tr>
							<tr>
								<td></td>
								<td><input class='TF' type='text' placeholder='Source Ip'
									name='sourceip' /></td>
								<td><input class='TF' type='text' placeholder='Source Port'
									name='sorceport' /></td>
								<td><input class='TF' type='text' placeholder='Dest. Ip'
									name='destinationip' /></td>
								<td><input class='TF' type='text' placeholder='Dest.Port'
									name='destinationport' /></td>
							</tr>

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
</html> --%>