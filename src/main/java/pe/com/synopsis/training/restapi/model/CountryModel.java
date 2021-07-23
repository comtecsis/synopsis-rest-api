package pe.com.synopsis.training.restapi.model;

import org.springframework.stereotype.Component;

public class CountryModel {

    private String name;
    private Integer population;
    private String capital;
    private String currency;

    public CountryModel(String name, Integer population, String capital, String currency) {
        this.name = name;
        this.population = population;
        this.capital = capital;
        this.currency = currency;
    }

    public CountryModel(){}



    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
