package smallpackage;

import carspackage.Cars;

public class CarPrice extends Cars {

    public Double price;

    public CarPrice(String name, String make, Double price){
        super(name, make);
        this.price = price;
    }

    public Double getPrice(){
        return price;
    }
}
