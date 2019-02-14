//* /population/size?people=
//        * return the countries that have a population equal to or greater than the given population
//        * /population/min
//        * return the country with the smallest population
//        * /population/max
//        * return the country with the largest population

package com.lambdaschool.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

@RestController
@RequestMapping("/population")
public class PopulationController {
    @RequestMapping("/size")
    public ArrayList<Country> getPopulationBySize(@RequestParam(value = "people") int people) {
        return JavaCountriesApplication.countries.findCountries(c -> (c.getPopulation() >= people));
    }
    @RequestMapping("min")
    public ArrayList<Country> getMinPopulation() {
        JavaCountriesApplication.countries.countryList.sort(Comparator.comparingInt(Country::getPopulation));
        int minPopulation = JavaCountriesApplication.countries.countryList.get(0).getPopulation();
        return JavaCountriesApplication.countries.findCountries(c -> (c.getPopulation() == minPopulation));
    }
    @RequestMapping("/max")
    public ArrayList<Country> getMaxPopulation() {
        JavaCountriesApplication.countries.countryList.sort(Comparator.comparingInt(Country::getPopulation)
                .reversed());
        int maxPopulation = JavaCountriesApplication.countries.countryList.get(0).getPopulation();
        return JavaCountriesApplication.countries.findCountries(c -> (c.getPopulation() == maxPopulation));
    }
}
