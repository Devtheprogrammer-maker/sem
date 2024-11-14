package com.napier.sem;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class AppTest {
    static App app;

    @BeforeAll
    static void init(){
        app = new App();
    }

    @Test
    void unitTest()
    {

        assertEquals(5, 5);
    }

    @Test
    void printCitiesTestNull()
    {
        app.printCityReport(null);
    }


}