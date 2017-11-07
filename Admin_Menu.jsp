<%@page import="pack.ExamClass"%>
<%@page import="pack.ExamClass"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>css3menu.com</title>
        <!-- Start css3menu.com HEAD section -->
        <link rel="stylesheet" href="Admin_Menus_1_files/css3menu1/style.css" type="text/css" /><style type="text/css">._css3m{display:none}</style>
        <!-- End css3menu.com HEAD section -->


    </head>
    <body style="background-color:#EBEBEB">
        <!-- Start css3menu.com BODY section -->
        <ul id="css3menu1" class="topmenu" style="border: 0px;">
            <%
                List<ExamClass> ex = ExamClass.getList();
                int i = 0;
                for (ExamClass ee: ex) {

            %>
            <li class="topmenu"><a href="Exam_Test.jsp?id=<%=ee.getId()%>" style="width:107px;"><%=ee.getTitle()%></a></li>
           
                <%
                
                }%>
        </ul> 

    </body>
</html>
