package org.example.Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class DirectorBusTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void VerificarBuildChico() {
        LocalDateTime fechaInicio = LocalDateTime.of(2021, 2, 2, 2, 2);
        DirectorBus builderBusChico = new DirectorBus();
        Bus bus = builderBusChico.buildChico(new Recorrido("Santiago", "Antofagasta", fechaInicio, 120));

        assertEquals(1, bus.getPisos());
        assertEquals(40, bus.getAsientosPorPiso());
    }

    @Test
    void VerificarBuildMediano() {
        LocalDateTime fechaInicio = LocalDateTime.of(2021, 2, 2, 2, 2);
        DirectorBus builderBusMediano = new DirectorBus();
        Bus bus = builderBusMediano.buildMediano(new Recorrido("Santiago", "Antofagasta", fechaInicio, 120));

        assertEquals(1, bus.getPisos());
        assertEquals(60, bus.getAsientosPorPiso());
    }

    @Test
    void buildGrande() {
        LocalDateTime fechaInicio = LocalDateTime.of(2021, 2, 2, 2, 2);
        DirectorBus builderBusGrande = new DirectorBus();
        Bus bus = builderBusGrande.buildGrande(new Recorrido("Santiago", "Antofagasta", fechaInicio, 120));

        assertEquals(2, bus.getPisos());
        assertEquals(60, bus.getAsientosPorPiso());
    }
}