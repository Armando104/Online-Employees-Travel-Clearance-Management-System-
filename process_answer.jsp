<%@page import="pack.ExamClass"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="pack.Selectee_Applicant"%>
<%@page import="pack.Result"%>
<%@page import="java.util.Date"%>
<%@page import="pack.User"%>
<%@page import="pack.Passing_Exam"%>
<%@page import="pack.Question"%>
<%@page import="pack.Answer"%>

<%

    
    
                
                Calendar cal1=new GregorianCalendar();
                Calendar cal2=new GregorianCalendar();
                
                
                cal1.setTime((Date)session.getAttribute("start"));
                int h=cal2.get(Calendar.MINUTE)-cal1.get(Calendar.MINUTE);
                 String getExtoam = request.getParameter("exmID");
               
                ExamClass ex=ExamClass.getExam_From_ID(Integer.parseInt(getExtoam));
                //out.println(ex.getExamTime()+" H="+h+" MINUTE 1:"+cal1.get(Calendar.MINUTE)+" minute 2:"+cal2.get(Calendar.MINUTE));
    
    //if(h<Integer.parseInt(ex.getExamTime().split(" ")[0])){
   
    
    
    String as1 = request.getParameter("answer_1");
    String as2 = request.getParameter("answer_2");
    String as3 = request.getParameter("answer_3");
//    String as4 = request.getParameter("answer_4");
//    String as5 = request.getParameter("answer_5");
   

    Answer aa1 = Answer.getAnswer_From_ID(as1);
    Answer aa2 = Answer.getAnswer_From_ID(as2);
    Answer aa3 = Answer.getAnswer_From_ID(as3);
//    Answer aa4 = Answer.getAnswer_From_ID(as4);
//    Answer aa5 = Answer.getAnswer_From_ID(as5);

    double res = 0.0;
if(aa1!=null){
    if (aa1.getValid() == 1) {
        Question c = Question.getQuestion_From_Id(aa1.getQuestion_id() + "");
        res = res + c.getMarks();
    }
}
if(aa2!=null){
    if (aa2.getValid() == 1) {
        Question c = Question.getQuestion_From_Id(aa2.getQuestion_id() + "");
        res = res + c.getMarks();
    }
}
if(aa3!=null){
    if (aa3.getValid() == 1) {
        Question c = Question.getQuestion_From_Id(aa3.getQuestion_id() + "");
        res = res + c.getMarks();
    }
}
//    if (aa4.getValid() == 1) {
//        Question c = Question.getQuestion_From_Id(aa4.getQuestion_id() + "");
//        res = res + c.getMarks();
//
//    }
//    if (aa5.getValid() == 1) {
//        Question c = Question.getQuestion_From_Id(aa5.getQuestion_id() + "");
//        res = res + c.getMarks();
//    }
    User u = (User) session.getAttribute("applicant");
//    Passing_Exam pe = new Passing_Exam();
//    pe.setId(Passing_Exam.getMaxID());
//    pe.setApplicant_id(u.getUser_id());
//    pe.setExam_id(Integer.parseInt(getExtoam));
//    pe.setExam_Date(new Date());
//    pe.setStatus("ok");
//    if (pe.insert()) {
//        out.println("TRUE");
//    }
    Result rs = new Result();
    rs.setId(Result.getMaxID());
    rs.setApp_id(u.getUser_id());
    rs.setExam_id(Integer.parseInt(getExtoam));
    rs.setGrade(res);
    double result=res;
    request.setAttribute("amanota",rs.getGrade()+"");
    rs.setResult_Date(new Date());
    Date nn = new Date();
    Calendar rr = new GregorianCalendar();
    rr.setTime(nn);
    rs.setYear(rr.get(Calendar.YEAR)+"");
    if (res >= 5) {
//        Selectee_Applicant sa = new Selectee_Applicant();
//        sa.setId(Selectee_Applicant.getMaxID());
//        sa.setApplicant_id(rs.getApp_id());
//        sa.setBattallion_id(0);
//        sa.setNo_of_Tours(0);
//        sa.setUser_id(u.getUser_id());
//        sa.setMission_StartDate(new Date());
//        sa.setMission_EndDate(new Date());
//        sa.setRec_Date(new Date());
//        sa.insert();
        rs.setStatus("Pass");
    } else {
        rs.setStatus("Fail");
    }
    rs.setPhysical_Status("Pending");
    if (rs.insert()) {
        String ok = "Inserted Successfully!";
        request.setAttribute("ok", ok);

    }
//    }else{
//       out.println("TIME OUT");
//    }
%>
<jsp:forward page="Your_Score.jsp"/>
 