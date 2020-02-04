package com.kuang.bean;

public class MyDataSource {

    private String name;

    private String password;

    private String url;

    private String clazz;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "MyDataSource{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                ", clazz='" + clazz + '\'' +
                '}';
    }
}
