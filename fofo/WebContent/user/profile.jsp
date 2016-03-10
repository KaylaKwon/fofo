<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../include/header.jsp" %>

<body class="hold-transition login-page">
  <div class="wrapper">
  <div class="content-wrapper">
  	<!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Profile
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Profile</li>
          </ol>
        </section>
        
        <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <!-- left column -->
        <div class="col-md-6">
			<div class="box box-primary">
            	<div class="box-header with-border">
              		<h3 class="box-title">Profile</h3>
            	</div>
              <form role="form">
                <!-- text input -->
                <div class="box-body">
                
                	
	                <div class="form-group">
	                
	                  <label for="exampleInputFile">Image</label>
	                  <br>
	                	<input type="image" name="image" src="data:image/png;base64,iVBORw0KGgoAAAANSU
	                	hEUgAAAHkAAAB5CAMAAAAqJH57AAAAMFBMVEXJx8f////x8fHGxMT6+vrW1dXn5ubMysrQzs7b2tr09
	                	PT39/fs7Ozq6enj4uLT0tLh5spbAAACjklEQVRoge2a247rIAxFIQ4BcuP//3ZCJh21PSHY7XYrHbHe+
	                	rQEJuBLjWk0Go1GQx0i+rjSeJ9S3HAp5J8f87q1G3u704/z6vxH3OTXm/WPaQj64jTYU+akqiUTn5f7
	                	Rz9oitNY8u7uoBbuVFzwoY5KalcRb6ioKdTF1joFs7mM8Y1J4fMqfE3PzPD9Zu31vt9gNc1Mse081sxe
	                	MvqQETPKGXCkO765h4oFm20t9BKNArFdgWJJmK1dkGZBmLfvCmmeJOYJ+UWz7mwVs2zNyFdD8lFtuQnQL
	                	Foz1CxaM3K3v3e2ZeYRaRbdJCNOLMgLMtA77Gv3tuytikhzkpihOWCQHG5sCig4YhNU/L0MkASBhh4w
	                	I3gz0JUVf7vhhRWjeD42G17SMa9u7MnOEPMaW/FdA95LCc3+bmbHWjJebFiRxkd5h3G80Q2DA1pr4ln
	                	Fm9WVRU96vc9KE1Bpr3cu71B8Q+qei/ONbgo9cvVaau51pni+B+2Jgi/st9Idck9hv7Va23ecVzq6x+s
	                	wnz6X6lHO5tOeCbJ+LInDaZh7lWb+o7k0r1I3h1KDSm9k9Ev5pVx0zVd5oOaMbsvFLp7JXiHtvOErhYb
	                	KRJbIu6Gehw3OQ+fwtM+6eeXNODjcED7ERdQDtHNM78vJxFmm3em7+Nb3TSa9oj1Y3KsLJ3Ki1t+/dPE
	                	1d3zTmxnlbgrL+97MnGTqy8tKRi8rL6sVlARBH1TWYEWqwWJ22sDtiEjgxVo0d2XSs+pbUf+eC2fCgPue
	                	HmDUe6Ab5Jl63eV1xFtCXlm0xsH+pZYgyiZTEqo1n2gaJ6HS9+b9Ieo1risvydRAyvWUQe+A1boKXzSzW
	                	skaZhM6NfRr+0aj0Wg0/hN+APmaGv2nJYnFAAAAAElFTkSuQmCC" width="100">
	                
	                  <input type="file" id="exampleInputFile">
	                  <p class="help-block">Example block-level help text here.</p>
	                </div>
	                
	                <div class="form-group">
	                  <label for="name">Full name</label>
	                  <input type="text" class="form-control" placeholder="Enter ..." id="">
	                </div>
	                
           		   <div class="form-group">
	                	<label>Date of birth</label>
		                <div class="input-group">
	                 		 <div class="input-group-addon">
	                 	  		 <i class="fa fa-calendar"></i>
	                		 </div>
	                  		 <input type="text" class="form-control" data-inputmask="'alias': 'mm/dd/yyyy'"  data-mask>
	                  		 <!-- 이거 수정 -->
	               		</div>
               		</div>
	                
	                 <div class="form-group">
	                  <label for="name">School</label>
	                  <input type="text" class="form-control" placeholder="Enter ..." id="">
	                </div>
	               
	              
	                
	                <div class="col-xs-4">
          			    <button type="submit" class="btn btn-primary btn-block btn-flat">Edit</button>
         			</div><!-- /.col -->
	                
                </div>
                <!-- box-body -->
              </form>
            </div>
            <!-- /.box-primary -->
          </div>
          <!-- /.col-md-6 -->
        </div>
        <!--row -->
     
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
	
    
<script src="../../plugins/input-mask/jquery.inputmask.js"></script>
<script src="../../plugins/input-mask/jquery.inputmask.date.extensions.js"></script>

<script src="../../plugins/input-mask/jquery.inputmask.extensions.js"></script>
    <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
      $(function () {
       
        //Datemask dd/mm/yyyy
        $("[data-mask]").inputmask("mm/dd/yyyy", {"placeholder": "mm/dd/yyyy"});
      
      });
    </script>
    </div>
    </div>
  </body>

<%@ include file="../include/footer.jsp" %>
