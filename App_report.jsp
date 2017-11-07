
<%@page import="java.util.List"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.*"%>
<%@page import="pack.*"%>
  <%@page import="pack.*"%>

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
                        
                         <h1> List of All Applicants <%=oo%></h1>
                
                ${p.msg}
                ${pz.msg}
                <br>
                    <table border="1" class="" id='sample_1' style="width: 100%">
                    <thead>
                        <tr>
                            <th>No</th>
                             <th>Applicant Name</th>
                            <th>Applicant Code</th>
                            <th> Gender</th>
                            <th>Telefone</th>
                            <th>Applicant Status</th>
                            <th>Reason</th>
                            
                                
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int no = 1;
                            List<Applicant> l =Applicant.getYear(oo);
                            for (int i = 0; i < l.size(); i++) {
                                if(l.get(i).getState().equalsIgnoreCase("Qualified")){
                                %>
                                 <tr>
                                <%
                                //if(l.get(i).getPhysical_Status().equalsIgnoreCase("Pending")){
                        %>
                       
                        <td><%=no%></td>
                              
                        <td><%=l.get(i).getNames() %></td>
                       <td><%=l.get(i).getUser_id() %></td>
                        <td><%=l.get(i).getGender() %></td>
                        <td><%=l.get(i).getTelefone() %></td>
                        <td><%=l.get(i).getState() %></td>
                        <td><%=l.get(i).getStateDescription() %></td>
                       
                        <%
                            
                                   
                                }
                                if(l.get(i).getState().equalsIgnoreCase("Disqualified")){
                        %>
                       
                            <td><%=no%></td>
                             
                        <td><%=l.get(i).getNames() %></td>
                        <td><%=l.get(i).getUser_id() %></td>
                        <td><%=l.get(i).getGender() %></td>
                        <td><%=l.get(i).getTelefone() %></td>
                        <td><%=l.get(i).getState() %></td>
                        <td><%=l.get(i).getStateDescription() %></td>
                     
                        <%
                                   
                                }


//}

                        
                           
                                
                                
                                  
                                 
                                 
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
