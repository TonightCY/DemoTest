package com.tonight.mapper;

import com.tonight.bean.Roomdetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomdetailMapper {
    int deleteByPrimaryKey(Integer rdid);

    int insert(Roomdetail record);

    int insertSelective(Roomdetail record);

    Roomdetail selectByPrimaryKey(Integer rdid);

    int updateByPrimaryKeySelective(Roomdetail record);

    int updateByPrimaryKey(Roomdetail record);

    List<Roomdetail> selectAll();
}