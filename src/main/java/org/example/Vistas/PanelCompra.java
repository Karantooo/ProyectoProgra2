package org.example.Vistas;

import org.example.Logica.Asiento;
import org.example.Logica.Pasajero;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase tipo JPanel para manejar la compra de un asiento
 */
public class PanelCompra extends JPanel {
    private Asiento asiento;
    private Pasajero pasajero;
    private String nombre;
    private String apellido;
    private String banco;
    private String numCuenta;
    private PanelReservarAsiento panelReservarAsiento;

    /**
     * En el constructor se crean todos los jlabels para identificar cada JtextFields y se crean todos los JTextFields
     * para introducir las caracteristicas del Pasajero que se desea asignar al asiento, tambien se genera el JButtons
     * Enviar para asignar el pasajero
     * @param asiento asiento que desea comprar
     * @param panelReservarAsiento PanelReservaAsiento desde el cual se genero este PanelCompra
     */
    public PanelCompra(Asiento asiento, PanelReservarAsiento panelReservarAsiento) {
        this.panelReservarAsiento = panelReservarAsiento;
        this.setLayout(null);
        this.asiento = asiento;
        this.setBackground(Color.cyan);
        this.setBorder(new LineBorder(Color.BLACK, 10));

        int yInicial = 75;
        int xInicial = 45;
        //JLabels
        JLabel labelTitulo = new JLabel("Ingese los datos del pasajero");
        labelTitulo.setFont(new Font("SansSerif", Font.PLAIN, 30));
        labelTitulo.setBounds(xInicial + 100,15,500,50);
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelTitulo);
        JLabel labelNombre = new JLabel("Nombre: ");
        labelNombre.setFont(new Font("SansSerif", Font.PLAIN, 30));
        labelNombre.setBounds(xInicial,yInicial,150,50);
        labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
        labelNombre.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelNombre);
        JLabel labelApellido = new JLabel("Apellido: ");
        labelApellido.setFont(new Font("SansSerif", Font.PLAIN, 30));
        labelApellido.setBounds(xInicial,yInicial + 75,150,50);
        labelApellido.setHorizontalAlignment(SwingConstants.CENTER);
        labelApellido.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelApellido);
        JLabel labelBanco = new JLabel("Banco: ");
        labelBanco.setFont(new Font("SansSerif", Font.PLAIN, 30));
        labelBanco.setBounds(xInicial,yInicial + 150,150,50);
        labelBanco.setHorizontalAlignment(SwingConstants.CENTER);
        labelBanco.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelBanco);
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
        JTextField textoApellido = new JTextField();
        textoApellido.setFont(new Font("SansSerif", Font.PLAIN, sizeTextoIngresado));
        textoApellido.setBounds(xInicial + 200, yInicial + 75, 500, 50);
        this.add(textoApellido);
        JTextField textoBanco = new JTextField();
        textoBanco.setFont(new Font("SansSerif", Font.PLAIN, sizeTextoIngresado));
        textoBanco.setBounds( xInicial + 200, yInicial + 150, 500, 50);
        this.add(textoBanco);
        JTextField textoNumeroDeCuenta = new JTextField();
        textoNumeroDeCuenta.setFont(new Font("SansSerif", Font.PLAIN, sizeTextoIngresado));
        textoNumeroDeCuenta.setBounds(xInicial + 200, yInicial + 225, 500, 50);
        this.add(textoNumeroDeCuenta);

        JButton botonEnviar = new JButton("Asignar pasajero");
        botonEnviar.setBounds(xInicial + 200,yInicial+ 400, 200, 100);
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombre = textoNombre.getText();
                apellido = textoApellido.getText();
                banco = textoBanco.getText();
                numCuenta = textoNumeroDeCuenta.getText();
                boolean textoVacio = revisarTextosVacios();
                if(textoVacio) generarMensajeIngreseDatos();
                else {
                    boolean estadoEnvio = revisarEnvio();
                    if (estadoEnvio) {
                        asignarPasajero();
                    } else generarMensajeCreacionIncorrecta();
                }
            }
        });
        this.add(botonEnviar);
    }

    /**
     * Metodo para asignar el pasajero al asiento y generar el mensaje de creacion correcta
     */
    private void asignarPasajero() {
        this.pasajero = new Pasajero(nombre, apellido, banco, numCuenta);
        this.asiento.setPasajero(pasajero);
        generarMensajeCreacionCorrecta();
    }

    /**
     * Metodo para revisar si es que el envio es valido
     * @return falso si no es valido, true si lo es
     */
    private boolean revisarEnvio() {
        if(contieneNumero(nombre) | contieneNumero(apellido) | contieneNumero(banco)) return false;
        else return contieneSoloNumeros(numCuenta);
    }

    /**
     * Metodo para revisar si un string contiene algun numero
     * @param s String ingresado
     * @return true si es que contiene al menos un numero, false si no
     */
    private boolean contieneNumero(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que revisa si un string contiene solo numeros
     * @param s String ingresado
     * @return false si contiene al menos una letra, true si no
     */
    private boolean contieneSoloNumeros(String s){
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo para generar un mensaje en caso de que no se ingresen todos los datos
     */
    private void generarMensajeIngreseDatos() {
        JOptionPane.showMessageDialog(null, "Debes ingresar todos los datos!");
    }

    /**
     * Metodo para generar un mensaje en caso de que los datos sean invalidos
     */
    private void generarMensajeCreacionIncorrecta() {
        JOptionPane.showMessageDialog(null, "Alguno de los datos ingresados es invalido");
    }

    /**
     * Metodo para generar un Panel con un mensaje de que la creacion fue correcta y ademas un boton para volver al menu
     * inicial
     */
    private void generarMensajeCreacionCorrecta() {
        this.removeAll();

        JLabel labelCreacionCorrecta = new JLabel("Se asigno correctamente al pasajero!");
        labelCreacionCorrecta.setBounds(0, 0, getWidth(), getHeight());
        labelCreacionCorrecta.setFont(new Font("SansSerif", Font.PLAIN, 30));
        labelCreacionCorrecta.setHorizontalAlignment(SwingConstants.CENTER);
        labelCreacionCorrecta.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelCreacionCorrecta);

        JButton botonVolver = new JButton("Volver al menu inicial");
        botonVolver.setBounds(525, 600, 200, 100);
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelReservarAsiento.volverMenuPrincipal();
            }
        });
        this.add(botonVolver);

        this.repaint();
        this.revalidate();
    }

    /**
     * Metodo que revisa si es que alguno de los datos no se ingreso
     * @return true si es que alguno de los textos esta vacio, false si no
     */
    private boolean revisarTextosVacios() {
        if(nombre.isEmpty() || apellido.isEmpty() || banco.isEmpty() || numCuenta.isEmpty()) return true;
        else return false;
    }
}
