package com.tonight.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by 85181 on 2018/11/16.
 */
public class Detail {

    String did;
    String bid;
    String dname;
    String dmobile;
    @JsonFormat(pattern = "yyyy-MM-dd ",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date starttime;
    @JsonFormat(pattern = "yyyy-MM-dd ",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date endtime;
    String btype;

    Integer count;

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getDmobile() {
        return dmobile;
    }

    public void setDmobile(String dmobile) {
        this.dmobile = dmobile;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}
