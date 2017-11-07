<%@page import="java.util.List"%>
<jsp:useBean id="exam" scope="request" class="pack.ExamClass"></jsp:useBean>
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
                        <li><a href="Question_Form.jsp">Set Question</a></li>
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
                    <%
                        String hh = exam.getMsg();
                        if (hh == null) {
                            hh = "";
                        }
                    %>

                    <img src="staff/user.png" width="30" height="30" alt="user"/>
                    <p style="color: #9cff00;margin-bottom: -10px;background-color: black"><%=hh%></p>
                    
                    <form method="POST" style="padding-top:10px;" action="setExam_Action.jsp">

                        <table border="0">
                            <tbody>

                                <tr>
                                    <td>
                                        <label>Exam Title:</label>
                                    </td>
                                    <td>
                                        <input style="width: 200px;height: 18px" type="text" name="title" value="${exam.title}" required=""/>
                                        <input style="width: 200px;height: 18px" type="hidden" name="exam_id" value="${exam.exam_id}" required=""/>
                                    </td>
                                    <td style="color: red"></td>

                                </tr> 

                                <tr>
                                    <td>
                                        <label>Duration</label>
                                    </td>
                                    <td>
                                        <select name="examTime" style="width: 205px;height: 18px;" value="${exam.examTime}">
                                            <option>1 Hour</option>
                                            <option>2 Hours</option>
                                            <option>3 Hours</option>
                                        </select>  
                                    </td>
                                    <td style="color: red"></td>

                                </tr> 


                                            <tr>
                                    <td>Department
                                    </td>
                                    <td>

                                        <%
                                            List<Department> l = Department.getDepartmentist();
                                            int i = 0;
                                        %>
                                        <select name="dept" style="width: 205px;">
                                            <%
                                                while (i < l.size()) {
//                                                    int hdi=l.get(i).getDepartment();
//                                                    Department sp=Department.getDept_From_ID(hdi);
//                                                    int kk=sp.getDepartment_id();
//                                                    Department dp=Department.getDept_From_ID(l.get(i).getDepartment());
//                                                    String jj=dp.getDepartment_name();
                                            %>
                                            <option value="<%=l.get(i).getDepartment_id() %>">
                                                <%=l.get(i).getDepartment_name() %>
                                            </option>
                                            <%

                                                    i++;
                                                }
                                            %>      

                                        </select>

                                    </td>
                                    <td></td>
                                </tr>
                                            <tr>
                                    <td>
                                        <label>Exam Date</label>
                                    </td>
                                    <td>
                                        <input style="width: 200px;" type="date" name="exam_date" value="${exam.exam_date}" style="height: 18px;" />
                                    </td>
                                </tr> 



                                <tr>
                                    <td>
                                        <label></label>
                                    </td>
                                    <td>
                                        <input style="width: 50px;height: 30px" type="submit" name="op" value="${exam.op}" readonly="readonly" />
                                    </td>
                                </tr> 
                            </tbody>
                        </table>
                    </form>
                    <a href="Exam_List.jsp">EXAM VIEW</a>
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
                                <h1 style="text-align: left">Online Employees Travel Clearance Management System for Rwanda Defense Force</h1>
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
                            <P style="color: white">Ministry Defence<br>
                                    Kigali
                                    P.O. Box 6239 Kigali, Rwanda

                                    Email:info@mod.rw</P>                      </div>
                    </div>
                </div>
                <div class="panel border-right">
                    <div class="title">
                        <h1>REPORTS</h1>

                        <div class="content">
                            
                        </div>
                    </div>
                </div>
                <div class="panel border-right">
                    <div class="title">
                        <h1>COPY RIGHT</h1>

                        <div class="content">
                            <p style="color: white">www.mod.rw<br> rights reserved </p>
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
