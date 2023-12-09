package org.example.Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Panel para generar el panel inicial en el que se decide si se quiere crear un viaje o reservar un asiento
 * @author Benjamin Espinoza
 */
public class PanelMenuInicial extends JPanel {
    private PanelPrincipal panelPrincipal;

    /**
     * Se establece las condiciones iniciales del panel como sus dimensiones, layout
     * @param panelPrincipal
     */
    public PanelMenuInicial(PanelPrincipal panelPrincipal){
        this.panelPrincipal = panelPrincipal;
        this.setLayout(new GridLayout(1,2));
        this.setPreferredSize(new Dimension(1400,800));

        generarNuevoMenuInicial();
    }

    /**
     * Funcion que se utilzia para cambiar de un panelMenuInicial a un PanelcrearViaje
     */
    public void generarPanelCrearViaje() {
        this.removeAll();
        this.add(new PanelCrearViaje(this));
        repaint();
        revalidate();
    }

    /**
     * Funcion que se utilzia para cambiar de un panelMenuInicial a un PanelReservaAsiento
     */
    public void generarPanelReservaAsiento() {
        this.removeAll();
        this.add(new PanelReservarAsiento(this));
        repaint();
        revalidate();
    }

    /**
     * Funcion que se utilzia para cambiar de un panelMenuInicial a un PanelNuevoMenuInicial
     */
    public void generarNuevoMenuInicial(){
        this.removeAll();

        this.setLayout(new GridLayout(1,2));
        this.setPreferredSize(new Dimension(1400,800));

        JButton botonCrearViaje = new JButton("Crear Viaje");
        JButton botonReservarAsiento = new JButton("Reservar Asiento");
        botonCrearViaje.setBackground(Color.CYAN);
        botonReservarAsiento.setBackground(Color.CYAN);
        botonReservarAsiento.setPreferredSize(new Dimension(this.getWidth() / 2,this.getHeight() / 2));
        botonCrearViaje.setFont(new Font("SansSerif", Font.PLAIN, 50));
        botonReservarAsiento.setFont(new Font("SansSerif", Font.PLAIN, 50));
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
        repaint();
        revalidate();
    }

    public PanelPrincipal getPanelPrincipal() {
        return panelPrincipal;
    }
}

