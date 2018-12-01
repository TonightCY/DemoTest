package com.tonight.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tonight.bean.Bike;
import com.tonight.bean.Detail;
import com.tonight.mapper.BikeMapper;
import com.tonight.mapper.DetailMapper;
import com.tonight.service.DetailServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2018/11/16.
 */
@Service
public class DetailServiceImpl implements DetailServiceIf{

    @Autowired
    DetailMapper dm;
    @Autowired
    BikeMapper bm;

    @Override
    public Map<String,Object> query(Integer page, Integer rows,Detail detail) {
        PageHelper.startPage(page,rows);
        List<Detail> list = dm.query();
        //获取参数
        PageInfo<Detail> pi = new PageInfo<>(list);
        Map<String,Object> result = new HashMap<>();
        result.put("rows",list);
        result.put("total",pi.getTotal());

        return result;
    }

    @Override
    public int add(Detail detail) {
        Bike bike = bm.queryByBid(detail.getBid());
        System.out.println(bike.getNum());
        if (bike.getNum()<=0){
            return -1;
        }
        bike.setNum(bike.getNum()-1);
        bm.update(bike);
        return dm.add(detail);
    }

    @Override
    @Transactional
    public int returnbike(Detail detail) {
        Bike bike =bm.queryByBid(detail.getBid());
        System.out.println(bike.getNum());
        bike.setNum(bike.getNum()+1);
        bm.update(bike);
        return dm.returnbike(detail);
    }

    @Override
    public int getCountByDid(String date) {
        int result = dm.getCountByDid(date).size();
        return result;
    }

    @Override
    public List<Detail> getCountByBidAndDid(String date) {

        return dm.getCountByBidAndDid(date);
    }

    @Override
    public List<Detail> getlistIfBidExist() {
        return dm.getlistIfBidExist();
    }
}
