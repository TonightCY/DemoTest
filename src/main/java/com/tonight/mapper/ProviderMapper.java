package com.tonight.mapper;

import com.tonight.bean.Emp;
import com.tonight.bean.Provider;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 85181 on 2018/11/7.
 */
@Repository
public interface ProviderMapper {
    List<Provider> getProvider();
}
