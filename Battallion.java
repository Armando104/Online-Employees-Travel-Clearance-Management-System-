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
public class Battallion {
    private int battallion_id;
    private String battallionId,battallion_name,bat_name_msg,leader,leader_msg,msg,op="Submit",location,locationn_msg,battallion_members;
    private int battaion_members;
    boolean valid=true;

    public Battallion() {
    }

    public Battallion(int battallion_id, String battallionId, String battallion_name, String bat_name_msg, String leader, String leader_msg, String msg, String location, String locationn_msg, String battallion_members, int battaion_members) {
        this.battallion_id = battallion_id;
        this.battallionId = battallionId;
        this.battallion_name = battallion_name;
        this.bat_name_msg = bat_name_msg;
        this.leader = leader;
        this.leader_msg = leader_msg;
        this.msg = msg;
        this.location = location;
        this.locationn_msg = locationn_msg;
        this.battallion_members = battallion_members;
        this.battaion_members = battaion_members;
    }

    
   
    
    public static int getMaxID() {
        int id =0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from battallion");
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
//===========================================================
     public boolean insert() {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into battallion values(?,?,?,?,?)");
            pst.setInt(1, battallion_id);
            pst.setString(2, battallion_name);
            pst.setString(3, leader);
            pst.setString(4, location);
            pst.setInt(5, battaion_members);

            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//============================================================
     public boolean delete() {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("delete from battallion where Bid=?");
            pst.setInt(1, battallion_id);

            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//============================================================   
     public boolean update() {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("update battallion set Name=?,Leader=?,Location=?,members=? where Bid=?");
            pst.setInt(5, battallion_id);
            pst.setString(1, battallion_name);
            pst.setString(2, leader);
            pst.setString(3, location);
            pst.setInt(4, battaion_members);
            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//============================================================   
      public static int get_Count_Location(String op) {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select count(Bid) from battallion where Location='" + op + "' ");
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
       public static List<Battallion> getBattallionList() {
        List<Battallion> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from battallion");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Battallion pr=new Battallion();
                pr.setBattallion_id(rs.getInt(1));
                pr.setBattallion_name(rs.getString(2));
                pr.setLeader(rs.getString(3));
                pr.setLocation(rs.getString(4));
                pr.setBattaion_members(rs.getInt(5));
                l.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }
//============================================================
         public static Battallion getBattallion_From_ID(int id) {
         Battallion pr = null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from battallion where Bid=" + id + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Battallion();

                {
                pr.setBattallion_id(rs.getInt(1));
                pr.setBattallion_name(rs.getString(2));
                pr.setLeader(rs.getString(3));
                pr.setLocation(rs.getString(4));
                pr.setBattaion_members(rs.getInt(5));
                }
                //l.add(pr);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
//============================================================
//=============================================================     
    
    
    public int getBattallion_id() {
        return battallion_id;
    }

    public void setBattallion_id(int battallion_id) {
        this.battallion_id = battallion_id;
    }

    public String getBattallion_name() {
        return battallion_name;
    }

    public void setBattallion_name(String battallion_name) {
        this.battallion_name = battallion_name;
         try {
            String p[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            for (int i = 0; i < p.length; i++) {
                if (battallion_name.contains(p[i])) {
                    valid = false;
                    bat_name_msg = "Remove Numbers";
                }
            }

        } catch (Exception e) {

        }

    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
         try {
            String p[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            for (int i = 0; i < p.length; i++) {
                if (leader.contains(p[i])) {
                    valid = false;
                    leader_msg = "Remove Numbers";
                }
            }

        } catch (Exception e) {

        }

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getBattaion_members() {
        return battaion_members;
    }

    public void setBattaion_members(int battaion_members) {
        this.battaion_members = battaion_members;
        if(battaion_members==1||battaion_members==2||battaion_members==3||battaion_members==4||battaion_members==5||battaion_members==6||battaion_members==7||battaion_members==8||battaion_members==9||battaion_members==0){
            valid=false;
            bat_name_msg="It should contains only numbers";
        }
    }

    

    public String getBat_name_msg() {
        return bat_name_msg;
    }

    public void setBat_name_msg(String bat_name_msg) {
        this.bat_name_msg = bat_name_msg;
    }

    public String getLeader_msg() {
        return leader_msg;
    }

    public void setLeader_msg(String leader_msg) {
        this.leader_msg = leader_msg;
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

    public String getLocationn_msg() {
        return locationn_msg;
    }

    public void setLocationn_msg(String locationn_msg) {
        this.locationn_msg = locationn_msg;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getBattallion_members() {
        return battallion_members;
    }

    public void setBattallion_members(String battallion_members) {
        this.battallion_members = battallion_members;
    }

   

    public String getBattallionId() {
        return battallionId;
    }

    public void setBattallionId(String battallionId) {
        this.battallionId = battallionId;
    }

    @Override
    public String toString() {
        return "Battallion{" + "battallion_id=" + battallion_id + ", battallionId=" + battallionId + ", battallion_name=" + battallion_name + ", bat_name_msg=" + bat_name_msg + ", leader=" + leader + ", leader_msg=" + leader_msg + ", msg=" + msg + ", op=" + op + ", location=" + location + ", locationn_msg=" + locationn_msg + ", battallion_members=" + battallion_members + ", battaion_members=" + battaion_members + ", valid=" + valid + '}';
    }

   
    

    
    
}
