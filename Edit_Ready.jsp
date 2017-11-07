<%@page import="pack.Result"%>
<jsp:useBean id="t" scope="request" class="pack.Result">
    </jsp:useBean>
<%
String hh=request.getParameter("id");
Result lt=Result.getResult_ID(Integer.parseInt(hh));
t.setResult_id(lt.getId()+"");
t.setAppID(lt.getApp_id()+"");
t.setExamID(lt.getExam_id()+"");
t.setResultGrade(lt.getGrade()+"");
t.setResultDate(lt.getResult_Date()+"");
t.setStatus(lt.getStatus());
t.setPhysical_Status(lt.getPhysical_Status());
t.setOp("Edit");
%>
<jsp:forward page="Ready.jsp"/>