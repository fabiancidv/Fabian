package com.Cid.Fabian.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Cid.Fabian.model.Incidencia;
import com.Cid.Fabian.repository.IncidenciaRepository;

import jakarta.validation.Valid;

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

    public Incidencia readById(Incidencia incidencia, int id) {
        return incidenciaRepository.listarPorId(incidencia, id);
    }

    public Incidencia update(int id, Incidencia incidencia) {
        return incidenciaRepository.actualizar(id, incidencia);
    }

    public String delete(int id, Incidencia incidencia) {
        return incidenciaRepository.borrarPorId(id, incidencia);
    }

    public List<Incidencia> readByYear(int year) {
        return incidenciaRepository.buscarPorAño(year);
    }
    
}
