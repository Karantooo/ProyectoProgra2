package org.example.Vistas;

import javax.swing.*;

/**
 * Clase para inicializar la ventana en la que se va a ejecutar el sistema de gestion de creacion de buses, y compra de
 * asientos
 * Inicializa panelPrincipal en que esta toda la implementacion de la GUI
 * @author Benjamin Espinoza
 */
public class Ventana extends JFrame {
    PanelPrincipal panelPrincipal;

    /**
     * Establece la configuracion para la ventana
     */
    public Ventana(){
        this.panelPrincipal = new PanelPrincipal();
        this.setSize(1600, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(panelPrincipal);
        this.setTitle("Administracion de buses");

        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }
}
