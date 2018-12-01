package com.tonight.bean;

/**
 * Created by 85181 on 2018/11/15.
 */
public class Bike {
//    bid varchar(40) primary key,
//    bno varchar(40),
//    pid varchar(40),
//    btype varchar(40),
//    num int,
//    status varchar(10)
    String bid;
    String bno;
    Integer pid;
    String btype;
    Integer num;
    Integer status;

    String testString;

    String author;
    String prname;

    @Override
    public String toString() {
        return "Bike{" +
                "bid='" + bid + '\'' +
                ", bno='" + bno + '\'' +
                ", pid=" + pid +
                ", btype='" + btype + '\'' +
                ", num=" + num +
                ", status=" + status +
                ", prname='" + prname + '\'' +
                '}';
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPrname() {
        return prname;
    }

    public void setPrname(String prname) {
        this.prname = prname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
