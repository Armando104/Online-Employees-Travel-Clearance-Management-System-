
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="pack.User"%>
<%@page import="pack.Applicant"%>
<%@page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="dd" scope="request" class="pack.Applicant">
    <jsp:setProperty name="dd" property="*" />
</jsp:useBean>
<%

    User u = (User) session.getAttribute("admin");
    if (dd.isValid()) {
        if (dd.getOp().equalsIgnoreCase("Submit")) {
            dd.setId(Applicant.getMaxID());
            dd.setNames(dd.getNames());
            dd.setAddress(dd.getAddress());
            dd.setTelefone(dd.getTelefone());
            dd.setGender(dd.getGender());
            dd.setNid(dd.getNid());
            dd.setEmail(dd.getEmail());
            dd.setUsername(dd.getUsername());
            dd.setPassword(dd.getPassword());
            dd.setUser_id(User.getMaxID());
            dd.setHospDept_id(dd.getHospDept_id());
            dd.setStatus(dd.getStatus());
            dd.setState("Qualified");
            dd.setStateDescription("Completed");
            dd.setYear(dd.getYear());
            //dd.setHospDept_id(Integer.parseInt(dd.getHospDeptID()));
            
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
                dd.setDob(sdf.parse(dd.getDob_s()));
                dd.setReg_Date(new Date());
                Date nn = new Date();
                Calendar rr = new GregorianCalendar();
               rr.setTime(nn);
               dd.setYear(rr.get(Calendar.YEAR)+"");
    
                //out.println(dd.insert());
            } catch (Exception e) {
                out.println(e.toString());
            }
            System.out.println("Results: "+dd);
            if (dd.insert()) {
                dd.setMsg("APPLICANT ADDED SUCCESSFULLY!");
                 User uu = new User();
                uu.setUser_id(dd.getId());
                uu.setNames(dd.getNames());
                uu.setUsername(dd.getUsername());
                uu.setPassword(dd.getPassword());
                uu.setRole("applicant");
                uu.setUser_status("unlocked");
                uu.insert();
                session.setAttribute("appID", dd.getId());
                %>
                <jsp:forward page="Application_Form.jsp"/>
                <%
            }
            else{
                dd.setMsg("<h3 style=color:red;>Records has not registered</h3>");
            }
        }

        if (dd.getOp().contains("DO YOU WANT TO DELETE")) {

            Applicant pp = new Applicant();
            pp.setId(Integer.parseInt(dd.getApp_id()));
            if (pp.delete()) {
                dd.setMsg("RECORD DELETED SUCCESSFULLY!");
            }
        }
        if (dd.getOp().contains("DO YOU WANT TO EDIT")) {

            if (dd.update()) {
                dd.setMsg("RECORD UPDATED SUCCESSFULLY!");
            }
        }
    }
    
%>

<jsp:forward page="ApplicantForm.jsp"/>