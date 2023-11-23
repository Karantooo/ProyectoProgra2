package org.example.Logica;

public class BusBuilder implements Builder{
    private int pisos;
    private int asientosPorPiso;
    private Recorrido recorrido;
    public BusBuilder(){
        this.pisos = 1;
        this.pisos = 20;
        this.recorrido = null;
    }
    @Override
    public void buildPisos(int pisos) {
        this.pisos = pisos;
    }

    @Override
    public void buildAsientosPorPiso(int asientosPorPiso) {
        this.asientosPorPiso = asientosPorPiso;
    }

    @Override
    public void buildRecorrido(Recorrido recorrido) {
        this.recorrido = recorrido;
    }

    public Bus buildBus(){
        return new Bus(pisos,asientosPorPiso,recorrido);
    }
}
