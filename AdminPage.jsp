<%@page import="pack.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
    User u = (User) session.getAttribute("admin");
    if (u == null) {
%>
<jsp:forward page="index_1.jsp"/>
<%
    }
%>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>RDF</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Oswald|Open+Sans' rel='stylesheet' type='text/css'>
            <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
            <script type="text/javascript" src="js/jquery-ui.js"></script>
            <script type="text/javascript" src="js/carouselScript.js"></script>
            <link href="css/carousel.css" rel="stylesheet" type="text/css"/>
            
       
            
          <!--
          <link href="bootstraps/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
          <link href="bootstraps/js/bootstrap.min.js" />
          -->
          
    </head>
    <body style="background-color: #bcbcbc">

        <div class="clear"></div>
        <!-- end of SOCIAL ICONS -->
        <div class="header">
            <div class="row">
                <div class="logo " style="height: 130px;width: auto;float: left">
                    <img src="images/Flag-map_of_Rwanda.svg.png" width="200 " height="175" alt="Flag-map_of_Rwanda.svg" style="height: 80px;width:  100px;margin-top: -00px;"/>

                </div>
                <div class="" style="width: auto;float: left">
                    <center>
                        <h1 style="color: chartreuse">Ministry Of Defence</h1>
                        <h3 style="color: chartreuse">Rwanda Defence Force</h3>
                    </center>
                </div>
            
            
                <div class="menu " style="width: auto;float: right">
                    <ul>
                        <li><a href="index_1.jsp" class="active">Home</a></li>
                        <li><a href="ApplicantView.jsp"><span>Applicant Records</span></a></li>
                     
                        <li><a href="Exam_Form.jsp">Exam Info</a></li>
                        
                        
                        <li><a href="ExamCenterView.jsp">Site Exam</a></li>
                                                
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




            <div style="width: 970px;height: 200px;background:url(images/banner-bg.jpg) no-repeat center;">
                <center>


                    <img src="staff/user.png" width="30" height="30" alt="user"/>                      <p style="color: #9cff00;margin-bottom: -10px;background-color: black">HELLO <%=u.getNames()%></p>
                    <img src="" width="640" height="480" alt="" style="height: 200px;width: 400px;"/>
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
                            <P style="color: white">Ministry Of Defence<br>
                                    Rwanda
                                    P.O. Box 23 Kigali, Rwanda

                                    Email:info@mod.rw</P> 
                        <p style="color: white">www.mod.gov.rw<br> rights reserved </p>
                        
                        </div>
                    </div>
                </div>
                 
                <div class="panel border-right" style="">
                    <div class="title">
                        <h1>FORMS</h1>

                        <div class="content">
                          
                             
                            <p style="color: white"><a style="color: white" target="_blank" href="User_List.jsp"> All users</a></p>
                          
                           <p style="color: white"><a style="color: white" target="_blank" href="Hospital_Form.jsp"> Hospital News</a></p>
                        <p style="color: white"><a style="color: white" target="_blank" href="HospitalDept.jsp"> Set Hospital</a></p>
                          
                        <p style="color: white"><a style="color: white" target="_blank" href="Dept_Form.jsp"> About Department</a></p>
                        <p style="color: white"><a style="color: white" target="_blank" href="Region_View.jsp">Region Info</a></p>
                        <p style="color: white"><a style="color: white" target="_blank" href="result_View.jsp"> Set Travel</a></p>
                            
                            <p style="color: white"><a style="color: white" target="_blank" href="BattallionView.jsp"> Batallion View</a></p>
                        </div>
                    </div>
                </div>
                 
                <div class="panel border-right">
                    <div class="title">
                        <h1>REPORTS</h1>

                        <div class="content">
                           
                           
                          
                            
                            
                            <p style="color: white"><a style="color: white" target="_blank" href="Piechart.jsp"> Statistics</a></p>
                            <form method="POST" action="App_report.jsp">
                                
                               
                                <p style="color: white"><select name="pickdate">
                                       <option>2017</option>
                                        <option>2018</option>
                                         <option>2019</option>
                                          <option>2020</option>
                                    </select>
                                        
                                </p>
                                <input type="Submit"value="Applicants"/>
                            </form>
                            <form method="POST" action="report2.jsp">
                                
                               
                                <p style="color: white"><select name="pickdate">
                                       <option>2017</option>
                                        <option>2018</option>
                                         <option>2019</option>
                                          <option>2020</option>
                                    </select>
                                        
                                </p>
                                <input type="Submit"value="Exam Results"/>
                            </form>
                            
                            <form method="POST" action="Report_1.jsp">
                                
                               
                                <p style="color: white"><select name="pickdate">
                                       <option>2017</option>
                                        <option>2018</option>
                                         <option>2019</option>
                                          <option>2020</option>
                                    </select>
                                        
                                </p>
                                <input type="Submit"value=" Pending"/>
                            </form>
                            
                            <form method="POST" action=report.jsp>
                                
                               
                                <p style="color: white"><select name="pickdate">
                                       <option>2017</option>
                                        <option>2018</option>
                                         <option>2019</option>
                                          <option>2020</option>
                                    </select>
                                        
                                </p>
                                <input type="Submit"value="Deployed"/>
                            </form>
                            
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
