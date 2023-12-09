package org.example.Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para verificar que la clase DirectorBus instancie bien los buses
 * @author Carlos Tomas Alvarez Norambuena
 */
class DirectorBusTest {

    @BeforeEach
    void setUp() {
    }

    /**
     * Se instancia y verifica que el bus chico se creo correctamente.
     */
    @Test
    void VerificarBuildChico() {
        LocalDateTime fechaInicio = LocalDateTime.of(2021, 2, 2, 2, 2);
        DirectorBus builderBusChico = new DirectorBus();
        Bus bus = builderBusChico.buildChico(new Recorrido("Santiago", "Antofagasta", fechaInicio, 120));

        assertEquals(1, bus.getPisos());
        assertEquals(40, bus.getAsientosPorPiso());
    }

    /**
     * Se instancia y verifica que el bus mediano se creo correctamente.
     */
    @Test
    void VerificarBuildMediano() {
        LocalDateTime fechaInicio = LocalDateTime.of(2021, 2, 2, 2, 2);
        DirectorBus builderBusMediano = new DirectorBus();
        Bus bus = builderBusMediano.buildMediano(new Recorrido("Santiago", "Antofagasta", fechaInicio, 120));

        assertEquals(1, bus.getPisos());
        assertEquals(60, bus.getAsientosPorPiso());
    }

    /**
     * Se instancia y verifica que el bus grande se creo correctamente.
     */
    @Test
    void buildGrande() {
        LocalDateTime fechaInicio = LocalDateTime.of(2021, 2, 2, 2, 2);
        DirectorBus builderBusGrande = new DirectorBus();
        Bus bus = builderBusGrande.buildGrande(new Recorrido("Santiago", "Antofagasta", fechaInicio, 120));

        assertEquals(2, bus.getPisos());
        assertEquals(60, bus.getAsientosPorPiso());
    }
}