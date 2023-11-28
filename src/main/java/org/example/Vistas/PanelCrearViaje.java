package org.example.Vistas;

import org.example.Logica.Bus;
import org.example.Logica.Recorrido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCrearViaje extends JPanel {
    private String origen;
    private String destino;
    private int hora;
    private int minuto;
    private int duracion;
    private int capacidadPorPiso;
    private int cantidadDePisos;
    private PanelMenuInicial panelMenuInicial;
    public PanelCrearViaje(PanelMenuInicial panelMenuInicial){
        this.panelMenuInicial = panelMenuInicial;
        this.setBackground(Color.cyan);
        this.setLayout(null);

        int xInicial = 0;
        int yInicial = 100;

        //JLabels
        JLabel labelOrigen = new JLabel("Origen: ");
        labelOrigen.setFont(new Font("SansSerif", Font.PLAIN, 30));
        labelOrigen.setBounds(0,yInicial,150,50);
        labelOrigen.setHorizontalAlignment(SwingConstants.CENTER);
        labelOrigen.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelOrigen);
        JLabel labelDestino = new JLabel("Destino: ");
        labelDestino.setFont(new Font("SansSerif", Font.PLAIN, 30));
        labelDestino.setBounds(0,yInicial + 100,150,50);
        labelDestino.setHorizontalAlignment(SwingConstants.CENTER);
        labelDestino.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelDestino);
        JLabel labelHora = new JLabel("Hora: ");
        labelHora.setFont(new Font("SansSerif", Font.PLAIN, 30));
        labelHora.setBounds(0,yInicial + 200,150,50);
        labelHora.setHorizontalAlignment(SwingConstants.CENTER);
        labelHora.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelHora);
        JLabel labelMinutos = new JLabel("Minutos: ");
        labelMinutos.setFont(new Font("SansSerif", Font.PLAIN, 30));
        labelMinutos.setBounds(xInicial + 700,yInicial + 200,150,50);
        labelMinutos.setHorizontalAlignment(SwingConstants.CENTER);
        labelMinutos.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelMinutos);
        JLabel labelCapacidadPorPiso = new JLabel("Capacidad por piso: ");
        labelCapacidadPorPiso.setFont(new Font("SansSerif", Font.PLAIN, 15));
        labelCapacidadPorPiso.setBounds(0,yInicial + 300,150,50);
        labelCapacidadPorPiso.setHorizontalAlignment(SwingConstants.CENTER);
        labelCapacidadPorPiso.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelCapacidadPorPiso);
        JLabel labelCantidadDePisos = new JLabel("Cantidad de pisos: ");
        labelCantidadDePisos.setFont(new Font("SansSerif", Font.PLAIN, 15));
        labelCantidadDePisos.setBounds(0,yInicial + 400,150,50);
        labelCantidadDePisos.setHorizontalAlignment(SwingConstants.CENTER);
        labelCantidadDePisos.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelCantidadDePisos);
        JLabel labelDuracion = new JLabel("Duracion(en minutos): ");
        labelDuracion.setFont(new Font("SansSerif", Font.PLAIN, 15));
        labelDuracion.setBounds(0,yInicial + 500,150,50);
        labelDuracion.setHorizontalAlignment(SwingConstants.CENTER);
        labelDuracion.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelDuracion);

        //JTextFields
        int sizeTextoIngresado = 25;
        JTextField textoOrigen = new JTextField();
        textoOrigen.setFont(new Font("SansSerif", Font.PLAIN, sizeTextoIngresado));
        textoOrigen.setBounds(150, yInicial, 500, 50);
        this.add(textoOrigen);
        JTextField textoDestino = new JTextField();
        textoDestino.setFont(new Font("SansSerif", Font.PLAIN, sizeTextoIngresado));
        textoDestino.setBounds(150, yInicial + 100, 500, 50);
        this.add(textoDestino);
        JTextField textoHora = new JTextField();
        textoHora.setFont(new Font("SansSerif", Font.PLAIN, sizeTextoIngresado));
        textoHora.setBounds(150, yInicial + 200, 500, 50);
        this.add(textoHora);
        JTextField textoMinutos = new JTextField();
        textoMinutos.setFont(new Font("SansSerif", Font.PLAIN, sizeTextoIngresado));
        textoMinutos.setBounds(150 + 700, yInicial + 200, 500, 50);
        this.add(textoMinutos);
        JTextField textoDuracion = new JTextField();
        textoDuracion.setFont(new Font("SansSerif", Font.PLAIN, sizeTextoIngresado));
        textoDuracion.setBounds(150, yInicial + 500, 500, 50);
        this.add(textoDuracion);

        //JComboBox
        JComboBox<Integer> comboBoxCapacidadPorPiso = new JComboBox<Integer>();
        comboBoxCapacidadPorPiso.addItem(40);
        comboBoxCapacidadPorPiso.addItem(60);
        comboBoxCapacidadPorPiso.addItem(80);
        comboBoxCapacidadPorPiso.setBounds(150, yInicial + 300, 150,50);
        this.add(comboBoxCapacidadPorPiso);
        JComboBox<Integer> comboBoxCantidadDePisos = new JComboBox<Integer>();
        comboBoxCantidadDePisos.addItem(1);
        comboBoxCantidadDePisos.addItem(2);
        comboBoxCantidadDePisos.setBounds(150, yInicial + 400, 150,50);
        this.add(comboBoxCantidadDePisos);

        //JButton
        JButton botonEnviar = new JButton("Crear");
        botonEnviar.setBounds(1150,yInicial+ 525, 200, 100);
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                origen = textoOrigen.getText();
                destino = textoDestino.getText();
                hora = Integer.parseInt(textoHora.getText());
                minuto = Integer.parseInt(textoMinutos.getText());
                capacidadPorPiso = (int) comboBoxCapacidadPorPiso.getSelectedItem();
                cantidadDePisos = (int) comboBoxCantidadDePisos.getSelectedItem();
                duracion = Integer.parseInt(textoDuracion.getText());

                boolean estadoenvio = revisarEnvio();
                if(estadoenvio){
                    Recorrido recorrido = new Recorrido(origen, destino, hora, minuto);
                    Bus.BusBuilder busBuilder = new Bus.BusBuilder(recorrido);
                    panelMenuInicial.getPanelPrincipal().agregarBus(busBuilder.buildBus());
                    generarMensajeCreacionCorrecta();
                }
                else generarMensajeCreacionIncorrecta();
            }
        });
        this.add(botonEnviar);
    }

    private boolean revisarEnvio(){
        if(hora < 0 | hora > 24) return false;
        if(minuto < 0 | minuto > 60) return false;
        if(duracion < 0) return false;
        return true;
    }

    private void generarMensajeCreacionCorrecta() {
        this.removeAll();

        //Jlabel
        JLabel labelCreacionCorrecta = new JLabel("El viaje se creo exitosamente!");
        labelCreacionCorrecta.setBounds(0, 0, getWidth(), getHeight());
        labelCreacionCorrecta.setFont(new Font("SansSerif", Font.PLAIN, 30));
        labelCreacionCorrecta.setHorizontalAlignment(SwingConstants.CENTER);
        labelCreacionCorrecta.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelCreacionCorrecta);

        //JButtons
        JButton botonVolver = new JButton("Volver");
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverMenuPrincipal();
            }
        });
        botonVolver.setBounds(1150,625, 200, 100);
        this.add(botonVolver);
        repaint();
        revalidate();
    }

    private void generarMensajeCreacionIncorrecta() {
        this.removeAll();

        //Jlabel
        JLabel labelCreacionInCorrecta = new JLabel("El viaje no se pudo crear!");
        labelCreacionInCorrecta.setBounds(0, 0, getWidth(), getHeight());
        labelCreacionInCorrecta.setFont(new Font("SansSerif", Font.PLAIN, 30));
        labelCreacionInCorrecta.setHorizontalAlignment(SwingConstants.CENTER);
        labelCreacionInCorrecta.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelCreacionInCorrecta);

        //JButtons
        JButton botonVolver = new JButton("Volver");
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverMenuPrincipal();
            }
        });
        botonVolver.setBounds(1150,625, 200, 100);
        this.add(botonVolver);
        repaint();
        revalidate();
    }

    private void volverMenuPrincipal(){
        this.remove(this);
        panelMenuInicial.generarNuevoMenuInicial();
        this.repaint();
        this.revalidate();
    }
}