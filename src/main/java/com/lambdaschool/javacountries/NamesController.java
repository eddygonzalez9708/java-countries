// * The following URLs should return the requested data given the parameters
//        * /names/all
//        * return the names of all the countries alphabetically
//        * /names/begin?letter=
//        * return the countries alphabetically that begin with the given letter
//        * /names/size?length=
//        * return the countries alphabetically that have a name equal to or longer than the given length

package com.lambdaschool.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names/")
public class NamesController {
    @RequestMapping("/all")
    public ArrayList<Country> getAllNames() {
        JavaCountriesApplication.countries.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return JavaCountriesApplication.countries.countryList;
    }
    @RequestMapping("/begin")
    public ArrayList<Country> getNameByFirstLetter(@RequestParam(value = "letter") String letter) {
        ArrayList<Country> temp = JavaCountriesApplication.countries.findCountries(e ->
                (e.getName().toLowerCase().charAt(0) == letter.toLowerCase().charAt(0)));
        temp.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return temp;
    }
    @RequestMapping("/size")
    public ArrayList<Country> getNameByLength(@RequestParam(value = "length") int length) {
        ArrayList<Country> temp = JavaCountriesApplication.countries.findCountries(c ->
                (c.getName().length() >= length));
        temp.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return temp;
    }
}
