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
public class HospitalDepartment {

    private int id, hospital_id, department_id;
    private String hospdeptID,hospID,deptID,msg,op="Submit";
    private boolean valid=true;

    public HospitalDepartment() {
    }

    public HospitalDepartment(int id, int hospital_id, int department_id, String hospdeptID, String hospID, String deptID, String msg) {
        this.id = id;
        this.hospital_id = hospital_id;
        this.department_id = department_id;
        this.hospdeptID = hospdeptID;
        this.hospID = hospID;
        this.deptID = deptID;
        this.msg = msg;
    }
   

    public static int getMaxID() {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from hospital_department");
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
            PreparedStatement pst = con.prepareStatement("insert into hospital_department values(?,?,?)");
            pst.setInt(1, id);
            pst.setInt(2, hospital_id);
            pst.setInt(3, department_id);
            
            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//================================================== 

    public static List<HospitalDepartment> getHospital_DeptList() {
        List<HospitalDepartment> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from hospital_department");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                HospitalDepartment pr = new HospitalDepartment();
                pr.setId(rs.getInt(1));
                pr.setHospital_id(rs.getInt(2));
                pr.setDepartment_id(rs.getInt(3));
                l.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }
//===============================================

    public static HospitalDepartment getHospital_Dept_From_ID(int HDid) {
        HospitalDepartment pr = null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from hospital_department where hosp_dept_id =" + HDid + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new HospitalDepartment();
                
                {
                    pr.setId(rs.getInt(1));
                    pr.setHospital_id(rs.getInt(2));
                    pr.setDepartment_id(rs.getInt(3));                    
                }
                //l.add(pr);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
//===============================================
    public static HospitalDepartment getHospital_Dept_All(String Hid,String did) {
        HospitalDepartment pr = null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from hospital_department where hospital_id =" + Hid + "and dept_id="+did+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new HospitalDepartment();
                
                {
                    pr.setId(rs.getInt(1));
                    pr.setHospital_id(rs.getInt(2));
                    pr.setDepartment_id(rs.getInt(3));                    
                }
                //l.add(pr);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
//===============================================


    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getHospital_id() {
        return hospital_id;
    }
    
    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }
    
    public int getDepartment_id() {
        return department_id;
    }
    
    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getHospdeptID() {
        return hospdeptID;
    }

    public void setHospdeptID(String hospdeptID) {
        this.hospdeptID = hospdeptID;
    }

    public String getHospID() {
        return hospID;
    }

    public void setHospID(String hospID) {
        this.hospID = hospID;
    }

    public String getDeptID() {
        return deptID;
    }

    public void setDeptID(String deptID) {
        this.deptID = deptID;
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

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "HospitalDepartment{" + "id=" + id + ", hospital_id=" + hospital_id + ", department_id=" + department_id + ", hospdeptID=" + hospdeptID + ", hospID=" + hospID + ", deptID=" + deptID + ", msg=" + msg + ", op=" + op + ", valid=" + valid + '}';
    }
    
    
}
