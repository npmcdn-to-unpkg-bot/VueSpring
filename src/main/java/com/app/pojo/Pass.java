package com.app.pojo;

import java.io.Serializable;

/**
 * Created by mosl on 16/8/26.
 */
public class Pass implements Serializable{

    private String pass;
    private String goods;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }
}
