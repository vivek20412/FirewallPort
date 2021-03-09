<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />

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

<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="assets/js/ace-extra.min.js"></script>



<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
</head>

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

	$(document).on('click', '.toggle-password', function() {

	    $(this).toggleClass("fa-eye fa-eye-slash");
	    
	    var input = $("#pass_log_id");
	    input.attr('type') === 'password' ? input.attr('type','text') : input.attr('type','password')
	});
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
	<div align="left" style="width: 400px; height: 300px; margin-left: 400px;">
	
	
	<div id="forgot-box" class="forgot-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="ace-icon fa fa-key"></i>
												Change password
											</h4>

											<div class="space-6"></div>
										

									<form:form id="command" action="passchange.do" commandName="paswordchangeId" method="post"> 
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
														<p style="color: green;">
														
														${email}
														</p>
														
														</span>
													</label>
													<p style="color: red">
		
		${status}
		</p>
														<p>
											  New password
											</p>
													
															<input type="password" class="form-control" id="pass_log_id" placeholder="new password"   name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required />
														
												<span toggle="#password-field" class="fa fa-fw fa-eye field_icon toggle-password"></span>	
												
														<p>
											  Confirm password
											</p>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="confirmpassword"  type="password" class="form-control" htmlEscape="true" placeholder="confirm password"></form:input>
															
																
															
														</span>
													</label>
													
												

													<div class="clearfix">
														<input type="submit" class="width-35 pull-right btn btn-sm btn-primary" value="Submit"/>
														
												
													</div>
												
												</fieldset>
											</form:form>
										</div><!-- /.widget-main -->

								
									</div><!-- /.widget-body -->
								</div><!-- /.forgot-box -->
								</div>
	



					
					
					
				
			
									







	</div>



	

	<div>


							




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

