package com.napier.sem;

/**
 * Object representation of the City Table from World database
 */
public class City {
    private long id;
    private String name;
    private String countryCode;
    private String district;
    private long population;

    public City(int id, String name, String countryCode, String district, Integer population) {
        this.id = this.id;
        this.name = this.name;
        this.countryCode = this.countryCode;
        this.district = this.district;
        this.population = this.population;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public long getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", name='" + name + '\''
                + ", countryCode='" + countryCode + '\'' + ", district='"
                + district + '\'' + ", population=" + population + '}';
    }
}
