package com.edu.cqu.bysj.rfidcar.service;

import com.edu.cqu.bysj.rfidcar.mapper.AdminMapper;
import com.edu.cqu.bysj.rfidcar.model.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public List<CarInfoSearch> findCarInfo(@Param("p_name") String p_name, @Param("c_type") String c_type){
        return adminMapper.findCarInfoByPNameAndCarTypeAndpassTime(p_name,c_type);

    }

    public List<Point>  getAllPointByIdAndTime(String rfid_id/*,Timestamp startTime,Timestamp endTime*/){
        return  adminMapper.getAllPointByIdAndTime(rfid_id/*,startTime,endTime*/);

    }

    public List<UserInfoSearch> findUserinfoByUsername(String username){
        return adminMapper.findUserInfoByUsername(username);
    }

    public List<record> findRecordByUsername(String username){
        return adminMapper.findRecordByusername(username);
    }

    public List<historyTraceInfo> findHistoryTraceInfoByrfidId(String rfid_id){
        return adminMapper.findHistoryTraceInfoByrfidId(rfid_id);
    }
    public List<Point> TraceTrackSearchByRfidId(String rfid_id){
        return adminMapper.TraceTrackSearchByRfidId(rfid_id);
    }
    public List<record> findAllRecord(){
        return adminMapper.findAllRecord();
    }

    public int saveRecord(record re){
        return adminMapper.saveRecord(re);
    }
}
