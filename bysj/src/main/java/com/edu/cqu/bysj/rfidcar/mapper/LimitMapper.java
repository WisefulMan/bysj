package com.edu.cqu.bysj.rfidcar.mapper;

import com.edu.cqu.bysj.rfidcar.model.CarLimit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LimitMapper {
    //增加禁行限制
    void add(CarLimit carLimit);
    //修改禁行限制
    void edit(CarLimit carLimit);
    //删除禁行限制
    void delete(int id);
    //获取所有限制
    List<CarLimit> listAll();
    //翻页
    List<CarLimit> listPages();
    public CarLimit getById(int id);
}
