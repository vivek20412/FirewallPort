<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Add Details</title>

    <!-- Bootstrap -->
    
 
    <!-- Bootstrap -->
    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/resources/font/font-awesome.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/resources/nprocess/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="/resources/animatecss/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/resources/customcss/custom.min.css" rel="stylesheet">
    <!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script type="text/javascript">

	$(document).ready(function(){
		//alert("hi");
		  $("#add").click(function(){
		    //alert("hi");
		    
		    $('#ipTable').append("<tr><td><input class='TF' type='checkbox' placeholder='Source Ip' name='record' /></td><td><input class='TF' type='text' placeholder='Host Name' name='hostname' /></td><td><select name='os'><option value='windows'>Windows</option><option value='linux'>Linux</option><option value='mac'>Mac</option></select></td><td><input class='TF' type='text' placeholder='Private IP' name='privateip' /></td></tr>");
          
			  });
		  /* $(".removeRow").click(function(){

           alert("remove");

		  }); */
		  
		});



	function removeRow()
	{
       //alert("remove");
        /* $('#ipTable tr:last').remove(); */ 
       $("table tbody").find('input[name="record"]').each(function(){
           if($(this).is(":checked")){
               $(this).parents("tr").remove();
           }
       });
       
		}

   function formSubmit()
   {
	   var customername=$('#customername').val();
	   var mob=$('#mob').val();
	   var email=$('#email').val();
	   var count=0;
	   //alert('mob='+mob+'email='+email);
	   if(customername==undefined || customername=='')
		   {
		   
              $('#customernameError').html("Customer Name is Required");
              count++;
              
		   }
	   if(mob==undefined || mob=='')
	   {
	     
          $('#mobError').html("Mobile Number is Required");
          count++;
         
	   }
	   if(email==undefined || email=='')
	   {
	     
          $('#emailError').html("E-Mail is Required");
          count++;
          
	   }
	   if(count>0)
		   {
		      $('#customernameError').show();
		      $('#mobError').show();
		      $('#emailError').show();
		      return false;
		   }
	   else
		   {
		   $('#customernameError').hide();
		      $('#mobError').hide();
		      $('#emailError').hide();
		      document.getElementById('form').submit();
		   }
	   }
	</script>
 

    

  </head>



  

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>Railtel</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <!-- <img src="images/img.jpg" alt="..." class="img-circle profile_img"> -->
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>${user.username}</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="/employee/ticketRequest">View Ticket Request</a></li>
                      <li><a href="/employee/request">Request</a></li>
                  
                     
                    </ul>
                  </li>
                
                </ul>
              </div>

            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
            
           
              
              <a data-toggle="tooltip" data-placement="top" title="Logout" href="/logout">
                <span class="glyphicon glyphicon-off" aria-hidden="true">Logout</span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <div class="nav toggle">
                  <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                </div>
                <nav class="nav navbar-nav">
                <ul class=" navbar-right">
                  <li class="nav-item dropdown open" style="padding-left: 15px;">
                    <a href="javascript:;" class="user-profile dropdown-toggle" aria-haspopup="true" id="navbarDropdown" data-toggle="dropdown" aria-expanded="false">
                      ${user.username }
                    </a>
                   
                    </ul>
                
              </nav>
            </div>
          </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Railtel Corporation of India Ltd <small></small></h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    
                    <span class="input-group-btn">
                     
                    </span>
                  </div>
                </div>
              </div>
            </div>

            <div class="clearfix"></div>

           	<div class="row">
						<div class="col-md-12 col-sm-12 ">
							<div class="x_panel">
								<div class="x_title">
									<h2>Customer ! <small>Add Details</small></h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
										</li>
										<li class="dropdown">
											<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-wrench"></i></a>
											<ul class="dropdown-menu" role="menu">
												<li><a class="dropdown-item" href="#">Settings 1</a>
												</li>
												<li><a class="dropdown-item" href="#">Settings 2</a>
												</li>
											</ul>
										</li>
										<li><a class="close-link"><i class="fa fa-close"></i></a>
										</li>
									</ul>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<br />
									
									
									<form:form action="${pageContext.request.contextPath}/employee/savePublicIPDetails" modelAttribute="customer"  class="form-horizontal form-label-left" method="post">
                     

				     <c:if test="${msg!=null}">
					<div class="alert alert-success"
						style="font-family: cursive; margin-top: 20px; border-radius: 20px;">
						${msg }</div>
				</c:if>
				     <input type="hidden" name="id" value="${customerDetails.id}" />
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="first-name">Customer Name: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
											
											<form:input type="text"
							class="form-control" placeholder="Customer Name" id="customername" path="customername" value="${customerDetails.customername }" readonly="true"/>
							<form:errors path="customername" cssClass="error"/>
												
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="last-name">Mobile Number:<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
											 <form:input  type="number"
							class="form-control" placeholder="Mobile Number" id="mob" path="mob" value="${customerDetails.mob }" readonly="true"/>
							<form:errors path="mob" cssClass="error"/>
											</div>
										</div>
										<div class="item form-group">
											<label for="middle-name" class="col-form-label col-md-3 col-sm-3 label-align">E-Mail</label>
											<div class="col-md-6 col-sm-6 ">
											<form:input  type="email"
							class="form-control" placeholder="E-Mail" id="email" path="email" value="${customerDetails.email}" readonly="true" />
							<form:errors path="email" cssClass="error"/>
											</div>
										</div>
								
							
								
								<table  class="table table-striped table-bordered" style="width:100%" id="ipTable">
                      <thead>
                        <tr><th>Host Name</th><th>OS</th><th>Private IP</th><th>Public IP</th><th>NAT</th></tr>
                      </thead>


                      <tbody>
                      
                      <tr>

					
					<td><c:forEach items="${customerDetails.serverDetails}" var="l"><input class='TF' type='text'  name='hostname' value="${l.hostname}" readonly="true"/><input type="hidden" name="serverDetails_id" value="${l.id }"/></c:forEach></td>
					<td><c:forEach items="${customerDetails.serverDetails}" var="l"><input class='TF' type='text'  value="${l.os}" name="os" readonly="true"/></c:forEach></td>
					<td><c:forEach items="${customerDetails.serverDetails}" var="l"><input class='TF' type='text'  name='privateip' value="${l.privateip}" readonly="true"/></c:forEach></td>
					<td><c:forEach items="${customerDetails.serverDetails}" var="l"><input class='TF' type='text' placeholder='Public IP' name='publicip' value="${l.publicip}" /></c:forEach></td>
					<td><c:forEach items="${customerDetails.serverDetails}" var="l"><select name="nat"><option value="select">Select NAT</option>
					<option value="snat">SNAT</option>
					<option value="dnat">DNAT</option></select>
					</c:forEach></td>
					</tr>
									

                      </tbody>
                    </table>
                    	
                  
										<div class="ln_solid"></div>
										<div class="item form-group">
											<div class="col-md-6 col-sm-6 offset-md-3">
												
												<center><button class="btn btn-primary" type="reset" >Reset</button>
												<button type="submit" class="btn btn-success">Submit</button></center>
											</div>
										</div>

									</form:form>
								</div>
							</div>
						</div>
					</div>
      

            
                </div>
              </div>
            </div>
         
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            @2020 Railtel Corporation of india Ltd
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="/resources/jquery/jquery.min.js"></script>
    <!-- Bootstrap -->
   <script src="/resources/bootstrap/bootstrap.bundle.min.js"></script>
    <!-- FastClick -->
    <script src="/resources/fastclick/fastclick.js"></script>
    <!-- NProgress -->
    <script src="/resources/nprocess/nprogress.js"></script>
    <!-- iCheck -->
    <script src="/resources/icheck/icheck.min.js"></script>
    <!-- Datatables -->
    <script src="/resources/Customdatatables/jquery.dataTables.min.js"></script>
    

    <!-- Custom Theme Scripts -->
    <script src="/resources/datatablesJS/custom.min.js"></script>

  </body>