<%@page import="pack.Battallion"%>
<%@page import="pack.Applicant"%>
<%@page import="pack.User"%>
<jsp:useBean id="dd" scope="request" class="pack.Battallion">
    <jsp:setProperty name="dd" property="*" />
</jsp:useBean>

<%
 //User u = (User) session.getAttribute("admin");
 if(dd.isValid()){
     if(dd.getOp().contains("Submit")){
         dd.setBattallion_id(Battallion.getMaxID());
        // String ii=dd.getApplicant_id();
        //Applicant ap=Applicant.getApplicant_From_Name(ii);
        //dd.setApplicantId(Integer.parseInt(dd.getApplicant_id()));
        dd.setBattaion_members(Integer.parseInt(dd.getBattallion_members()));
        if(dd.insert()){
            dd.setMsg("Battallion is Recorded Successfully!");
        }
     }
     if(dd.getOp().contains("Do you want to delete")){
         Battallion bb=new Battallion();
         bb.setBattallion_id(Integer.parseInt(dd.getBattallionId()));
         if(bb.delete()){
             dd.setMsg("Record Deleted Successfully!");
         }
     }
 }



%>
<jsp:forward page="Battallion_Form.jsp"/>