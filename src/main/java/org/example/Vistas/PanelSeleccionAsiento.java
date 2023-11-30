package org.example.Vistas;

import org.example.Logica.Bus;

import javax.swing.*;
import java.awt.*;

public class PanelSeleccionAsiento extends JPanel {
    private Bus bus;
    public PanelSeleccionAsiento(Bus bus){
        this.bus = bus;
        this.setLayout(new GridLayout(1,bus.getPisos()));
        for(int i = 0; i < bus.getPisos(); i++){
            this.add(new PanelCorridaAsientos(bus.getCorridaAsientosPorPiso().get(i)));
        }
    }
}
