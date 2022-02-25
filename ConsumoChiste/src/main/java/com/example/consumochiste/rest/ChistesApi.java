package com.example.consumochiste.rest;

import com.example.consumochiste.model.Chiste;
import com.example.consumochiste.servicio.HiloLogica;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
@RequestMapping("/chistes")
public class ChistesApi {

    @GetMapping("/obtener")
    public HashSet<Chiste> getChiste() {
        HiloLogica hlogica = new HiloLogica();
        return hlogica.crearHilos();
    }
}
