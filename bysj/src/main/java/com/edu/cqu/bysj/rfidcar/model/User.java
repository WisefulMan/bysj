package com.edu.cqu.bysj.rfidcar.model;

public class User {
    private String username;
    //car  id
    private String c_id;
    private String password;
//    private String gender;
//    private Integer age;
    //电子车牌rfid  id
    private String rfid_id;
    //权限
    private String rolename;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getRfid_id() {
        return rfid_id;
    }

    public void setRfid_id(String rfid_id) {
        this.rfid_id = rfid_id;
    }
}
