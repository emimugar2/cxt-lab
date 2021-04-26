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
public class CriptosController {

    ArrayList<Criptos> criptoRepository = new ArrayList<Criptos>();
    public CriptosController(){
        criptoRepository.add(new Criptos(1, "ADA", 1.20));
        criptoRepository.add(new Criptos(2, "DOGE", 100));
        criptoRepository.add(new Criptos(3, "DOT", 27.30));
        criptoRepository.add(new Criptos(4, "BTC", 50000));
        criptoRepository.add(new Criptos(5, "ETH", 12000));
        criptoRepository.add(new Criptos(6, "WIN", 0.0001));
    }
    @GetMapping("/criptos")
    public ArrayList<Criptos> getCriptos() {
        return criptoRepository;
    }
    @GetMapping("/cripto/{id}")
    public Criptos getCriptoById(@PathVariable ("id") int id) {
        for (int i=0;i<criptoRepository.size(); i++) {
            Criptos cripto = criptoRepository.get(i);
            if (cripto.getId()==id) {
                return cripto;
            }
        }
        return new Criptos(404, "No existe", 666);
    }
}