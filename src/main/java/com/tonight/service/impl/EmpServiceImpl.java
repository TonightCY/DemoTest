package com.tonight.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tonight.bean.Emp;
import com.tonight.mapper.EmpMapper;
import com.tonight.service.EmpServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 85181 on 2018/11/7.
 */
@Service
public class EmpServiceImpl implements EmpServiceIf {
    @Autowired
    EmpMapper empMapper;


    @Transactional
    @Override
    public void add(Emp emp) {
        Emp emp1 = empMapper.getEmpByEno(emp.getEno());
        if (emp1!=null){
            throw new RuntimeException("员工编号不为空");
        }
        emp.setHiredate(new Date());
        emp.setPassword(DigestUtils.md5DigestAsHex(emp.getPassword().getBytes()));
        int result = empMapper.add(emp);
        if (result<=0){
            throw new RuntimeException("新增员工"+emp.getEname()+"失败");
        }
    }

    @Override
    public Emp getEno(String eno) {
        return empMapper.getEmpByEno(eno);
    }

    @Override
    public Map<String, Object> query(Integer page, Integer rows, Emp emp) {
        PageHelper.startPage(page,rows);
        List<Emp> list = empMapper.query(emp);
        //获取参数
        PageInfo<Emp> pi = new PageInfo<>(list);
        Map<String,Object> result = new HashMap<>();
        result.put("rows",list);
        result.put("total",pi.getTotal());

        return result;
    }

    @Override
    public Emp findEmpById(Integer id) {

        return empMapper.findEmpById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Emp emp) {
        Emp e = empMapper.findEmpById(emp.getId());
        if (e==null){
            throw new RuntimeException("该员工"+emp.getEno()+"不存在");
        }
        int i = empMapper.update(emp);
        if (i<=0){
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    @Transactional
    public int remove(List<Integer> ids) {
        if (ids!=null){
            return empMapper.remove(ids);
        }
        return 0;
    }

    @Override
    public void updatePass(String password, Integer id) {
        int result = empMapper.updatePass(password,id);
        if (result<=0){
            throw new RuntimeException("修改密码失败");
        }
    }


}
