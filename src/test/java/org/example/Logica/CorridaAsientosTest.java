package org.example.Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorridaAsientosTest {
    private CorridaAsientos corridaAsientos;

    @BeforeEach
    void set_Up(){
        corridaAsientos = new CorridaAsientos(30);
    }
    @Test
    void verificarAsientosPremiumTest(){
        assertEquals(6, corridaAsientos.getAsientosPremium());
    }

    @Test
    void verificarAsientosEjecutivoTest(){
        assertEquals(3, corridaAsientos.getAsientosEjecutivo());
    }

    @Test
    void verificarAsientosEconomicoTest(){
        assertEquals(21, corridaAsientos.getAsientosEconomicos());
    }

    @Test
    void verificarClasesPremiumTest(){
        assertEquals("Asiento Premium", corridaAsientos.getAsiento(0, 3).getDescripcionAsiento());
        assertEquals("Asiento Premium", corridaAsientos.getAsiento(1, 0).getDescripcionAsiento());
        assertEquals("Asiento Premium", corridaAsientos.getAsiento(1, 1).getDescripcionAsiento());

    }

    @Test
    void verificarClasesEjecutivoTest(){
        assertEquals("Asiento Ejecutivo", corridaAsientos.getAsiento(0, 0).getDescripcionAsiento());
        assertEquals("Asiento Ejecutivo", corridaAsientos.getAsiento(0, 1).getDescripcionAsiento());
        assertEquals("Asiento Ejecutivo", corridaAsientos.getAsiento(0, 2).getDescripcionAsiento());

    }

    @Test
    void verificarClasesEconomicoTest(){
        assertEquals("Asiento Economico", corridaAsientos.getAsiento(2, 3).getDescripcionAsiento());
        assertEquals("Asiento Economico", corridaAsientos.getAsiento(5, 1).getDescripcionAsiento());
        assertEquals("Asiento Economico", corridaAsientos.getAsiento(2, 2).getDescripcionAsiento());

    }

}