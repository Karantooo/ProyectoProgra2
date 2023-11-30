package org.example.Logica;

public class DirectorAsiento {

    public DirectorAsiento(){

    }

    public Asiento buildPremium(EstadoAsiento estadoAsiento, String codigoAsiento, int precio){
        Asiento.Builder builder = new Asiento.Builder(estadoAsiento, codigoAsiento, precio);
        builder.setSistemaEntretenimiento(false);
        builder.setReclinable(true);
        builder.setDescripcionAsiento("Asiento Premium");
        return builder.buildAsiento();
    }

    public Asiento buildEconomico(EstadoAsiento estadoAsiento, String codigoAsiento, int precio){
        Asiento.Builder builder = new Asiento.Builder(estadoAsiento, codigoAsiento, precio);
        builder.setSistemaEntretenimiento(false);
        builder.setReclinable(false);
        builder.setDescripcionAsiento("Asiento Economico");
        return builder.buildAsiento();
    }

    public Asiento buildEjecutivo(EstadoAsiento estadoAsiento, String codigoAsiento, int precio){
        Asiento.Builder builder = new Asiento.Builder(estadoAsiento, codigoAsiento, precio);
        builder.setSistemaEntretenimiento(true);
        builder.setReclinable(true);
        builder.setDescripcionAsiento("Asiento Ejecutivo");
        return builder.buildAsiento();
    }


}
