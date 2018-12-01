package com.tonight.bean;

/**
 * Created by 85181 on 2018/11/7.
 */
public class Dept {
    private Integer id;
    private Integer pid;
    private String dno;
    private String dname;
    private String dloc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String name) {
        this.dname = name;
    }

    public String getDloc() {
        return dloc;
    }

    public void setDloc(String dloc) {
        this.dloc = dloc;
    }
}
