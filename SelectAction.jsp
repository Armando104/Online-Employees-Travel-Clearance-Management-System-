<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<jsp:useBean id="d" scope="request" class="pack.Selectee_Applicant">
    <jsp:setProperty name="d" property="*" />
</jsp:useBean>
<%@page import="pack.Selectee_Applicant"%>
<%
Date today = new Date();
try{                       
   if(d.isValid()){
                          
if(d.getOp().contains("Edit")){
    Selectee_Applicant ss=new Selectee_Applicant();
    ss.setId(Integer.parseInt(d.getSelecteeID()));
    ss.setApplicant_id(Integer.parseInt(d.getAppID()));
    ss.setBattallion_id(Integer.parseInt(d.getBattID()));
    Selectee_Applicant pp=Selectee_Applicant.getSelectee_AppID(d.getUser_id());
    ss.setNo_of_Tours(Integer.parseInt(d.getNOT()));
    ss.setUser_id(Integer.parseInt(d.getUserID()));
    try{
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
    ss.setMission_StartDate(df.parse(d.getStart_date()));
    ss.setMission_EndDate(df.parse(d.getEnd_date()));
    
                   ss.setRec_Date(today);
                   Calendar c=new GregorianCalendar();
                        c.setTime(ss.getMission_StartDate());
                        ss.setYear(c.get(Calendar.YEAR)+"");
                   
                   
             //s.setRecDate("Rec Date");
    }catch(Exception e){
        
    }
    

   out.println(d);
  
    if(ss.update()){
        
        d.setMsg("Applicant is ready for to start the mission!");
        // out.println("OK");
    }else{
        out.println("FALSE");
    }
}
    }
}catch(Exception e){
        out.println(d);
        }
%>
<jsp:forward page="Result_Form.jsp"/>
