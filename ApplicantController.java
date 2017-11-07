/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author JUSTE
 */
public class ApplicantController {
    private String applicant_id,aaplicantId_msg,names,namesmsg,address,addressmsg,telefone,telefonemsg,gender,gendermsg,nid,nidmsg;
    private String dob,dobmsg,email,emailmsg,status,statusmsg,recordingDate,recordingDatemsg,operator="SUBMIT";
    private boolean valid=true;

    public ApplicantController(String applicant_id, String aaplicantId_msg, String names, String namesmsg, String address, String addressmsg, String telefone, String telefonemsg, String gender, String gendermsg, String nid, String nidmsg, String dob, String dobmsg, String email, String emailmsg, String status, String statusmsg, String recordingDate, String recordingDatemsg) {
        this.applicant_id = applicant_id;
        this.aaplicantId_msg = aaplicantId_msg;
        this.names = names;
        this.namesmsg = namesmsg;
        this.address = address;
        this.addressmsg = addressmsg;
        this.telefone = telefone;
        this.telefonemsg = telefonemsg;
        this.gender = gender;
        this.gendermsg = gendermsg;
        this.nid = nid;
        this.nidmsg = nidmsg;
        this.dob = dob;
        this.dobmsg = dobmsg;
        this.email = email;
        this.emailmsg = emailmsg;
        this.status = status;
        this.statusmsg = statusmsg;
        this.recordingDate = recordingDate;
        this.recordingDatemsg = recordingDatemsg;
    }

    public String getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(String applicant_id) {
        this.applicant_id = applicant_id;
    }

    public String getAaplicantId_msg() {
        return aaplicantId_msg;
    }

    public void setAaplicantId_msg(String aaplicantId_msg) {
        this.aaplicantId_msg = aaplicantId_msg;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
        try {
            String p[]={"0","1","2","3","4","5","6","7","8","9"};
            for(int i=0;i<p.length;i++){
                if(names.contains(p[i])){
                valid=false;
                namesmsg="Remove Numbers";
                break;
                }
            }
        } catch (Exception ex) {
         
        } 
    }

    public String getNamesmsg() {
        return namesmsg;
    }

    public void setNamesmsg(String namesmsg) {
        this.namesmsg = namesmsg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressmsg() {
        return addressmsg;
    }

    public void setAddressmsg(String addressmsg) {
        this.addressmsg = addressmsg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
        try {
            if(telefone.length()!=10){
                valid=false;
                telefonemsg="Out of Range";
            }
            if(telefone.contains("[a-zA-Z]+")){
                valid=false;
                telefonemsg="Must contains only Numbers";
            }
        } catch (Exception ex) {
         
        } 
        
    }

    public String getTelefonemsg() {
        return telefonemsg;
    }

    public void setTelefonemsg(String telefonemsg) {
        this.telefonemsg = telefonemsg;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGendermsg() {
        return gendermsg;
    }

    public void setGendermsg(String gendermsg) {
        this.gendermsg = gendermsg;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
        try {
            if(nid.length()!=16){
             valid=false;
            nidmsg="A valid N.ID is 16 Digits";
            }
        } catch (Exception ex) {
            valid=false;
            nidmsg="Please Use Only Numbers";
        }
    }

    public String getNidmsg() {
        return nidmsg;
    }

    public void setNidmsg(String nidmsg) {
        this.nidmsg = nidmsg;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
        Date d = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            d = sdf.parse(dob);
            if (d.after(new Date())) {
                valid = false;
                dobmsg = "USE A BEFORE TODAY DATE";
            }
            Calendar cal1 = new GregorianCalendar();
            Calendar cal2 = new GregorianCalendar();
            cal2.setTime(d);
            int age = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
            if (age < 18) {
                valid = false;
                dobmsg = "DATE OUT OF RANGE";
            }
        } catch (Exception e) {
            valid = false;
            dobmsg = "INVALID FORMAT";
        }
    }

    public String getDobmsg() {
        return dobmsg;
    }

    public void setDobmsg(String dobmsg) {
        this.dobmsg = dobmsg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        if(email.contains("@")){
            valid=true;
        }else{
            valid=false;
            emailmsg="Invalid Format!";
        }
    }

    public String getEmailmsg() {
        return emailmsg;
    }

    public void setEmailmsg(String emailmsg) {
        this.emailmsg = emailmsg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusmsg() {
        return statusmsg;
    }

    public void setStatusmsg(String statusmsg) {
        this.statusmsg = statusmsg;
    }

    public String getRecordingDate() {
        return recordingDate;
    }

    public void setRecordingDate(String recordingDate) {
        this.recordingDate = recordingDate;
        Date d = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            d = sdf.parse(dob);
            if (d.after(new Date())) {
                valid = false;
                recordingDatemsg = "USE A BEFORE TODAY DATE";
            }
            
        } catch (Exception e) {
            valid = false;
            dobmsg = "INVALID FORMAT";
        }
    }

    public String getRecordingDatemsg() {
        return recordingDatemsg;
    }

    public void setRecordingDatemsg(String recordingDatemsg) {
        this.recordingDatemsg = recordingDatemsg;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
    
    
}
