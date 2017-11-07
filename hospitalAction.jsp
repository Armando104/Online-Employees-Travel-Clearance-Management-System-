<%@page import="pack.Hospital"%>
<jsp:useBean id="hh" scope="request" class="pack.Hospital">
     <jsp:setProperty name="hh" property="*" />
</jsp:useBean>
<%
if(hh.getOp().contains("Submit")){
    hh.setHospital_id(Hospital.getMaxID());
    hh.setHospital_name(hh.getHospital_name());
    hh.setLocation(hh.getLocation());
    if(hh.insert()){
        hh.setMsg("Record inserted Successfully");
    }
}

%>
<jsp:forward page="Hospital_Form.jsp"/>