package com.edu.cqu.bysj.rfidcar.service;

import com.edu.cqu.bysj.rfidcar.mapper.UserMapper;
import com.edu.cqu.bysj.rfidcar.model.Point;
import com.edu.cqu.bysj.rfidcar.model.User;
import com.edu.cqu.bysj.rfidcar.model.historyTraceInfo;
import com.edu.cqu.bysj.rfidcar.model.record;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service
public class UserService{
    @Resource
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User findByUsername(String username){
        User user = userMapper.findByUsername(username);
        if(user != null){
            return user;
        }else{
            return null;
        }
    }

    public User getUserByUsernameAndPassword(String username,String password){
        User user = userMapper.getUserByUsernameAndPassword(username,password);
        return user;
    }

    public String selectUser(User user){
        User user1 = userMapper.findByUsername(user.getUsername());
        if(user1 != null){
            return "用户已存在";
        }else{
            userMapper.insert(user);
            return "注册成功";
        }
    }

    public List<record> findRecordByUsername(String username){
        return userMapper.findRecordByUsername(username);
    }

    public List<historyTraceInfo> findHistoryTraceInfoByUsername(String username){
        return userMapper.findHistoryTraceInfoByUsername(username);
    }

    public int saveRecord(record re){
        return userMapper.saveRecord(re);
    }

    public List<Point> getPointListByTime(String username, Timestamp startTime,Timestamp endTime ){
        return userMapper.getPointListByTime(username,startTime,endTime);
    }

    public List<Point> getPointListByRfidId(String username){
        return userMapper.getPointListByRfidId(username);
    }
}