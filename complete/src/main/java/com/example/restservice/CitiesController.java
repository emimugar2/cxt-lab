package com.example.restservice;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitiesController {

    ArrayList<Cities> cityRepository = new ArrayList<Cities>();
    public CitiesController(){
        cityRepository.add(new Cities(1, "Coruña", "Coruña"));
        cityRepository.add(new Cities(2, "Pontevedra", "Pontevedra"));
		cityRepository.add(new Cities(3, "Santiago", "Coruña"));
		cityRepository.add(new Cities(4, "Lugo", "Lugo"));
		cityRepository.add(new Cities(5, "Ourense", "Ourense"));
		cityRepository.add(new Cities(6, "Vigo", "Pontevedra"));
    }
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