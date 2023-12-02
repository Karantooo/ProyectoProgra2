package org.example.Vistas;

import org.example.Logica.Asiento;
import org.example.Logica.CorridaAsientos;

import javax.swing.*;
import java.awt.*;

public class PanelCorridaAsientos extends JPanel {
    private CorridaAsientos corridaAsientos;
    public PanelCorridaAsientos(CorridaAsientos corridaAsientos){
        this.corridaAsientos = corridaAsientos;
        this.setLayout(new GridLayout(corridaAsientos.getFilas(), corridaAsientos.getColumnas()));
        for(int i = 0; i < corridaAsientos.getFilas(); i++){
            for(int j = 0; j < corridaAsientos.getColumnas(); j++){
                this.add(new PanelAsiento(corridaAsientos.getAsiento(i,j), this));
            }
        }
        this.setBackground(Color.black);
    }
    public void generarPanelDetallesAsiento(Asiento asiento) {
        this.removeAll();
        this.setLayout(null);

        JTextArea informacionAsiento = new JTextArea("Estado del asiento: " + asiento.getEstadoAsiento());
        informacionAsiento.setBackground(Color.cyan);
        informacionAsiento.setText(informacionAsiento.getText() + "\nPasajero: " + asiento.getPasajero());
        informacionAsiento.setText(informacionAsiento.getText() + "\nNumero de asiento: " + asiento.getCodigoAsiento());
        informacionAsiento.setText(informacionAsiento.getText() + "\nTipo de asiento: " + asiento.getDescripcionAsiento());
        informacionAsiento.setText(informacionAsiento.getText() + "\nPrecio del asiento: " + asiento.getPrecioAsiento());
        informacionAsiento.setFont(new Font("SansSerif", Font.PLAIN, 15));
        informacionAsiento.setLineWrap(true);
        informacionAsiento.setWrapStyleWord(true);
        informacionAsiento.setEditable(false);
        informacionAsiento.setBounds(0, 0, getWidth(), getHeight());
        this.add(informacionAsiento);
        this.repaint();
        this.revalidate();
    }
}
