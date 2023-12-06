package org.example.Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase Creada para probar las funcionalidades de la clase CorridaAsientos
 */
class CorridaAsientosTest {
    private CorridaAsientos corridaAsientos;

    /**
     * Se inicializa la corrida de asientos con 30 asientos
     */
    @BeforeEach
    void set_Up(){
        corridaAsientos = new CorridaAsientos(30);
    }

    /**
     * Se verifica que se calculo bien la cantidad de asientos premium
     */
    @Test
    void verificarAsientosPremiumTest(){
        assertEquals(6, corridaAsientos.getAsientosPremium());
    }
    /**
     * Se verifica que se calculo bien la cantidad de asientos ejecutivo
     */
    @Test
    void verificarAsientosEjecutivoTest(){
        assertEquals(3, corridaAsientos.getAsientosEjecutivo());
    }
    /**
     * Se verifica que se calculo bien la cantidad de asientos economicos
     */
    @Test
    void verificarAsientosEconomicoTest(){
        assertEquals(21, corridaAsientos.getAsientosEconomicos());
    }

    /**
     * Se toman algunos asientos y se verifica que sean premium.
     */
    @Test
    void verificarClasesPremiumTest(){
        assertEquals("Asiento Premium", corridaAsientos.getAsiento(0, 3).getDescripcionAsiento());
        assertEquals("Asiento Premium", corridaAsientos.getAsiento(1, 0).getDescripcionAsiento());
        assertEquals("Asiento Premium", corridaAsientos.getAsiento(1, 1).getDescripcionAsiento());

    }

    /**
     * Se toman algunos asientos y se verifica que sean ejecutivo.
     */
    @Test
    void verificarClasesEjecutivoTest(){
        assertEquals("Asiento Ejecutivo", corridaAsientos.getAsiento(0, 0).getDescripcionAsiento());
        assertEquals("Asiento Ejecutivo", corridaAsientos.getAsiento(0, 1).getDescripcionAsiento());
        assertEquals("Asiento Ejecutivo", corridaAsientos.getAsiento(0, 2).getDescripcionAsiento());

    }
    /**
     * Se toman algunos asientos y se verifica que sean economicos.
     */
    @Test
    void verificarClasesEconomicoTest(){
        assertEquals("Asiento Economico", corridaAsientos.getAsiento(2, 3).getDescripcionAsiento());
        assertEquals("Asiento Economico", corridaAsientos.getAsiento(5, 1).getDescripcionAsiento());
        assertEquals("Asiento Economico", corridaAsientos.getAsiento(2, 2).getDescripcionAsiento());

    }

}