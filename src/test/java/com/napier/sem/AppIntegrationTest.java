package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
        try {
            // Wait for database to be ready
            Thread.sleep(5000);
            app.connect("localhost:33060", 30000);
        } catch (Exception e) {
            System.err.println("Failed to connect to database: " + e.getMessage());
            // Don't throw the exception - let the test fail naturally
        }
    }

    @AfterAll
    static void cleanup() {
        if (app != null) {
            app.disconnect();
        }
    }

    @Test
    void testGetCity() {
        // Basic test to ensure test framework works
        assertNotNull(app, "App should not be null");

        // Actual test
        City city = app.getCity(1);
        assertNotNull(city, "City should not be null");
        assertEquals(1, city.ID, "City ID should be 1");
        assertEquals("Kabul", city.Name, "City name should be Kabul");
        assertEquals("AFG", city.CountryCode, "Country code should be AFG");
        assertEquals("Kabol", city.District, "District should be Kabol");
        assertEquals("1780000", city.Population, "Population should be 1780000");
    }
}