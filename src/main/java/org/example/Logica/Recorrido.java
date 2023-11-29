package org.example.Logica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Recorrido {
    private String origen;
    private String destino;
    private LocalTime duracion;
    private LocalDateTime fechaYHora;

    public Recorrido(String origen, String destino, LocalDateTime fechaYHora, LocalTime duracion) {
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
        return duracion.getMinute();
    }
    public int getDuracionHoras() {
        return duracion.getHour();
    }

    public int getDuracionTotalEnMin(){
        return duracion.getHour() * 60 + duracion.getMinute();
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
