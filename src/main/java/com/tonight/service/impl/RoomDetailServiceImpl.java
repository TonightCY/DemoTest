package com.tonight.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tonight.bean.Room;
import com.tonight.bean.Roomdetail;
import com.tonight.mapper.RoomMapper;
import com.tonight.mapper.RoomdetailMapper;
import com.tonight.service.RoomDetailServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2018/11/26.
 */
@Service
public class RoomDetailServiceImpl implements RoomDetailServiceIf {

    @Autowired
    RoomdetailMapper rdm;

    @Override
    public int deleteByPrimaryKey(Integer rdid) {
        return rdm.deleteByPrimaryKey(rdid);
    }

    @Override
    public int insert(Roomdetail record) {
        return rdm.insert(record);
    }

    @Override
    public int insertSelective(Roomdetail record) {
        return rdm.insertSelective(record);
    }

    @Override
    public Roomdetail selectByPrimaryKey(Integer rdid) {
        return rdm.selectByPrimaryKey(rdid);
    }

    @Override
    public int updateByPrimaryKeySelective(Roomdetail record) {
        return rdm.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Roomdetail record) {
        return rdm.updateByPrimaryKey(record);
    }

    @Override
    public Map<String, Object> selectAll(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<Roomdetail> list = rdm.selectAll();
        //获取参数
        PageInfo<Roomdetail> pi = new PageInfo<>(list);
        Map<String,Object> result = new HashMap<>();
        result.put("rows",list);
        result.put("total",pi.getTotal());
        return result;
    }
}
