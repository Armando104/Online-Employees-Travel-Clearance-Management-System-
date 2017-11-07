<%@page import="pack.*"%>
<%@page import="java.util.List"%>
<jsp:useBean id="dd" scope="request" class="pack.User"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>RDF</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Oswald|Open+Sans' rel='stylesheet' type='text/css'>
            <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
            <script type="text/javascript" src="js/jquery-ui.js"></script>
            <script type="text/javascript" src="js/carouselScript.js"></script>
            <link href="bootstrap.css" rel="stylesheet" type="text/css"/>
            
          <%--  <link href="bootstraps/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
          <link href="bootstraps/js/bootstrap.min.js" rel="stylesheet" type="text/css"/>--%>
          
             
            
    </head>
    <body style="background-color: #bcbcbc">

        <div class="clear"></div>
        <!-- end of SOCIAL ICONS -->
         <div class="header">
            <div class="row">
                <div class="logo" style="height: 130px;width: auto;float: left;margin-left: 200px;">
                    <img src="images/Flag-map_of_Rwanda.svg.png" width="200 " height="175" alt="Flag-map_of_Rwanda.svg" style="height: 80px;width:  100px;margin-top: -00px;"/>
                   
                </div>
                <div style="width: auto;float: left;">
                    <center>
                        <h1 style="color: chartreuse">Ministry Of Defence</h1>
                        <h3 style="color: chartreuse">Rwanda Defence Force</h3>
                     </center>
                </div>
                <div class="menu" style="width: auto;float: right">
                    <ul>
                        <li><a href="index_1.jsp" class="active">Home</a></li>
                        <li><a href="ApplicantForm.jsp">Sign Up</a></li>
                        <li><a href="ExamCenterView.jsp">Timetable</a></li>
                        <li><a href="App_report.jsp">Applicants</a></li>
                        <li><a href="LoginForm.jsp">Login</a></li>
                    </ul>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <!-- end of MENU WRAPPER -->
        <div class="banner-wrapper">
            <div class="row">

            </div>


        </div>
        <center>




            <div style="width: 970px;height: 420px;background:url(images/banner-bg.jpg) no-repeat center;">
                
                 <div style="width:100%;height: auto;float: right">
                    <center>
               
              <br> <br>
                    
                    <br><br><br>
                    <h2 style="color: #000000">Please Provide Correct Username And Password</h2>
                 ${dd.msg}
                <form action="LoginProcessing.jsp" method="POST">
                    <table border="0">
                        <tbody>
                            <tr>
                                <td>Username</td>
                                <td><input type="text" name="username" value="${dd.username}" /></td>
                                <td style="color: red"></td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td><input type="password" name="password" value="${dd.password}" /></td>
                                <td style="color: red"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Login" class="btn btn-large"/></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>

                </form>
                               
                            
          </center>
                </div>
            </div>
        </center>
            
       
        <!-- end of BANNER WRAPPER -->
         
        <!-- end of BOX WRAPPER -->
       
        <div class="footer-wrapper" style="margin-top: -0px;margin-bottom: -10px">
            <div class="footer">
                <center>
                <p> <p style="color: white">www.mod.rw <br>All rights reserved. </p></p></center>
            </div>
             
        </div>
        
        <!----footer-wrapper-------->
        <!-- end of WRAPPER -->
    </body> 
</html>
