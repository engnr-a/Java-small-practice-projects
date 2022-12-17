import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InitPerson {

    public static void  main(String [] args){

        System.setProperty("log4j.configurationFile", "C:\\Users\\absuleim\\Desktop\\JarDependecy\\src\\main\\resources\\log4j2.xml");
        //the constructor has a logger instance for every object of this class.
        Logger logger = LogManager.getLogger(Main.class);

        Employee alice = new Employee("Alice", Person.gender.FAMALE, 24, 17363L, "DevOps");
        logger.info("Initialized employee: "+alice.getName());

        Employee jarda = new Employee("Jarda", Person.gender.MALE, 24, 1234L, "Senior Engineer");
        logger.info("Initialized employee: "+jarda.getName());
    }
}
