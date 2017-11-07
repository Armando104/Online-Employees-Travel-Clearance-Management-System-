/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JUSTE
 */
public class Result {
 
    private int id,app_id,exam_id;
    private Double grade;
    private Date result_Date;
    private String status,result_id,appID,examID,resultGrade,physical_Status,ResultDate,op="Submit",Year;

    public Result() {
    }

    public Result(int id, int app_id, int exam_id, Double grade, Date result_Date, String status, String result_id, String appID, String examID, String resultGrade, String physical_Status, String ResultDate,String Year) {
        this.id = id;
        this.app_id = app_id;
        this.exam_id = exam_id;
        this.grade = grade;
        this.result_Date = result_Date;
        this.status = status;
        this.result_id = result_id;
        this.appID = appID;
        this.examID = examID;
        this.resultGrade = resultGrade;
        this.physical_Status = physical_Status;
        this.ResultDate = ResultDate;
        this.Year= Year; 
    }

    


    
    public static int getMaxID() {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from result");
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
    public boolean insert() {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into result values(?,?,?,?,?,?,?,?)");
            pst.setInt(1, id);
            pst.setInt(2, app_id);
            pst.setInt(3, exam_id);
            pst.setDouble(4, grade);
            pst.setDate(5, new java.sql.Date(result_Date.getTime()));
            pst.setString(6, status);
            pst.setString(7, physical_Status);
            pst.setString(8, Year);
            
            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//===============================================================
    public static List<Result> getList() {
        List<Result> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from result order by grade desc");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Result pr=new Result();
                pr.setId(rs.getInt(1));
                pr.setApp_id(rs.getInt(2));
                pr.setExam_id(rs.getInt(3));
                pr.setGrade(rs.getDouble(4));
                pr.setResult_Date(rs.getDate(5));
                pr.setStatus(rs.getString(6));
                pr.setPhysical_Status(rs.getString(7));
                  pr.setYear(rs.getString(8));
                l.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

//================================================================ 
    public static  Result getResult_ID(int id) {
        Result pr =null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from result where result_id="+id+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Result();
                pr.setId(rs.getInt(1));
                pr.setApp_id(rs.getInt(2));
                pr.setExam_id(rs.getInt(3));
                pr.setGrade(rs.getDouble(4));
                pr.setResult_Date(rs.getDate(5));
                pr.setStatus(rs.getString(6));
                pr.setPhysical_Status(rs.getString(7));
                  pr.setYear(rs.getString(8));
            }
             con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
//==================================================================
    public static  Result getResultFrom_AppID(int id) {
        Result pr =null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from result where result_id="+id+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Result();
                pr.setId(rs.getInt(1));
                pr.setApp_id(rs.getInt(2));
                pr.setExam_id(rs.getInt(3));
                pr.setGrade(rs.getDouble(4));
                pr.setResult_Date(rs.getDate(5));
                pr.setStatus(rs.getString(6));
                pr.setPhysical_Status(rs.getString(7));
                  pr.setYear(rs.getString(8));
            }
             con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
   public static List<Result> getDate(String id) {
        List<Result> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from result where year="+id+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Result   pr = new Result();
                pr.setId(rs.getInt(1));
                pr.setApp_id(rs.getInt(2));
                pr.setExam_id(rs.getInt(3));
                pr.setGrade(rs.getDouble(4));
                pr.setResult_Date(rs.getDate(5));
                pr.setStatus(rs.getString(6));
                pr.setPhysical_Status(rs.getString(7));
                pr.setYear(rs.getString(8));
                l.add(pr);
            }
             con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }
//==================================================================
    public static  Result getResultFrom_All(int id,String op) {
        Result pr =null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from result where applicant_id="+id+" and Physical_Status="+op+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Result();
                pr.setId(rs.getInt(1));
                pr.setApp_id(rs.getInt(2));
                pr.setExam_id(rs.getInt(3));
                pr.setGrade(rs.getDouble(4));
                pr.setResult_Date(rs.getDate(5));
                pr.setStatus(rs.getString(6));
                pr.setPhysical_Status(rs.getString(7));
            }
             con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
//==================================================================
    public static int get_Count_All(int o,String op) {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select count(result_id) from result where applicant_id=" + o + " and Physical_Status='"+op+"'");
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
     public static  Result getResult_Status(String id) {
        Result pr =null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from result where Physical_Status="+id+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Result();
                pr.setId(rs.getInt(1));
                pr.setApp_id(rs.getInt(2));
                pr.setExam_id(rs.getInt(3));
                pr.setGrade(rs.getDouble(4));
                pr.setResult_Date(rs.getDate(5));
                pr.setStatus(rs.getString(6));
                pr.setPhysical_Status(rs.getString(7));
            }
             con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
      
  //================================================================  
      public boolean update() {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("update result set Physical_Status=? where result_id=?");
            pst.setInt(2, id);
            pst.setString(1, physical_Status);
            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//============================================================   
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    

    public Date getResult_Date() {
        return result_Date;
    }

    public void setResult_Date(Date result_Date) {
        this.result_Date = result_Date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult_id() {
        return result_id;
    }

    public void setResult_id(String result_id) {
        this.result_id = result_id;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getExamID() {
        return examID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }

    public String getResultGrade() {
        return resultGrade;
    }

    public void setResultGrade(String resultGrade) {
        this.resultGrade = resultGrade;
    }

    public String getPhysical_Status() {
        return physical_Status;
    }

    public void setPhysical_Status(String physical_Status) {
        this.physical_Status = physical_Status;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getResultDate() {
        return ResultDate;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }
    

    public void setResultDate(String ResultDate) {
        this.ResultDate = ResultDate;
    }

    @Override
    public String toString() {
        return "Result{" + "id=" + id + ", app_id=" + app_id + ", exam_id=" + exam_id + ", grade=" + grade + ", result_Date=" + result_Date + ", status=" + status + ", result_id=" + result_id + ", appID=" + appID + ", examID=" + examID + ", resultGrade=" + resultGrade + ", physical_Status=" + physical_Status + ", op=" + op + '}';
    }

    
    
    
    
}
