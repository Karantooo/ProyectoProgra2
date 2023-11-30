package org.example.Logica;

/**
 * Clase director para instanciar ciertos buses por defecto.
 * La idea es para ghenerar buses predeterminados para los casos iniciales por defecto.
 * @author Benjamin Espinoza
 */
public class DirectorBus {

    /**
     * Bus por defecto de tamaño pequeño.
     * @param recorrido
     * @return
     */
    public Bus buildChico(Recorrido recorrido){
        Bus.BusBuilder busBuilder = new Bus.BusBuilder(recorrido);
        busBuilder.buildPisos(1);
        busBuilder.buildAsientosPorPiso(40);
        return busBuilder.buildBus();
    }
    /**
     * Bus por defecto de tamaño mediano.
     * @param recorrido
     * @return
     */
    public Bus buildMediano(Recorrido recorrido){
        Bus.BusBuilder busBuilder = new Bus.BusBuilder(recorrido);
        busBuilder.buildPisos(1);
        busBuilder.buildAsientosPorPiso(60);
        return busBuilder.buildBus();
    }
    /**
     * Bus por defecto de tamaño grande.
     * @param recorrido
     * @return
     */
    public Bus buildGrande(Recorrido recorrido){
        Bus.BusBuilder busBuilder = new Bus.BusBuilder(recorrido);
        busBuilder.buildPisos(2);
        busBuilder.buildAsientosPorPiso(60);
        return busBuilder.buildBus();
    }
}
