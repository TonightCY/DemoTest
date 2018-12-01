package com.tonight.mapper;

import com.tonight.bean.Emp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 85181 on 2018/11/7.
 */
@Repository
public interface EmpMapper {
    public int add(Emp emp);

    public Emp getEmpByEno(@Param("eno") String eno);

    public Emp getEmpByNameAndPass(@Param("name") String name,@Param("password") String password);

    public List<Emp> query(Emp emp);

    public Emp findEmpById(@Param("id") Integer id);

    public int update(Emp emp);

    public int remove(@Param("ids") List<Integer> ids);

    public int updatePass(@Param("password") String password,@Param("id") Integer id);
}
