package com.neverend.blog.moudel.weixin;

public class BtnBean {
    /**
     * key : key111
     * name : 批准
     * replace_name : 已批准
     * color : red
     * is_bold : true
     */

    private String key;
    private String name;
    private String replace_name;
    private String color;
    private boolean is_bold;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReplace_name() {
        return replace_name;
    }

    public void setReplace_name(String replace_name) {
        this.replace_name = replace_name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isIs_bold() {
        return is_bold;
    }

    public void setIs_bold(boolean is_bold) {
        this.is_bold = is_bold;
    }

    @Override
    public String toString() {
        return "BtnBean{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", replace_name='" + replace_name + '\'' +
                ", color='" + color + '\'' +
                ", is_bold=" + is_bold +
                '}';
    }
}
