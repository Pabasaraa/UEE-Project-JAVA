package com.uee.project;

public class RequestHelperClass {

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    String key;

    String title;

    public RequestHelperClass(){
    }

    public RequestHelperClass(String answer, String key) {
        this.title = title;
        this.key = key;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }
}
