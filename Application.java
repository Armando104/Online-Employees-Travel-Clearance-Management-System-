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
public class Application {
    private int id,applicant_id;
    private String app_id,applicantID,CV,status,regDate,op="SUBMIT",msg;
    private Date reg_Date;
    private boolean valid=true;

    public Application() {
    }

    public Application(int id, int applicant_id, String app_id, String applicantID, String CV, String status, String regDate, String msg, Date reg_Date) {
        this.id = id;
        this.applicant_id = applicant_id;
        this.app_id = app_id;
        this.applicantID = applicantID;
        this.CV = CV;
        this.status = status;
        this.regDate = regDate;
        this.msg = msg;
        this.reg_Date = reg_Date;
    }
    
    public static int getMaxID() {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from application");
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
//=================================================
    public boolean insert() {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into application values(?,?,?,?,?)");
            pst.setInt(1, id);
            pst.setInt(2, applicant_id);
            pst.setString(3, CV);           
            pst.setDate(4, new java.sql.Date(reg_Date.getTime()));
            pst.setString(5, status);
            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//====================================================
 public static List<Application> getList() {
        List<Application> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from application");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Application pr=new Application();
                pr.setId(rs.getInt(1));
                pr.setApplicant_id(rs.getInt(2));
                pr.setCV(rs.getString(3));
                pr.setReg_Date(rs.getDate(4));
                pr.setStatus(rs.getString(5));
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

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(String applicantID) {
        this.applicantID = applicantID;
    }

    public String getCV() {
        return CV;
    }

    public void setCV(String CV) {
        this.CV = CV;
    }

   
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getReg_Date() {
        return reg_Date;
    }

    public void setReg_Date(Date reg_Date) {
        this.reg_Date = reg_Date;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    
    
    
}
