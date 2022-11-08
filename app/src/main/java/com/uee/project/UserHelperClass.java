package com.uee.project;

import android.widget.EditText;

public class UserHelperClass {

    String ReNo;
    String Phone;
    String Home;
    String Title;
    String Msg;
    String key;

    public UserHelperClass() {

    }

    public UserHelperClass(String reNo, String phone, String home, String title, String msg, String key) {
       ReNo = reNo;
       Phone = phone;
       Home = home;
       Title = title;
       Msg = msg;
       this.key=key;
    }

    public String getReNo() {
        return ReNo;
    }

    public void setReNo(String reNo) {
        ReNo = reNo;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getHome() {
        return Home;
    }

    public void setHome(String home) {
        Home = home;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {Title = title;}

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
