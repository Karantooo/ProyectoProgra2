package org.example.Logica;

public class DirectorBus {
    public Bus buildChico(Recorrido recorrido){
        Bus.BusBuilder busBuilder = new Bus.BusBuilder(recorrido);
        busBuilder.buildPisos(1);
        busBuilder.buildAsientosPorPiso(40);
        return busBuilder.buildBus();
    }
    public Bus buildMediano(Recorrido recorrido){
        Bus.BusBuilder busBuilder = new Bus.BusBuilder(recorrido);
        busBuilder.buildPisos(1);
        busBuilder.buildAsientosPorPiso(60);
        return busBuilder.buildBus();
    }
    public Bus buildGrande(Recorrido recorrido){
        Bus.BusBuilder busBuilder = new Bus.BusBuilder(recorrido);
        busBuilder.buildPisos(2);
        busBuilder.buildAsientosPorPiso(60);
        return busBuilder.buildBus();
    }
}
