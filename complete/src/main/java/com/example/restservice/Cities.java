package com.example.restservice;

public class Cities {

    private final long id;
    private final String name;
    private final String province;

    public Cities(long id, String name, String province) {
        this.id = id;
        this.name = name;
        this.province = province;

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProvince() {
        return province;
    }
}

