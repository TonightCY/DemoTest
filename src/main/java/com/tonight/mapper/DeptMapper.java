package com.tonight.mapper;

import com.tonight.bean.Dept;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 85181 on 2018/11/7.
 */
@Repository
public interface DeptMapper {
    public List<Dept> findDeptByPid(@Param("pid") Integer pid);
}
