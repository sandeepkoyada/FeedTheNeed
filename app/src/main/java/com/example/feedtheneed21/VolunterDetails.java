package com.example.feedtheneed21;

class VolunterDetails {
    String id="";
    String name="";
    String phone="";
    String address="";

    public VolunterDetails(String id,String name, String phone, String address) {
        this.id=id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
