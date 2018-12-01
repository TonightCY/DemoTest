package com.tonight.controller;

import com.tonight.bean.Bike;
import com.tonight.bean.Detail;
import com.tonight.bean.Emp;
import com.tonight.service.BikeServiceIf;
import com.tonight.service.DetailServiceIf;
import com.tonight.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 85181 on 2018/11/16.
 */
@Controller
@RequestMapping(value = "/bike")
public class BikeController {

    @Autowired
    BikeServiceIf bs;
    @Autowired
    DetailServiceIf ds;

    @RequestMapping(value = "/tolist")
    public String tolist(){
        return "/emp/list";
    }

    @RequestMapping(value = "/tolist2")
    public String tolist2(){
        return "/emp/list2";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Map<String,Object> list(Integer page, Integer rows,Bike bike){

        return bs.listByBnoAndPid(page,rows,bike);
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public ResultMsg add(Bike bike){
        Bike bike2 = bs.queryByBnoAndPid(bike);
        if (bike2!=null){
            return new ResultMsg(500,"数据重复");
        }

        bike.setBid(UUID.randomUUID().toString().replaceAll("-",""));
        bike.setStatus(0);

        bs.add(bike);
        return new ResultMsg(200,"添加成功");
    }

    @RequestMapping(value = "/del")
    @ResponseBody
    public ResultMsg remove(@RequestBody List<String> bids){
        List<Detail> list = ds.getlistIfBidExist();
        for(String b:bids){
            for (Detail detail:list){
                if (b.equals(detail.getBid())){
                    return new ResultMsg(null,"有车未还无法删除");
                }
            }
        }


        bs.delectByBid(bids);
        return new ResultMsg(null,"删除成功");
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public ResultMsg update(Bike bike){
        System.out.println(bike);
        Bike bike2 = bs.queryByBnoAndPid(bike);
        System.out.println(bike2);

        if (bike2!=null){

            if (!bike2.getBid().equals(bike.getBid())){
                return new ResultMsg(500,"数据重复");
            }
        }
        bs.update(bike);
        return new ResultMsg(200,"修改成功");
    }


    //跳转页面
    @RequestMapping(value="/empAddAndUpdate",method = RequestMethod.GET)
    public String empAddAndUpdate(String bid, Model m){
        if (bid!=null){
            Bike b = bs.queryByBid(bid);
            m.addAttribute("b",b);
        }
        return "/emp/AddAndUpdate";
    }

    @RequestMapping(value = "/getBno")
    @ResponseBody
    public List<Bike> getBno(){
        return bs.getAllBike();
    }
}
