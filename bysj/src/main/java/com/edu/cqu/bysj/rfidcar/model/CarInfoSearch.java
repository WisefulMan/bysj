package com.edu.cqu.bysj.rfidcar.model;

import java.sql.Timestamp;

public class CarInfoSearch {
    private String rfid_id;
    private String c_id;
    private String c_type;
    private String use_type;
    private Timestamp passtime;
    private String p_name;
//    private Timestamp startTime;
//    private Timestamp endTime;

    public String getRfid_id() {
        return rfid_id;
    }

    public void setRfid_id(String rfid_id) {
        this.rfid_id = rfid_id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_type() {
        return c_type;
    }

    public void setC_type(String c_type) {
        this.c_type = c_type;
    }

    public String getUse_type() {
        return use_type;
    }

    public void setUse_type(String use_type) {
        this.use_type = use_type;
    }

    public Timestamp getPasstime() {
        return passtime;
    }

    public void setPasstime(Timestamp passtime) {
        this.passtime = passtime;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }
}
