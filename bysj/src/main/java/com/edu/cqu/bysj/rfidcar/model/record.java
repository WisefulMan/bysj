package com.edu.cqu.bysj.rfidcar.model;

import java.sql.Timestamp;

public class record {
    private String username;
//    private String c_id;
    private String rfid_id;
    private Timestamp visit_time;
//    private String rfid_ip;
    private String action;


    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getVisit_time() {
        return visit_time;
    }

    public void setVisit_time(Timestamp visit_time) {
        this.visit_time = visit_time;
    }
//
//    public String getRfid_ip() {
//        return rfid_ip;
//    }
//
//    public void setRfid_ip(String rfid_ip) {
//        this.rfid_ip = rfid_ip;
//    }

    public String getRfid_id() {
        return rfid_id;
    }

    public void setRfid_id(String rfid_id) {
        this.rfid_id = rfid_id;
    }
}
