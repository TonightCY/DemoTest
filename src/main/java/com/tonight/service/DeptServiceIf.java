package com.tonight.service;

import com.tonight.util.TreeNode;

import java.util.List;

/**
 * Created by 85181 on 2018/11/7.
 */
public interface DeptServiceIf {
    public List<TreeNode> findDeptByPid(Integer pid);
}
