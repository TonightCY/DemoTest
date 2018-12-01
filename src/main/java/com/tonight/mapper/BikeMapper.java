package com.tonight.mapper;

import com.tonight.bean.Bike;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 85181 on 2018/11/15.
 */
@Repository
public interface BikeMapper {
    int add(Bike bike);
    int delectByBid(@Param("pids")List<String> bids);
    int update(Bike bike);
    Bike queryByBid(@Param("pid")String pid);
    Bike queryByBnoAndPid(Bike bike);
    List<Bike> listByBnoAndPid(Bike bike);
}
