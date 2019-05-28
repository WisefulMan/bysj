package com.edu.cqu.bysj.rfidcar.service;

import com.edu.cqu.bysj.rfidcar.mapper.LimitMapper;
import com.edu.cqu.bysj.rfidcar.model.CarLimit;
import com.edu.cqu.bysj.rfidcar.util.MvcDataDto;
import com.edu.cqu.bysj.rfidcar.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LimitService {
    @Autowired
    private LimitMapper limitMapper;

    public void add(CarLimit carLimit){
        limitMapper.add(carLimit);
    }

    public void edit(CarLimit carLimit){
        limitMapper.edit(carLimit);
    }

    public List<CarLimit> listAll(){
        return limitMapper.listAll();
    }

    public PageInfo<CarLimit> listPages(MvcDataDto param) {
        PageInfo<CarLimit> limit= null;
        Page page = param.getPage();
        if(page != null){
            //翻页关键，调用插件的翻页方法，把前端的翻页数据传进插件
            PageHelper.startPage(page.getCurrentPage() , page.getPageSize());
            List<CarLimit> list = limitMapper.listPages();
            limit = new PageInfo<>(list);
        }
        return limit;
    }

    public CarLimit getById(int id){
        return limitMapper.getById(id);
    }

    public void  delete(int id){
        limitMapper.delete(id);
    }

}
