<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="pack.Selectee_Applicant"%>
<jsp:useBean id="d" scope="request" class="pack.Selectee_Applicant"></jsp:useBean>
<%
 String id1 = request.getParameter("ido");
 Selectee_Applicant sa=Selectee_Applicant.getSelectee_ID(Integer.parseInt(id1));
 d.setSelecteeID(sa.getId()+"");
 d.setAppID(sa.getApplicant_id()+"");
 d.setBattID(sa.getBattallion_id()+"");
 d.setNOT(sa.getNo_of_Tours()+"");
 d.setUserID(sa.getUser_id()+"");
 d.setStart_date(sa.getMission_StartDate()+"");
 d.setEnd_date(sa.getMission_EndDate()+"");
 d.setRecDate(sa.getRec_Date()+"");

 d.setOp("Edit");
                     
                    // Date nn =new Date(d.getMissionStartDate()+"");
                        // Calendar rr = new GregorianCalendar();
                      // rr.setTime(nn);
                  //d.setYear(rr.get(Calendar.YEAR)+"");
     

//out.println(id1);
%>
<jsp:forward page="Result_Form.jsp"/>


