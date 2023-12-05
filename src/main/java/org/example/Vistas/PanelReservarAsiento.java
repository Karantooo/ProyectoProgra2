package org.example.Vistas;

import org.example.Logica.Asiento;
import org.example.Logica.Bus;
import org.example.Logica.DirectorBus;
import org.example.Logica.Recorrido;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Panel para manejar la reserva de un asiento
 */
public class PanelReservarAsiento extends JPanel {
    private PanelMenuInicial panelMenuInicial;
    private ArrayList<Bus> busArrayList;
    private Bus busSeleccionado;
    private boolean vaAComprar = false;

    /**
     * En el constructor se generan viajes predeterminados, y se generan un panel para la mitad superior con los viajes
     * y un panel para la mitad inferior
     * @param panelMenuInicial panel de menu inicial desde el que se genero este panel
     */
    public PanelReservarAsiento(PanelMenuInicial panelMenuInicial) {
        this.panelMenuInicial = panelMenuInicial;
        this.busArrayList = panelMenuInicial.getPanelPrincipal().getBusArrayList();
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

        JPanel panelMitadInferior = getPanelMitadInferior();

        this.add(panelMitadInferior);
    }

    /**
     * Metodo que genera un PanelViaje para el bus que se indique y le agrega el boton para seleccionar el viaje
     * @param i indice en el cual este el bus
     * @return PanelViaje junto con el boton para seleccionarlo
     */
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

    /**
     * Metodo para generar el panel de la mitad inferior, crea un trexto con indicaciones y un JButton para volver al
     * menu incial
     * @return
     */
    private JPanel getPanelMitadInferior() {
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

    /**
     * Metodo para generar los viajes predeterminados, si es que se crearon mas de tres viajes antes de intentar
     * reservar un asiento estos viajes no se generan
     */
    private void generarViajesPredeterminados() {
        if(busArrayList.size() >= 3) return;
        DirectorBus directorBus = new DirectorBus();
        busArrayList.add(directorBus.buildGrande(new Recorrido("Stgo", "Afta", LocalDateTime.of(2024,1,27,15,30), 1125)));
        busArrayList.add(directorBus.buildChico(new Recorrido("Ccp", "Stgo", LocalDateTime.of(2024,1,13,12,0), 360)));
        busArrayList.add(directorBus.buildMediano(new Recorrido("Chiguayante", "Stgo", LocalDateTime.of(2023,12,24,12,30),390)));
    }

    /**
     * Metodo para volver al menu inicial
     */
    public void volverMenuPrincipal(){
        this.remove(this);
        panelMenuInicial.generarNuevoMenuInicial();
        this.repaint();
        this.revalidate();
    }

    /**
     * Meotodo para volver a este mismo JPanel
     */
    private void volverPanelReservarAsiento() {
        this.removeAll();
        this.add(new PanelReservarAsiento(panelMenuInicial));
        this.repaint();
        this.revalidate();
    }

    /**
     * Metodo para generar el panel desde el cual se selecciona el asiento para comprar
     * @param bus bus elegido para comprar un viaje
     */
    private void generarPanelSeleccionAsiento(Bus bus) {
        this.removeAll();
        this.busSeleccionado = bus;
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

            panelAsientos.add(new PanelCorridaAsientos(bus.getCorridaAsientosPorPiso().get(i), this), BorderLayout.CENTER);
            panelPisos.add(panelAsientos);
            this.add(panelPisos);
        }
        this.repaint();
        this.revalidate();
    }

    /**
     * Metodo para generar el panel con el detalle del asiento escogido para comprar, genera un boton para volver y otro
     * para comprar el asiento
     * @param asiento asiento escogido para comprar
     */
    public void generarPanelDetalleAsiento(Asiento asiento) {
        this.removeAll();

        JPanel panelDetallesAsiento = new JPanel(null);
        panelDetallesAsiento.setBackground(Color.PINK);
        panelDetallesAsiento.setBorder(new LineBorder(Color.BLACK, 10));

        JTextArea informacionAsiento = new JTextArea("Estado del asiento: " + asiento.getEstadoAsiento());
        informacionAsiento.setBackground(Color.PINK);
        if(asiento.getPasajero() == null) informacionAsiento.setText(informacionAsiento.getText() + "\nPasajero: No tiene");
        else informacionAsiento.setText(informacionAsiento.getText() + "\nPasajero: " + asiento.getPasajero().getNombre() + " " + asiento.getPasajero().getApellido());
        informacionAsiento.setText(informacionAsiento.getText() + "\nNumero de asiento: " + asiento.getCodigoAsiento());
        informacionAsiento.setText(informacionAsiento.getText() + "\nTipo de asiento: " + asiento.getDescripcionAsiento());
        informacionAsiento.setText(informacionAsiento.getText() + "\nPrecio del asiento: $" + asiento.getPrecioAsiento());
        informacionAsiento.setFont(new Font("SansSerif", Font.PLAIN, 25));
        informacionAsiento.setLineWrap(true);
        informacionAsiento.setWrapStyleWord(true);
        informacionAsiento.setEditable(false);
        informacionAsiento.setBounds(10,10 , 500, 240);
        panelDetallesAsiento.add(informacionAsiento);

        JButton botonVolverSeleccionAsiento = new JButton("Volver");

        botonVolverSeleccionAsiento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarPanelSeleccionAsiento(busSeleccionado);
            }
        });
        botonVolverSeleccionAsiento.setBounds(10,650,250,100);
        panelDetallesAsiento.add(botonVolverSeleccionAsiento);

        JButton botonComprar = new JButton("Presione aqui para comprar este asiento");
        botonComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarPanelCompra(asiento);
            }
        });
        botonComprar.setBounds(900,250,300,150);
        panelDetallesAsiento.add(botonComprar);

        this.add(panelDetallesAsiento);
        this.repaint();
        this.revalidate();
    }

    /**
     * Metodo que genera un PanelCompra con el asiento escogido
     * @param asiento Asiento escogido para comprar
     */
    private void generarPanelCompra(Asiento asiento) {
        PanelCompra panelCompra = new PanelCompra(asiento, this);
        this.add(panelCompra);
        this.repaint();
        this.revalidate();
    }
}
