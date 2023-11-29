package org.example.Logica;

import java.util.ArrayList;

public class CorridaAsientos {
    private Asiento[][] asientos;
    private int asientosPremium;
    private int asientosEconomicos;
    private int asientosEjecutivo;

    public CorridaAsientos(int cantidadAsientos) {
        asientosEjecutivo = (int)(cantidadAsientos *  0.1);
        asientosPremium = (int)(cantidadAsientos *  0.2);
        asientosEconomicos = cantidadAsientos - (asientosPremium +  asientosEjecutivo);

        int filas = cantidadAsientos/4;
        int columnas = 4;
        asientos = new Asiento[filas][columnas];

        int cantidadAsientosCreados = 0;

        for (int i = 0; i < filas; i++){
            for (int j = 0 ; j < columnas; j++){
                DirectorAsiento director = new DirectorAsiento();
                String codigoAsiento = new String(i + "-" + j);
                if (cantidadAsientosCreados < asientosEjecutivo)
                    asientos[i][j] = director.buildEjecutivo(EstadoAsiento.DISPONIBLE, null, codigoAsiento);
                else if (cantidadAsientosCreados < asientosPremium + asientosEjecutivo)
                    asientos[i][j] = director.buildPremium(EstadoAsiento.DISPONIBLE, null, codigoAsiento);
                else
                    asientos[i][j] = director.buildEconomico(EstadoAsiento.DISPONIBLE, null, codigoAsiento);
                cantidadAsientosCreados++;
            }
        }
    }
}
