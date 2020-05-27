package com.example.feedtheneed21;

public class Detail {

    String text;
    String type;
    String id;
    public Detail() {
        this.text = " ";
        this.type = " ";
        this.id = " ";
    }

    public Detail(String id,String text, String type ) {
        this.text = text;
        this.type = type;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }
    void set(String id,String text, String type){
        this.text = text;
        this.type = type;
        this.id = id;
    }


}
