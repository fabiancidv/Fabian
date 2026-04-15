package com.Cid.Fabian.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Cid.Fabian.model.Incidencia;
import com.Cid.Fabian.service.IncidenciaService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RequestMapping("api/v1/incidencias")
@RestController
public class IncidenciaController {
    @Autowired
    IncidenciaService incidenciaService;

    @PostMapping
    public ResponseEntity<?> postIncidencia(@Valid @RequestBody Incidencia incidencia) {
        Incidencia incidenciaNueva = incidenciaService.create(incidencia);
        if (incidencia != null){
            ResponseEntity.ok(incidenciaNueva);
        }
        return ResponseEntity.badRequest().body("Los datos ingresados no son correctos");
    }
    
    @GetMapping("listar")
    public ResponseEntity<?> getIncidencias(@RequestBody @Valid Incidencia incidencias) {
        List<Incidencia> listaIncidencias = incidenciaService.readAll();
        if (listaIncidencias.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No ha sido posible encontrar incidencias");
        }
        return ResponseEntity.ok(listaIncidencias);
    }

    @GetMapping("")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    
}
