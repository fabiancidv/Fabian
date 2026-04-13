package com.Cid.Fabian.model;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Incidencia {

    private static final AtomicInteger contador = new AtomicInteger(1);
    private int id;

    @NotBlank(message = "Debe ingresar una descripcion del problema")
    @Size(min = 2, max = 1000)
    private String descripcionProblema;

    private EstadoIncidencia estadoIncidencia;

    @Min(value = 1, message = "No es posible ingresar valores menores a 1")
    @Max(value = 5, message = "No es posible ingresar valores mayores a 5")
    private int nivelPrioridad;

    @NotBlank(message = "Debe ingresar su nombre de usuario")
    @Size(min = 2, max = 50)
    private String usuarioQueReporta;

    private String fechaRegistro;

    public Incidencia(String descripcionProblema, EstadoIncidencia estadoIncidencia, int nivelPrioridad, String usuarioQueReporta, String fechaRegistro){
        this.id=contador.getAndIncrement();
        this.descripcionProblema = descripcionProblema.setDescripcionProblema();
        this.estadoIncidencia = setEstadoIncidencia(estadoIncidencia);
        this.nivelPrioridad = setNivelPrioridad(nivelPrioridad);
        this.usuarioQueReporta = setUsuarioQueReporta(usuarioQueReporta);
        this.fechaRegistro = setFechaRegistro(fechaRegistro);
    }
}
