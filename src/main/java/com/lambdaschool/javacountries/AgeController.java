// * /age/age?age=
//        * return the countries that have a median age equal to or greater than the given age
//        * /age/min
//        * return the country with the smallest median age
//        * /age/max
//        * return the country the the greatest median age

package com.lambdaschool.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

@RestController
@RequestMapping("/age")
public class AgeController {
    @RequestMapping("/age")
    public ArrayList<Country> getAgeLargerOrEqual(@RequestParam(value = "age") int age) {
        return JavaCountriesApplication.countries.findCountries(c -> (c.getAge() >= age));
    }
    @RequestMapping("/min")
    public ArrayList<Country> getMinAge() {
        JavaCountriesApplication.countries.countryList.sort(Comparator.comparingInt(Country::getAge));
        int minAge = JavaCountriesApplication.countries.countryList.get(0).getAge();
        return JavaCountriesApplication.countries.findCountries(c -> (c.getAge() == minAge));
    }
    @RequestMapping("/max")
    public ArrayList<Country> getMaxAge() {
        JavaCountriesApplication.countries.countryList.sort(Comparator.comparingInt(Country::getAge)
                .reversed());
        int maxAge = JavaCountriesApplication.countries.countryList.get(0).getAge();
        return JavaCountriesApplication.countries.findCountries(c -> (c.getAge() == maxAge));
    }
}
