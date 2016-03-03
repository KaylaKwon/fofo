<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../include/header.jsp" %>

  <body class="hold-transition login-page">
  <div class="wrapper">
  <div class="content-wrapper">
  	<!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            User Login
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">User Login</li>
          </ol>
        </section>
        
        <!-- Main content -->
        <section class="content">
		    <div class="login-box">
		      <div class="login-logo">
		        <a href="../home.jsp"><b>Admin</b>LTE</a>
		      </div><!-- /.login-logo -->
		      <div class="login-box-body">
		        <p class="login-box-msg">Sign in to start your session</p>
		        <form action="/user/loginPost" method="post">
		          <div class="form-group has-feedback">
		            <input type="email" name="uid" class="form-control" placeholder="USER ID">
		            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
		          </div>
		          <div class="form-group has-feedback">
		            <input type="password" name="upw" class="form-control" placeholder="Password">
		            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
		          </div>
		          <div class="row">
		            <div class="col-xs-8">
		              <div class="checkbox icheck">
		                <label>
		                  <input type="checkbox" name="useCookie"> Remember Me
		                </label>
		              </div>
		            </div><!-- /.col -->
		            <div class="col-xs-4">
		              <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
		            </div><!-- /.col -->
		          </div>
		        </form>
		
		        <div class="social-auth-links text-center">
		          <p>- OR -</p>
		          <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using Facebook</a>
		          <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign in using Google+</a>
		        </div><!-- /.social-auth-links -->
		
		        <a href="#">I forgot my password</a><br>
		        <a href="register.jsp" class="text-center">Register a new membership</a>
		
		      </div><!-- /.login-box-body -->
		    </div><!-- /.login-box -->
		</section>
	</div>
	
    <!-- jQuery 2.1.4 -->
    <script src="../../plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="../../bootstrap/js/bootstrap.min.js"></script>
    <!-- iCheck -->
    <script src="../../plugins/iCheck/icheck.min.js"></script>
    <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
    </script>
    </div>
  </body>


<%@ include file="../include/footer.jsp" %>