package com.tonight.bean;

public class Room {
    private Integer rid;

    private String rnum;

    private String rtype;

    private String rtool;

    private Integer status;

    private int rprice;

    private Integer startprice;
    private Integer endprice;

    public Integer getRprice() {
        return rprice;
    }

    public void setRprice(Integer rprice) {
        this.rprice = rprice;
    }

    public Integer getStartprice() {
        return startprice;
    }

    public void setStartprice(Integer startprice) {
        this.startprice = startprice;
    }

    public Integer getEndprice() {
        return endprice;
    }

    public void setEndprice(Integer endprice) {
        this.endprice = endprice;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRnum() {
        return rnum;
    }

    public void setRnum(String rnum) {
        this.rnum = rnum == null ? null : rnum.trim();
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype == null ? null : rtype.trim();
    }

    public String getRtool() {
        return rtool;
    }

    public void setRtool(String rtool) {
        this.rtool = rtool == null ? null : rtool.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}