package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
    }

    @Test
    void testGetCity() {
        // Add a simple test first to verify test execution
        assertTrue(true, "This test should always pass");

        // Your actual test code here
        City city = app.getCity(1);
        assertEquals(1, city.ID);
        assertEquals("Kabul", city.Name);
        assertEquals("AFG", city.CountryCode);
        assertEquals("Kabol", city.District);
        assertEquals("1780000", city.Population);
    }
}