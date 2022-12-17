package org.example;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;



/**
 * Hello world!
 * @author Shola
 */
public class App {
    private String mode;
    private static Logger logger;

    public App(String mode){
        this.mode = mode;
        System.setProperty("log4j.configurationFile",
                "C:\\Users\\absuleim\\Desktop\\JARWithMaven\\src\\main\\resources\\log4j2.xml");
        this.logger = LogManager.getLogger(App.class);
    }

    public void printMode(){
        logger.info("App is running in: "+this.mode + " mode");
        logger.warn(App.class);
    }

    public static void main( String[] args ) {

        App appInstance = new App("Dev");
        appInstance.printMode();

    }
}
