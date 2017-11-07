/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

/**
 *
 * @author JUSTE
 */
public class HospitalController {
    private String hospital_id,hospitalID_msg,hospital_name,hospitalName_msg,location,location_msg,operator="SUBMIT";
    private boolean valid=true;

    public String getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(String hospital_id) {
        this.hospital_id = hospital_id;
    }

    public String getHospitalID_msg() {
        return hospitalID_msg;
    }

    public void setHospitalID_msg(String hospitalID_msg) {
        this.hospitalID_msg = hospitalID_msg;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
        try {
            String p[]={"0","1","2","3","4","5","6","7","8","9"};
            for(int i=0;i<p.length;i++){
                if(hospital_name.contains(p[i])){
                valid=false;
                hospitalName_msg="Remove Numbers";
                break;
                }
            }
        } catch (Exception ex) {
         
        } 
    }

    public String getHospitalName_msg() {
        return hospitalName_msg;
    }

    public void setHospitalName_msg(String hospitalName_msg) {
        this.hospitalName_msg = hospitalName_msg;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        try {
            String p[]={"0","1","2","3","4","5","6","7","8","9"};
            for(int i=0;i<p.length;i++){
                if(location.contains(p[i])){
                valid=false;
                location_msg="Remove Numbers";
                break;
                }
            }
        } catch (Exception ex) {
         
        } 
    }

    public String getLocation_msg() {
        return location_msg;
    }

    public void setLocation_msg(String location_msg) {
        this.location_msg = location_msg;
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
