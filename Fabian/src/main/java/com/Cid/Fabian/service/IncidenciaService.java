package com.Cid.Fabian.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Cid.Fabian.model.Incidencia;
import com.Cid.Fabian.repository.IncidenciaRepository;

@Service
public class IncidenciaService {
    @Autowired
    IncidenciaRepository incidenciaRepository;

    public Incidencia create(Incidencia incidencia) {
        return incidenciaRepository.crear(incidencia);
    }

    public List<Incidencia> readAll() {
        return incidenciaRepository.listar();
    }
    
}
