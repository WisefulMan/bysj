package com.edu.cqu.bysj.rfidcar.model;

public class CarPass {
    private String passtime;
    private String rfid_ip;
    private String rfid_id;
    private String p_name;
    private String imgurl;

    public String getPasstime() {
        return passtime;
    }

    public void setPasstime(String passtime) {
        this.passtime = passtime;
    }

    public String getRfid_ip() {
        return rfid_ip;
    }

    public void setRfid_ip(String rfid_ip) {
        this.rfid_ip = rfid_ip;
    }

    public String getRfid_id() {
        return rfid_id;
    }

    public void setRfid_id(String rfid_id) {
        this.rfid_id = rfid_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
