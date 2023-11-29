package org.example.Logica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Recorrido {
    private String origen;
    private String destino;
    private int duracion;
    private LocalDateTime fechaYHora;

    public Recorrido(String origen, String destino, LocalDateTime fechaYHora, int duracion) {
        this.origen = origen;
        this.destino = destino;

        this.duracion = duracion;

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


    public int getDuracionMinutos() {
        return duracion % 60;
    }
    public int getDuracionHoras() {
        return duracion / 60;
    }

    public int getDuracionTotalEnMin(){
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
