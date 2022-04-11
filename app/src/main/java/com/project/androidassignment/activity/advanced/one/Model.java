package com.project.androidassignment.activity.advanced.one;

import java.io.Serializable;

public class Model implements Serializable {
    public String name, age, weight;

    public Model(String name, String age, String weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Model(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
