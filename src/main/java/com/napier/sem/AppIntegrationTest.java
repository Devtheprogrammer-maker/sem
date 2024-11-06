package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 10000);

    }

    @Test
    void testGetEmployee()
    {
        City city = app.getCity(1);
        assertEquals(city.ID, 1);
        assertEquals(city.Name, "Kabul");
        assertEquals(city.CountryCode, "AFG");
        assertEquals(city.District, "Kabol");
        assertEquals(city.Population, "1780000");
    }
}