package com.tonight.mapper;

import com.tonight.bean.Detail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 85181 on 2018/11/16.
 */
@Repository
public interface DetailMapper {
    List<Detail> query();

    int add(Detail detail);

    int returnbike(Detail detail);

    List<Detail> getCountByDid(@Param("did") String date);

    List<Detail> getCountByBidAndDid(@Param("did")String date);

    List<Detail> getlistIfBidExist();
}
