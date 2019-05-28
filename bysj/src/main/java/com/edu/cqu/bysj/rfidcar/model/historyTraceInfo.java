package com.edu.cqu.bysj.rfidcar.model;

import java.sql.Timestamp;

public class historyTraceInfo {
    private String rfid_x;
    private String rfid_y;
    private String p_direction;
    private String p_name;
    private Timestamp passtime;
    private String rfid_id;

    public String getRfid_x() {
        return rfid_x;
    }

    public void setRfid_x(String rfid_x) {
        this.rfid_x = rfid_x;
    }

    public String getRfid_y() {
        return rfid_y;
    }

    public void setRfid_y(String rfid_y) {
        this.rfid_y = rfid_y;
    }

    public String getP_direction() {
        return p_direction;
    }

    public void setP_direction(String p_direction) {
        this.p_direction = p_direction;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public Timestamp getPasstime() {
        return passtime;
    }

    public void setPasstime(Timestamp passtime) {
        this.passtime = passtime;
    }

    public String getRfid_id() {
        return rfid_id;
    }

    public void setRfid_id(String rfid_id) {
        this.rfid_id = rfid_id;
    }
}
