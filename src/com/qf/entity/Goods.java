package com.qf.entity;

import java.util.Date;

public class Goods {
    private int id;
    private String goodsName;
    private double price;
    private int score;
    private Date deployDate;
    private String imgPath;
    private String comment;
   private String type;
   private int typeId;

    public Goods() {
    }

    public Goods(int id, String goodsName, double price, int score, Date deployDate, String imgPath, String comment, String type) {
        this.id = id;
        this.goodsName = goodsName;
        this.price = price;
        this.score = score;
        this.deployDate = deployDate;
        this.imgPath = imgPath;
        this.comment = comment;
        this.type = type;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getDeployDate() {
        return deployDate;
    }

    public void setDeployDate(Date deployDate) {
        this.deployDate = deployDate;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", score=" + score +
                ", deployDate=" + deployDate +
                ", imgPath='" + imgPath + '\'' +
                ", comment='" + comment + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
