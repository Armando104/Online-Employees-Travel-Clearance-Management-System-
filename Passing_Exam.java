
package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;


public class Passing_Exam {
   private int id,applicant_id,exam_id;
   private String passID,applicantID,examID,status;
   private Date exam_Date;

    public Passing_Exam() {
    }

    public Passing_Exam(int id, int applicant_id, int exam_id, String passID, String applicantID, String examID, String status, Date exam_Date) {
        this.id = id;
        this.applicant_id = applicant_id;
        this.exam_id = exam_id;
        this.passID = passID;
        this.applicantID = applicantID;
        this.examID = examID;
        this.status = status;
        this.exam_Date = exam_Date;
    }

    public int getId() {
        return id;
    }
 public static int getMaxID() {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from passing_exam");
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
            PreparedStatement pst = con.prepareStatement("insert into passing_exam values(?,?,?,?,?)");
            pst.setInt(1, id);
            pst.setInt(2, applicant_id);
            pst.setInt(3, exam_id);
            pst.setDate(4, new java.sql.Date(exam_Date.getTime()));
            pst.setString(5, status);
            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//===============================================================
    public void setId(int id) {
        this.id = id;
    }

    public int getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(int applicant_id) {
        this.applicant_id = applicant_id;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public String getPassID() {
        return passID;
    }

    public void setPassID(String passID) {
        this.passID = passID;
    }

    public String getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(String applicantID) {
        this.applicantID = applicantID;
    }

    public String getExamID() {
        return examID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getExam_Date() {
        return exam_Date;
    }

    public void setExam_Date(Date exam_Date) {
        this.exam_Date = exam_Date;
    }

    @Override
    public String toString() {
        return "Passing_Exam{" + "id=" + id + ", applicant_id=" + applicant_id + ", exam_id=" + exam_id + ", passID=" + passID + ", applicantID=" + applicantID + ", examID=" + examID + ", status=" + status + ", exam_Date=" + exam_Date + '}';
    }
   
   
   
   
}
