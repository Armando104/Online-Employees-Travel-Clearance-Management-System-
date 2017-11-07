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
public class BattallionController {
    private String battallion_id,battallionId_msg,battallion_name,battallionName_msg,leader,leadermsg,location,locationmsg,operator="SUBMIT";
    private boolean valid=true;

    public String getBattallion_id() {
        return battallion_id;
    }

    public void setBattallion_id(String battallion_id) {
        this.battallion_id = battallion_id;
    }

    public String getBattallionId_msg() {
        return battallionId_msg;
    }

    public void setBattallionId_msg(String battallionId_msg) {
        this.battallionId_msg = battallionId_msg;
    }

    public String getBattallion_name() {
        return battallion_name;
    }

    public void setBattallion_name(String battallion_name) {
        this.battallion_name = battallion_name;
        try {
            String p[]={"0","1","2","3","4","5","6","7","8","9"};
            for(int i=0;i<p.length;i++){
                if(battallion_name.contains(p[i])){
                valid=false;
                battallionName_msg="Remove Numbers";
                break;
                }
            }
        } catch (Exception ex) {
         
        } 
    }

    public String getBattallionName_msg() {
        return battallionName_msg;
    }

    public void setBattallionName_msg(String battallionName_msg) {
        this.battallionName_msg = battallionName_msg;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
        try {
            String p[]={"0","1","2","3","4","5","6","7","8","9"};
            for(int i=0;i<p.length;i++){
                if(leader.contains(p[i])){
                valid=false;
                leadermsg="Remove Numbers";
                break;
                }
            }
        } catch (Exception ex) {
         
        } 
    }

    public String getLeadermsg() {
        return leadermsg;
    }

    public void setLeadermsg(String leadermsg) {
        this.leadermsg = leadermsg;
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
                locationmsg="Remove Numbers";
                break;
                }
            }
        } catch (Exception ex) {
         
        } 
    }

    public String getLocationmsg() {
        return locationmsg;
    }

    public void setLocationmsg(String locationmsg) {
        this.locationmsg = locationmsg;
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
