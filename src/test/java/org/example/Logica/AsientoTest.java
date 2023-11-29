package org.example.Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsientoTest {
    Asiento asiento1;
    @BeforeEach
    void setUp() {
        Asiento.Builder builder = new Asiento.Builder(EstadoAsiento.OCUPADO, "1-3");
        builder.setSistemaEntretenimiento(true);
        asiento1 = builder.buildAsiento();

    }

    @Test
    void verificacionSeteoCorrectoVariablesAsiento1(){
        assertEquals("1-3", asiento1.getCodigoAsiento());
        assertEquals(EstadoAsiento.OCUPADO, asiento1.getEstadoAsiento());
        assertNull(asiento1.getPasajero());
        assertEquals(true, asiento1.getSistemaEntretenimiento());
        assertEquals(false, asiento1.getReclinable());
    }




}