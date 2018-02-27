package com.gsy.glsurvive.mine_model.video;

import android.graphics.Bitmap;

/**
 * Created by TR-AND2 on 2018/1/9.
 */

public class LocalVideoBean {
    private String name;
    private String path;
    private Bitmap bitmap;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "LocalVideoBean{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
