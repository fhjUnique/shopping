package com.bwie.text.fenghujie20170417.bean;

/**
 * Created by dell on 2017/4/17.
 */

public class Bean {
    private String text_name;
    private boolean ischeck;

    public Bean(String text_name) {
        this.text_name = text_name;
    }

    public String getText_name() {
        return text_name;
    }

    public void setText_name(String text_name) {
        this.text_name = text_name;
    }

    public boolean ischeck() {
        return ischeck;
    }

    public void setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
    }
}
