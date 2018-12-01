package com.tonight.mapper;

import com.tonight.bean.Bike;
import com.tonight.bean.Room;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    List<Room> selectByRnumAndRPrice(Room room);

    Room selectByRnum(@Param("rnum") String rnum);

    List<Room> getRoom();
}