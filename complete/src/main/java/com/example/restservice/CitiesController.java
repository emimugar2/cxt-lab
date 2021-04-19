package com.example.restservice;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitiesController {

    @Autowired
    public List<String>  cityRepository = Arrays.asList("Coruña", "Vigo", "Ourense", "Pontevedra");
    @GetMapping("/cities")
    public String[] getCities(@RequestParam(value = "value", required = false) String value) {
        List<String> cities = null;
        cities = (List<String>) cityRepository;
        return cities.toArray(new String[0]);
    }
    @GetMapping("/city/{id}")
    public String getCityById(@PathVariable Long id) {
        String city = cityRepository.get(id.intValue());
        return city;
    }
}