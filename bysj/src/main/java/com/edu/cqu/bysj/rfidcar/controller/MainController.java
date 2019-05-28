package com.edu.cqu.bysj.rfidcar.controller;

import com.edu.cqu.bysj.rfidcar.mapper.UserMapper;
import com.edu.cqu.bysj.rfidcar.model.CarLimit;
import com.edu.cqu.bysj.rfidcar.model.Point;
import com.edu.cqu.bysj.rfidcar.model.User;
import com.edu.cqu.bysj.rfidcar.model.record;
import com.edu.cqu.bysj.rfidcar.service.LimitService;
import com.edu.cqu.bysj.rfidcar.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private LimitService limitService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String index(){
        return "login";
    }

    @PostMapping("/doregister")
    public String doregister(User user,Model model){
//        user.setUsername("jay");
        System.out.println("用户名" + user.getUsername());
        try {
            userMapper.selectIsName(user);
            model.addAttribute("error", "该账号已存在！");
        } catch (Exception e) {
            user.setRolename("USER");
            userMapper.insert(user);
            System.out.println("注册成功");
            model.addAttribute("error", "恭喜您，注册成功！");
            return "login";
        }

        return "register";
    }

    @GetMapping("/register")
    public String register(Model model){
        return "register";
    }

    @PostMapping("/dologin")
    public String dologin(User user,Model model){
        User user1 = userMapper.selectbyUsernameAndPsw(user);
        if (user1 != null) {
            httpSession.setAttribute("user", user1);
            User name = (User) httpSession.getAttribute("user");
            if(user1.getRolename().equals("ADMIN")){
                System.out.println("管理员页面登录成功");
//                //获取当前时间
//                Timestamp d = new Timestamp(System.currentTimeMillis());
//                record r = new record();
//                r.setVisit_time(d);
//                r.setRfid_id(user.getRfid_id());
//                r.setUsername(user.getUsername());
//                userService.saveRecord(r);
                return "redirect:admin";
            }else{
                System.out.println("用户界面登录成功");
//                //获取当前时间
//                Timestamp d = new Timestamp(System.currentTimeMillis());
//                record r = new record();
//                r.setVisit_time(d);
//                r.setRfid_id(user.getRfid_id());
//                r.setUsername(user.getUsername());
//                userService.saveRecord(r);
                return "redirect:user/index";
            }

        } else {
            model.addAttribute("error", "用户名或密码错误，请重新登录！");
            System.out.println("登录失败，返回登录");
            return "login";
        }
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }

    @GetMapping("/admin")
    public String admin(Model model,User user){
        System.out.println("管理员界面");
        User user1 = userMapper.selectbyUsernameAndPsw(user);
        model.addAttribute("user",user1);
        if (user1 != null) {
            httpSession.setAttribute("user", user1);
        }
        return "adminIndex";
    }

    @GetMapping("/user/index")
    public String userindex(Model model,User user){
        System.out.println("用户界面");
        User user1 = userMapper.selectbyUsernameAndPsw(user);
        model.addAttribute("user",user1);
        if (user1 != null) {
            httpSession.setAttribute("user", user1);
        }
        return "userIndex";
    }


    @GetMapping("user/info")
    public String userManage(Model model){
        User user = (User) httpSession.getAttribute("user");
        User user1 = userMapper.selectbyUsernameAndPsw(user);
        model.addAttribute("user",user1);
        return "info";
    }

//    @GetMapping("/user/record")
//    public String record(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
//        System.out.println("搜索记录界面");
////        User user1 = userMapper.selectbyUsernameAndPsw(user);
////        model.addAttribute("user",user1);
////        String username = user.getUsername();
////        System.out.println(username);
//        User user = (User)httpSession.getAttribute("user");
//        System.out.println(user.getUsername());
////        model.addAttribute("record",userService.findRecordByUsername(user.getUsername()));
////        //获取当前时间
////        Timestamp d = new Timestamp(System.currentTimeMillis());
////        record r = new record();
////        r.setVisit_time(d);
////        r.setRfid_id(user.getRfid_id());
////        r.setUsername(user.getUsername());
////        userService.saveRecord(r);
//        PageHelper.startPage(pageNum,5);
//        List<record> recordList = userService.findRecordByUsername(user.getUsername());
//
//        PageInfo<record> pageInfo = new PageInfo<record>(recordList);
//        model.addAttribute("recordList",pageInfo);
//        return "userRecord";
//    }

    @GetMapping("/user/historyTraceInfo")
    public String userHistoryTraceInfo(Model model,String username){
        System.out.println("历史轨迹信息");
        User user = (User)httpSession.getAttribute("user");
        model.addAttribute("historyTraceInfo",userService.findHistoryTraceInfoByUsername(user.getUsername()));
        return "userHistoryTraceInfo";
    }
    @GetMapping("/user/historyTraceSearch")
    public String historyTraceSearch(Model model){
        return "userHistoryTraceSearch";
    }

    @GetMapping("/user/historyTraceMap")
    public String userHistoryTraceMap(Model model){
        System.out.println("历史轨迹重现页面");
        User user = (User)httpSession.getAttribute("user");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
//        Gson gson = new Gson();
//        String pat1 = "yyyy-MM-dd HH:mm:ss";
//        SimpleDateFormat sdf = new SimpleDateFormat(pat1);
//        Date st = sdf.parse(startTime);
//        Date et =sdf.parse(endTime);
//        Timestamp starttime =  new Date(startTime).Format("yyyy-MM-dd HH:mm:ss");
        List<Point> pointList = userService.getPointListByRfidId(user.getUsername());
        String pointListStr = gson.toJson(pointList);
        System.out.println(pointListStr);
        model.addAttribute("pointListStr",pointListStr);
//        model.addAttribute("pointList",userService.getPointListByRfidId(user.getUsername()));
        //添加限制区域
        Gson gson1 = new Gson();
        List<CarLimit> carLimits = limitService.listAll();
        String carLimitList = gson1.toJson(carLimits);
        System.out.println(carLimitList);
        model.addAttribute("carLimitList",carLimitList);
        return "userHistoryTrace";
    }

    @GetMapping("/user/traceTrackMap")
    public String userTraceTrackMap(Model model){
        System.out.println("实时轨迹跟踪页面");
        Gson gson = new Gson();
        User user = (User)httpSession.getAttribute("user");
        List<Point> pointList = userService.getPointListByRfidId(user.getUsername());
        String pointListStr = gson.toJson(pointList);
        model.addAttribute("pointListStr",pointListStr);
        System.out.println(pointListStr);
//        model.addAttribute("TracepointList",userService.getPointListByRfidId(user.getUsername()));
        //添加限制区域
        Gson gson1 = new Gson();
        List<CarLimit> carLimits = limitService.listAll();
        String carLimitList = gson1.toJson(carLimits);
        System.out.println(carLimitList);
        model.addAttribute("carLimitList",carLimitList);
        return "userTraceTrack";
    }

    @GetMapping("/user/limitInfo")
    public String limitInfo(Model model){
        System.out.println("限行信息界面");
        List<CarLimit> carLimits = limitService.listAll();
//        String carLimitList = gson1.toJson(carLimits);
//        System.out.println(carLimitList);
        model.addAttribute("carLimitList",carLimits);
        return "limitInfo";
    }


}
