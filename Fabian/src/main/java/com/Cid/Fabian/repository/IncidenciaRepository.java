package com.Cid.Fabian.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Cid.Fabian.model.Incidencia;

@Repository
public class IncidenciaRepository {
    List<Incidencia> incidencias = new ArrayList<>();

    public Incidencia crear(Incidencia incidencia) {
        incidencias.add(incidencia);
        return incidencia;
    }

    
}
