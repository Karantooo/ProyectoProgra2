package org.example.Logica;

import java.util.ArrayList;

public class CorridaAsientos {
    private Asiento[][] asientos;
    private int asientosPremium;
    private int asientosEconomicos;
    private int asientosEjecutivo;
    private int filas;
    private int columnas;


    public CorridaAsientos(int cantidadAsientos) {
        asientosEjecutivo = (int)(cantidadAsientos *  0.1);
        asientosPremium = (int)(cantidadAsientos *  0.2);
        asientosEconomicos = cantidadAsientos - (asientosPremium +  asientosEjecutivo);

        filas = cantidadAsientos/4;
        columnas = 4;
        asientos = new Asiento[filas][columnas];

        int cantidadAsientosCreados = 0;

        for (int i = 0; i < filas; i++){
            for (int j = 0 ; j < columnas; j++){
                DirectorAsiento director = new DirectorAsiento();
                String codigoAsiento = new String(i + "-" + j);
                if (cantidadAsientosCreados < asientosEjecutivo)
                    asientos[i][j] = director.buildEjecutivo(codigoAsiento);
                else if (cantidadAsientosCreados < asientosPremium + asientosEjecutivo)
                    asientos[i][j] = director.buildPremium(codigoAsiento);
                else
                    asientos[i][j] = director.buildEconomico(codigoAsiento);
                cantidadAsientosCreados++;
            }
        }
    }

    public Asiento getAsiento(int x, int y){
        return asientos[x][y];
    }

    public int getAsientosPremium() {
        return asientosPremium;
    }

    public int getAsientosEconomicos() {
        return asientosEconomicos;
    }

    public int getAsientosEjecutivo() {
        return asientosEjecutivo;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}
