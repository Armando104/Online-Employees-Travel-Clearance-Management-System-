<%@page import="pack.Department"%>
<jsp:useBean id="de" scope="request" class="pack.Department">
    <jsp:setProperty name="de" property="*" />
</jsp:useBean>

<%
if(de.getOp().contains("Submit")){
    de.setDepartment_id(Department.getMaxID());
    de.setDepartment_name(de.getDepartment_name());
    if(de.insert()){
        de.setMsg("Department added successfully!");
    }
}
%>
<jsp:forward page="Dept_Form.jsp"/>