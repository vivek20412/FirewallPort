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

    <title>Login | </title>

    <!-- Bootstrap -->
    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/resources/font/font-awesome.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/resources/nprocess/nprogress.csss" rel="stylesheet">
    <!-- Animate.css -->
    <link href="/resources/animatecss/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/resources/customcss/custom.min.css" rel="stylesheet">
  </head>


<<style>
<!--

-->

</style>
  <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
        
        
          <section class="login_content">
           
              <h1 >Login</h1>
              
            
              	<form:form action="login" method="post">
              	  <c:if test="${param.error !=null }">
					<div class="alert alert-danger alert-dismissible fade show"
						style="font-family: cursive; margin-top: 20px; border-radius: 20px;">
						<i>Wrong Credentials</i>
					</div>
					
				</c:if>
				<c:if test="${param.logout!=null}">
					<div class="alert alert-success"
						style="font-family: cursive; margin-top: 20px; border-radius: 20px;">Logged
						out Sucessfully!</div>
				</c:if>
              <div>
                <input type="text" class="form-control" name="username" placeholder="Username" required="" />
              </div>
              <div>
                <input type="password" class="form-control" name="password" placeholder="Password" required="" />
              </div>
              <div>
                <input type="submit" class="btn btn-primary" value="Login"/>
                <input type="button" class="btn btn-secondary active" value="cancel"/>
                
              </div>
</form:form>
              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">New user
                  <a href="#signup" class="to_register"> Create Account</a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                
                  <p>©2020 All Rights Reserved. Railtel Corporation of India. Privacy and Terms</p>
                </div>
              </div>
           
          </section>
        </div>

      
          
      </div>
    </div>
  </body>
</html>
