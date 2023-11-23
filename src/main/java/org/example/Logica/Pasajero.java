package org.example.Logica;

public class Pasajero {
    private String nombre;
    private String apellido;
    private String banco;
    private String numCuenta;

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
}
