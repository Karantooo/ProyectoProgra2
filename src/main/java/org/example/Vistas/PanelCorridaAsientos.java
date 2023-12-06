package org.example.Vistas;

import org.example.Logica.Asiento;
import org.example.Logica.CorridaAsientos;

import javax.swing.*;
import java.awt.*;

/**
 * Clase para instanciar el panel en el que se muestran las corridas de asientos.
 * @author Benjamin Espinoza
 */
public class PanelCorridaAsientos extends JPanel {
    private CorridaAsientos corridaAsientos;
    private PanelReservarAsiento panelReservarAsiento;

    /**
     * Se establece un GridLayout en el que se puede visualizar en cada casilla el asiento correspondiente.
     * Se utiliza el objeto corridaAsientos para establecer la informacion especifica de cada asiento.
     * @param corridaAsientos
     * @param panelReservarAsiento
     */
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
