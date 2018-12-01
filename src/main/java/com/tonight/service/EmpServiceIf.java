package com.tonight.service;

import com.tonight.bean.Dept;
import com.tonight.bean.Emp;
import com.tonight.util.TreeNode;

import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2018/11/7.
 */
public interface EmpServiceIf {
    public void add(Emp emp);

    Emp getEno(String username);

    public Map<String,Object> query(Integer page,Integer rows,Emp emp);

    public Emp findEmpById(Integer id);

    public void update(Emp emp);

    public int remove(List<Integer> ids);

    public void updatePass(String password,Integer id);
}
