package com.tonight.service.impl;

import com.tonight.bean.Provider;
import com.tonight.mapper.ProviderMapper;
import com.tonight.service.ProviderServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 85181 on 2018/11/16.
 */
@Service
public class ProviderServiceImpl implements ProviderServiceIf{
    @Autowired
    ProviderMapper pm;

    @Override
    public List<Provider> getProvider() {
        return pm.getProvider();
    }
}
