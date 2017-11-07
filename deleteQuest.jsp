<%@page import="pack.Question"%>
<jsp:useBean id="dd" scope="request" class="pack.Question"></jsp:useBean>
<%
String hj=request.getParameter("id");
Question q=Question.getQuestion_From_Id(hj+"");
dd.setQuestionID(q.getId()+"");
dd.setDescription(q.getDescription());
dd.setExamCode(q.getExam_Code()+"");
dd.setQuestion_Marks(q.getMarks()+"");
dd.setOp("Delete");

%>
<jsp:forward page="Question_Form.jsp"/>