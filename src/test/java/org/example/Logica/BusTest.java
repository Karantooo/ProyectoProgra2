package org.example.Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class BusTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void verificarPatronBuild(){
        LocalDateTime fechaYHora = LocalDateTime.of(2023, 1, 1, 1, 1);
        LocalTime duracion = LocalTime.of(13, 4);
        Recorrido recorrido = new Recorrido("Puerto Montt", "Concepcion", fechaYHora, duracion);
         Bus.BusBuilder creadorBus = new Bus.BusBuilder(recorrido);
         creadorBus.buildPisos(3);
         creadorBus.buildAsientosPorPiso(12);
         Bus bus = creadorBus.buildBus();

         assertEquals(bus.getPisos(), 3);
         assertEquals(bus.getAsientosPorPiso(), 12);
    }

}