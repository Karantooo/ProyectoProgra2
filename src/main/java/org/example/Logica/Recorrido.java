package org.example.Logica;

public class Recorrido {
    private String origen;
    private String destino;
    private int hora;
    private int minutos;
    private int duracion;
    public Recorrido(String origen, String destino, int hora, int minutos) {
        this.origen = origen;
        this.destino = destino;
        this.hora = hora;
        this.minutos = minutos;
        this.duracion = this.hora * 60 + this.minutos;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    @Override
    public String toString() {
        String descripcionRecorrido = new String();
        descripcionRecorrido += "\nOrigen: " + origen;
        descripcionRecorrido += "\nDestino: " + destino;
        descripcionRecorrido += "\nHora: " + hora;
        descripcionRecorrido += "\nMinutos: " + minutos;
        descripcionRecorrido += "\nDuracion: " + duracion;

        return descripcionRecorrido;
    }
}
