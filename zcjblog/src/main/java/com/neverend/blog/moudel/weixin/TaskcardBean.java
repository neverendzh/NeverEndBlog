package com.neverend.blog.moudel.weixin;

import java.util.List;

public class TaskcardBean {
    private String title;
    private String description;
    private String url;
    private String task_id;
    private List<BtnBean> btn;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public List<BtnBean> getBtn() {
        return btn;
    }

    public void setBtn(List<BtnBean> btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "TaskcardBean{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", task_id='" + task_id + '\'' +
                ", btn=" + btn +
                '}';
    }
}
