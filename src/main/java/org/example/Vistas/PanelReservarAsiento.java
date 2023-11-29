package org.example.Vistas;

import org.example.Logica.Bus;
import org.example.Logica.DirectorBus;
import org.example.Logica.Recorrido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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
        this.setLayout(new GridLayout(2,1));
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
        panelMitadSuperior.setBounds(150, 150, getWidth(), getHeight() / 2);
        this.add(panelMitadSuperior);

        JPanel panelMitadInferior = new JPanel(null);
        panelMitadInferior.setBackground(Color.orange);
        JLabel labelEleccion = new JLabel("Seleccione el viaje que desea comprar");
        labelEleccion.setHorizontalAlignment(SwingConstants.CENTER);
        labelEleccion.setVerticalAlignment(SwingConstants.CENTER);
        labelEleccion.setFont(new Font("SansSerif", Font.PLAIN, 50));
        labelEleccion.setBounds(200,0,1000,250);
        panelMitadInferior.add(labelEleccion);

        JButton botonVolver = new JButton("Volver");
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverMenuPrincipal();
            }
        });
        botonVolver.setBounds(0, 300, 200, 50);
        panelMitadInferior.add(botonVolver);

        this.add(panelMitadInferior);
    }
    private void generarViajesPredeterminados() {
        if(busArrayList.size() >= 3) return;
        DirectorBus directorBus = new DirectorBus();
        busArrayList.add(directorBus.buildGrande(new Recorrido("Stgo", "Afta", LocalDateTime.of(2024,1,27,15,30), LocalTime.of(18,45))));
        busArrayList.add(directorBus.buildChico(new Recorrido("Ccp", "Stgo", LocalDateTime.of(2024,1,13,12,0), LocalTime.of(6,0))));
        busArrayList.add(directorBus.buildMediano(new Recorrido("Chiguayante", "Stgo", LocalDateTime.of(2023,12,24,12,30), LocalTime.of(6,30))));
    }

    private void volverMenuPrincipal(){
        this.remove(this);
        panelMenuInicial.generarNuevoMenuInicial();
        this.repaint();
        this.revalidate();
    }
}
