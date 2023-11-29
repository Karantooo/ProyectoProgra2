package org.example.Logica;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Recorrido {
    private String origen;
    private String destino;
    private int duracion;
    private LocalDateTime fechaYHora;

    public Recorrido(String origen, String destino, LocalDateTime fechaYHora) {
        this.origen = origen;
        this.destino = destino;

        this.duracion = fechaYHora.getHour() * 60 + fechaYHora.getMinute();

        this.fechaYHora = fechaYHora;
    }

    public String getOrigen() {
        return origen;
    }


    public String getDestino() {
        return destino;
    }


    public int getHora() {
        return fechaYHora.getHour() ;
    }


    public int getMinutos() {
        return fechaYHora.getMinute();
    }


    public int getDuracion() {
        return duracion;
    }
    public int getYear(){
        return fechaYHora.getYear();
    }
    public int getMonth(){
        return fechaYHora.getMonthValue();
    }
    public int getDay(){
        return fechaYHora.getDayOfMonth();
    }

    @Override
    public String toString() {
        String descripcionRecorrido = new String();
        descripcionRecorrido += "\nOrigen: " + origen;
        descripcionRecorrido += "\nDestino: " + destino;
        descripcionRecorrido += "\nHora: " + fechaYHora.getHour();
        descripcionRecorrido += "\nMinutos: " + fechaYHora.getMinute();
        descripcionRecorrido += "\nDuracion: " + duracion;

        return descripcionRecorrido;
    }
}
