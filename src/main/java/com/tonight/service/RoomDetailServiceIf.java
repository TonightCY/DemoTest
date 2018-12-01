package com.tonight.service;

import com.tonight.bean.Roomdetail;

import java.util.Map;

/**
 * Created by 85181 on 2018/11/26.
 */
public interface RoomDetailServiceIf {
    int deleteByPrimaryKey(Integer rdid);

    int insert(Roomdetail record);

    int insertSelective(Roomdetail record);

    Roomdetail selectByPrimaryKey(Integer rdid);

    int updateByPrimaryKeySelective(Roomdetail record);

    int updateByPrimaryKey(Roomdetail record);

    Map<String,Object> selectAll(Integer page, Integer rows);
}
