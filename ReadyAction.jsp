<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="pack.User"%>
<%@page import="java.util.Date"%>
<%@page import="pack.Selectee_Applicant"%>
<%@page import="pack.Result"%>
<jsp:useBean id="t" scope="request" class="pack.Result">
    <jsp:setProperty name="t" property="*" />
    </jsp:useBean>
<%
     User p = (User) session.getAttribute("admin");
if(t.getOp().contains("Edit")){
    Result ll=new Result();
    ll.setId(Integer.parseInt(t.getResult_id()));
    ll.setPhysical_Status(t.getPhysical_Status());
    ll.update();
    Selectee_Applicant sa = new Selectee_Applicant();
        sa.setId(Selectee_Applicant.getMaxID());
        sa.setApplicant_id(Integer.parseInt(t.getAppID()));
        sa.setBattallion_id(0);
        Result lp=Result.getResultFrom_AppID(Integer.parseInt(t.getResult_id()));
        //out.println(ll.getApp_id());
        if(lp.getPhysical_Status().contains("Approved")){
            int pp=Result.get_Count_All(lp.getApp_id(), lp.getPhysical_Status());
        sa.setNo_of_Tours(pp+1);
        }
        //sa.setNo_of_Tours(Selectee_Applicant.get_Count_App(Integer.parseInt(t.getAppID()))+1);
        sa.setNo_of_Tours(1);
        sa.setUser_id(p.getUser_id());
        sa.setMission_StartDate(new Date());
        sa.setMission_EndDate(new Date());
        sa.setRec_Date(new Date());
        Date dd=new Date();
        Calendar c=new GregorianCalendar();
        c.setTime(dd);
                  sa.setYear(c.get(Calendar.YEAR)+"");
             
        sa.insert();
}

%>
<jsp:forward page="result_View.jsp"/>

