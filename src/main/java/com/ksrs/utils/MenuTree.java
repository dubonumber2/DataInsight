package com.ksrs.utils;

import com.ksrs.entity.Menu;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25 0025.
 */
public class MenuTree {
    private int id;
    private String text;
    private String iconCls;
    private List<Menu> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
