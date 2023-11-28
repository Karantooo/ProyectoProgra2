package org.example.Vistas;

import org.example.Logica.Bus;
import org.example.Logica.DirectorBus;
import org.example.Logica.Recorrido;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelReservarAsiento extends JPanel {
    private PanelMenuInicial panelMenuInicial;
    private ArrayList<Bus> busArrayList;
    public PanelReservarAsiento(PanelMenuInicial panelMenuInicial) {
        this.panelMenuInicial = panelMenuInicial;
        busArrayList = panelMenuInicial.getPanelPrincipal().getBusArrayList();
        this.setLayout(null);
        this.setBackground(Color.orange);
        generarViajesPredeterminados();

        for(int i = 0; i < busArrayList.size(); i++){
            PanelViaje panelViaje = new PanelViaje(busArrayList.get(i));
            panelViaje.setBounds(150 * i, 0, 150, 150);
            this.add(panelViaje);
        }
    }
    private void generarViajesPredeterminados() {
        DirectorBus directorBus = new DirectorBus();
        busArrayList.add(directorBus.buildGrande(new Recorrido("Stgo", "Afta", 12, 30)));
        busArrayList.add(directorBus.buildChico(new Recorrido("Ccp", "Stgo", 6, 0)));
        busArrayList.add(directorBus.buildMediano(new Recorrido("Chiguayante", "Stgo", 15, 30)));
    }
}
