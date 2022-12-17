import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Import classes from the new packages
import carspackage.Cars;
import smallpackage.CarPrice;

public class Main {

    private static Logger logger; //logger instance
    private String mode;

    public Main(String mode) {
        this.mode = mode;
        //wiring the logger to the system/class
        System.setProperty("log4j.configurationFile", "C:\\Users\\absuleim\\Desktop\\JarDependecy\\src\\main\\resources\\log4j2.xml");
        //the constructor has a logger instance for every object of this class.
        this.logger = LogManager.getLogger(Main.class);
    }

    public void printMode() throws NullPointerException{
        logger.info("Application is currently running in mode: " + this.mode + " mode.");
    }

    public static void main(String[] args) {

        Cars teslaz = new Cars("Model Z", "Tesla");
        CarPrice mercedes = new CarPrice("E-Class", "Mercedes", 17363D);


        Main ep = new Main("DEV");
        ep.printMode();
        logger.warn(ep.getClass());
        System.out.println("--------------------------------------------");
        logger.info("Cars instantiated:--> "+ teslaz.toString() + ";  "+ mercedes.toString());
        System.out.println("--------------------------------------------");


    }
}

