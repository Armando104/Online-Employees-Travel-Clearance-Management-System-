<%@page import="java.text.SimpleDateFormat"%>
<%@page import="pack.ExamClass"%>
<jsp:useBean id="exam" scope="request" class="pack.ExamClass">
     <jsp:setProperty name="exam" property="*" />
</jsp:useBean>

<%
if(exam.getOp().contains("submit")){
    exam.setId(exam.getMaxID());
    exam.setTitle(exam.getTitle());
    exam.setExamTime(exam.getExamTime());
    exam.setDepartment(Integer.parseInt(exam.getDept()));
    try {
                SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
                exam.setExamDate(sdf.parse(exam.getExam_date()));
                
                //out.println(dd.insert());
            } catch (Exception e) {
                out.println(e.toString());
            }
    if(exam.insert()){
        exam.setMsg("Exam added successfully!");
         //out.println(dd.getId()+" "+dd.getDescription()+" "+dd.getExamTime());
    }
    //out.println(false);
}
if(exam.getOp().contains("Do you want to edit")){
    exam.setId(Integer.parseInt(exam.getExam_id()));
    if(exam.update()){
        exam.setMsg("Record updated successfully!");
    }
}
if(exam.getOp().contains("Do you want to delete")){
    exam.setId(Integer.parseInt(exam.getExam_id()));
    if(exam.delete()){
        exam.setMsg("Record deleted successfully!");
    }
            }





%>
<jsp:forward page="Exam_Form.jsp"/>