package com.tonight.controller;

import com.tonight.bean.Provider;
import com.tonight.service.ProviderServiceIf;
import org.apache.ibatis.ognl.IntHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 85181 on 2018/11/16.
 */
@Controller
@RequestMapping(value = "/pro")
public class ProviderController {

    @Autowired
    ProviderServiceIf ps;

    @RequestMapping(value = "/getpro")
    @ResponseBody
    public List<Provider> getPro(){
      return ps.getProvider();
    }
}
