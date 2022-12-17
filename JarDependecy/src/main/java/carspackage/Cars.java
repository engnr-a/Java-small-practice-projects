package carspackage;

public class Cars {

    public String name;
    public String make;
    public Cars(String name, String make){
        this.name = name;
        this.make = make;
    }



    @Override
    public String toString() {
        return String.format("Name:%s, Make:%s", name, make);
    }
}
