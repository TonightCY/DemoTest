package com.tonight.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Roomdetail {
    private Integer rdid;

    private String rdnum;

    private String rdname;

    public String getRdname() {
        return rdname;
    }

    public void setRdname(String rdname) {
        this.rdname = rdname;
    }

    private String rdidcard;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date intime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date outtime;

    private Integer days;

    private Integer sum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date logintime;

    private Integer status;

    public Integer getRdid() {
        return rdid;
    }

    public void setRdid(Integer rdid) {
        this.rdid = rdid;
    }

    public String getRdnum() {
        return rdnum;
    }

    public void setRdnum(String rdnum) {
        this.rdnum = rdnum == null ? null : rdnum.trim();
    }

    public String getRdidcard() {
        return rdidcard;
    }

    public void setRdidcard(String rdidcard) {
        this.rdidcard = rdidcard == null ? null : rdidcard.trim();
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}