package org.example;

public class Person {
    private String name;

    enum gender{
        MALE, FAMALE, NONBINAR,
    }

    private gender genderType;

    private Integer age;

    public Person(String name){
        this.name = name;
    }
    public Person(String name, gender genderType, Integer age) {
        this.name = name;
        this.genderType = genderType;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public gender getGenderType() {
        return genderType;
    }

    public void setGenderType(gender genderType) {
        this.genderType = genderType;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString(){
        return String.format("Name: %s, ID: %s, Age: %d", name, genderType, age);
    }
}
