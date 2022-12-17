package com.shola;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Execution(ExecutionMode.CONCURRENT) //This annotation enables concurrent execution.
public class ProductTest {

    static Product tv;
    @BeforeAll
    static void initAll(){
        tv = new Product("LifeImage", "Alpha", 1111, 63.5, "Electronics");
    }

    //This is a composed annotation interface used to specify a composite of four different 'EnabledIf conditions'.
        // It also encompasses the @Test annotation.
    @Retention(RetentionPolicy.RUNTIME) //The annotation will be retained until runtime.
    @Test
    @EnabledIfEnvironmentVariable(named="HOMEDRIVE", matches="C:")
    @EnabledForJreRange(max=JRE.JAVA_12)
    @EnabledIfSystemProperty(named="os.version", matches ="10\\..*")
    @EnabledIfSystemProperty(named="os.arch", matches ="amd64")
    public @ interface MyCustomTestAnnotation{

    }

    @MyCustomTestAnnotation
    @Timeout(3)
    @Order(2)
    void systemPptBasedTest() throws InterruptedException {
        assertNotEquals(tv.increasePrice(23.0), tv.getPrice());
    }

    @MyCustomTestAnnotation
    @Tag("DEVShola")
    @Order(3)
    @DisabledForJreRange(min=JRE.JAVA_12) //This annotation will take precedence if evaluated to true.
    void systemPptBasedTest2(){
        assertEquals(tv.getModel(), "Alpha");
    }

    @Test
    @Order(4)
    @Tag("DEVShola")
    void systemPptBasedTest3(){
        assertEquals(tv.getBrandName(), "LifeImage");
    }

    @Test
    @Order(1)
    void systemPptBasedTest4(){
        assertEquals(tv.getBrandName(), "LifeImage");
    }

}
