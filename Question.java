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
import java.util.List;

/**
 *
 * @author JUSTE
 */
public class Question {
    private int id;
     private int Exam_Code;
    private int Marks;
    private String description,examCode,question_Marks,QuestionID,marks,msg,op="Submit";

    public Question() {
    }

    public Question(int id, int Exam_Code, int Marks, String description, String examCode, String question_Marks, String QuestionID, String marks, String msg) {
        this.id = id;
        this.Exam_Code = Exam_Code;
        this.Marks = Marks;
        this.description = description;
        this.examCode = examCode;
        this.question_Marks = question_Marks;
        this.QuestionID = QuestionID;
        this.marks = marks;
        this.msg = msg;
    }

   
    
public static int getMaxID() {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from question");
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
            PreparedStatement pst = con.prepareStatement("insert into question values(?,?,?,?)");
            pst.setInt(1, id);
            pst.setString(2, description);
            pst.setInt(3, Exam_Code);
            pst.setInt(4, Marks);
            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//===============================================================
 public static Question getQuestion_From_Description(String id) {
        Question pr=null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from question where description =" + id + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Question();

                {
                    pr.setId(rs.getInt(1));
                    pr.setDescription(rs.getString(2));
                    pr.setExam_Code(rs.getInt(3));
                    pr.setMarks(rs.getInt(4));
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
 public static Question getQuestion_From_ExamCode(String id) {
        Question pr=null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from question where exam_code =" + id + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Question();

                {
                    pr.setId(rs.getInt(1));
                    pr.setDescription(rs.getString(2));
                    pr.setExam_Code(rs.getInt(3));
                    pr.setMarks(rs.getInt(4));
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
 public boolean delete() {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("delete from question where question_id=?");
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
 public static Question getQuestion_From_Id(String id) {
        Question pr=null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from question where question_id =" + id + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Question();

                {
                    pr.setId(rs.getInt(1));
                    pr.setDescription(rs.getString(2));
                    pr.setExam_Code(rs.getInt(3));
                    pr.setMarks(rs.getInt(4));
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
  public static List<Question> getList() {
        List<Question> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from question");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Question pr=new Question();
                pr.setId(rs.getInt(1));
                pr.setDescription(rs.getString(2));
                pr.setExam_Code(rs.getInt(3));
                pr.setMarks(rs.getInt(4));
                l.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

//================================================================ 
   public static int get_Count() {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select count(question_id) from question");
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
  public static List<Question> getList1(String id) {
        List<Question> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from question where exam_code="+id+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Question pr=new Question();
                pr.setId(rs.getInt(1));
                pr.setDescription(rs.getString(2));
                pr.setExam_Code(rs.getInt(3));
                pr.setMarks(rs.getInt(4));
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

    public int getExam_Code() {
        return Exam_Code;
    }

    public void setExam_Code(int Exam_Code) {
        this.Exam_Code = Exam_Code;
    }

    public int getMarks() {
        return Marks;
    }

    public void setMarks(int Marks) {
        this.Marks = Marks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

    public String getQuestion_Marks() {
        return question_Marks;
    }

    public void setQuestion_Marks(String question_Marks) {
        this.question_Marks = question_Marks;
    }

    public String getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(String QuestionID) {
        this.QuestionID = QuestionID;
    }

    
    public void setMarks(String marks) {
        this.marks = marks;
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

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", Exam_Code=" + Exam_Code + ", Marks=" + Marks + ", description=" + description + ", examCode=" + examCode + ", question_Marks=" + question_Marks + ", QuestionID=" + QuestionID + ", marks=" + marks + ", msg=" + msg + ", op=" + op + '}';
    }




  
    
    
}
