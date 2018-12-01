package com.tonight.service;

import com.tonight.bean.Room;

import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2018/11/26.
 */
public interface RoomServiceIf {
    int deleteByPrimaryKey(Integer rid);

    int insert(Room room);

    int insertSelective(Room room);

    Room selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room room);

    Map<String,Object> selectByRnumAndRPrice(Integer page, Integer rows,Room room);

    Room selectByRnum(String rnum);

    List<Room> getRoom();
}
