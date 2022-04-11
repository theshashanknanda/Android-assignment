package com.project.androidassignment.retrofit.two;

public class Model {
    private String firstname;
    private int id;
    private String lastname;

    public String getFirstname(){
        return firstname;
    }

    public int getId(){
        return id;
    }

    public String getLastname(){
        return lastname;
    }

    @Override
    public String toString() {
        return "MysqlModel{" +
                "firstname='" + firstname + '\'' +
                ", id=" + id +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
