package com.qf.entity;

public class GoodsType {
    private int id;
    private String typeName;
    private int level;
    private int pid;

    public GoodsType() {
    }

    public GoodsType(int id, String typeName, int level, int pid) {
        this.id = id;
        this.typeName = typeName;
        this.level = level;
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
