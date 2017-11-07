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
public class ExamClass {
    private int id,department;
    private String title,exam_id,examTime,msg,exam_date,dept,op="submit";
    private boolean valid=true;
    private Date ExamDate;

    public ExamClass() {
    }

    public ExamClass(int id, int department, String title, String exam_id, String examTime, String msg, String exam_date, String dept, Date ExamDate) {
        this.id = id;
        this.department = department;
        this.title = title;
        this.exam_id = exam_id;
        this.examTime = examTime;
        this.msg = msg;
        this.exam_date = exam_date;
        this.dept = dept;
        this.ExamDate = ExamDate;
    }

   


   
public static int getMaxID() {
        int id = 110;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from exam");
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
//==================================================
 public boolean insert() {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into exam values(?,?,?,?,?)");
            pst.setInt(1, id);
            pst.setString(2, title);
            pst.setString(3,examTime);
            pst.setInt(4, department);
            pst.setDate(5, new java.sql.Date(ExamDate.getTime()));
            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//==================================================
 public boolean delete() {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("delete from exam where exam_code=?");
            pst.setInt(1, id);

            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//==============================================================
 public static List<ExamClass> getList() {
        List<ExamClass> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from exam");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ExamClass pr=new ExamClass();
                pr.setId(rs.getInt(1));
                pr.setTitle(rs.getString(2));
                pr.setExamTime(rs.getString(3));
                pr.setDepartment(rs.getInt(4));
                pr.setExamDate(rs.getDate(5));
                l.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

//================================================================ 
 public static List<ExamClass> getListFrom_Title(String app) {
        List<ExamClass> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from exam where exam_title="+app+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ExamClass pr=new ExamClass();
                pr.setId(rs.getInt(1));
                pr.setTitle(rs.getString(2));
                pr.setExamTime(rs.getString(3));
                pr.setDepartment(rs.getInt(4));
                pr.setExamDate(rs.getDate(5));
                l.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }
//=================================================================   
 public static ExamClass getExam_From_Title(String id) {
        ExamClass pr = null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from exam where exam_title =" + id + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new ExamClass();
                pr.setId(rs.getInt(1));
                pr.setTitle(rs.getString(2));
                pr.setExamTime(rs.getString(3));
                 pr.setDepartment(rs.getInt(4));
                pr.setExamDate(rs.getDate(5));
                {
                    
                }
                //l.add(pr);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
//=================================================================     
 public static ExamClass getExam_From_ID(int id) {
        ExamClass pr = null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from exam where exam_code =" + id + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new ExamClass();
                pr.setId(rs.getInt(1));
                pr.setTitle(rs.getString(2));
                pr.setExamTime(rs.getString(3));
                 pr.setDepartment(rs.getInt(4));
                pr.setExamDate(rs.getDate(5));
                
                //l.add(pr);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
 
//=================================================================
 
 public static ExamClass getExam_From_Department(int id) {
        ExamClass pr = null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from exam where dept_id =" + id + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new ExamClass();
                pr.setId(rs.getInt(1));
                pr.setTitle(rs.getString(2));
                pr.setExamTime(rs.getString(3));
                pr.setExamTime(rs.getString(4));
                pr.setExamDate(rs.getDate(5));
                //l.add(pr);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
 
//=================================================================
 
 public boolean update() {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("update exam set exam_title=?,exam_time=? where exam_code=?");
            pst.setInt(3, id);
            pst.setString(1, title);
            pst.setString(2, examTime);
            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

//==============================================================
//=================================================================   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getExamDate() {
        return ExamDate;
    }

    public void setExamDate(Date ExamDate) {
        this.ExamDate = ExamDate;
    }

   

    public String getExam_id() {
        return exam_id;
    }

    public void setExam_id(String exam_id) {
        this.exam_id = exam_id;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

   

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getExam_date() {
        return exam_date;
    }

    public void setExam_date(String exam_date) {
        this.exam_date = exam_date;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "ExamClass{" + "id=" + id + ", department=" + department + ", title=" + title + ", exam_id=" + exam_id + ", examTime=" + examTime + ", msg=" + msg + ", exam_date=" + exam_date + ", dept=" + dept + ", op=" + op + ", valid=" + valid + ", ExamDate=" + ExamDate + '}';
    }
    

    

    
    
   
    
    
    
    public static void main(String[] args) {
        System.out.println(getExam_From_Department(1).getExamDate());
    }
    
}
