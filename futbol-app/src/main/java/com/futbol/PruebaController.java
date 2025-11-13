package com.futbol;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaController {

    @GetMapping("/hola")
    public String hola() {
        return "¡Aplicación de fútbol funcionando! Tablas creadas en H2.";
    }
}
