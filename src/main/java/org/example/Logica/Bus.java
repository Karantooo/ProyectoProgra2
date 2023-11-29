package org.example.Logica;

import java.util.ArrayList;

public class Bus {
    private int pisos;
    private int asientosPorPiso;
    private Recorrido recorrido;

    private Bus(int pisos, int asientosPorPiso, Recorrido recorrido) {
        this.pisos = pisos;
        this.asientosPorPiso = asientosPorPiso;
        this.recorrido = recorrido;

    }

    public int getPisos() {
        return pisos;
    }

    public int getAsientosPorPiso() {
        return asientosPorPiso;
    }

    public Recorrido getRecorrido() {
        return recorrido;
    }

    @Override
    public String toString() {
        String descripcionBus = new String();
        descripcionBus += "Pisos: " + pisos;
        descripcionBus += "\nAsientos por piso: " + asientosPorPiso;
        descripcionBus += "\nRecorrido: " + recorrido.toString();

        return descripcionBus;
    }
    public static class BusBuilder {
        private int pisos;
        private int asientosPorPiso;
        private Recorrido recorrido;
        public BusBuilder(Recorrido recorrido){
            this.pisos = 1;
            this.asientosPorPiso = 40;
            this.recorrido = recorrido;
        }

        public void buildPisos(int pisos) {
            this.pisos = pisos;
        }

        public void buildAsientosPorPiso(int asientosPorPiso) {
            this.asientosPorPiso = asientosPorPiso;
        }

        public Bus buildBus(){
            return new Bus(pisos,asientosPorPiso,recorrido);
        }
    }
}
