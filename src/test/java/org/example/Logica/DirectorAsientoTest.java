package org.example.Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectorAsientoTest {

    @BeforeEach
    void setUp() {
        DirectorAsiento director_premium = new DirectorAsiento();
        director_premium.buildPremium("1-2");
        DirectorAsiento director_ejecutivo = new DirectorAsiento();
        DirectorAsiento director_economico = new DirectorAsiento();
    }

    @Test
    void creacionAsientoPremium(){
        assertEquals("4-1", asiento2.getCodigoAsiento());
        assertEquals(EstadoAsiento.DISPONIBLE, asiento2.getEstadoAsiento());
        assertEquals("Juan", asiento2.getPasajero().getNombre());
        assertEquals(false, asiento2.getSistemaEntretenimiento());
        assertEquals(true, asiento2.getReclinable());
    }
}