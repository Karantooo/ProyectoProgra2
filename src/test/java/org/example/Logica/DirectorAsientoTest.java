package org.example.Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectorAsientoTest {

    Asiento asientoEconomico;
    Asiento asientoPremium;
    Asiento asientoEjecutivo;
    @BeforeEach
    void setUp() {
        DirectorAsiento directorPremium = new DirectorAsiento();
        asientoPremium = directorPremium.buildPremium("1-2");

        DirectorAsiento directorEjecutivo = new DirectorAsiento();
        asientoEjecutivo = directorEjecutivo.buildEjecutivo("2-2");
        DirectorAsiento directorEconomico = new DirectorAsiento();
        asientoEconomico = directorEconomico.buildEconomico("3-3");
    }

    @Test
    void creacionAsientoPremium(){
        assertEquals("1-2", asientoPremium.getCodigoAsiento());
        assertEquals(EstadoAsiento.DISPONIBLE, asientoPremium.getEstadoAsiento());
        assertNull(asientoPremium.getPasajero());
        assertEquals(false, asientoPremium.getSistemaEntretenimiento());
        assertEquals(true, asientoPremium.getReclinable());
    }

    @Test
    void creacionAsientoEjecutivo(){
        assertEquals("2-2", asientoEjecutivo.getCodigoAsiento());
        assertEquals(EstadoAsiento.DISPONIBLE, asientoEjecutivo.getEstadoAsiento());
        assertNull(asientoEjecutivo.getPasajero());
        assertEquals(true, asientoEjecutivo.getSistemaEntretenimiento());
        assertEquals(true, asientoEjecutivo.getReclinable());
    }
    @Test
    void creacionAsientoEconomico(){
        assertEquals("3-3", asientoEconomico.getCodigoAsiento());
        assertEquals(EstadoAsiento.DISPONIBLE, asientoEconomico.getEstadoAsiento());
        assertNull(asientoEconomico.getPasajero());
        assertEquals(false, asientoEconomico.getSistemaEntretenimiento());
        assertEquals(false, asientoEconomico.getReclinable());
    }

}