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
public class Answer {
    private int id;
    private String description,description_msg,question_Id,questionID_msg,msg,op="submit";
    private int question_id;
    private boolean validd=true;
    private int valid;

    public Answer() {
    }

    public Answer(int id, String description, String description_msg, String question_Id, String questionID_msg, String msg, int question_id, int valid) {
        this.id = id;
        this.description = description;
        this.description_msg = description_msg;
        this.question_Id = question_Id;
        this.questionID_msg = questionID_msg;
        this.msg = msg;
        this.question_id = question_id;
        this.valid = valid;
    }

   
   
    
     public static int getMaxID() {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from answer");
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
//============================================
     public boolean insert() {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into answer values(?,?,?,?)");
            pst.setInt(1, id);
            pst.setString(2, description);
            pst.setInt(3, question_id);
            pst.setInt(4, valid);
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
            PreparedStatement pst = con.prepareStatement("delete from answer where answer_id=?");
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
      public static Answer getAnswer_From_ID(String id) {
        Answer pr=null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from answer where answer_id =" + id + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Answer();

                {
                    pr.setId(rs.getInt(1));
                    pr.setDescription(rs.getString(2));
                    pr.setQuestion_id(rs.getInt(3));
                    pr.setValid(rs.getInt(4));
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
//==============================================================
      public static List<Answer> getList(String id) {
        List<Answer> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from answer where question_id="+id+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Answer pr=new Answer();
                pr.setId(rs.getInt(1));
                pr.setDescription(rs.getString(2));
                pr.setQuestion_id(rs.getInt(3));
                pr.setValid(rs.getInt(4));
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

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  

    public String getQuestion_Id() {
        return question_Id;
    }

    public void setQuestion_Id(String question_Id) {
        this.question_Id = question_Id;
    }

    public String getQuestionID_msg() {
        return questionID_msg;
    }

    public void setQuestionID_msg(String questionID_msg) {
        this.questionID_msg = questionID_msg;
    }

    public String getDescription_msg() {
        return description_msg;
    }

    public void setDescription_msg(String description_msg) {
        this.description_msg = description_msg;
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

    public boolean isValidd() {
        return validd;
    }

    public void setValidd(boolean validd) {
        this.validd = validd;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "Answer{" + "id=" + id + ", description=" + description + ", description_msg=" + description_msg + ", question_Id=" + question_Id + ", questionID_msg=" + questionID_msg + ", msg=" + msg + ", op=" + op + ", question_id=" + question_id + ", validd=" + validd + ", valid=" + valid + '}';
    }

   

    
}
