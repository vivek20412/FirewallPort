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

    <title>Ticket Request Details</title>

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
 

    

  </head>
  <script type="text/javascript">
  $(document).ready( function () {
	    $('#datatable').DataTable();
	} );
	  

</script>

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
                    <input type="text" class="form-control" placeholder="">
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
                    <h2>Ticket Request Details  <small></small></h2>
                  
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                      <div class="row">
                          <div class="col-sm-12">
                            <div class="card-box table-responsive">
                    <p class="text-muted font-13 m-b-30">
                    
                    </p>
                    <table id="datatable" class="table table-striped table-bordered" style="width:100%">
                      <thead>
                        <tr>
                          <th>ID</th>
                          <th>Name</th>
                          <th>Mobile No</th>
                          <th>Service Request No</th>
                          <th>Ticket Status</th>
                          <th>Action</th>
                        </tr>
                      </thead>


                      <tbody>
                       <c:forEach items="${list}" var="ticket">
<tr><td>${ticket.id }</td><td>${ticket.customername}</td><td>${ticket.mob}</td><td><a href="${pageContext.request.contextPath}/employee/viewSingleRequest/${ticket.service_no}">${ticket.service_no}</a></td><td>
<c:if test="${ticket.ticketStatus eq 'pending'}">  
    <span class="btn btn-danger">Pending</span>  
    </c:if> 
	<c:if test="${ticket.ticketStatus eq 'approved'}">  
    <span class="btn btn-success">Approved</span>  
    </c:if> 
    <c:if test="${ticket.ticketStatus eq 'hold'}">  
    <span class="btn btn-primary">Hold</span>  
    </c:if> 
    <c:if test="${ticket.ticketStatus eq 'completed'}">  
    <span class="btn btn-success">Completed</span>  
    </c:if> 
    <c:if test="${ticket.ticketStatus eq 'rejected'}">  
    <span class="btn btn-danger">Rejected</span>  
    </c:if></td>
    <td>
    <c:if test="${ticket.ticketStatus eq 'approved'}">  
    <a href="configure/${ticket.id}" class="btn btn-success">Configure</a>
    </c:if></td>
    </tr>
</c:forEach>

                      </tbody>
                    </table>
                  </div>
                  </div>
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
