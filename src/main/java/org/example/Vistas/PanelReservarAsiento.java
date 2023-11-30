package org.example.Vistas;

import org.example.Logica.Bus;
import org.example.Logica.DirectorBus;
import org.example.Logica.Recorrido;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
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
            PanelViaje panelViaje = getPanelViaje(i);
            panelMitadSuperior.add(panelViaje);
        }
        panelMitadSuperior.setBounds(150, 150, getWidth(), getHeight() / 2);
        this.add(panelMitadSuperior);

        JPanel panelMitadInferior = getPanelMitadSuperior();

        this.add(panelMitadInferior);
    }

    private PanelViaje getPanelViaje(int i) {
        PanelViaje panelViaje = new PanelViaje(busArrayList.get(i));
        panelViaje.setBounds(300 * i, 0, 300, 300);

        int finalI = i;
        JButton botonSeleccionarViaje = new JButton("Presione aqui para seleccionar este viaje");
        botonSeleccionarViaje.setBackground(Color.cyan);
        botonSeleccionarViaje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarPanelSeleccionAsiento(busArrayList.get(finalI));
            }
        });
        panelViaje.add(botonSeleccionarViaje);
        return panelViaje;
    }

    private JPanel getPanelMitadSuperior() {
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
        return panelMitadInferior;
    }

    private void generarViajesPredeterminados() {
        if(busArrayList.size() >= 3) return;
        DirectorBus directorBus = new DirectorBus();
        busArrayList.add(directorBus.buildGrande(new Recorrido("Stgo", "Afta", LocalDateTime.of(2024,1,27,15,30), 1125)));
        busArrayList.add(directorBus.buildChico(new Recorrido("Ccp", "Stgo", LocalDateTime.of(2024,1,13,12,0), 360)));
        busArrayList.add(directorBus.buildMediano(new Recorrido("Chiguayante", "Stgo", LocalDateTime.of(2023,12,24,12,30),390)));
    }

    private void volverMenuPrincipal(){
        this.remove(this);
        panelMenuInicial.generarNuevoMenuInicial();
        this.repaint();
        this.revalidate();
    }

    private void volverPanelReservarAsiento() {
        this.removeAll();
        this.add(new PanelReservarAsiento(panelMenuInicial));
        this.repaint();
        this.revalidate();
    }

    private void generarPanelSeleccionAsiento(Bus bus) {
        this.removeAll();
        this.setLayout(new GridLayout(1,2));

        PanelViaje panelViaje = new PanelViaje(bus);
        JButton botonVolver = new JButton("Volver");
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverPanelReservarAsiento();
            }
        });
        botonVolver.setBackground(Color.cyan);
        panelViaje.add(botonVolver);
        this.add(panelViaje);

        JPanel panelPisos = new JPanel(new GridLayout(1,bus.getPisos()));
        for(int i = 0; i < bus.getPisos(); i++){
            JPanel panelAsientos = new JPanel(new BorderLayout());
            panelAsientos.setBorder(new LineBorder(Color.blue, 2));

            JLabel labelPiso = new JLabel("Piso: " + (i + 1));
            labelPiso.setHorizontalAlignment(SwingConstants.CENTER);
            labelPiso.setVerticalAlignment(SwingConstants.CENTER);
            panelAsientos.add(labelPiso, BorderLayout.NORTH);

            panelAsientos.add(new PanelCorridaAsientos(bus.getCorridaAsientosPorPiso().get(i)), BorderLayout.CENTER);
            panelPisos.add(panelAsientos);
            this.add(panelPisos);
        }
        this.repaint();
        this.revalidate();
    }

}
