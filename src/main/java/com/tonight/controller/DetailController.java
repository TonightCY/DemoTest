package com.tonight.controller;

import com.tonight.bean.Bike;
import com.tonight.bean.Detail;
import com.tonight.service.BikeServiceIf;
import com.tonight.service.DetailServiceIf;
import com.tonight.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2018/11/16.
 */
@Controller
@RequestMapping(value = "/detail")
public class DetailController {

    @Autowired
    DetailServiceIf ds;
    @Autowired
    BikeServiceIf bs;

    @RequestMapping (value = "list")
    @ResponseBody
    public Map<String,Object> list (Integer page, Integer rows, Detail detail){
        return  ds.query(page,rows,detail);
    }


    //还车
    @ResponseBody
    @RequestMapping(value="/returnbike")
    public ResultMsg returnbike(Detail detail){
//        SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
//        String d = adf.format(new Date());
        detail.setEndtime(new Date());
        ds.returnbike(detail);


        return new ResultMsg(200,"归还成功");
    }

//租车
    @ResponseBody
    @RequestMapping(value="/add")
    public ResultMsg add(Detail detail){
        int result = ds.add(detail);
        if (result==-1){
            return new ResultMsg(500,"剩余车辆不足,无法租赁");
        }
        return new ResultMsg(200,"租赁成功");
    }


    @RequestMapping(value = "addDetail")
    public String addDetail(Model model){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String date = sdf.format(new Date()).replace("-","");
//        String n = (ds.getCountByDid(date)+1)+"";
//        while (n.length()<4){
//            n="0"+n;
//        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        model.addAttribute("logintime",sdf.format(new Date()));
        return "/addDetail";
    }
    @RequestMapping(value = "getdetail")
    @ResponseBody
    public List<Detail> getdetail(String day){
        System.out.println(day);
        Map<String,Object> map = new HashMap<String,Object>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date()).replace("-","");
        day = day.toString().replace("-","");

        List<Detail> list  = ds.getCountByBidAndDid(day);

        return list;
    }


}
