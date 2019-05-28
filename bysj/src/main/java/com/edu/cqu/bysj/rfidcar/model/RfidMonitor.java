package com.edu.cqu.bysj.rfidcar.model;

public class RfidMonitor {
    //采集点位置
    private String p_name;
    //采集点方向
    private String p_direction;
    //采集点网络ip
    private String rfid_ip;
    //rfid id
    private Integer rfid_id;
    //rfid经度
    private Float rfid_x;
    //rfid纬度
    private Float rfid_y;

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_direction() {
        return p_direction;
    }

    public void setP_direction(String p_direction) {
        this.p_direction = p_direction;
    }

    public String getRfid_ip() {
        return rfid_ip;
    }

    public void setRfid_ip(String rfid_ip) {
        this.rfid_ip = rfid_ip;
    }

    public Integer getRfid_id() {
        return rfid_id;
    }

    public void setRfid_id(Integer rfid_id) {
        this.rfid_id = rfid_id;
    }

    public Float getRfid_x() {
        return rfid_x;
    }

    public void setRfid_x(Float rfid_x) {
        this.rfid_x = rfid_x;
    }

    public Float getRfid_y() {
        return rfid_y;
    }

    public void setRfid_y(Float rfid_y) {
        this.rfid_y = rfid_y;
    }
}