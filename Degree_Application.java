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
public class Degree_Application {
    private int id,app_id;
    private String degree_id,appID,degree,op="Submit";
    private Date rec_date;

    public Degree_Application() {
    }

    public Degree_Application(int id, int app_id, String degree_id, String appID, String degree, Date rec_date) {
        this.id = id;
        this.app_id = app_id;
        this.degree_id = degree_id;
        this.appID = appID;
        this.degree = degree;
        this.rec_date = rec_date;
    }
 public static int getMaxID() {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from application_degree");
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
            PreparedStatement pst = con.prepareStatement("insert into application_degree values(?,?,?,?)");
            pst.setInt(1, id);
            pst.setInt(2, app_id);
            pst.setString(3, degree);           
            pst.setDate(4, new java.sql.Date(rec_date.getTime()));
            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//====================================================
  public static List<Degree_Application> getList() {
        List<Degree_Application> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from application_degree");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Degree_Application pr=new Degree_Application();
                pr.setId(rs.getInt(1));
                pr.setApp_id(rs.getInt(2));
                pr.setDegree(rs.getString(3));
                pr.setRec_date(rs.getDate(4));
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

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public String getDegree_id() {
        return degree_id;
    }

    public void setDegree_id(String degree_id) {
        this.degree_id = degree_id;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Date getRec_date() {
        return rec_date;
    }

    public void setRec_date(Date rec_date) {
        this.rec_date = rec_date;
    }

    @Override
    public String toString() {
        return "Degree_Application{" + "id=" + id + ", app_id=" + app_id + ", degree_id=" + degree_id + ", appID=" + appID + ", degree=" + degree + ", op=" + op + ", rec_date=" + rec_date + '}';
    }
    
    

    
}
