package org.example.Logica;

public class Asiento {
    private EstadoAsiento estadoAsiento;
    private Pasajero pasajero;
    private String codigoAsiento;
    private Boolean reclinable;
    private Boolean sistemaEntretenimiento;
    private String descripcionAsiento;


    private Asiento(EstadoAsiento estadoAsiento, Pasajero pasajero, String codigoAsiento, Boolean reclinable,
     Boolean sistemaEntretenimiento, String descripcionAsiento){
        this.estadoAsiento = estadoAsiento;
        this.pasajero = pasajero;
        this.codigoAsiento = codigoAsiento;
        this.descripcionAsiento = descripcionAsiento;
        this.reclinable = reclinable;
        this.sistemaEntretenimiento = sistemaEntretenimiento;
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

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public String getDescripcionAsiento() {
        return descripcionAsiento;
    }

    public static class Builder{
        private EstadoAsiento estadoAsiento;
        private Pasajero pasajero;
        private String codigoAsiento;
        private Boolean reclinable;
        private Boolean sistemaEntretenimiento;
        private String descripcionAsiento;

        public Builder(EstadoAsiento estadoAsiento, Pasajero pasajero, String codigoAsiento){
            this.codigoAsiento = codigoAsiento;
            this.pasajero = pasajero;
            this.codigoAsiento = codigoAsiento;
            this.descripcionAsiento = "";
        }

        public void setReclinable(Boolean reclinable) {
            this.reclinable = reclinable;
        }

        public void setSistemaEntretenimiento(Boolean sistemaEntretenimiento) {
            this.sistemaEntretenimiento = sistemaEntretenimiento;
        }

        public void setDescripcionAsiento(String descripcion){
            descripcionAsiento = descripcion;
        }


        public Asiento buildAsiento(){
            Asiento asiento = new Asiento(estadoAsiento, pasajero, codigoAsiento, reclinable,
                    sistemaEntretenimiento, descripcionAsiento);
            return asiento;
        }
    }


}
