package com.tonight.mapper;

import com.tonight.bean.Roomdetail;
import com.tonight.bean.Roomtype;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomtypeMapper {
    int deleteByPrimaryKey(Integer rtid);

    int insert(Roomtype record);

    int insertSelective(Roomtype record);

    Roomtype selectByPrimaryKey(Integer rtid);

    int updateByPrimaryKeySelective(Roomtype record);

    int updateByPrimaryKey(Roomtype record);


}