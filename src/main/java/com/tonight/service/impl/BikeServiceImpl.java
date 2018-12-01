package com.tonight.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tonight.bean.Bike;
import com.tonight.bean.Emp;
import com.tonight.mapper.BikeMapper;
import com.tonight.service.BikeServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2018/11/16.
 */
@Service
public class BikeServiceImpl implements BikeServiceIf {
    @Autowired
    BikeMapper bm;

    @Override
    public int add(Bike bike) {
        return bm.add(bike);
    }

    @Override
    public int delectByBid(List<String> bids) {

        return bm.delectByBid(bids);
    }

    @Override
    public int update(Bike bike) {
        return bm.update(bike);
    }

    @Override
    public Bike queryByBid(String pid) {
        return bm.queryByBid(pid);
    }

    @Override
    public Bike queryByBnoAndPid(Bike bike) {
        return bm.queryByBnoAndPid(bike);
    }

    @Override
    public Map<String,Object> listByBnoAndPid(Integer page, Integer rows,Bike bike) {
        PageHelper.startPage(page,rows);
        List<Bike> list = bm.listByBnoAndPid(bike);
        //获取参数
        PageInfo<Bike> pi = new PageInfo<>(list);
        Map<String,Object> result = new HashMap<>();
        result.put("rows",list);
        result.put("total",pi.getTotal());

        return result;

    }

    @Override
    public List<Bike> getAllBike() {
        return bm.listByBnoAndPid(new Bike());
    }
}
