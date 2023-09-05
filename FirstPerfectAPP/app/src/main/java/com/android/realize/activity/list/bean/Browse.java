package com.android.realize.activity.list.bean;

/**
 *
 **/
public class Browse {
    private String text;

    public Browse(String text) {
        this.text = text;
    }

    public String getText() {
        return text == null ? "" : text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
