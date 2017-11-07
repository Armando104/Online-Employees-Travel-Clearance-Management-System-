<%@page import="pack.ExamClass"%>
<jsp:useBean id="exam" scope="request" class="pack.ExamClass"></jsp:useBean>
<%
String io=request.getParameter("id");
ExamClass uu=exam.getExam_From_ID(Integer.parseInt(io));
exam.setExam_id(uu.getId()+"");
exam.setTitle(uu.getTitle());
exam.setExamTime(uu.getExamTime());
exam.setOp("Do you want to edit "+uu.getTitle().toUpperCase());

//out.println(dd.getExam_id());
%>
<jsp:forward page="Exam_Form.jsp"/>