package org.example.Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para verificar La creacion de los buses con el patron builder
 */
class BusTest {

    @BeforeEach
    void setUp() {

    }

    /**
     * Se instancia un bus para verificar que el builder funciona correctamente
     */
    @Test
    void verificarPatronBuild(){
        LocalDateTime fechaYHora = LocalDateTime.of(2023, 1, 1, 1, 1);
        int duracion = 360;
        Recorrido recorrido = new Recorrido("Puerto Montt", "Concepcion", fechaYHora, duracion);
         Bus.BusBuilder creadorBus = new Bus.BusBuilder(recorrido);
         creadorBus.buildPisos(3);
         creadorBus.buildAsientosPorPiso(12);
         Bus bus = creadorBus.buildBus();

         assertEquals(bus.getPisos(), 3);
         assertEquals(bus.getAsientosPorPiso(), 12);
    }

}