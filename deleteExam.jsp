<%@page import="pack.ExamClass"%>
<jsp:useBean id="exam" scope="request" class="pack.ExamClass"></jsp:useBean>
   
<%
String hh=request.getParameter("id");
ExamClass mm=exam.getExam_From_ID(Integer.parseInt(hh));
exam.setExam_id(mm.getId()+"");
exam.setTitle(mm.getTitle());
exam.setExamTime(mm.getExamTime());
exam.setOp("Do you want to delete "+mm.getTitle().toUpperCase());

%>
<jsp:forward page="Exam_Form.jsp"/>