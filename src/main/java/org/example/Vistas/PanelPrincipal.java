package org.example.Vistas;

import org.example.Logica.Bus;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Clase tipo JPanel  que se encarga de almacenar el arraylist de buses y ademas generar un PanelMenuInicial
 * @author Benjamin Espinoza
 */
public class PanelPrincipal extends JPanel {
    private ArrayList<Bus> busArrayList;
    private PanelMenuInicial panelMenuInicial;

    /**
     * Constructor de la clase, inicializa el arraylist de buses y el PanelMenuInicial
     */
    public PanelPrincipal(){
        busArrayList = new ArrayList<>();
        this.setBackground(Color.orange);
        this.setLayout(new GridLayout(1,1));
        panelMenuInicial = new PanelMenuInicial(this);
        this.add(panelMenuInicial);
    }

    /**\
     * Meotdo para agregar buses a la lista de buses
     * @param bus bus que se va agrega al arraylist
     */
    public void agregarBus(Bus bus) {
        busArrayList.add(bus);
    }

    public ArrayList<Bus> getBusArrayList() {
        return busArrayList;
    }
}
