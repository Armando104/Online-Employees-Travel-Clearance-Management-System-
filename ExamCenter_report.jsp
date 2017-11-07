
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



                    <div style="width: 100%;height: auto;border-bottom:   0px black solid;background-color: white;">
                            <center>    
                            <center>
                        
                       
                        
                
                ${p.msg}
                ${pz.msg}
                <br>
                    <table border="1" class="" id='sample_1' style="width: 100%">
                    <thead>
                        <tr>
               
                <th>APPLICANT CODE</th>
                <th>NAMES</th>
                <th>HOSPITAL</th>
                <th>EXAM CENTER</th>
                <th>EXAM</th>
                <th>Exam To Be Done On</th>
                <th>DURATION</th>                           
                <th>DEPARTMENT</th>
                            
                            
                                
                        </tr>
                    </thead>
                    <tbody>
                        <%
                             List<Applicant> ll = Applicant.getList();
                int j = 0;
                while (j < ll.size()) {
                                
                        %>
                       <tr>
                              <td><%=ll.get(j).getId()%></td>
                <td><%=ll.get(j).getNames()%></td>
               
            
                <td><%=Hospital.getHospital_From_ID(HospitalDepartment.getHospital_Dept_From_ID(ll.get(j).getHospDept_id()).getHospital_id()).getHospital_name()%></td>
                <td><%=Region.getRegion_From_ID(Hospital.getHospital_From_ID(HospitalDepartment.getHospital_Dept_From_ID(ll.get(j).getHospDept_id()).getHospital_id()).getLocation()).getName() %></td>
               
                <td><%=ExamClass.getExam_From_Department(Department.getDept_From_ID(HospitalDepartment.getHospital_Dept_From_ID(ll.get(j).getHospDept_id()).getDepartment_id()).getDepartment_id()).getTitle() %></td>
               
                
               <td><%=ExamClass.getExam_From_Department(Department.getDept_From_ID(HospitalDepartment.getHospital_Dept_From_ID(ll.get(j).getHospDept_id()).getDepartment_id()).getDepartment_id()).getExamDate() %></td>
               
              
                <td><%=ExamClass.getExam_From_Department(Department.getDept_From_ID(HospitalDepartment.getHospital_Dept_From_ID(ll.get(j).getHospDept_id()).getDepartment_id()).getDepartment_id()).getExamTime() %> Hour(s)</td>
               
               
                 <td><%=Department.getDept_From_ID(HospitalDepartment.getHospital_Dept_From_ID(ll.get(j).getHospDept_id()).getDepartment_id()).getDepartment_name() %></td>
                       </tr>
                        <%
                    j++;
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
                            <h3 style="margin-right: -830px;font-style: oblique"><%="Thank You!" %></h3>
                            <table border="0">

                                <tbody>
                                    <tr>

                                        <td><input type="button" value="Print The Above Report" onclick="javascript:printDiv('s')" class="btn btn-inverse" style="width: 1003px;"/></td>
                                    </tr>
                                </tbody>
                            </table>   
                        </center>
                        </body>
                        </html>
