<%@page import="java.util.List"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.*"%>
<%@page import="pack.*"%>
  <%@page import="pack.*"%>
<%
    User u = (User) session.getAttribute("admin");     
    
   
    if (u == null) {
%>
<jsp:forward page="index_1.jsp"/>
<%        }


%>
<html>
    <head>
        <title></title>
        <link href="styless/fonts.css" rel="stylesheet" />
        <link href="styless/bootstrap.css" rel="stylesheet" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap.css" type="text/css" /><style type="text/css">._css3m{display:none}</style>

        <script language="javascript" type="text/javascript">
            function printDiv(divID) {
                //Get the HTML of div
                var divElements = document.getElementById(divID).innerHTML;
                //Get the HTML of whole page
                var oldPage = document.body.innerHTML;

                //Reset the page's HTML with div's HTML only
                document.body.innerHTML =
                        "<html><head><title></title></head><body><center>" +
                        divElements + "</center></body>";

                //Print Page
                window.print();

                //Restore orignal HTML
                document.body.innerHTML = oldPage;


            }
        </script>

    </head>

    <body>
    <center>
        <div id="s">
            <%
                String date = new GregorianCalendar().get(Calendar.DAY_OF_MONTH) + "/" + (new GregorianCalendar().get(Calendar.MONDAY) + 1) + "/" + (new GregorianCalendar().get(Calendar.YEAR));

            %>
            <div id="ds" style="width: 95%;height: auto;background-color: white;color: black;border: 0px #000 solid">

                <div style="width: 100%;height: auto;margin-top: 0px;border:  3px black solid;border-radius: 0px;background-color: whitesmoke">
                    <div style="width: 100%;height: auto;border-bottom:   0px black solid;background-color: white">
                        <center>
                           <img src="images/RDF.jpg" width="107" height="124" alt="RDF"/>
                            <p>Ministry Of Defence </p>
                            <p>Kigali-Rwanda</p>
                        </center>
                    </div>
                        <%
                String oo= request.getParameter("pickdate");
                     if(oo==null){
                         %>
                          <h1>No Data Found</h1>
                         <%
                       }
                    %>


                    <div style="width: 100%;height: auto;border-bottom:   0px black solid;background-color: white;">
                            <center>    
                            <center>
                        
                        <h1> List of Exam Results <%=oo%> </h1>
                
                ${p.msg}
                ${pz.msg}
                <br>
                    <table border="1" class="" id='sample_1' style="width: 100%">
                    <thead>
                        <tr>
                            <th>No</th>
                             <th>Applicant Name</th>
                            <th>Exam Title</th>
                            <th>Grade </th>
                            <th>Applicant Status</th>
                           
                            <th>Passing Exam Date</th>
                                
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int no =1;
                            List<Result> l = Result.getDate(oo);
                            for (int i = 0; i < l.size(); i++) {
                                if(l.get(i).getStatus().equalsIgnoreCase("Pass")){
                                %>
                                 <tr>
                                <%
                                if(l.get(i).getPhysical_Status().equalsIgnoreCase("Pending")){
                        %>
                       
                        <td style="background-color: yellow"><%=no%></td>
                              
                              <td style="background-color: yellow"><%=Applicant.getApplicant_From_ID(l.get(i).getApp_id()).getNames()%></td>
                              <td style="background-color: yellow"><%=ExamClass.getExam_From_ID(l.get(i).getExam_id()).getTitle() %></td>
                            <td style="background-color: yellow"><%=l.get(i).getGrade() %></td>
                            <td style="background-color: yellow"><%=l.get(i).getStatus() %></td>
                           
                            <td style="background-color: yellow"><%=l.get(i).getResult_Date() %></td>
                            <%
                                }else{
                                    if(l.get(i).getPhysical_Status().equalsIgnoreCase("Approved")){
                                    %>
                                    <td style="background-color: yellow"><%=no%></td>
                              
                              <td style="background-color: yellow"><%=Applicant.getApplicant_From_ID(l.get(i).getApp_id()).getNames()%></td>
                              <td style="background-color: yellow"><%=ExamClass.getExam_From_ID(l.get(i).getExam_id()).getTitle() %></td>
                            <td style="background-color: yellow"><%=l.get(i).getGrade() %></td>
                            <td style="background-color: yellow"><%=l.get(i).getStatus() %></td>
                           
                            <td style="background-color: yellow"><%=l.get(i).getResult_Date() %></td>
                            <%
    }
                                    
              }
                                }
                            if(l.get(i).getStatus().equalsIgnoreCase("Fail")){
                                  %>
                        
                            <td style="background-color: red"><%=no%></td>
                            
                              <td style="background-color: red"><%=Applicant.getApplicant_From_ID(l.get(i).getApp_id()).getNames()%></td>
                              <td style="background-color: red"><%=ExamClass.getExam_From_ID(l.get(i).getExam_id()).getTitle() %></td>
                            <td style="background-color: red"><%=l.get(i).getGrade() %></td>
                            <td style="background-color: red"><%=l.get(i).getStatus() %></td>
                            <td style="background-color: red"><%=l.get(i).getResult_Date() %></td>
                        <%
                            } 
                            no++;
                               
                                  %>
                                 </tr>
                                  <%
                             }
                                  %>
                    </tbody>
                </table>
                            <h5 style="margin-right: -830px"><%="Printed On " + date%></h5> 
                            <br> 
                            </div>

                            </div>
                            </div>
                            </div>
                            <br>
                            <table border="0">

                                <tbody>
                                    <tr>

                                        <td><input type="button" value="Print The Above Report" onclick="javascript:printDiv('s')" class="btn btn-inverse" style="width: 1003px;"/></td>
                                      
                                    </tr>
                                    <tr>
                                        <td> <a style="color: black" target="_blank" href="index_1.jsp"> Back</a> </td>
                                    </tr>
                                </tbody>
                            </table>   
                        </center>
                        </body>
                        </html>
