package org.example.Logica;

public class DirectorAsiento {

    public DirectorAsiento(){

    }

    public Asiento buildPremium(String codigoAsiento){
        Asiento.Builder builder = new Asiento.Builder(EstadoAsiento.DISPONIBLE, codigoAsiento, 1500);
        builder.setSistemaEntretenimiento(false);
        builder.setReclinable(true);
        builder.setDescripcionAsiento("Asiento Premium");
        return builder.buildAsiento();
    }

    public Asiento buildEconomico(String codigoAsiento){
        Asiento.Builder builder = new Asiento.Builder(EstadoAsiento.DISPONIBLE, codigoAsiento, 1000);
        builder.setSistemaEntretenimiento(false);
        builder.setReclinable(false);
        builder.setDescripcionAsiento("Asiento Economico");
        return builder.buildAsiento();
    }

    public Asiento buildEjecutivo(String codigoAsiento){
        Asiento.Builder builder = new Asiento.Builder(EstadoAsiento.DISPONIBLE, codigoAsiento, 2000);
        builder.setSistemaEntretenimiento(true);
        builder.setReclinable(true);
        builder.setDescripcionAsiento("Asiento Ejecutivo");
        return builder.buildAsiento();
    }


}
