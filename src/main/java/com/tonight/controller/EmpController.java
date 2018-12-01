package com.tonight.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.util.StringUtil;
import com.tonight.bean.Emp;
import com.tonight.service.EmpServiceIf;
import com.tonight.util.ResultMsg;
import com.tonight.util.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2018/11/7.
 */
@Controller
@RequestMapping(value="/emp")
public class EmpController {

    @Autowired
    private EmpServiceIf es;


    //跳转页面
    @RequestMapping(value="/empAddAndUpdate",method = RequestMethod.GET)
    public String empAddAndUpdate(Integer id, Model m){
        if (id!=null){
            Emp e = es.findEmpById(id);
            m.addAttribute("e",e);
        }
        return "/emp/AddAndUpdate";
    }


    //添加
    @RequestMapping(value = "/add")
    @ResponseBody
    public ResultMsg add(Emp emp){
        try{
            es.add(emp);
            return new ResultMsg(200,"添加成功");
        }catch(Exception e){
            e.printStackTrace();
            return new ResultMsg(500,"添加失败");
        }

    }


    //跳转列表页
    @RequestMapping(value = "list")
    public String list(){
        return "/emp/list";
    }



    @RequestMapping(value = "/query",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> query(Integer page,Integer rows,Emp emp){
        return es.query(page,rows,emp);
    }


    @RequestMapping(value = "/update")
    @ResponseBody
    public ResultMsg update(Emp emp){
        try{
            es.update(emp);
            return new ResultMsg(200,"修改成功");
        }catch(Exception e){
            e.printStackTrace();
            return new ResultMsg(500,"修改失败");
        }
    }
    /*
    * 删除
    * */
    @RequestMapping(value = "/remove")
    @ResponseBody
    public ResultMsg remove(@RequestBody List<Integer> ids){
        int result = es.remove(ids);

        return new ResultMsg(null,"删除"+result+"条成功");
    }

}
