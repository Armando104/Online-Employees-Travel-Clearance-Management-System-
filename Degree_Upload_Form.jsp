<%@page import="java.util.List"%>
<%@page import="pack.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
    //User u = (User) session.getAttribute("admin");
    //if (u == null) {
%>
<%
   // }
%>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>myict</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Oswald|Open+Sans' rel='stylesheet' type='text/css'>
            <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
            <script type="text/javascript" src="js/jquery-ui.js"></script>
            <script type="text/javascript" src="js/carouselScript.js"></script>
            <link href="css/carousel.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="clear"></div>
        <!-- end of SOCIAL ICONS -->
        <div class="header">
            <div class="row">
                <div class="logo" style="height: 130px;width: auto;float: left">
                    <img src="images/Flag-map_of_Rwanda.svg.png" width="200 " height="175" alt="Flag-map_of_Rwanda.svg" style="height: 80px;width:  100px;margin-top: -00px;"/>

                </div>
                <div style="width: auto;float: left">
                    <center>
                        <h1 style="color: chartreuse">Ministry Of Defence</h1>
                        <h3 style="color: chartreuse">Rwanda Defence Force</h3>
                    </center>
                </div>
                <div class="menu" style="width: auto;float: right">
                    <ul>
                        <li><a href="index_1.jsp" class="active">Home</a></li>
                        <li><a href="ApplicantForm.jsp">Applicant Sign Up</a></li>
                        <li><a href="ApplicantView.jsp">Applicant Records</a></li>
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




            <div style="width: 970px;padding-bottom: 5px;padding-top: 5px; background:url(images/banner-bg.jpg) no-repeat center;">
                <center>
                     
                    
                     

                    <img src="staff/user.png" width="30" height="30" alt="user"/>
                    <p style="color: #9cff00;margin-bottom: -10px;background-color: black"></p>
                    
                    <form method="POST" style="padding-top:10px;" action="Degree_Process.jsp" enctype="multipart/form-data">
                      
                        <table border="0">
                            <tbody>
                                
                                <tr>
                                            <td>Upload your Degree</td>
                                        </tr>
                                        <tr>
                                            <td><input type="file" name="degree" size="50" class="btn btn-navbar"/></td>
                                        </tr>                               
                                                         
                                <tr>
                                    <td>
                                        <label></label>
                                    </td>
                                </tr>
                                        <tr>
                                        <td>
                                        
                                        <input type="submit" name="op" value="SUBMIT" class="btn btn-inverse" />
                                    </td>
                                </tr> 
                            </tbody>
                        </table>
                    </form>
                </center>
            </div>
            <!--
            <div style="width: 970px;height:50px;color:#1c263c;border-top: 1px solid #000;background:url(images/banner-bg.jpg) no-repeat center;">
                <center>
                    <h1 style="color:#1c263c">ONLINE RDB STAFF FORUM</h1>
                    <br>
                    </center>
            </div>
            -->
        </center>
        <!-- end of BANNER WRAPPER -->

        <!-- end of BOX WRAPPER -->
        <div class="page padding-bottom">
            <div class="content_wrap">
                <div class="left-panel" style="width: 100%">
                    <div class="panel">
                        <div class="title">
                            <div class="icons"><img src="images/arrow-icons.png" alt="" /></div>
                            <center>
                                <h1 style="text-align: left">Online Employees Travel Clearance Management System for Rwanda Defence Force</h1>
                            </center>
                        </div>

                    </div>

                    <div class="clear"></div>
                </div>

                <div class="clear"></div>
            </div>
            <!-- end of BOX WRAPPER -->
            <div class="clear"></div>
        </div>
        <div class="footer-wrapper" style="margin-top: -20px">
            <div class="footer">

                <div class="panel" style="">
                    <div class="title">
                        <h1>CONTACT US</h1>

                        <div class="content">
                            <P style="color: white">Ministry Of Youth & ICT<br>
                                    Pension Plaza, KN 3 Rd, Kigali
                                    P.O. Box 23 Kigali, Rwanda

                                    Email:info@myict.gov.rw</P>                      </div>
                    </div>
                </div>
                <div class="panel border-right">
                    <div class="title">
                        <h1>REPORTS</h1>

                        <div class="content">
                            <p style="color: white"><a style="color: white" target="_blank" href="Piechart.jsp">Graduates Statistics</a></p>
                            <p style="color: white"><a style="color: white" target="_blank" href="All_Graduates.jsp">All Graduates List</a></p>
                        </div>
                    </div>
                </div>
                <div class="panel border-right">
                    <div class="title">
                        <h1>COPY RIGHT</h1>

                        <div class="content">
                            <p style="color: white">www.myict.gov.rw<br> rights reserved </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <!----footer-wrapper-------->
        <!-- end of WRAPPER -->
    </body>
</html>
