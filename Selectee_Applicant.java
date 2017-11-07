/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author JUSTE
 */
public class Selectee_Applicant {
    private int id,applicant_id,battallion_id,No_of_Tours,user_id;
    private Date mission_StartDate,mission_EndDate,rec_Date;
    private String selecteeID,appID,battID,NOT,userID,start_date,end_date,RecDate,msg,missionStartDate,missionStartDate_msg,missionEndDate,missionEndDate_msg,op="Submit",year;
             private boolean valid=true;

    public Selectee_Applicant() {
    }

    public Selectee_Applicant(int id, int applicant_id, int battallion_id, int No_of_Tours, int user_id, Date mission_StartDate, Date mission_EndDate, Date rec_Date, String selecteeID, String appID, String battID, String NOT, String userID, String start_date, String end_date, String RecDate, String msg, String missionStartDate, String missionStartDate_msg, String missionEndDate, String missionEndDate_msg) {
        this.id = id;
        this.applicant_id = applicant_id;
        this.battallion_id = battallion_id;
        this.No_of_Tours = No_of_Tours;
        this.user_id = user_id;
        this.mission_StartDate = mission_StartDate;
        this.mission_EndDate = mission_EndDate;
        this.rec_Date = rec_Date;
        this.selecteeID = selecteeID;
        this.appID = appID;
        this.battID = battID;
        this.NOT = NOT;
        this.userID = userID;
        this.start_date = start_date;
        this.end_date = end_date;
        this.RecDate = RecDate;
        this.msg = msg;
        this.missionStartDate = missionStartDate;
        this.missionStartDate_msg = missionStartDate_msg;
        this.missionEndDate = missionEndDate;
        this.missionEndDate_msg = missionEndDate_msg;
        this.year=year;
    }
   
    

   

     public static int getMaxID() {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from selecteesapplicant");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id + 1;
    }
//===============================================================
      public static int getNo_Of_Tours() {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from selecteesapplicant");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getInt(4);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id + 1;
    }
//===============================================================
     public boolean insert() {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into selecteesapplicant values(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, id);
            pst.setInt(2, applicant_id);
            pst.setInt(3, battallion_id);
            pst.setInt(4, No_of_Tours);
            pst.setInt(5, user_id);
            pst.setDate(6, new java.sql.Date(mission_StartDate.getTime()));
            pst.setDate(7, new java.sql.Date(mission_EndDate.getTime()));
                        pst.setDate(8, new java.sql.Date(rec_Date.getTime()));
                        pst.setString(9, year);
            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//===============================================================
     public static  Selectee_Applicant getSelectee_ID(int id) {
        Selectee_Applicant pr =null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from selecteesapplicant where id="+id+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Selectee_Applicant();
                pr.setId(rs.getInt(1));
                pr.setApplicant_id(rs.getInt(2));
                pr.setBattallion_id(rs.getInt(3));
                pr.setNo_of_Tours(rs.getInt(4));
                pr.setUser_id(rs.getInt(5));
                pr.setMission_StartDate(rs.getDate(6));
                pr.setMission_EndDate(rs.getDate(7));
                pr.setRec_Date(rs.getDate(8));
                  pr.setYear(rs.getString(9));
            }
             con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
//===================================================================     
     public static  Selectee_Applicant getSelectee_AppID(int id) {
        Selectee_Applicant pr =null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from selecteesapplicant where Applicant_id="+id+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Selectee_Applicant();
                pr.setId(rs.getInt(1));
                pr.setApplicant_id(rs.getInt(2));
                pr.setBattallion_id(rs.getInt(3));
                pr.setNo_of_Tours(rs.getInt(4));
                pr.setUser_id(rs.getInt(5));
                pr.setMission_StartDate(rs.getDate(6));
                pr.setMission_EndDate(rs.getDate(7));
                pr.setRec_Date(rs.getDate(8));
                  pr.setYear(rs.getString(9));
            }
             con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
//================================================================     
     public static  Selectee_Applicant getSelectee_All_List() {
        Selectee_Applicant pr =null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from selecteesapplicant");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Selectee_Applicant();
                pr.setId(rs.getInt(1));
                pr.setApplicant_id(rs.getInt(2));
                pr.setBattallion_id(rs.getInt(3));
                pr.setNo_of_Tours(rs.getInt(4));
                pr.setUser_id(rs.getInt(5));
                pr.setMission_StartDate(rs.getDate(6));
                pr.setMission_EndDate(rs.getDate(7));
                pr.setRec_Date(rs.getDate(8));
                pr.setYear(rs.getString(9));
            }
             con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
//================================================================     
     public static int get_Count_App(int op) {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select count(No_of_Tours) from selecteesapplicant where Applicant_id=" + op + " ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
      
//=============================================================
     public boolean update() {
        try {
               Date today = new Date();
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("update selecteesapplicant set Bid=?,No_of_Tours=?,Start_Date=?,End_Date=?,Today_Date=?,Year=? where Id=?");
            pst.setInt(7, id);
            pst.setInt(1,battallion_id);
            pst.setInt(2, No_of_Tours);
            pst.setDate(3, new java.sql.Date(mission_StartDate.getTime()));
            pst.setDate(4, new java.sql.Date(mission_EndDate.getTime()));
           // pst.setDate(4, new java.sql.Date(today.getTime()));
         
            pst.setDate(5, new java.sql.Date(today.getTime()));
            pst.setString(6, year);
            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//============================================================   
     
     public static List<Selectee_Applicant> getList() {
        List<Selectee_Applicant> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from selecteesapplicant");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Selectee_Applicant pr=new Selectee_Applicant();
                pr.setId(rs.getInt(1));
                pr.setApplicant_id(rs.getInt(2));
                pr.setBattallion_id(rs.getInt(3));
                pr.setNo_of_Tours(rs.getInt(4));
                pr.setUser_id(rs.getInt(5));
                pr.setMission_StartDate(rs.getDate(6));
                pr.setMission_EndDate(rs.getDate(7));
                pr.setRec_Date(rs.getDate(8));
                pr.setYear(rs.getString(9));
                l.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }
//==============================================================================
     public static List<Selectee_Applicant> getTime(String a) {
        List<Selectee_Applicant> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
             PreparedStatement pst = con.prepareStatement("select * from selecteesapplicant where Year="+a+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Selectee_Applicant pr=new Selectee_Applicant();
                pr.setId(rs.getInt(1));
                pr.setApplicant_id(rs.getInt(2));
                pr.setBattallion_id(rs.getInt(3));
                pr.setNo_of_Tours(rs.getInt(4));
                pr.setUser_id(rs.getInt(5));
                pr.setMission_StartDate(rs.getDate(6));
                pr.setMission_EndDate(rs.getDate(7));
                pr.setRec_Date(rs.getDate(8));
                pr.setYear(rs.getString(9));
                l.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

//================================================================ 
     
    
     
      
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(int applicant_id) {
        this.applicant_id = applicant_id;
    }

    public int getBattallion_id() {
        return battallion_id;
    }

    public void setBattallion_id(int battallion_id) {
        this.battallion_id = battallion_id;
    }

    public int getNo_of_Tours() {
        return No_of_Tours;
    }

    public void setNo_of_Tours(int No_of_Tours) {
        this.No_of_Tours = No_of_Tours;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getMission_StartDate() {
        return mission_StartDate;
    }

    public void setMission_StartDate(Date mission_StartDate) {
        this.mission_StartDate = mission_StartDate;
        
    }
    public Date getMission_EndDate() {
        return mission_EndDate;
    }

    public void setMission_EndDate(Date mission_EndDate) {
        this.mission_EndDate = mission_EndDate;
    }

    public Date getRec_Date() {
        return rec_Date;
    }

    public void setRec_Date(Date rec_Date) {
        this.rec_Date = rec_Date;
    }

    public String getSelecteeID() {
        return selecteeID;
    }

    public void setSelecteeID(String selecteeID) {
        this.selecteeID = selecteeID;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getBattID() {
        return battID;
    }

    public void setBattID(String battID) {
        this.battID = battID;
    }

    public String getNOT() {
        return NOT;
    }

    public void setNOT(String NOT) {
        this.NOT = NOT;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    

    public void setStart_date(String start_date) {
        this.start_date = start_date;
        Date d=null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            d = sdf.parse(start_date);
            if (d.before(new Date())) {
                valid = false;
               missionStartDate_msg = "USE AN AFTER TODAY DATE";
            }
//            Calendar cal1 = new GregorianCalendar();
//            Calendar cal2 = new GregorianCalendar();
//            cal2.setTime(d);
//            int age = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
//            if (age < 18 || age > 35) {
//                valid = false;
//                dobmsg = "DATE OUT OF RANGE";
//            }
        } catch (Exception e) {
            valid = false;
            missionStartDate_msg = "INVALID FORMAT";
        }
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
          this.end_date = end_date;
        Date d=null;
        Date f=null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            d = sdf.parse(end_date);
            f=sdf.parse(start_date);
            if (d.before(f)) {
                valid = false;
                missionEndDate_msg = "USE AN AFTER STARTING DATE MISSION";
            }
            //Calendar cal1 = new GregorianCalendar();
            //Calendar cal2 = new GregorianCalendar();
            //cal2.setTime(d);
            //cal1.setTime(mission_StartDate);
            //int age = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
//            if (age <1) {
//                valid = false;
//                missionEndDate_msg = "DATE OUT OF RANGE";
//            }
        } catch (Exception e) {
            valid = false;
            missionEndDate_msg = "INVALID FORMAT";
        }
        
      
    }
    

    public String getRecDate() {
        return RecDate;
    }

    public void setRecDate(String RecDate) {
        this.RecDate = RecDate;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getMissionStartDate() {
        return missionStartDate;
    }

    public void setMissionStartDate(String missionStartDate) {
        this.missionStartDate = missionStartDate;
        
    }

    public String getMissionStartDate_msg() {
        return missionStartDate_msg;
    }

    public void setMissionStartDate_msg(String missionStartDate_msg) {
        this.missionStartDate_msg = missionStartDate_msg;
    }

    public String getMissionEndDate() {
        return missionEndDate;
    }

    public void setMissionEndDate(String missionEndDate) {
        this.missionEndDate = missionEndDate;
        
    }

    public String getMissionEndDate_msg() {
        return missionEndDate_msg;
    }

    public void setMissionEndDate_msg(String missionEndDate_msg) {
        this.missionEndDate_msg = missionEndDate_msg;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "Selectee_Applicant{" + "id=" + id + ", applicant_id=" + applicant_id + ", battallion_id=" + battallion_id + ", No_of_Tours=" + No_of_Tours + ", user_id=" + user_id + ", mission_StartDate=" + mission_StartDate + ", mission_EndDate=" + mission_EndDate + ", rec_Date=" + rec_Date + ", selecteeID=" + selecteeID + ", appID=" + appID + ", battID=" + battID + ", NOT=" + NOT + ", userID=" + userID + ", start_date=" + start_date + ", end_date=" + end_date + ", RecDate=" + RecDate + ", msg=" + msg + ", missionStartDate=" + missionStartDate + ", missionStartDate_msg=" + missionStartDate_msg + ", missionEndDate=" + missionEndDate + ", missionEndDate_msg=" + missionEndDate_msg + ", op=" + op + '}';
    }

    
   
}
