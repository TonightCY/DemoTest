package com.tonight.service;

import com.tonight.bean.Bike;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2018/11/16.
 */
public interface BikeServiceIf {

    int add(Bike bike);
    int delectByBid(@Param("bids")List<String> bids);
    int update(Bike bike);
    Bike queryByBid(@Param("pid")String pid);
    Bike queryByBnoAndPid(Bike bike);
    Map<String,Object> listByBnoAndPid(Integer page, Integer rows,Bike bike);


    List<Bike> getAllBike();
}
