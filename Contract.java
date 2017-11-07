/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.Date;

/**
 *
 * @author JUSTE
 */
public class Contract {
    private int contract_id;
    private Date startDate,endDate;
    private String type;
    private int applicant_id;

    public Contract() {
    }

    public Contract(int contract_id, Date startDate, Date endDate, String type, int applicant_id) {
        this.contract_id = contract_id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.applicant_id = applicant_id;
    }

    @Override
    public String toString() {
        return "Contract{" + "contract_id=" + contract_id + ", startDate=" + startDate + ", endDate=" + endDate + ", type=" + type + ", applicant_id=" + applicant_id + '}';
    }
    
    
}
