package org.example.Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsientoTest {

    @BeforeEach
    void setUp() {
        DirectorAsiento director = new DirectorAsiento();
        director.buildEconomico(EstadoAsiento.OCUPADO, new Pasajero("Juan", "Perez", "Santander", "564656"), "A2");
        director.buildEjecutivo(EstadoAsiento.DISPONIBLE, null, "B4");
        director.buildEconomico(EstadoAsiento.DISPONIBLE, null, "C1");

    }




}