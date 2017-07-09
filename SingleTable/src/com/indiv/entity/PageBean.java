package com.indiv.entity;

import java.util.List;

/**
 * Created by wangsongyan on 2017/7/8.
 * email: wangsongyan921@163.com
 */
public class PageBean<T> {

    private int pc;//当前页码 page code
    //    private int tp;//总页数 total pages
    private int tr;//总记录数 total record
    private int ps;//每页的记录数 page size
    private List<T> beanList; //当前页的记录

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getTp() {
        //通过总记录数和每页记录数计算总页数
        return getTr() % getPs() == 0 ? getTr() / getPs() : getTr() / getPs() + 1;
    }

//    public void setTp(int tp) {
//        this.tp = tp;
//    }

    public int getTr() {
        return tr;
    }

    public void setTr(int tr) {
        this.tr = tr;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }
}
