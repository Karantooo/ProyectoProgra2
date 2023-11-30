package org.example.Logica;

/**
 * Clase ideada para manejar un asiento de manera individual.
 * Lo realizamos con un patron builder en mente cosa de que
 * distintas clases puedan crear asientos a su gusto.
 * @author Carlos Tomas Alvarez Norambuena
 */

public class Asiento {
    private EstadoAsiento estadoAsiento;
    private Pasajero pasajero;
    private String codigoAsiento;
    private Boolean reclinable;
    private Boolean sistemaEntretenimiento;
    private String descripcionAsiento;
    private int precioAsiento;

    /**
     * Constructor de la clase privado por defecto.
     * La idea es instanciar la clase por medio de la clase interna builder.
     * @param estadoAsiento
     * @param pasajero
     * @param codigoAsiento
     * @param reclinable
     * @param sistemaEntretenimiento
     * @param descripcionAsiento
     */
    private Asiento(EstadoAsiento estadoAsiento, Pasajero pasajero, String codigoAsiento, Boolean reclinable,
     Boolean sistemaEntretenimiento, String descripcionAsiento, int precioAsiento){
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

    /**
     * Metodo setter para utilizar cuando se hace una compra de asiento.
     * @param estadoAsiento
     */
    public void setEstadoAsiento(EstadoAsiento estadoAsiento) {
        this.estadoAsiento = estadoAsiento;
    }

    /**
     * Metodo setter para utilizar cuando se hace una compra de asiento.
     * @param pasajero
     */
    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    /**
     * La idea es que cada asiento tenga una breve descripcion de lo que se crea.
     * En este contexto se utilizo para marcar que asientos tienen forman de una clase en particular.
     * @return
     */
    public String getDescripcionAsiento() {
        return descripcionAsiento;
    }

    /**
     * Clase interna dentro de la clase Asiento.
     * Se utiliza para instanciar la clase. Segun el patron builder.
     */
    public static class Builder{
        private EstadoAsiento estadoAsiento;
        private Pasajero pasajero;
        private String codigoAsiento;
        private Boolean reclinable;
        private Boolean sistemaEntretenimiento;
        private String descripcionAsiento;
        private int asientoPrecio;

        /**
         * Patron que instancia las condiciones obligatorias para todo asiento.
         * Se exige al menos detallar si el asiento esta ocupado o no y su codigo.
         * @param estadoAsiento
         * @param codigoAsiento
         */
        public Builder(EstadoAsiento estadoAsiento, String codigoAsiento, int precioAsiento){
            this.estadoAsiento = estadoAsiento;
            this.pasajero = null;
            this.codigoAsiento = codigoAsiento;
            this.descripcionAsiento = "";
            this.reclinable = false;
            this.sistemaEntretenimiento = false;
            this.asientoPrecio = precioAsiento;
        }

        /**
         * Se setea si quiere que el asiento se recline.
         * @param reclinable
         */
        public void setReclinable(Boolean reclinable) {
            this.reclinable = reclinable;
        }

        /**
         * Se decide si quiere que el asiento tenga un sistema de entretenimiento.
         * @param sistemaEntretenimiento
         */
        public void setSistemaEntretenimiento(Boolean sistemaEntretenimiento) {
            this.sistemaEntretenimiento = sistemaEntretenimiento;
        }

        /**
         * Se establece una descripcion del asiento.
         * @param descripcion
         */
        public void setDescripcionAsiento(String descripcion){
            descripcionAsiento = descripcion;
        }

        /**
         * Se asocia un pasajero que va a utilizar el asiento
         * @param pasajero
         */
        public void setPasajero(Pasajero pasajero) {
            this.pasajero = pasajero;
        }

        /**
         * Metodo utilizado para instanciar objetos de la clase Asiento.
         * @return Devuelve un asiento segun lo creado.
         */
        public Asiento buildAsiento(){
            Asiento asiento = new Asiento(estadoAsiento, pasajero, codigoAsiento, reclinable,
                    sistemaEntretenimiento, descripcionAsiento, asientoPrecio);
            return asiento;
        }
    }


}
