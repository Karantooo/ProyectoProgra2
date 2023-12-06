package org.example.Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para verificar la correcta creacion del recorrido.
 * @author Carlos Tomas Alvarez Norambuena
 */
class RecorridoTest {

    Recorrido recorrido1;

    /**
     * Se crea recorrido.
     */
    @BeforeEach
    void setUp() {
        recorrido1 = new Recorrido("Concepcion", "Santiago", LocalDateTime.of(2021, 2, 2, 2,2 ), 360);
    }

    @Test
    void testDuracionViaje(){

        assertEquals(recorrido1.getDuracionTotalEnMin(), 360);

    }

    @Test
    void testOrigenYDestino(){
        assertEquals("Concepcion", recorrido1.getOrigen());
        assertEquals("Santiago", recorrido1.getDestino());
    }

}