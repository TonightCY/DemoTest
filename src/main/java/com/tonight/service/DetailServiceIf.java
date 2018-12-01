package com.tonight.service;

import com.tonight.bean.Bike;
import com.tonight.bean.Detail;

import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2018/11/16.
 */
public interface DetailServiceIf {
    Map<String,Object> query(Integer page, Integer rows,Detail detail);

    int add(Detail detail);

    int returnbike(Detail detail);

    int getCountByDid(String date);

    List<Detail> getCountByBidAndDid(String date);

    List<Detail> getlistIfBidExist();
}
