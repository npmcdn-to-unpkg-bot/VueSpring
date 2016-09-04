package com.app.pojo;

import java.util.List;

/**
 * Created by mosl on 16/9/3.
 */
public class Doc {

    private String name;
    private String mPath;
    private String mTime;
    private List<String> docs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getmPath() {
        return mPath;
    }

    public void setmPath(String mPath) {
        this.mPath = mPath;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public List<String> getDocs() {
        return docs;
    }

    public void setDocs(List<String> docs) {
        this.docs = docs;
    }
}
