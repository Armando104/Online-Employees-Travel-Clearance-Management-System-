<%@page import="pack.Applicant"%>
<jsp:useBean id="dd" scope="request" class="pack.Applicant"></jsp:useBean>

<%
//int oi=Integer.parseInt(request.getParameter("id"));
String hh=request.getParameter("id");
Applicant ee=Applicant.getApplicant_From_ID(Integer.parseInt(hh));
dd.setId(ee.getId());
dd.setNames(ee.getNames());
dd.setAddress(ee.getAddress());
dd.setTelefone(ee.getTelefone());
dd.setGender(ee.getGender());
dd.setNid(ee.getNid());
dd.setDob(ee.getDob());
dd.setEmail(ee.getEmail());
//dd.setUser_id(ee.getUser_id());
dd.setHospDept_id(ee.getHospDept_id());
dd.setStatus(ee.getStatus());
dd.setReg_Date(ee.getReg_Date());
dd.setOp("DO YOU WANT TO EDIT "+dd.getNames().toUpperCase()+"?");
%>
<jsp:forward page="ApplicantForm.jsp"/>