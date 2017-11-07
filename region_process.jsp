<%@page import="pack.Region"%>
<jsp:useBean id="reg" scope="request" class="pack.Region">
     <jsp:setProperty name="reg" property="*"  />
</jsp:useBean>
<%
if(reg.getOp().contains("Submit")){
    reg.setId(Region.getMaxID());
    reg.setName(reg.getName());
    if(reg.insert()){
        reg.setMsg("Region Added Successfully!");
    }
}

%>
<jsp:forward page="Region_Form.jsp"/>