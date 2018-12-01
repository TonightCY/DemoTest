package com.tonight.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tonight.bean.Bike;
import com.tonight.bean.Room;
import com.tonight.mapper.RoomMapper;
import com.tonight.service.RoomServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2018/11/26.
 */
@Service
public class RoomServiceImpl implements RoomServiceIf {
    @Autowired
    RoomMapper roomMapper;

    @Override
    public int deleteByPrimaryKey(Integer rid) {

        return roomMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public int insert(Room room) {
        return roomMapper.insert(room);
    }

    @Override
    public int insertSelective(Room room) {
        return roomMapper.insertSelective(room);
    }

    @Override
    public Room selectByPrimaryKey(Integer rid) {
        return roomMapper.selectByPrimaryKey(rid);
    }

    @Override
    public int updateByPrimaryKeySelective(Room record) {
        return roomMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Room room) {
        return roomMapper.updateByPrimaryKey(room);
    }

    @Override
    public Map<String, Object> selectByRnumAndRPrice(Integer page, Integer rows,Room room) {
        PageHelper.startPage(page,rows);
        List<Room> list = roomMapper.selectByRnumAndRPrice(room);
        //获取参数
        PageInfo<Room> pi = new PageInfo<>(list);
        Map<String,Object> result = new HashMap<>();
        result.put("rows",list);
        result.put("total",pi.getTotal());
        return result;
    }

    @Override
    public Room selectByRnum(String rnum) {
        return roomMapper.selectByRnum(rnum);
    }

    @Override
    public List<Room> getRoom() {
        return roomMapper.getRoom();
    }


}
