
<%@page import="java.util.Date"%>

<%@page import="java.util.List"%>
<%@page import="pack.*"%>
<%@page import="pack.*"%>
<%
    User u = (User) session.getAttribute("applicant");

    if (u == null) {
%>
<jsp:forward page="index_1.jsp"/>
<%        }
    int no = 1;
    List<Result> sa = Result.getList();
    for (int i = 0; i < sa.size(); i++) {
          request.setAttribute("op", sa.get(i).getStatus());
          request.setAttribute("po", sa.get(i).getPhysical_Status());
    }

    Applicant cc = Applicant.getApplicant_From_ID(u.getUser_id());
    Selectee_Applicant po = Selectee_Applicant.getSelectee_AppID(cc.getUser_id());
    if (po != null) {
        Date end = po.getMission_EndDate();
        Date today = new Date();
        if ((end.after(today))||(po==null)) {
%>
<jsp:forward page="Applicant_OK.jsp"/>
<%
        }
    }
%>


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
                        <h3 style="color: chartreuse">Ministry Of Defence</h3>
                        <h5 style="color: chartreuse">Rwanda Defence Force</h5>
                    </center>
                </div>
                <div class="menu" style="width: auto;float: right;margin-left: 100px;">



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




            <div style="width: 970px;height: 470px;background:url(images/banner-bg.jpg) no-repeat center;">
                <div style="width: auto;border-right:  2px dotted #333;height: 470px;float: left">
                    <a href="Profile.jsp"><img src="staff/user.png" width="30" height="30" alt="user"/>                      <p style="color: #9cff00;margin-bottom: -10px;background-color: black"><%=u.getNames()%></p></a>

                    <jsp:include page="Admin_Menu.jsp"/>
                    <br>
                        <a href="Logout.jsp"><img src="staff/exit.png" width="32" height="32" alt="exit" style="margin-top: 15px;"/> </a>

                </div>
                <div style="width:83%;height: auto;float: right">
                    <center>
                        <br></br><br></br><br><br>


                                <table border="0">
                                    <thead>
                                        <tr>
                                            <th></th>
                                            <th></th>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>


                                        </tr>
                                    </tbody>
                                </table>






                                </center>
                                </div>
                                </div>
                                </center>


                                <!-- end of BANNER WRAPPER -->

                                <!-- end of BOX WRAPPER -->

                                <div class="footer-wrapper" style="margin-top: -0px;margin-bottom: -10px">
                                    <div class="footer">
                                        <center>
                                            <p> <p style="color: white">www.mod.rw All rights reserved. </p></p></center>
                                    </div>

                                </div>

                                <!----footer-wrapper-------->
                                <!-- end of WRAPPER -->
                                </body> 
                                </html>



