package org.example.Logica;

public class DirectorAsiento {
    Asiento.Builder builder;
    public DirectorAsiento(Asiento.Builder builder){
        this.builder = builder;
    }

    public Asiento buildPremium(){
        builder.setSistemaEntretenimiento(true);
        builder.setReclinable(true);
        return builder.buildAsiento();
    }

    public Asiento buildEconomico(){
        builder.setSistemaEntretenimiento(false);
        builder.setReclinable(false);
        return builder.buildAsiento();
    }

    public Asiento buildEjecutivo(){
        builder.setSistemaEntretenimiento(true);
        builder.setReclinable(false);
        return builder.buildAsiento();
    }


}
