package com.daelim.data;

public class ListData {
    private int cloth_image_id;
    private String name;
    private String price;

    public ListData(int id, String name, String price) {
        this.cloth_image_id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return cloth_image_id;
    }

    public void setId(int id) {
        this.cloth_image_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }





}
