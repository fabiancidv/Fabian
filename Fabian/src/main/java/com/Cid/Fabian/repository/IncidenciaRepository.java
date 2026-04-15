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

    public List<Incidencia> listar() {
        return incidencias;
    }

    public Incidencia buscarPorId(int id) {
        for (Incidencia incidencia : incidencias){
            if (incidencia.getId() == id)
                return incidencia;
        }
        return null;
    }

    public Incidencia listarPorId(Incidencia incidencia, int id) {
        Incidencia buscar = buscarPorId(id);
        return buscar;
    }

    public Incidencia actualizar(int id, Incidencia incidencia) {
        Incidencia buscar = buscarPorId(id);
        if (buscar !=null){
            buscar.setAñoRegistro(incidencia.getAñoRegistro());
            buscar.setDescripcionProblema(incidencia.getDescripcionProblema());
            buscar.setEstadoIncidencia(incidencia.getEstadoIncidencia());
            buscar.setNivelPrioridad(incidencia.getNivelPrioridad());
            buscar.setUsuarioQueReporta(incidencia.getUsuarioQueReporta());
        }
        return null;
    }

    public String borrarPorId(int id, Incidencia incidencia) {
        Incidencia buscar = buscarPorId(id);
        if (buscar != null){
            incidencias.remove(buscar);
            return "Incidencia borrada con exito";
        }
        return null;
    }

    
}
