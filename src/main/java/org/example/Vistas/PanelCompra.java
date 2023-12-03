package org.example.Vistas;

import org.example.Logica.Asiento;
import org.example.Logica.Pasajero;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelCompra extends JPanel {
    private Asiento asiento;
    private Pasajero pasajero;
    public PanelCompra(Asiento asiento) {
        this.setLayout(null);
        this.setBackground(Color.cyan);
        this.setBorder(new LineBorder(Color.BLACK, 10));

        int yInicial = 75;
        int xInicial = 45;
        //JLabels
        JLabel labelNombre = new JLabel("Nombre: ");
        labelNombre.setFont(new Font("SansSerif", Font.PLAIN, 30));
        labelNombre.setBounds(xInicial,yInicial,150,50);
        labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
        labelNombre.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelNombre);
        JLabel labelBanco = new JLabel("Banco: ");
        labelBanco.setFont(new Font("SansSerif", Font.PLAIN, 30));
        labelBanco.setBounds(xInicial,yInicial + 75,150,50);
        labelBanco.setHorizontalAlignment(SwingConstants.CENTER);
        labelBanco.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelBanco);
        JLabel labelRut = new JLabel("Rut: ");
        labelRut.setFont(new Font("SansSerif", Font.PLAIN, 30));
        labelRut.setBounds(xInicial,yInicial + 150,150,50);
        labelRut.setHorizontalAlignment(SwingConstants.CENTER);
        labelRut.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelRut);
        JLabel labelNumeroDeCuenta = new JLabel("Numero de cuenta: ");
        labelNumeroDeCuenta.setFont(new Font("SansSerif", Font.PLAIN, 20));
        labelNumeroDeCuenta.setBounds(xInicial,yInicial + 225,200,50);
        labelNumeroDeCuenta.setHorizontalAlignment(SwingConstants.CENTER);
        labelNumeroDeCuenta.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelNumeroDeCuenta);

        //JTextFields
        int sizeTextoIngresado = 25;
        JTextField textoNombre = new JTextField();
        textoNombre.setFont(new Font("SansSerif", Font.PLAIN, sizeTextoIngresado));
        textoNombre.setBounds(xInicial + 200, yInicial, 500, 50);
        this.add(textoNombre);
        JTextField textoBanco = new JTextField();
        textoBanco.setFont(new Font("SansSerif", Font.PLAIN, sizeTextoIngresado));
        textoBanco.setBounds( xInicial + 200, yInicial + 75, 500, 50);
        this.add(textoBanco);
        JTextField textoRut = new JTextField();
        textoRut.setFont(new Font("SansSerif", Font.PLAIN, sizeTextoIngresado));
        textoRut.setBounds(xInicial + 200, yInicial + 150, 500, 50);
        this.add(textoRut);
        JTextField textoNumeroDeCuenta = new JTextField();
        textoNumeroDeCuenta.setFont(new Font("SansSerif", Font.PLAIN, sizeTextoIngresado));
        textoNumeroDeCuenta.setBounds(xInicial + 200, yInicial + 225, 500, 50);
        this.add(textoNumeroDeCuenta);


    }
}
