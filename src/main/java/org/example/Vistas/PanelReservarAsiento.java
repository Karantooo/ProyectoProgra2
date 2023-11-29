package org.example.Vistas;

import org.example.Logica.Bus;
import org.example.Logica.DirectorBus;
import org.example.Logica.Recorrido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class PanelReservarAsiento extends JPanel {
    private PanelMenuInicial panelMenuInicial;
    private ArrayList<Bus> busArrayList;
    public PanelReservarAsiento(PanelMenuInicial panelMenuInicial) {
        this.panelMenuInicial = panelMenuInicial;
        this.busArrayList = panelMenuInicial.getPanelPrincipal().getBusArrayList();
        generarViajesPredeterminados();
        generarViajesPredeterminados();
        this.setLayout(null);
        this.setBackground(Color.orange);

        JPanel panelMitadSuperior = new JPanel(new GridLayout(1,busArrayList.size()));
        for(int i = 0; i < busArrayList.size(); i++){
            PanelViaje panelViaje = new PanelViaje(busArrayList.get(i));
            panelViaje.setBounds(300 * i, 0, 300, 300);
            int finalI = i;
            panelViaje.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    System.out.println(busArrayList.get(finalI));
                }
            });
            panelMitadSuperior.add(panelViaje);
        }
        panelMitadSuperior.setBounds(150, 150, getWidth() / 2, getHeight() / 2);
        this.add(panelMitadSuperior);
    }
    private void generarViajesPredeterminados() {
        DirectorBus directorBus = new DirectorBus();
        LocalTime duracion = LocalTime.of(1,40);
        busArrayList.add(directorBus.buildGrande(new Recorrido("Stgo", "Afta", LocalDateTime.of(2024,1,27,15,30), duracion)));
        busArrayList.add(directorBus.buildChico(new Recorrido("Ccp", "Stgo", LocalDateTime.of(2024,1,13,12,0), duracion)));
        busArrayList.add(directorBus.buildMediano(new Recorrido("Chiguayante", "Stgo", LocalDateTime.of(2023,12,24,12,30), duracion)));
    }
}
