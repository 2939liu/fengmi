package com.qf.entity;

import java.util.Date;

public class Order {
    private int id;
    private String orderCode;
    private Double totalPrice;
    private Date creatDate;
    private int uid;
    private int status;
    private String user;
    private String status1;

    public Order() {
    }

    public Order(int id, String orderCode, Double totalPrice, Date creatDate, int uid, int status) {
        this.id = id;
        this.orderCode = orderCode;
        this.totalPrice = totalPrice;
        this.creatDate = creatDate;
        this.uid = uid;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }
}
