package com.edu.cqu.bysj.rfidcar.controller;

import com.alibaba.fastjson.JSON;
import com.edu.cqu.bysj.rfidcar.mapper.AdminMapper;
import com.edu.cqu.bysj.rfidcar.model.*;
import com.edu.cqu.bysj.rfidcar.service.AdminService;
import com.edu.cqu.bysj.rfidcar.service.LimitService;
import com.edu.cqu.bysj.rfidcar.util.MvcDataDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;

@Controller
//@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private LimitService limitService;

    private HttpSession httpSession;

//    @GetMapping("/admin")
//    public String admin(Model model){
//        System.out.println("admin界面");
//        return "admin";
//    }

    @GetMapping("/admin/carinfo")
    public String carInfo(Model model){
        System.out.println("carinfo 界面");
        return "CarInfo";
    }

    @GetMapping("/admin/traceTrack")
    public String traceTrack(Model model,String rfid_id){
        //获取点集，并转化为json格式
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
        List<Point> traceTrackPoint = adminService.TraceTrackSearchByRfidId(rfid_id);
        String TraceTrackPoint = gson.toJson(traceTrackPoint);
        System.out.println(TraceTrackPoint);
        model.addAttribute("TraceTrackPoint",TraceTrackPoint);
        User user = (User)adminMapper.findUserByRFIDID(rfid_id);
        //获取当前时间
        Timestamp d = new Timestamp(System.currentTimeMillis());
        record r = new record();
        r.setVisit_time(d);
        r.setRfid_id(user.getRfid_id());
        r.setUsername(user.getUsername());
        r.setAction("usertraceTrack");
        adminMapper.saveRecord(r);
        //添加限制区域
        Gson gson1 = new Gson();
        List<CarLimit> carLimits = limitService.listAll();
        String carLimitList = gson1.toJson(carLimits);
        System.out.println(carLimitList);
        model.addAttribute("carLimitList",carLimitList);
        return "TraceTrack";
    }

    @GetMapping("/admin/historyTrace")
    public String historyTrace(Model model,String rfid_id){
        //获取点集，并转化为json格式
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
        List<Point> historytracePoint = adminService.TraceTrackSearchByRfidId(rfid_id);
        String HistorytracePoint = gson.toJson(historytracePoint);
        System.out.println( HistorytracePoint);
        model.addAttribute("HistorytracePoint", HistorytracePoint);
        User user = (User)adminMapper.findUserByRFIDID(rfid_id);
        //获取当前时间,添加记录
        Timestamp d = new Timestamp(System.currentTimeMillis());
        record r = new record();
        r.setVisit_time(d);
        r.setRfid_id(user.getRfid_id());
        r.setUsername(user.getUsername());
        r.setAction("HistroyTraceSearch");
        adminMapper.saveRecord(r);
        //添加限制区域
        Gson gson1 = new Gson();
        List<CarLimit> carLimits = limitService.listAll();
        String carLimitList = gson1.toJson(carLimits);
        System.out.println(carLimitList);
        model.addAttribute("carLimitList",carLimitList);
        return "HistoryTrace";
    }

    @GetMapping("/admin/historyTraceInfoSearch")
    public String historyTraceInfo(Model model){
        return "HistoryTraceInfoSearch";
    }

    @GetMapping("/admin/userInfoSearch")
    public String userInfoSearch(Model model){
        return "AdminUserInfoSearch";
    }

    @GetMapping("/admin/recordSearch")
    public String recordSearch(Model model){
        return "RecordSearch";
    }

    @GetMapping(value = "/admin/record")
    public String record(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        System.out.println("record页面");
//        String username ;
        PageHelper.startPage(pageNum,5);
        List<record> recordList = adminService.findAllRecord();

        PageInfo<record> pageInfo = new PageInfo<record>(recordList);
        model.addAttribute("recordList",pageInfo);
        return "AdminRecord";
    }

    @GetMapping(value = "/admin/findCarInfo")
    public String searchCarInfo(Model model,String p_name,String c_type){
//
//        String p_name = carInfoSearch.getP_name();
//        String c_type = carInfoSearch.getC_type();
        System.out.println("searchCarInfo界面");
        model.addAttribute("carList",adminService.findCarInfo(p_name,c_type));
        return "AdminCarInfo";
    }

    @GetMapping("/admin/getAllPointByIdAndTime")
    public String getAllPointByIdAndTime(Model model,String rfid_id/*,Timestamp startTime,Timestamp endTime*/){
        model.addAttribute("pointList",adminService.getAllPointByIdAndTime(rfid_id/*,startTime,endTime*/));

        return "TraceTrack";
    }

    @GetMapping(value = "/admin/userinfo")
    public String userinfo(Model model,String username){
        model.addAttribute("userinfolist",adminService.findUserinfoByUsername(username));
        User user = (User)adminMapper.findUserByUsername(username);
        //获取当前时间
        Timestamp d = new Timestamp(System.currentTimeMillis());
        record r = new record();
        r.setVisit_time(d);
        r.setRfid_id(user.getRfid_id());
        r.setUsername(user.getUsername());
        r.setAction("userInfoSearch");
        adminMapper.saveRecord(r);
        return "AdminUserInfo";
    }

    @GetMapping("/admin/historyTraceInfo")
    public String searchTraceInfo(Model model ,String rfid_id){
        model.addAttribute("historyTraceInfoList",adminService.findHistoryTraceInfoByrfidId(rfid_id));
        User user = (User)adminMapper.findUserByRFIDID(rfid_id);
        //获取当前时间
        Timestamp d = new Timestamp(System.currentTimeMillis());
        record r = new record();
        r.setVisit_time(d);
        r.setRfid_id(user.getRfid_id());
        r.setUsername(user.getUsername());
        r.setAction("historyTraceInfoSearch");
       adminMapper.saveRecord(r);
        return "HistoryTraceInfo";
    }

    @GetMapping("/admin/TraceTrackSearchByRfidId")
    public String TraceTrackSearchByRfidId(Model model){
        return "TraceTrackSearchByRfidId";
    }

    @GetMapping("/admin/HistoryTraceByRfidID")
    public String HistoryTraceByRfidID(Model model){
        return "HistoryTraceByRfidID";
    }

    @GetMapping("/admin/limit/list")
    public String list(Model model){
        model.addAttribute("limitList",limitService.listAll());
        return "limit/list";
    }

    @RequestMapping("/admin/limit/pages")
    public String listPages(){
        return "limit/pages";
    }

    @ResponseBody
    @RequestMapping("/admin/limit/getListPage")
    public Object getListPage(String param){
        MvcDataDto data = JSON.parseObject(param , MvcDataDto.class);
        return limitService.listPages(data);
    }

    @RequestMapping("/admin/limit/edit")
    public String edit(Model model, @RequestParam(defaultValue = "0") int id){
        //isAdd : 向前端页面返回一个是新增与编辑的标识
        if(id > 0){
            model.addAttribute("isAdd",false);
            model.addAttribute("carLimit",limitService.getById(id));
        }else{
            model.addAttribute("isAdd",true);
            model.addAttribute("carLimit",new CarLimit());
        }
        return "limit/edit";
    }

    //新增和编辑
    @ResponseBody
    @RequestMapping("/admin/limit/save")
    public String save(@ModelAttribute CarLimit carLimit){
        if(carLimit == null){
            return "fail";
        }
        if(carLimit.getId() != null && carLimit.getId() > 0){
            limitService.edit(carLimit);
        }else{
            limitService.add(carLimit);
        }
        return "success";
    }

    @RequestMapping(value = "/admin/limit/del/{id}" , method = RequestMethod.GET)
    public String delete(@PathVariable int id){
       limitService.delete(id);
        return "redirect:/admin/limit/list";
    }

}

