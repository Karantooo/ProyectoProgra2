package org.example.Vistas;

import org.example.Logica.Bus;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelViaje extends JPanel {
    Bus bus;
    public PanelViaje(Bus bus){
        this.bus = bus;
        this.setBackground(Color.cyan);
        this.setBorder(new LineBorder(Color.BLACK, 2));
        JTextArea informacionViaje = new JTextArea("Origen: " + bus.getRecorrido().getOrigen());
        informacionViaje.setBackground(Color.cyan);
        informacionViaje.setText(informacionViaje.getText() + "\nDestino: " + bus.getRecorrido().getDestino());
        informacionViaje.setText(informacionViaje.getText() + "\nFecha: " + bus.getRecorrido().getDay() + "-" + bus.getRecorrido().getMonth() + "-" + bus.getRecorrido().getYear());
        informacionViaje.setText(informacionViaje.getText() + "\nHora: " + bus.getRecorrido().getHora() + ":" + bus.getRecorrido().getMinutos());
        informacionViaje.setText(informacionViaje.getText() + "\nCantidad de asientos: " + bus.getAsientosPorPiso() * bus.getPisos());
        informacionViaje.setFont(new Font("SansSerif", Font.PLAIN, 15));
        informacionViaje.setLineWrap(true);
        informacionViaje.setWrapStyleWord(true);
        informacionViaje.setEditable(false);
        informacionViaje.setBounds(0, 0, getWidth(), getHeight());
        this.add(informacionViaje);
    }
}
