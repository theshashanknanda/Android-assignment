package com.project.androidassignment.adapter.advanced.one;

public class Employee {
    private int photo;
    private String name, position, joiningDate;

    public Employee(){}

    public Employee(int photo, String name, String position, String joiningDate) {
        this.photo = photo;
        this.name = name;
        this.position = position;
        this.joiningDate = joiningDate;
    }

    public Employee(String name, String position, String joiningDate) {
        this.name = name;
        this.position = position;
        this.joiningDate = joiningDate;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }
}
