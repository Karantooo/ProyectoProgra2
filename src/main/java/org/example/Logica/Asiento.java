package org.example.Logica;

public class Asiento {
    private EstadoAsiento estadoAsiento;
    private Pasajero pasajero;
    private String codigoAsiento;
    private Boolean reclinable;
    private Boolean sistemaEntretenimiento;



    private Asiento(EstadoAsiento estadoAsiento, Pasajero pasajero, String codigoAsiento, Boolean reclinable,
     Boolean sistemaEntretenimiento){
        this.estadoAsiento = estadoAsiento;
        this.pasajero = pasajero;
        this.codigoAsiento = codigoAsiento;
    }

    public EstadoAsiento getEstadoAsiento() {
        return estadoAsiento;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public String getCodigoAsiento() {
        return codigoAsiento;
    }

    public Boolean getReclinable() {
        return reclinable;
    }

    public Boolean getSistemaEntretenimiento() {
        return sistemaEntretenimiento;
    }

    public void setEstadoAsiento(EstadoAsiento estadoAsiento) {
        this.estadoAsiento = estadoAsiento;
    }

    public static class Builder{
        private EstadoAsiento estadoAsiento;
        private Pasajero pasajero;
        private String codigoAsiento;
        private Boolean reclinable;
        private Boolean sistemaEntretenimiento;

        public Builder(EstadoAsiento estadoAsiento, Pasajero pasajero, String codigoAsiento){
            this.codigoAsiento = codigoAsiento;
            this.pasajero = pasajero;
            this.codigoAsiento = codigoAsiento;
        }

        public void setReclinable(Boolean reclinable) {
            this.reclinable = reclinable;
        }

        public void setSistemaEntretenimiento(Boolean sistemaEntretenimiento) {
            this.sistemaEntretenimiento = sistemaEntretenimiento;
        }

        public Asiento buildAsiento(){
            return new Asiento(estadoAsiento, pasajero, codigoAsiento, reclinable,
                                sistemaEntretenimiento);
        }
    }


    /*
    EstadoAsiento mostrarEstadoAsiento();
    Pasajero mostrarPasajero();
    String informacionAsiento();*/
}
