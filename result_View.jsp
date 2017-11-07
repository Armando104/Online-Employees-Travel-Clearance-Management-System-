
<%@page import="java.util.Date"%>

<%@page import="java.util.List"%>
<%@page import="pack.*"%>
<%@page import="pack.*"%>
<%
    User u = (User) session.getAttribute("admin");

    if (u == null) {
%>
<jsp:forward page="index_1.jsp"/>
<%        }


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>mod</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Oswald|Open+Sans' rel='stylesheet' type='text/css'>
            <a href="result_View.jsp"></a>
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




            <div style="width: 970px;height: 500px;background:url(images/banner-bg.jpg) no-repeat center;overflow: scroll">
                <div style="width: auto;border-right:  2px dotted #333;height: 470px;float: left">
                    <a href="Profile.jsp"><img src="staff/user.png" width="30" height="30" alt="user"/>                      <p style="color: #9cff00;margin-bottom: -10px;background-color: black"><%=u.getNames()%></p></a>

                   
                    <br>
                        <a href="Logout.jsp"><img src="staff/exit.png" width="32" height="32" alt="exit" style="margin-top: 15px;"/> </a>

                </div>
                <div style="width:83%;height: auto;float: right">
                    <center>


                        ${p.msg}
                        <table border="1" class="table table-bordered" id='sample_1'>
                            <thead>
                                <tr>
                                    <th>No</th>
                                    <th>Applicant</th>
                                    <th>Exam </th>
                                    <th>Grade</th>
                                    <th>Exam Date</th>
                                    <th>Status</th>
                                    <th>Physical Test</th>
                                    <th>Assign</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                  Applicant pp = new Applicant();  
                                    List<Result> l = Result.getList();
                                    int no = 1;
                                    int k = 0;
                                    int ii=0;
                                    int i=0;
                                    String h="";
                                   
                                    for(Result rs: l){
                                        
                                //    while (i<l.size()) {
                                
                                
                                        k=rs.getExam_id();
                                        ii=rs.getApp_id();
                                         ExamClass mm=ExamClass.getExam_From_ID(k);
                                         pp=Applicant.getApplicant_From_ID(ii);
                                       
                                         h=pp.getNames();
                                         request.setAttribute("nam", h);
                                        double grad = rs.getGrade();
                                        String ko=rs.getPhysical_Status();

                                %>
                                <tr>
                                    
                                 
                                    
                                    
                                    <td><%=no%></td>
                                    <td><%=h%></td>
                                    <td><%=mm.getTitle()%></td>
                                    <td><%=grad%></td>
                                    <td><%=rs.getResult_Date()%></td>
                                    <%
                                        if (grad >= 5) {
                                    %>
                                    <td style="color: green"><%=rs.getStatus()%></td>
                                    <td><a href="Edit_Ready.jsp?id=<%=rs.getId()%>"><%=rs.getPhysical_Status()%></a></td>
                                    <%
                                    } else {
                                    %>
                                    <td style="color: red"><%=rs.getStatus()%></td>
                                    <%
                                         %>
                                         <td style="color: red">Reject</td>
                                         <%
                                        }
                                    %>
                                    
                                    <td><a href="Option_Result.jsp?ido=<%=rs.getId()%>&op=Edit"><img src="a.imgs/edit-icon.png" width="30" height="30" alt="edit-icon"/>
                                        </a></td>
                                        
                                         
                                    


                                </tr>
                                <%
                                            no++;
                                        }
                                    

                                %>
                            </tbody>
                        </table>
                            <a href="report.jsp" style=" color:#000">All Acceptance Candidate</a>
                        </form>
                        <a href="Email_Process.jsp" class="btn btn-success">Send Notification To Failed</a>

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
    <script src="Dyanmic-data-table/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="Dyanmic-data-table/js/jquery.dataTables.js"></script>
    <script type="text/javascript" src="Dyanmic-data-table/js/DT_bootstrap.js"></script>
    <script src="Dyanmic-data-table/js/dynamic-table.js"></script>


</html>
