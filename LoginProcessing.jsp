<%@page import="pack.*"%>
<jsp:useBean id="dd" scope="request" class="pack.User">
    <jsp:setProperty name="dd" property="*" />
</jsp:useBean>

<%
   Applicant ap = new Applicant();
    User u = User.getUser(dd.getUsername());
    
    
    
    if (u == null) {
        dd.setMsg("<h3 style=color:red>Invalid Username</h3>");
    }
    
    else if (u.getPassword().equals(dd.getPassword())) {

        if (u.getRole().equalsIgnoreCase("admin")) {

            session.setAttribute("admin", u);


%>

<jsp:forward page="AdminPage.jsp"/>
<%} else if (u.getRole().equalsIgnoreCase("Exam_Setter")) {

    session.setAttribute("Exam_Setter", u);
//out.println("His Role is :"+u.getUser_status());
    

%>


<jsp:forward page="Setter.jsp"/>

<%    } else if(u.getRole().equalsIgnoreCase("applicant")){

String state = Applicant.getApplicant_From_ID(u.getUser_id()).getState();
    
if(state.equalsIgnoreCase("Disqualified")){

        dd.setMsg("<h3 style=color:red> Disqualified Because: " +Applicant.getApplicant_From_ID(u.getUser_id()).getStateDescription() + " </h3>");
%>

<jsp:forward page="LoginForm.jsp"/>

<%
}else{

        session.setAttribute("applicant", u);
    
%>
<jsp:forward page="Home_Exam.jsp"/> 


<%
   } }
%>

<% 
}else {
        dd.setMsg("<h3 style=color:red>Invalid Password</h3>");
    }


%>

<jsp:forward page="LoginForm.jsp"/>
