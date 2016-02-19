package com.hpg.drag;

/**
 * Created by paul on 16/2/19.
 */
public class ItemBean {
    private int id;
    private String title;
    private int resourceId;
    private boolean isChoose = false;

    public ItemBean(int id,String title,int resourceId, boolean isChoose) {
        this.id = id;
        this.title = title;
        this.resourceId = resourceId;
        this.isChoose = isChoose;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItemBean(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public boolean isChoose() {
        return isChoose;
    }

    public void setIsChoose(boolean isChoose) {
        this.isChoose = isChoose;
    }
}
