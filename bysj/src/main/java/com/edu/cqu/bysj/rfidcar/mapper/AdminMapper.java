package com.edu.cqu.bysj.rfidcar.mapper;

import com.edu.cqu.bysj.rfidcar.model.*;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
@Mapper
public interface AdminMapper {
    //获取车辆信息
//    public List<RfidInfo> getCarInfoByUsername(User user);
    //
    public List<Point> getAllPointByIdAndTime(String rfid_id/*,Timestamp startTime,Timestamp endTime*/);

//    public RfidInfo getCarInfoByPName(String p_name);

//    public RfidInfo getCarInfoByCarType(String c_type);

    public List<CarInfoSearch> findCarInfoByPNameAndCarTypeAndpassTime(@Param("p_name") String p_name,@Param("c_type") String c_type);

    public List<UserInfoSearch> findUserInfoByUsername(String username);
    public List<record> findRecordByusername(String username);
    public List<historyTraceInfo> findHistoryTraceInfoByrfidId(String rfid_id);
//    Page<record> getRecords();
    public List<Point> TraceTrackSearchByRfidId(String rfid_id);
    public List<record> findAllRecord();
    int saveRecord(record record1);
    public User findUserByUsername(String username);
    public User findUserByRFIDID(String rfid_id);
}
