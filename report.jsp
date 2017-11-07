
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
                        
                       <h1> List of Deployed Applicants<%=oo%></h1>
                        
                
                ${p.msg}
                ${pz.msg}
                <br>
                    <table border="1" class="" id='sample_1' style="width: 100%">
                    <thead>
                        <tr>
                            <th>No</th>
                             <th>Applicant Name</th>
                            <th>Battallion Related To</th>
                            <th>No. Missions</th>
                            <th>Mission Start Date</th>
                            <th>Mission End Date</th>
                            <th>Date of Approval</th>
                            
                            
                                
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int no = 1;
                            List<Selectee_Applicant> l = Selectee_Applicant.getTime(oo);
                            for (int i = 0; i < l.size(); i++) {
                                
                        %>
                       <tr>
                              <td><%=l.get(i).getId()%></td>
                              <td><%=Applicant.getApplicant_From_ID(l.get(i).getApplicant_id()).getNames()%></td>
                              <%Battallion ba=Battallion.getBattallion_From_ID(l.get(i).getBattallion_id());
                                  if(l.get(i).getBattallion_id()==0){
                                      
                                      
                              %>
                              <td>-</td>
                           <%} else{
                           %>
                           <td><%=Battallion.getBattallion_From_ID(l.get(i).getBattallion_id()).getBattallion_name() %></td>
                           <%
                           
                           }%>  
                           <td><%=l.get(i).getNo_of_Tours()%></td>
                            <td><%=l.get(i).getMission_StartDate() %></td>
                            <td><%=l.get(i).getMission_EndDate() %></td>
                            <td><%=l.get(i).getRec_Date() %></td>
                            
                        <%
                            
                                      no++;
                                }
                                  
                                 
                                 
                               
                                
                                  %>
                       </tr>
                       
                            
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
