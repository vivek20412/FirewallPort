
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Railtelmail</title>

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />


<link rel="stylesheet" href="css/box.css" />


<!-- page specific plugin styles -->

<!-- text fonts -->



<!-- ace styles -->
<link rel="stylesheet" href="assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />


<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="assets/js/ace-extra.min.js"></script>


<style type="text/css">

.plinput{
display:inline-block;
width:200px;
margin-right: 200px;

}

</style>


<style>
.btn-circle {
	width: 200px;
	height: 200px;
	padding: 12px 18px;
	font-size: 24px;
	line-height: 1.33;
	border-radius: 100px;
	text-align: center;
}

.divbutton {
	right: 150px;
}
</style>

<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>




<body class="no-skin" oncontextmenu="return false;" onLoad="noBack();"
	onpageshow="if (event.persisted) noBack();" onUnload="">


	<div id="navbar" class="navbar navbar-default  ace-save-state">
	


			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand"> <small> <i class=""></i>
						Railtel Corporation of India Ltd
				</small>
				</a>
			</div>
			<div class="navbar-header pull-right">


			
			</div>

		</div>
		

   
	<br>
	<br>
	<div align="right" style="width: 400px; height: 300px; margin-left: 400px;">
	
	
	<div id="forgot-box" class="forgot-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header Blue lighter bigger">
												<i class="ace-icon fa fa-key"></i>
											Change Password
											</h4>
		
	<div class="space-6" >
	
	</div>
		<p style="color: red">
		
		${status}
		</p>
											<p>
											
												Enter your email id to receive otp  ${domain}
												<ol>
												<c:forEach var="doma" items="${domain}">
												
												 ${doma}
												</c:forEach>
											</p>
											
											</ol>

											

									<form:form id="command" action="sendotp.do"  commandName="employeeId" method="post"> 
												<fieldset>
											
														<div class="plinput" >
														<form:input path="emailid" placeholder="Email" htmlEscape="true" maxlength="40" size="48"/>
														</div>
															<br>
															
												</br>

													<div class="clearfix">
														<input type="submit" class="width-35 pull-right btn btn-sm btn-info" value="Send Me!"/>
														
												
													</div>
												</fieldset>
											</form:form>
										</div><!-- /.widget-main -->

									
									</div><!-- /.widget-body -->
								</div><!-- /.forgot-box -->





	<!-- 		</div>
			/.widget-main
		</div> -->
		<!-- /.widget-body -->
	</div>
	<!-- /.widget-box -->
	<!-- /.col -->
	<!-- /.main-content -->


	

	<div>


							



	<script src="assets/js/jquery-2.1.4.min.js"></script>
	
	<script src="assets/js/bootstrap.min.js"></script>

	<script src="assets/js/jquery-ui.custom.min.js"></script>
	<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="assets/js/jquery.easypiechart.min.js"></script>
	<script src="assets/js/jquery.sparkline.index.min.js"></script>
	<script src="assets/js/jquery.flot.min.js"></script>
	<script src="assets/js/jquery.flot.pie.min.js"></script>
	<script src="assets/js/jquery.flot.resize.min.js"></script>

	<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>

	<!-- inline scripts related to this page -->

</body>
</html>

