package com.tonight.controller;

import com.tonight.service.DeptServiceIf;
import com.tonight.util.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 85181 on 2018/11/7.
 */
@Controller
@RequestMapping(value = "/dept")
public class DeptController {
    @Autowired
    private DeptServiceIf ds;

    @RequestMapping(value = "/getDept",method = RequestMethod.POST)
    @ResponseBody
    public List<TreeNode> getDept(@RequestParam(value = "id",defaultValue = "0") Integer id){

        List<TreeNode> list = ds.findDeptByPid(id);
        return list;
    }
}
