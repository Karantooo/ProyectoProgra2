package org.example.Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase creada para verificar la creacion de asientos con el patron builder.
 * @author Carlos Tomas Alvarez Norambuena
 */
class AsientoTest {
    Asiento asiento1;
    Asiento asiento2;

    /**
     * Se instancian los 2 asientos para los test.
     */
    @BeforeEach
    void setUp() {
        Asiento.Builder builder = new Asiento.Builder(EstadoAsiento.OCUPADO, "1-3", 200);
        builder.setSistemaEntretenimiento(true);
        asiento1 = builder.buildAsiento();
        Asiento.Builder builder2 = new Asiento.Builder(EstadoAsiento.DISPONIBLE, "4-1", 1);
        builder2.setDescripcionAsiento("Descripcion generica");
        builder2.setReclinable(true);
        builder2.setPasajero(new Pasajero("Juan", "Perez", "Scotiabank", "41273"));
        asiento2 = builder2.buildAsiento();
    }

    /**
     * Se verifica la correcta instanciacion de asiento 1.
     */
    @Test
    void verificacionSeteoCorrectoVariablesAsiento1(){
        assertEquals("1-3", asiento1.getCodigoAsiento());
        assertEquals(EstadoAsiento.OCUPADO, asiento1.getEstadoAsiento());
        assertNull(asiento1.getPasajero());
        assertEquals(true, asiento1.getSistemaEntretenimiento());
        assertEquals(false, asiento1.getReclinable());
    }

    /**
     * Se verifica la correcta instanciacion de asiento 2.
     */
    @Test
    void verificacionSeteoCorrectoVariablesAsiento2(){
        assertEquals("4-1", asiento2.getCodigoAsiento());
        assertEquals(EstadoAsiento.DISPONIBLE, asiento2.getEstadoAsiento());
        assertEquals("Juan", asiento2.getPasajero().getNombre());
        assertEquals(false, asiento2.getSistemaEntretenimiento());
        assertEquals(true, asiento2.getReclinable());
    }


}