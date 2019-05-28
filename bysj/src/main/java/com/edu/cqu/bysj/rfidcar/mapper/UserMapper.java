package com.edu.cqu.bysj.rfidcar.mapper;

import com.edu.cqu.bysj.rfidcar.model.Point;
import com.edu.cqu.bysj.rfidcar.model.User;
//import com.github.pagehelper.Page;
import com.edu.cqu.bysj.rfidcar.model.historyTraceInfo;
import com.edu.cqu.bysj.rfidcar.model.record;
import com.sun.prism.impl.Disposer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Repository
@Mapper
public interface UserMapper {

//    @Select(" select * from user where username=#{username} and password=#{password}")
//    public User getUserByUsernameAndPassword(String username,String password);
//
//    @Insert("insert into user (username,password) values(#{username},#{password})")
//    public int saveUser(User user);
//
//    Page<User> pageByUser(Integer page,Integer size); //进行分页

//    int insertOne(User user);
    List<User> findAll();
    User findByUsername(@Param("username") String username);
    User getUserByUsernameAndPassword(@Param("username") String username,
                                      @Param("password") String password);
    int update(User user);
    int insert(User user);
    User selectbyUsernameAndPsw(User user);
    int selectIsName(User user);
    List<record> findRecordByUsername(String username);
    int saveRecord(record record1);
    public List<historyTraceInfo> findHistoryTraceInfoByUsername(String username);
    List<Point> getPointListByTime(String username,Timestamp startTime, Timestamp endTime);
    List<Point> getPointListByRfidId(String username);


}
