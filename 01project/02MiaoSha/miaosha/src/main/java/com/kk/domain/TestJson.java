package com.kk.domain;

public class TestJson {
    String name;
    String ADDRESS;

    public TestJson() {
    }

    public TestJson(String name, String ADDRESS) {
        this.name = name;
        this.ADDRESS = ADDRESS;
    }

    @Override
    public String toString() {
        return "TestJson{" +
                "name='" + name + '\'' +
                ", ADDRESS='" + ADDRESS + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }
}
