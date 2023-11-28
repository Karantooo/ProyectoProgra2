package org.example.Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelMenuInicial extends JPanel {
    public PanelMenuInicial(){
        this.setLayout(new GridLayout(1,2));
        this.setPreferredSize(new Dimension(1400,800));

        JButton botonCrearViaje = new JButton("Crear Viaje");
        JButton botonReservarAsiento = new JButton("Reservar Asiento");
        botonCrearViaje.setBackground(Color.CYAN);
        botonReservarAsiento.setBackground(Color.CYAN);
        botonReservarAsiento.setPreferredSize(new Dimension(this.getWidth() / 2,this.getHeight() / 2));

        botonCrearViaje.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarPanelCrearViaje();
            }
        });

        botonReservarAsiento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarPanelReservaAsiento();
            }
        });

        this.add(botonCrearViaje);
        this.add(botonReservarAsiento);
    }

    public void generarPanelCrearViaje() {
        this.removeAll();
        this.add(new PanelCrearViaje());
        repaint();
        revalidate();
    }

    public void generarPanelReservaAsiento() {
        this.removeAll();
        this.add(new PanelReservarAsiento());
        repaint();
        revalidate();
    }
}

