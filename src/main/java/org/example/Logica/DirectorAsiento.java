package org.example.Logica;

/**
 * Clase ideada para hacer ciertos builds por defecto que se van a utilizar para que generar las diferentes
 * categorias de los asientos.
 * @author Carlos Tomas Alvarez Norambuena
 */

public class DirectorAsiento {

    public DirectorAsiento(){

    }

    /**
     * Build por defecto para crear asientos premium
     * @param codigoAsiento codigo asociado al asiento
     * @return asiento premium
     */
    public Asiento buildPremium(String codigoAsiento){
        Asiento.Builder builder = new Asiento.Builder(EstadoAsiento.DISPONIBLE, codigoAsiento, 1500);
        builder.setSistemaEntretenimiento(false);
        builder.setReclinable(true);
        builder.setDescripcionAsiento("Asiento Premium");
        return builder.buildAsiento();
    }
    /**
     * Build por defecto para crear asientos economico
     * @param codigoAsiento codigo asociado al asiento
     * @return asiento economico
     */
    public Asiento buildEconomico(String codigoAsiento){
        Asiento.Builder builder = new Asiento.Builder(EstadoAsiento.DISPONIBLE, codigoAsiento, 1000);
        builder.setSistemaEntretenimiento(false);
        builder.setReclinable(false);
        builder.setDescripcionAsiento("Asiento Economico");
        return builder.buildAsiento();
    }
    /**
     * Build por defecto para crear asientos ejecutivo
     * @param codigoAsiento codigo asociado al asiento
     * @return asiento ejecutivo
     */
    public Asiento buildEjecutivo(String codigoAsiento){
        Asiento.Builder builder = new Asiento.Builder(EstadoAsiento.DISPONIBLE, codigoAsiento, 2000);
        builder.setSistemaEntretenimiento(true);
        builder.setReclinable(true);
        builder.setDescripcionAsiento("Asiento Ejecutivo");
        return builder.buildAsiento();
    }


}
