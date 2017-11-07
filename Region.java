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
public class Region {
    private int id;
    private String name,reg_id,op="Submit",msg;

    public Region() {
    }

    public Region(int id, String name, String reg_id, String msg) {
        this.id = id;
        this.name = name;
        this.reg_id = reg_id;
        this.msg = msg;
    }

   public static int getMaxID() {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from region");
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
            PreparedStatement pst = con.prepareStatement("insert into region values(?,?)");
            pst.setInt(1, id);
            pst.setString(2, name);
            
            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
  public static Region getRegion_From_ID(int id) {
         Region pr = null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from region where id=" + id + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Region();

                {
                pr.setId(rs.getInt(1));
                pr.setName(rs.getString(2));
                
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
  public static List<Region> getList() {
        List<Region> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from region");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Region pr=new Region();
                pr.setId(rs.getInt(1));
                pr.setName(rs.getString(2));
                
                l.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReg_id() {
        return reg_id;
    }

    public void setReg_id(String reg_id) {
        this.reg_id = reg_id;
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

    @Override
    public String toString() {
        return "Region{" + "id=" + id + ", name=" + name + ", reg_id=" + reg_id + ", op=" + op + ", msg=" + msg + '}';
    }

    
    
}
