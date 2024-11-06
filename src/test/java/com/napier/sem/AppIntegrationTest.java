package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    @Test
    void testGetEmployee()
    {
        City city = app.getCity(1);
        assertNotNull(city, "City should not be null");
        assertEquals(1, city.ID, "City ID should be 1");
        assertEquals("Kabul", city.Name, "City name should be Kabul");
        assertEquals("AFG", city.CountryCode, "Country code should be AFG");
        assertEquals("Kabol", city.District, "District should be Kabol");
        assertEquals(String.valueOf(city.Population), "1780000", "Population should be 1780000"); // Convert to String for comparison
    }
}