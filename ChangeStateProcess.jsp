<%@page import="pack.Applicant"%>
<% 
  Applicant a = new Applicant();

int applicantId = Integer.parseInt(request.getParameter("applicantId"));
String stateDescription = request.getParameter("stateDescription");

a.updateFor_State(stateDescription, applicantId);

%>
<jsp:forward page="ApplicantView.jsp" />