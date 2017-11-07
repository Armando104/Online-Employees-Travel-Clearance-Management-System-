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
public class Department {
    private int department_id;
    private String department_name,deptID,msg,op="Submit";
    private boolean valid=true;

    public Department() {
    }

    public Department(int department_id, String department_name, String deptID, String msg) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.deptID = deptID;
        this.msg = msg;
    }

   
 public static int getMaxID() {
        int id =0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from department");
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
            PreparedStatement pst = con.prepareStatement("insert into department values(?,?)");
            pst.setInt(1, department_id);
            pst.setString(2,department_name);
            
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
            PreparedStatement pst = con.prepareStatement("delete from department where dept_id=?");
            pst.setInt(1, department_id);

            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//==================================================
   public boolean update() {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("update department set dept_name=? where dept_id=?");
            pst.setInt(2, department_id);
            pst.setString(1, department_name);
            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//==================================================
   public static int get_Count_Dept() {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select count(dept_id) from department");
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
//==================================================  
    public static List<Department> getDepartmentist() {
        List<Department> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from department");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Department pr=new Department();
                pr.setDepartment_id(rs.getInt(1));
                pr.setDepartment_name(rs.getString(2));
                l.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }
//============================================================
     public static Department getDept_From_ID(int id) {
        Department pr=null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from department where dept_id =" + id + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Department();
                {
                    pr.setDepartment_id(rs.getInt(1));
                    pr.setDepartment_name(rs.getString(2));
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
     public static Department getDept_From_Name(String id) {
        Department pr=null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from department where dept_name =" + id + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Department();
                {
                    pr.setDepartment_id(rs.getInt(1));
                    pr.setDepartment_name(rs.getString(2));
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
     public static Department getDept_List() {
        Department pr=null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from department");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Department();
                {
                    pr.setDepartment_id(rs.getInt(1));
                    pr.setDepartment_name(rs.getString(2));
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
    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
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
        return "Department{" + "department_id=" + department_id + ", department_name=" + department_name + ", deptID=" + deptID + ", msg=" + msg + ", op=" + op + ", valid=" + valid + '}';
    }
    
    
}
