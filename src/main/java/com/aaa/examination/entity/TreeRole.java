package com.aaa.examination.entity;

import java.util.List;

/**
 * className:TreeRole
 * discriptoin:
 * author:llw
 * createTime:2018-12-13 17:21
 */
public class TreeRole {

    private int id;
    private String label;
    private int functioncoding;
    private String functionurl;
    List<TreeRole> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<TreeRole> getChildren() {
        return children;
    }

    public void setChildren(List<TreeRole> children) {
        this.children = children;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getFunctioncoding() {
        return functioncoding;
    }

    public void setFunctioncoding(int functioncoding) {
        this.functioncoding = functioncoding;
    }

    public String getFunctionurl() {
        return functionurl;
    }

    public void setFunctionurl(String functionurl) {
        this.functionurl = functionurl;
    }






}
