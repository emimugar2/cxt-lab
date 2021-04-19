package com.example.restservice;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitiesController {

    @Autowired
    public List<String>  cityRepository = Stream.of("Coruña", "Vigo", "Ourense", "Pontevedra").collect(Collectors.toList());
    @GetMapping("/rest/cities")
    public String[] getCities(@RequestParam(value = "value", required = false) String value) {
        List<String> cities = null;
            cities = (List<String>) cityRepository;
        return cities.toArray(new String[0]);
    }
    @GetMapping("/rest/city/{id}")
    public String getCityById(@PathVariable Long id) {
        String city = cityRepository.get(id.intValue());
        return city;
    }
}