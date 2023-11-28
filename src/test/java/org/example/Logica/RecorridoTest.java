package org.example.Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class RecorridoTest {

    Recorrido recorrido1;
    @BeforeEach
    void setUp() {
        recorrido1 = new Recorrido("Concepcion", "Santiago", LocalDateTime.of(2021, 2, 2, 2,2 ));
    }

    @Test
    void testDuracionViaje(){

        assertEquals(recorrido1.getDuracion(), 122);

    }


}