package com.tonight.service.impl;

import com.tonight.bean.Dept;
import com.tonight.mapper.DeptMapper;
import com.tonight.service.DeptServiceIf;
import com.tonight.util.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 85181 on 2018/11/7.
 */
@Service
public class DeptServiceImpl implements DeptServiceIf{
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<TreeNode> findDeptByPid(Integer pid) {

        List<TreeNode> trees = null;

        List<Dept> depts = deptMapper.findDeptByPid(pid);

        if(depts!=null&&depts.size()>0){
            trees = new ArrayList<>();

            for (Dept dept:depts){
                TreeNode tree = new TreeNode();
                tree.setId(dept.getId());
                tree.setText(dept.getDname());
                List<Dept> count = deptMapper.findDeptByPid(dept.getId());
                tree.setState(count==null||count.size()==0?"open":"closed");
                trees.add(tree);
            }

        }

        return trees;
    }
}
