<%@page import="pack.HospitalDepartment"%>
<jsp:useBean id="hd" scope="request" class="pack.HospitalDepartment">
     <jsp:setProperty name="hd" property="*" />
</jsp:useBean>
<%
if(hd.getOp().contains("Submit")){
    hd.setId(HospitalDepartment.getMaxID());
    hd.setHospital_id(Integer.parseInt(hd.getHospID()));
    hd.setDepartment_id(Integer.parseInt(hd.getDeptID()));
    if(hd.insert()){
        hd.setMsg("Records successfully recorded");
    }
}

%>
<jsp:forward page="HospitalDept.jsp"/>