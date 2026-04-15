package com.Cid.Fabian.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient.ResponseSpec;

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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




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

    @GetMapping("listar/{id}")
    public ResponseEntity<?> getIncidenciasById(@RequestBody @Valid Incidencia incidencia, @PathVariable int id) {
        Incidencia incidenciaById = incidenciaService.readById(incidencia,id);
        if (incidenciaById != null){
            return ResponseEntity.ok(incidenciaById);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No fue posible encontrar la id");
    }

    @PutMapping("listar/{id}")
    public ResponseEntity<?> putIncidencia(@PathVariable int id, @Valid @RequestBody Incidencia incidencia) {
        Incidencia incidenciaActualizada = incidenciaService.update(id, incidencia);
        if (incidenciaActualizada != null){
            return ResponseEntity.ok(incidenciaActualizada);
        }
        return null;
    }

    
    @DeleteMapping
    public ResponseEntity<?> deleteIncidencia(@PathVariable int id, @Valid @RequestBody Incidencia incidencia){
        String incidenciaBorrar = incidenciaService.delete(id, incidencia);
        if (incidenciaBorrar != null){
            return ResponseEntity<?>
        }
        return null;
    }
}
