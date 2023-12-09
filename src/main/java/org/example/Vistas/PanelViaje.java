package org.example.Vistas;

import org.example.Logica.Bus;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Clase tipo JPanel que se encarga de mostrar la informacion del viaje
 * @author Benjamin Espinoza
 */
public class PanelViaje extends JPanel {
    private Bus bus;

    /**
     * Constructor de la clase, se encarga de agregar al panel la informacion necesaria para el viaje
     * @param bus bus con el viaje que se desea mostar
     */
    public PanelViaje(Bus bus){
        this.bus = bus;
        this.setBackground(Color.cyan);
        this.setBorder(new LineBorder(Color.BLACK, 2));
        this.setLayout(new GridLayout(2,1));
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
