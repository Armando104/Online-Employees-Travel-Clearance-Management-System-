<%@page import="pack.ExamClass"%>
<%@page import="pack.Question"%>
<jsp:useBean id="dd" scope="request" class="pack.Question">

    <jsp:setProperty name="dd" property="*"  />
</jsp:useBean>

<%
    if (dd.getOp().contains("Submit")) {
        dd.setId(Question.getMaxID());
        dd.setExam_Code(Integer.parseInt(dd.getExamCode()));
        dd.setMarks(Integer.parseInt(dd.getQuestion_Marks()));
        if(dd.insert()){
            dd.setMsg("Question added successfully!");
        }
        else{
            dd.setMsg("Not Recorded");
        }
    }
    if(dd.getOp().contains("Delete")){
        dd.setId(Integer.parseInt(dd.getQuestionID()));
        if(dd.delete()){
            dd.setMsg("Question deleted successfully!!");
        }
    }

out.println(dd.getId());
%>
<jsp:forward page="Question_Form.jsp"/>
