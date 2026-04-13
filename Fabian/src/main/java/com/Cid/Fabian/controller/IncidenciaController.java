package com.Cid.Fabian.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Cid.Fabian.model.Incidencia;
import com.Cid.Fabian.service.IncidenciaService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("api/v1/incidencias")
@RestController
public class IncidenciaController {
    @Autowired
    IncidenciaService incidenciaService;

    @PostMapping
    public ResponseEntity<?> postIncidencia(@Valid @RequestBody Incidencia incidencia) {
        incidencia = incidenciaService.create(incidencia);
        if (incidencia != null){
            ResponseEntity.ok(incidencia);
        }
        return ResponseEntity.badRequest().body("Los datos ingresados no son correctos");
    }
    
    
}
