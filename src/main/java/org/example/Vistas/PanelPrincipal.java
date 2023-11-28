package org.example.Vistas;

import org.example.Logica.Bus;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelPrincipal extends JPanel {
    private ArrayList<Bus> busArrayList;
    private PanelMenuInicial panelMenuInicial;
    public PanelPrincipal(){
        busArrayList = new ArrayList<>();
        this.setBackground(Color.orange);
        panelMenuInicial = new PanelMenuInicial(this);
        this.add(panelMenuInicial);
    }

    public void agregarBus(Bus bus) {
        busArrayList.add(bus);
    }

}
