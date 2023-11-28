package org.example.Logica;

public class DirectorAsiento {

    public Asiento buildPremium(EstadoAsiento estadoAsiento, Pasajero pasajero, String codigoAsiento){
        Asiento.Builder builder = new Asiento.Builder(estadoAsiento, pasajero, codigoAsiento);
        builder.setSistemaEntretenimiento(false);
        builder.setReclinable(true);
        return builder.buildAsiento();
    }

    public Asiento buildEconomico(EstadoAsiento estadoAsiento, Pasajero pasajero, String codigoAsiento){
        Asiento.Builder builder = new Asiento.Builder(estadoAsiento, pasajero, codigoAsiento);
        builder.setSistemaEntretenimiento(false);
        builder.setReclinable(false);
        return builder.buildAsiento();
    }

    public Asiento buildEjecutivo(EstadoAsiento estadoAsiento, Pasajero pasajero, String codigoAsiento){
        Asiento.Builder builder = new Asiento.Builder(estadoAsiento, pasajero, codigoAsiento);
        builder.setSistemaEntretenimiento(true);
        builder.setReclinable(true);
        return builder.buildAsiento();
    }


}
