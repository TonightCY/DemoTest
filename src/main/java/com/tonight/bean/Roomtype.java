package com.tonight.bean;

public class Roomtype {
    private Integer rtid;

    private String rtname;

    private Integer rtprice;

    public Integer getRtid() {
        return rtid;
    }

    public void setRtid(Integer rtid) {
        this.rtid = rtid;
    }

    public String getRtname() {
        return rtname;
    }

    public void setRtname(String rtname) {
        this.rtname = rtname == null ? null : rtname.trim();
    }

    public Integer getRtprice() {
        return rtprice;
    }

    public void setRtprice(Integer rtprice) {
        this.rtprice = rtprice;
    }
}