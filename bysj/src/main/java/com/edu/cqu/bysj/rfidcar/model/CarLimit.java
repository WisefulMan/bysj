package com.edu.cqu.bysj.rfidcar.model;

public class CarLimit {
    private Integer id;
    private String car_limit_type;
    private String start_time;
    private String end_time;
    private String area;
//    private Float point_es_lng;
//    private Float point_es_lat;
//    private Float point_wn_lng;
//    private Float point_wn_lat;

    public String getCar_limit_type() {
        return car_limit_type;
    }

    public void setCar_limit_type(String car_limit_type) {
        this.car_limit_type = car_limit_type;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

//    public Float getPoint_es_lng() {
//        return point_es_lng;
//    }
//
//    public void setPoint_es_lng(Float point_es_lng) {
//        this.point_es_lng = point_es_lng;
//    }
//
//    public Float getPoint_es_lat() {
//        return point_es_lat;
//    }
//
//    public void setPoint_es_lat(Float point_es_lat) {
//        this.point_es_lat = point_es_lat;
//    }
//
//    public Float getPoint_wn_lng() {
//        return point_wn_lng;
//    }
//
//    public void setPoint_wn_lng(Float point_wn_lng) {
//        this.point_wn_lng = point_wn_lng;
//    }
//
//    public Float getPoint_wn_lat() {
//        return point_wn_lat;
//    }
//
//    public void setPoint_wn_lat(Float point_wn_lat) {
//        this.point_wn_lat = point_wn_lat;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
