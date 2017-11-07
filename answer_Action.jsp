<%@page import="pack.Answer"%>
<%@page import="pack.Question"%>
<jsp:useBean id="dd" scope="request" class="pack.Answer">
    <jsp:setProperty name="dd" property="*"  />
    
</jsp:useBean>
<%
if(dd.getOp().contains("submit")){
    dd.setId(Answer.getMaxID());
    dd.setDescription(dd.getDescription());
    //dd.setQuestion_id((Question.getQuestion_From_Description(dd.getQuestion_Id()).getId()));
    dd.setQuestion_id(Integer.parseInt(dd.getQuestion_Id()));
    dd.setValid(dd.getValid());
    //out.println(dd.insert());
    if(dd.insert()){
        dd.setMsg("Record is added successfully!");
    }else{
        dd.setMsg("Not Recorded!");
    }
}




%>
<jsp:forward page="Set_Answer.jsp"/>



