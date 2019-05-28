package com.edu.cqu.bysj.rfidcar.model;

import java.sql.Timestamp;

public class Point {
    private Float rfid_x;
    private Float rfid_y;
    private Timestamp passtime;
    private String imgurl;
    private String c_type;


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


    public Timestamp getPasstime() {
        return passtime;
    }

    public void setPasstime(Timestamp passtime) {
        this.passtime = passtime;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getC_type() {
        return c_type;
    }

    public void setC_type(String c_type) {
        this.c_type = c_type;
    }
}
