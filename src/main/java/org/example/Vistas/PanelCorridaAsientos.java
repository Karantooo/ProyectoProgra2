package org.example.Vistas;

import org.example.Logica.Asiento;
import org.example.Logica.CorridaAsientos;

import javax.swing.*;
import java.awt.*;

public class PanelCorridaAsientos extends JPanel {
    private CorridaAsientos corridaAsientos;
    private PanelReservarAsiento panelReservarAsiento;
    public PanelCorridaAsientos(CorridaAsientos corridaAsientos, PanelReservarAsiento panelReservarAsiento){
        this.corridaAsientos = corridaAsientos;
        this.panelReservarAsiento = panelReservarAsiento;
        this.setLayout(new GridLayout(corridaAsientos.getFilas(), corridaAsientos.getColumnas()));
        for(int i = 0; i < corridaAsientos.getFilas(); i++){
            for(int j = 0; j < corridaAsientos.getColumnas(); j++){
                this.add(new PanelAsiento(corridaAsientos.getAsiento(i,j), this));
            }
        }
        this.setBackground(Color.black);
    }
    public void generarPanelDetallesAsiento(Asiento asiento) {
        panelReservarAsiento.generarPanelDetalleAsiento(asiento);
    }
}
