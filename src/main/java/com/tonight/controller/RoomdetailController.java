package com.tonight.controller;

import com.tonight.bean.Room;
import com.tonight.bean.Roomdetail;
import com.tonight.service.RoomDetailServiceIf;
import com.tonight.service.RoomServiceIf;
import com.tonight.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2018/11/26.
 */
@Controller
@RequestMapping(value = "rdetail")
public class RoomdetailController {
    @Autowired
    RoomDetailServiceIf rds;
    @Autowired
    RoomServiceIf rs;

    @RequestMapping(value = "/list")
    @ResponseBody
    public Map<String,Object> list(Integer page, Integer rows, Room room){
        return rds.selectAll(page,rows);
   }

    @RequestMapping(value="getroom")
    @ResponseBody
    public List<Room> getRoom(){
        List<Room> list = rs.getRoom();

        return list;
    }

    @RequestMapping(value="add")
    @ResponseBody
    public ResultMsg addDetail(Roomdetail roomdetail){

        Room room = rs.selectByRnum(roomdetail.getRdnum());
        room.setStatus(1);
        rs.updateByPrimaryKeySelective(room);
        roomdetail.setStatus(1);
        rds.insertSelective(roomdetail);
        return  new ResultMsg(200,"success");
    }

    @RequestMapping(value="return")
    @ResponseBody
    public ResultMsg returnroom(Integer rdid){
        //修改detail
        Roomdetail roomdetail = rds.selectByPrimaryKey(rdid);
        roomdetail.setStatus(0);
        rds.updateByPrimaryKeySelective(roomdetail);
        //修改room 表
        Room room = rs.selectByRnum(roomdetail.getRdnum());
        room.setStatus(0);
        rs.updateByPrimaryKeySelective(room);

        return new ResultMsg(200,"退房成功");
    }
}
