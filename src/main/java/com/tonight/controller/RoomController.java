package com.tonight.controller;

import com.tonight.bean.Bike;
import com.tonight.bean.Room;
import com.tonight.service.RoomServiceIf;
import com.tonight.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.print.Book;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 85181 on 2018/11/26.
 */
@Controller
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomServiceIf rs;


    @RequestMapping(value = "/list")
    @ResponseBody
    public Map<String,Object> list(Integer page, Integer rows, Room room){
        return rs.selectByRnumAndRPrice(page,rows,room);
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public ResultMsg add(Room room){
        System.out.println(123);
        Room room2 = rs.selectByRnum(room.getRnum());
        if (room2!=null){
           return new ResultMsg(500,"房间号已经存在");
        }
        room.setStatus(0);
        rs.insertSelective(room);
        return new ResultMsg(200,"插入成功");
    }

    //跳转页面
    @RequestMapping(value="/empAddAndUpdate",method = RequestMethod.GET)
    public String empAddAndUpdate(Integer rid, Model m){
        if (rid!=null){
            Room room = rs.selectByPrimaryKey(rid);
            m.addAttribute("r",room);
        }
        return "/emp/AddAndUpdate";
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public ResultMsg update(Room room){
        rs.updateByPrimaryKeySelective(room);
        return new ResultMsg(200,"修改成功");
    }

    @RequestMapping(value = "/del")
    @ResponseBody
    public ResultMsg del(Integer id){

        Room room = rs.selectByPrimaryKey(id);
        if(room.getStatus()==1){
            return new ResultMsg(500,"未退房无法删除");
        }

        rs.deleteByPrimaryKey(id);

        return new ResultMsg(200,"删除成功");
    }

    @RequestMapping(value = "/getByRnum")
    @ResponseBody
    public Room selectByRnum(String rnum){
        return rs.selectByRnum(rnum);
    }
}
