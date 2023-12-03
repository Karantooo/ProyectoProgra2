package org.example.Logica;

/**
 * Clase para crear los pasajeros del bus.
 * Se entrega su informacion bancaria con la que va a pagar.
 */
public class Pasajero {
    private String nombre;
    private String apellido;
    private String banco;
    private String numCuenta;

    /**
     * Se ingresa nombre y datos bancarios
     * @param nombre
     * @param apellido
     * @param banco
     * @param numCuenta
     */
    public Pasajero(String nombre, String apellido, String banco, String numCuenta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.banco = banco;
        this.numCuenta = numCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getBanco() {
        return banco;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * Mensaje que se devuelve cuando se procesa el pago
     * @return string con mensaje de pago.
     */
    public String pagoRealizado(){
        return "La persona a realizado el pago exitosamente";
    }
}
