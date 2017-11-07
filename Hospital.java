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
public class Hospital {
    private int hospital_id,location;
    private String hospital_name,hospitalID,msg,op="Submit";
    private boolean valid=true;

    public Hospital() {
    }

    public Hospital(int hospital_id, String hospital_name, int location, String hospitalID, String msg) {
        this.hospital_id = hospital_id;
        this.hospital_name = hospital_name;
        this.location = location;
        this.hospitalID = hospitalID;
        this.msg = msg;
    }

  

   
public static int getMaxID() {
        int id =0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from hospital");
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
//===============================================
 public boolean insert() {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into hospital values(?,?,?)");
            pst.setInt(1, hospital_id);
            pst.setString(2, hospital_name);
            pst.setInt(3, location);
            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//===============================================
 public boolean delete() {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("delete from hospital where hospital_id=?");
            pst.setInt(1, hospital_id);

            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//===============================================
  public boolean update() {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("update hospital set hospital_name=?,location=? where hospital_id=?");
            pst.setInt(3, hospital_id);
            pst.setString(1, hospital_name);
            pst.setInt(2, location);
            
            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//===============================================
  public static int get_Count_Location(String op) {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select count(hospital_id) from hospital where location='" + op + "' ");
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
//===============================================
  public static int get_Count() {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select count(hospital_id) from hospital");
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
//===============================================
  public static List<Hospital> getHospitalList() {
        List<Hospital> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from hospital");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Hospital pr=new Hospital();
                pr.setHospital_id(rs.getInt(1));
                pr.setHospital_name(rs.getString(2));
                pr.setLocation(rs.getInt(3));
                l.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }
  //=============================================
  public static Hospital getHospital_From_ID(int id) {
         Hospital pr = null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from hospital where hospital_id=" + id + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Hospital();

                {
                pr.setHospital_id(rs.getInt(1));
                pr.setHospital_name(rs.getString(2));
                pr.setLocation(rs.getInt(3));
                }
                //l.add(pr);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
//================================================  
   public static Hospital getHospital_From_Name(String id) {
         Hospital pr = null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from hospital where hospital_name=" + id + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Hospital();

                {
                pr.setHospital_id(rs.getInt(1));
                pr.setHospital_name(rs.getString(2));
                pr.setLocation(rs.getInt(3));
                }
                //l.add(pr);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
//================================================  
    public int getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(String hospitalID) {
        this.hospitalID = hospitalID;
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

    @Override
    public String toString() {
        return "Hospital{" + "hospital_id=" + hospital_id + ", hospital_name=" + hospital_name + ", location=" + location + ", hospitalID=" + hospitalID + ", msg=" + msg + ", op=" + op + ", valid=" + valid + '}';
    }

   

    
}
