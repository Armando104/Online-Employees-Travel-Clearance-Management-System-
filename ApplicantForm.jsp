<%@page import="java.util.List"%>
<jsp:useBean id="dd" scope="request" class="pack.Applicant"></jsp:useBean>
<%@page import="pack.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
    //User u = (User) session.getAttribute("admin");
    //if (u == null) {
%>

<%
    //}
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
            <link href="bootstrap.css" rel="stylesheet" type="text/css"/>
            
    </head>
    <body style="background-color: #bcbcbc">

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




            <div style="width: 970px;padding-bottom: 6px;padding-top: 2px; background:url(images/banner-bg.jpg) no-repeat center;">
                <center>
                    <%
                        String kk=(String)request.getAttribute("ok");
                        if(kk==null){
                            kk="";
                        }
                    %>

                    <img src="staff/user.png" width="30" height="30" alt="user"/>
                    <p style="color: #9cff00;margin-bottom: 3x;background-color: black"><%=kk%></p>
                    

                    <form method="POST" style="padding-top:10px;" action="applicationAction.jsp">

                        <table border="0">
                            <tbody>
                                <tr>
                                    <td>
                                        Names
                                    </td>
                                    <td>
                                        <input style="width: 200px;" type="text" name="names" value="${dd.names}" required="" style="height: 18px;" />
                                        <input style="width: 200px;" type="hidden" name="app_id" value="${dd.app_id}" required="" style="height: 18px;" />
                                    </td>

                                    <td style="color: red">${dd.name_smsg}</td>

                                </tr> 
                                <tr>
                                    <td>
                                        address
                                    </td>
                                    <td>
                                        <input style="width: 200px;" type="text" name="address" value="${dd.address}"  style="height: 18px;" required="" />
                                    </td>
                                        
                                </tr
                                <tr>
                                    <td>
                                        telefone
                                    </td>
                                    <td>
                                        <input style="width: 200px;" type="text" name="telefone" value="${dd.telefone}" style="height: 18px;"  required=""/>
                                    </td>
                                        <td style="color: red">${dd.tel_msg}</td>
                                </tr> 
                                <tr>
                                    <td>
                                        gender
                                    </td>
                                    <td>
                                        <select name="gender" value="${dd.gender}">
                                            <option>Male</option>
                                            <option>Female</option>
                                        </select>  
                                    </td>
                                </tr>     
                                <tr>
                                    <td>
                                      nid
                                    </td>
                                    <td>
                                        <input style="width: 200px;" type="text" name="nid" value="${dd.nid}"  style="height: 18px;" required=""/>
                                    </td>
                                        <td style="color: red">${dd.nid_msg}</td>
                                </tr> 
                                <tr>
                                    <td>
                                        	dob
                                    </td>
                                    <td>
                                        <input style="width: 200px;" type="date" name="dob_s" value="${dd.dob_s}" style="height: 18px;" required="" />
                                    </td>
                                </tr> 
                                <tr>
                                    <td>
                                        email
                                    </td>
                                    <td>
                                        <input style="width: 200px;" type="text" name="email" value="${dd.email}" style="height: 18px;" required="" />
                                    </td>
                                        <td style="color: red">${dd.email_sg}</td>
                                </tr>
                                <tr>
                                    <td>
                                        Username
                                    </td>
                                    <td>
                                        <input style="width: 200px;" type="text" name="username" value="${dd.username}" style="height: 18px;" required="" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Password
                                    </td>
                                    <td>
                                        <input style="width: 200px;" type="password" name="password" value="${dd.password}" style="height: 18px;" required=""/>
                                    </td>
                                </tr>

                                <tr>
                                    <td>Hospital
                                    </td>
                                    <td>

                                        <%
                                            List<HospitalDepartment> l = HospitalDepartment.getHospital_DeptList();
                                            int i = 0;
                                        %>
                                        <select name="hospDept_id">
                                            <%
                                                while (i < l.size()) {
                                                    int hdi=l.get(i).getHospital_id();
                                                    Hospital sp=Hospital.getHospital_From_ID(hdi);
                                                    Department dp=Department.getDept_From_ID(l.get(i).getDepartment_id());
                                                    String jj=sp.getHospital_name();
                                            %>
                                            <option value="<%=l.get(i).getId()%>">
                                                <%="Hospital: "+sp.getHospital_name()+" Dept:"+dp.getDepartment_name()%>
                                            </option>
                                            <%

                                                    i++;
                                                }
                                            %>      

                                        </select>

                                    </td>
                                    <td></td>
                                </tr>
                                </tr> 
                                <tr>
                                    <td>
                                        <label>Status</label>
                                    </td>
                                    <td>
                                        <select name="status" value="${dd.status}">
                                            <option>Single</option>
                                            <option>Married</option>
                                            <option>In Relationship</option>
                                        </select>  
                                    </td>
                                </tr>   
                                



                                <tr>
                                    <td>

                                    </td>
                                    <td>
                                        <input type="submit" name="op" value="${dd.op}" class="btn btn-inverse" />
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
                            <P style="color: white">Ministry Of Defence<br>
                                    Rwanda
P.O. Box 6239 Kigali, Rwanda
 
Email:info@mod.rw</P>                      </div>
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
