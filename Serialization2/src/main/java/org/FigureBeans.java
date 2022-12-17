package org;

import org.json.JSONPropertyIgnore;
import org.json.JSONPropertyName;

import java.util.Random;


public class FigureBeans {
   public Random randomNumberGenerator = new Random();


    public String name;
    public String gender;
    public int age;

    public int figureID;
    public FigureBeans(){}
    public FigureBeans(String name, String gender, int age) {
        this.figureID = Math.abs(randomNumberGenerator.nextInt());
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @JSONPropertyIgnore
    public Random getRandomNumberGenerator() {
        return randomNumberGenerator;
    }

    public void setRandomNumberGenerator(Random randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @JSONPropertyName("TV Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @JSONPropertyName("Art ID")
    public int getFigureID() {
        return figureID;
    }

    public void setFigureID(int figureID) {
        this.figureID = figureID;
    }



        @Override
        public String toString() {
            return "Employee{" +
                "randomNumberGenerator=" + randomNumberGenerator +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", employeeID=" + figureID +
                '}';
        }
}
