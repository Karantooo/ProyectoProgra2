package org.example.Vistas;

import org.example.Logica.Bus;
import org.example.Logica.Recorrido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

/**
 * Clase tipo JPanel para manejar la creacion de un viaje
 */
public class PanelCrearViaje extends JPanel {
    private String origen;
    private String destino;
    private String year;
    private String month;
    private String day;
    private String hora;
    private String minuto;
    private String duracion;
    private int capacidadPorPiso;
    private int cantidadDePisos;
    private PanelMenuInicial panelMenuInicial;

    /**
     * En el constructor se crean todos los jlabels para identificar cada JtextFields y se crean todos los JTextFields y
     * JComboBox para introducir las caracteristicas del viaje que se desea crear, tambien se generan los JButtons Enviar
     * y Volver para crear el viaje o volver al menu principal
     *
     * @param panelMenuInicial panel de menu inicial desde el cual se genero este panel
     */
    public PanelCrearViaje(PanelMenuInicial panelMenuInicial){
        this.panelMenuInicial = panelMenuInicial;
        this.setBackground(Color.cyan);
        this.setLayout(null);

        int xInicial = 0;
        int yInicial = 50;

        //JLabels
        JLabel labelTitulo = new JLabel("Ingrese los datos del viaje");
        labelTitulo.setFont(new Font("SansSerif", Font.PLAIN, 40));
        labelTitulo.setBounds(200,0,1000,50);
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelTitulo);
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
        JLabel labelFecha = new JLabel("Fecha: ");
        labelFecha.setFont(new Font("SansSerif", Font.PLAIN, 30));
        labelFecha.setBounds(1000,yInicial + 250,150,50);
        labelFecha.setHorizontalAlignment(SwingConstants.CENTER);
        labelFecha.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelFecha);
        JLabel labelDia = new JLabel("Dia: ");
        labelDia.setFont(new Font("SansSerif", Font.PLAIN, 30));
        labelDia.setBounds(700,yInicial + 300,150,50);
        labelDia.setHorizontalAlignment(SwingConstants.CENTER);
        labelDia.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelDia);
        JLabel labelMes = new JLabel("Mes: ");
        labelMes.setFont(new Font("SansSerif", Font.PLAIN, 30));
        labelMes.setBounds(700,yInicial + 400,150,50);
        labelMes.setHorizontalAlignment(SwingConstants.CENTER);
        labelMes.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelMes);
        JLabel labelYear = new JLabel("Año: ");
        labelYear.setFont(new Font("SansSerif", Font.PLAIN, 30));
        labelYear.setBounds(700,yInicial + 500,150,50);
        labelYear.setHorizontalAlignment(SwingConstants.CENTER);
        labelYear.setVerticalAlignment(SwingConstants.CENTER);
        this.add(labelYear);
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
        JTextField textoDia = new JTextField();
        textoDia.setFont(new Font("SansSerif", Font.PLAIN, sizeTextoIngresado));
        textoDia.setBounds(150 + 700, yInicial + 300, 500, 50);
        this.add(textoDia);
        JTextField textoMes = new JTextField();
        textoMes.setFont(new Font("SansSerif", Font.PLAIN, sizeTextoIngresado));
        textoMes.setBounds(150 + 700, yInicial + 400, 500, 50);
        this.add(textoMes);
        JTextField textoYear = new JTextField();
        textoYear.setFont(new Font("SansSerif", Font.PLAIN, sizeTextoIngresado));
        textoYear.setBounds(150 + 700, yInicial + 500, 500, 50);
        this.add(textoYear);
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
        botonEnviar.setBounds(1150,yInicial+ 575, 200, 100);
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                origen = textoOrigen.getText();
                destino = textoDestino.getText();
                hora = textoHora.getText();
                minuto = textoMinutos.getText();
                year = textoYear.getText();
                month = textoMes.getText();
                day = textoDia.getText();
                capacidadPorPiso = (int) comboBoxCapacidadPorPiso.getSelectedItem();
                cantidadDePisos = (int) comboBoxCantidadDePisos.getSelectedItem();
                duracion = textoDuracion.getText();
                boolean textoVacio = revisarTextosVacios();
                if(textoVacio) generarMensajeIngreseDatos();
                else {
                    boolean estadoEnvio = revisarEnvio();
                    if (estadoEnvio) {
                        crearViaje();
                    } else generarMensajeCreacionIncorrecta();
                }
            }
        });
        this.add(botonEnviar);

        JButton botonVolver = new JButton("Volver");
        botonVolver.setBounds(10,yInicial+ 650, 200, 50);
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverMenuPrincipal();
            }
        });
        this.add(botonVolver);
    }

    /**
     * Metodo que genera un mensaje en caso de que no ingrese todos los datos
     */
    private void generarMensajeIngreseDatos(){
        JOptionPane.showMessageDialog(null, "Debes ingresar todos los datos!");
    }

    /**
     * Metodo que crea el viaje, lo agrega a los viajes y genera el mensaje de que fue creado correctamente
     */
    private void crearViaje(){
        Recorrido recorrido = new Recorrido(origen, destino, LocalDateTime.of(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day),Integer.parseInt(hora),Integer.parseInt(minuto)), Integer.parseInt(duracion));
        Bus.BusBuilder busBuilder = new Bus.BusBuilder(recorrido);
        busBuilder.buildPisos(cantidadDePisos);
        busBuilder.buildAsientosPorPiso(capacidadPorPiso);
        panelMenuInicial.getPanelPrincipal().agregarBus(busBuilder.buildBus());
        generarMensajeCreacionCorrecta();
    }

    /**
     * Metodo que revisa si los datos ingresados son correctos, como si la Hora y minutos de salida son validos, si la
     * duracion no es menor a cero, y si es que los datos que deben contener solo numeros o solo letras, lo hacen
     * @return true si el envio es valido, false si no
     */
    private boolean revisarEnvio(){
        if(Integer.parseInt(hora) < 0 | Integer.parseInt(hora) > 23) return false;
        if(Integer.parseInt(minuto) < 0 | Integer.parseInt(minuto) > 59) return false;
        if(Integer.parseInt(duracion) < 0) return false;
        if(contieneNumero(origen) | contieneNumero(destino)) return false;
        if(Integer.parseInt(day) < 0 | Integer.parseInt(day) > 31) return false;
        if(Integer.parseInt(month) < 0 | Integer.parseInt(month) > 12) return false;
        if(Integer.parseInt(year) < 0) return false;
        if(!(contieneSoloNumeros(hora) | contieneSoloNumeros(minuto) | contieneSoloNumeros(duracion) |
                contieneSoloNumeros(day) | contieneSoloNumeros(month) | contieneSoloNumeros(year))) return false;
        return true;
    }

    /**
     * Metodo que revisa si ingreso todos los datos
     * @return true si algun texto esta vacio, false sino
     */
    private boolean revisarTextosVacios(){
        if(origen.isEmpty() | destino.isEmpty() | hora.isEmpty() | minuto.isEmpty() | day.isEmpty() |
        month.isEmpty() | year.isEmpty() | duracion.isEmpty()) return true;
        else return false;
    }

    /**
     * Metodo que genera el mensaje de creacion correcta, crea un boton para volver al menu inicial
     */
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

    /**
     * Metodo que genera mensaje si alguno de los datos es invalido
     */
    private void generarMensajeCreacionIncorrecta() {
        JOptionPane.showMessageDialog(null, "Alguno de los datos ingresados es invalido");
    }

    /**
     * Metodo para volver al menu inicial
     */
    private void volverMenuPrincipal(){
        this.remove(this);
        panelMenuInicial.generarNuevoMenuInicial();
        this.repaint();
        this.revalidate();
    }

    /**
     * Metodo que revisa si un string contien un numero
     * @param s String ingresado
     * @return true si contiene algun numero y false si no
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
}
