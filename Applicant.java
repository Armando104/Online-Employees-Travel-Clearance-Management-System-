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
public class Applicant {

    private int id, hospDept_id,user_id;
    private String names,app_id, name_smsg, address, telefone, tel_msg, gender, nid, nid_msg, email, email_sg, status, status_msg, msg, username, password,userID, hospDeptID, op = "Submit",  state, stateDescription,year;
    private Date dob, Reg_Date;
    private String dob_s, reg_date_s;
    private boolean valid = true;

    public Applicant() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateDescription() {
        return stateDescription;
    }

    public void setStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
    }

    public Applicant(int id, int hospDept_id, String names, String app_id, String name_smsg, String address, String telefone, String tel_msg, String gender, String nid, String nid_msg, String email, String email_sg, String status, String status_msg, String msg, String username, String password, String userID, String hospDeptID, String state, String stateDescription, Date dob, Date Reg_Date, String dob_s, String reg_date_s) {
        this.id = id;
        this.hospDept_id = hospDept_id;
        this.names = names;
        this.app_id = app_id;
        this.name_smsg = name_smsg;
        this.address = address;
        this.telefone = telefone;
        this.tel_msg = tel_msg;
        this.gender = gender;
        this.nid = nid;
        this.nid_msg = nid_msg;
        this.email = email;
        this.email_sg = email_sg;
        this.status = status;
        this.status_msg = status_msg;
        this.msg = msg;
        this.username = username;
        this.password = password;
        this.userID = userID;
        this.hospDeptID = hospDeptID;
        this.state = state;
        this.stateDescription = stateDescription;
        this.dob = dob;
        this.Reg_Date = Reg_Date;
        this.dob_s = dob_s;
        this.reg_date_s = reg_date_s;
        this.year= year;
    }

    

//    @Override
//    public String toString() {
//        return "Applicant{" + "id=" + id + ", hospDept_id=" + hospDept_id + ", user_id=" + user_id + ", names=" + names + ", name_smsg=" + name_smsg + ", address=" + address + ", telefone=" + telefone + ", tel_msg=" + tel_msg + ", gender=" + gender + ", nid=" + nid + ", nid_msg=" + nid_msg + ", email=" + email + ", email_sg=" + email_sg + ", status=" + status + ", status_msg=" + status_msg + ", msg=" + msg + ", username=" + username + ", password=" + password + ", userID=" + userID + ", hospDeptID=" + hospDeptID + ", op=" + op + ", dob=" + dob + ", Reg_Date=" + Reg_Date + ", dob_s=" + dob_s + ", reg_date_s=" + reg_date_s + ", valid=" + valid + '}';
//    }

    @Override
    public String toString() {
        return "Applicant{" + "id=" + id + ", hospDept_id=" + hospDept_id + ", user_id=" + user_id + ", names=" + names + ", app_id=" + app_id + ", name_smsg=" + name_smsg + ", address=" + address + ", telefone=" + telefone + ", tel_msg=" + tel_msg + ", gender=" + gender + ", nid=" + nid + ", nid_msg=" + nid_msg + ", email=" + email + ", email_sg=" + email_sg + ", status=" + status + ", status_msg=" + status_msg + ", msg=" + msg + ", username=" + username + ", password=" + password + ", userID=" + userID + ", hospDeptID=" + hospDeptID + ", op=" + op + ", state=" + state + ", stateDescription=" + stateDescription + ", dob=" + dob + ", Reg_Date=" + Reg_Date + ", dob_s=" + dob_s + ", reg_date_s=" + reg_date_s + ", valid=" + valid + '}';
    }

   


    public static int getMaxID() {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from applicant");
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
            PreparedStatement pst = con.prepareStatement("insert into applicant values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, id);
            pst.setString(2, names);
            pst.setString(3, address);
            pst.setString(4, telefone);
            pst.setString(5, gender);
            pst.setString(6, nid);
            pst.setDate(7, new java.sql.Date(dob.getTime()));
            pst.setString(8, email);
            pst.setString(9, username);
            pst.setString(10, password);
            pst.setInt(11, user_id);
            pst.setInt(12, hospDept_id);
            pst.setString(13, status);
            pst.setDate(14, new java.sql.Date(Reg_Date.getTime()));
            pst.setString(15, state);
            pst.setString(16, stateDescription);
            pst.setString(17, year);
            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//===============================================================

    public boolean delete() {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("delete from applicant where applicant_id=?");
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

    public boolean update() {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("update applicant set names=?,address=?,telefone=?,gender=?,nid=?"
                    + ",dob=?,email=?,username=?,password=?,user_id=?,hosp_dept_id=?,status=?,recording_Date=?,state=?,stateDescription=?,year=? where applicant_id=?");
            pst.setInt(17, id);
            pst.setString(1, names);
            pst.setString(2, address);
            pst.setString(3, telefone);
            pst.setString(4, gender);
            pst.setString(5, nid);
            pst.setDate(6, new java.sql.Date(dob.getTime()));
            pst.setString(7, email);
             pst.setString(8, username);
              pst.setString(9, password);
              pst.setInt(10, user_id);
            pst.setInt(11, hospDept_id);
            pst.setString(12, status);
            pst.setDate(13, new java.sql.Date(Reg_Date.getTime()));
            pst.setString(14, state);
            pst.setString(15, stateDescription);
            pst.setString(16, year);
            
            
            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

//==============================================================
    public boolean updateFor_Status(String op) {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("update applicant set status=? where applicant_id=?");
            pst.setInt(2, id);

            pst.setString(1, op);
            pst.execute();
            System.out.println("ID:" + id + " OP:" + op);
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//==============================================================      

    //==============================================================
    public boolean updateFor_State(String op, int applicantId) {
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("update applicant set state=?, stateDescription=? where applicant_id=?");
            pst.setInt(3, applicantId);

            pst.setString(1, "Disqualified");
            pst.setString(2, op);
            pst.execute();
            System.out.println("ID:" + id + " OP:" + op);
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//==============================================================    
    
    public static int get_Count_Status(String op) {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select count(applicant_id) from applicant where status='" + op + "' ");
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

//================================================================
    public static List<Applicant> getList() {
        List<Applicant> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from applicant");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Applicant pr = new Applicant();
                pr.setId(rs.getInt(1));
                pr.setNames(rs.getString(2));
                pr.setAddress(rs.getString(3));
                pr.setTelefone(rs.getString(4));
                pr.setGender(rs.getString(5));
                pr.setNid(rs.getString(6));
                pr.setDob(rs.getDate(7));
                pr.setEmail(rs.getString(8));
                pr.setUsername(rs.getString(9));
                pr.setPassword(rs.getString(10));
                pr.setUser_id(rs.getInt(11));
                pr.setHospDept_id(rs.getInt(12));
             
                pr.setStatus(rs.getString(13));
                pr.setReg_Date(rs.getDate(14));
                pr.setState(rs.getString(15));
                pr.setStateDescription(rs.getString(16));
              
                 pr.setYear(rs.getString(17));
                l.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

//================================================================ 
    public static List<Applicant> getListFrom_ID(int app) {
        List<Applicant> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from applicant where applicant_id="+app+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Applicant pr = new Applicant();
                pr.setId(rs.getInt(1));
                pr.setNames(rs.getString(2));
                pr.setAddress(rs.getString(3));
                pr.setTelefone(rs.getString(4));
                pr.setGender(rs.getString(5));
                pr.setNid(rs.getString(6));
                pr.setDob(rs.getDate(7));
                pr.setEmail(rs.getString(8));
                pr.setUsername(rs.getString(9));
                pr.setPassword(rs.getString(10));
                pr.setUser_id(rs.getInt(11));
                pr.setHospDept_id(rs.getInt(12));

                pr.setStatus(rs.getString(13));
                pr.setReg_Date(rs.getDate(14));
                pr.setState(rs.getString(15));
                 pr.setStateDescription(rs.getString(16));
                 pr.setYear(rs.getString(17));
                l.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }
 //====================================================================================================
     public static List<Applicant> getYear(String app) {
        List<Applicant> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from applicant where year="+app+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Applicant pr = new Applicant();
                pr.setId(rs.getInt(1));
                pr.setNames(rs.getString(2));
                pr.setAddress(rs.getString(3));
                pr.setTelefone(rs.getString(4));
                pr.setGender(rs.getString(5));
                pr.setNid(rs.getString(6));
                pr.setDob(rs.getDate(7));
                pr.setEmail(rs.getString(8));
                pr.setUsername(rs.getString(9));
                pr.setPassword(rs.getString(10));
                pr.setUser_id(rs.getInt(11));
                pr.setHospDept_id(rs.getInt(12));

                pr.setStatus(rs.getString(13));
                pr.setReg_Date(rs.getDate(14));
                pr.setState(rs.getString(15));
                 pr.setStateDescription(rs.getString(16));
                 pr.setYear(rs.getString(17));
                l.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

//================================================================ 
    public static List<Applicant> getListFrom_Hospital(int app) {
        List<Applicant> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from applicant where hosp_dept_id="+app+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Applicant pr = new Applicant();
                pr.setId(rs.getInt(1));
                pr.setNames(rs.getString(2));
                pr.setAddress(rs.getString(3));
                pr.setTelefone(rs.getString(4));
                pr.setGender(rs.getString(5));
                pr.setNid(rs.getString(6));
                pr.setDob(rs.getDate(7));
                pr.setEmail(rs.getString(8));
                pr.setUsername(rs.getString(9));
                pr.setPassword(rs.getString(10));
                pr.setUser_id(rs.getInt(11));
                pr.setHospDept_id(rs.getInt(12));

                pr.setStatus(rs.getString(13));
                pr.setReg_Date(rs.getDate(14));
                l.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

//================================================================ 
    public static List<Applicant> getListFrom_State(String app) {
        List<Applicant> l = new ArrayList<>();
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from applicant where state="+app+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Applicant pr = new Applicant();
                pr.setId(rs.getInt(1));
                pr.setNames(rs.getString(2));
                pr.setAddress(rs.getString(3));
                pr.setTelefone(rs.getString(4));
                pr.setGender(rs.getString(5));
                pr.setNid(rs.getString(6));
                pr.setDob(rs.getDate(7));
                pr.setEmail(rs.getString(8));
                pr.setUsername(rs.getString(9));
                pr.setPassword(rs.getString(10));
                pr.setUser_id(rs.getInt(11));
                pr.setHospDept_id(rs.getInt(12));

                pr.setStatus(rs.getString(13));
                pr.setReg_Date(rs.getDate(14));
                 pr.setYear(rs.getString(15));
                l.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

//================================================================ 
    public static Applicant getApplicant_From_ID(int id) {
        Applicant pr = null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from applicant where user_id =" + id + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Applicant();

                {
                    pr.setId(rs.getInt(1));
                    pr.setNames(rs.getString(2));
                    pr.setAddress(rs.getString(3));
                    pr.setTelefone(rs.getString(4));
                    pr.setGender(rs.getString(5));
                    pr.setNid(rs.getString(6));
                    pr.setDob(rs.getDate(7));
                    pr.setEmail(rs.getString(8));
                    pr.setUsername(rs.getString(9));
                    pr.setPassword(rs.getString(10));
                    pr.setUser_id(rs.getInt(11));
                    pr.setHospDept_id(rs.getInt(12));

                    pr.setStatus(rs.getString(13));
                    pr.setReg_Date(rs.getDate(14));
                    pr.setState(rs.getString(15));
                    pr.setStateDescription(rs.getString(16));
                     pr.setYear(rs.getString(15));
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
    public static Applicant getApplicant_ID(int id) {
        Applicant pr = null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from applicant where applicant_id =" + id + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Applicant();

                {
                    pr.setId(rs.getInt(1));
                    pr.setNames(rs.getString(2));
                    pr.setAddress(rs.getString(3));
                    pr.setTelefone(rs.getString(4));
                    pr.setGender(rs.getString(5));
                    pr.setNid(rs.getString(6));
                    pr.setDob(rs.getDate(7));
                    pr.setEmail(rs.getString(8));
                    pr.setUsername(rs.getString(9));
                    pr.setPassword(rs.getString(10));
                    pr.setUser_id(rs.getInt(11));
                    pr.setHospDept_id(rs.getInt(12));

                    pr.setStatus(rs.getString(13));
                    pr.setReg_Date(rs.getDate(14));
                     pr.setYear(rs.getString(15));
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
     public static int get_Count_Hosp(int op) {
        int id = 0;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select count(hosp_dept_id) from applicant where applicant_id=" + op + " ");
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
public static Applicant getApplicant_From_Name(String id) {
        Applicant pr = null;
        try {
            Connection con = DBClassConnector.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from applicant where names =" + id + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pr = new Applicant();

                {
                    pr.setId(rs.getInt(1));
                    pr.setNames(rs.getString(2));
                    pr.setAddress(rs.getString(3));
                    pr.setTelefone(rs.getString(4));
                    pr.setGender(rs.getString(5));
                    pr.setNid(rs.getString(6));
                    pr.setDob(rs.getDate(7));
                    pr.setEmail(rs.getString(8));
                    pr.setUsername(rs.getString(9));
                    pr.setPassword(rs.getString(10));
                    pr.setUser_id(rs.getInt(11));
                    pr.setHospDept_id(rs.getInt(12));

                    pr.setStatus(rs.getString(13));
                    pr.setReg_Date(rs.getDate(14));
                   pr.setYear(rs.getString(15));
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHospDept_id() {
        return hospDept_id;
    }

    public void setHospDept_id(int hospDept_id) {
        this.hospDept_id = hospDept_id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
        try {
            String p[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            for (int i = 0; i < p.length; i++) {
                if (names.contains(p[i])) {
                    valid = false;
                    name_smsg = "Remove Numbers";
                }
            }

        } catch (Exception e) {

        }

    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
        if (telefone.length() != 10||telefone.isEmpty()) {
            valid = false;
            tel_msg = "Out of Range";
        }
        if (telefone.contains("[a-zA-Z]+")) {
            valid = false;
            tel_msg = "Invalid Format";
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        if (email.contains("@")) {
            email_sg="";
        }
        else{
            valid = false;
            email_sg = "Invalid Format";
        }

    }

    public String getStatus() {
        return status;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;

    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
        if (nid.contains("[a-zA-z]")) {
            valid = false;
            nid_msg = "Invalid Format";
        }
        if(nid.length()!=16){
            valid = false;
            nid_msg = "Must contains 16 digits!";
        }
    }

    public Date getReg_Date() {
        return Reg_Date;
    }

    public void setReg_Date(Date Reg_Date) {
        this.Reg_Date = Reg_Date;
    }

    public String getDob_s() {
        return dob_s;
    }

    public void setDob_s(String dob_s) {
        this.dob_s = dob_s;
    }

    public String getReg_date_s() {
        return reg_date_s;
    }

    public void setReg_date_s(String reg_date_s) {
        this.reg_date_s = reg_date_s;
    }

    public String getName_smsg() {
        return name_smsg;
    }

    public void setName_smsg(String name_smsg) {
        this.name_smsg = name_smsg;
    }

    public String getTel_msg() {
        return tel_msg;
    }

    public void setTel_msg(String tel_msg) {
        this.tel_msg = tel_msg;
    }

    public String getNid_msg() {
        return nid_msg;
    }

    public void setNid_msg(String nid_msg) {
        this.nid_msg = nid_msg;
    }

    public String getEmail_sg() {
        return email_sg;
    }

    public void setEmail_sg(String email_sg) {
        this.email_sg = email_sg;
    }

    public String getStatus_msg() {
        return status_msg;
    }

    public void setStatus_msg(String status_msg) {
        this.status_msg = status_msg;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

   
    public String getHospDeptID() {
        return hospDeptID;
    }

    public void setHospDeptID(String hospDeptID) {
        this.hospDeptID = hospDeptID;
    }

}
