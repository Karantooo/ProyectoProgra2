package org.example.Vistas;

import org.example.Logica.Asiento;
import org.example.Logica.EstadoAsiento;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase de tipo JPanel que se encarga de mostrar informacion sobre el asiento
 * @author Benjamin Espinoza
 */
public class PanelAsiento extends JPanel {
    private Asiento asiento;
    private String tipoAsiento;
    private String codigoAsiento;
    private JTextArea informacionAsiento;
    private PanelCorridaAsientos panelCorridaAsientos;

    /**
     * El constructor se encarga de generar el texto con la informacion del asiento y agregar un listener para generar
     * el panel con los detalles en caso de que se presione
     * @param asiento asiento mostrado
     * @param panelCorridaAsientos PanelCorridaAsientos desde el cual esta el asiento mostrado
     */
    public PanelAsiento(Asiento asiento, PanelCorridaAsientos panelCorridaAsientos){
        this.asiento = asiento;
        this.panelCorridaAsientos = panelCorridaAsientos;
        this.setLayout(new GridLayout(1,1));
        informacionAsiento = new JTextArea();
        if(asiento != null) {
            determinarTipoAsiento();
            if(asiento.getEstadoAsiento() == EstadoAsiento.OCUPADO) informacionAsiento.setBackground(Color.red);
        }

        informacionAsiento.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                generarPanelDetallesAsiento();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                generarPanelDetallesAsiento();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.add(informacionAsiento);

    }

    /**
     * Metodo para determinar el tipo de asiento que se va a mostrar, agrega toda  la informacion necesaria
     */
    public void determinarTipoAsiento() {
        switch (asiento.getDescripcionAsiento()){
            case "Asiento Premium":
                informacionAsiento.setBackground(Color.magenta);
                break;
            case "Asiento Economico":
                informacionAsiento.setBackground(Color.cyan);
                break;
            case "Asiento Ejecutivo":
                informacionAsiento.setBackground(Color.orange);
                break;
            default:
                break;
        }
        this.tipoAsiento = asiento.getDescripcionAsiento();
        this.codigoAsiento = asiento.getCodigoAsiento();
        informacionAsiento.setText("\nCodigo del asiento: " + this.codigoAsiento);
        informacionAsiento.setText(informacionAsiento.getText() + "\nTipo de asiento: " + this.tipoAsiento);
        informacionAsiento.setFont(new Font("SansSerif", Font.BOLD, 9));
        informacionAsiento.setLineWrap(true);
        informacionAsiento.setWrapStyleWord(true);
        informacionAsiento.setEditable(false);
        informacionAsiento.setBorder(new LineBorder(Color.BLACK, 2));
        informacionAsiento.setBounds(0, 0, getWidth(), getHeight());
    }

    /**
     * Metodo para generar el panel con los detalles del asiento en caso de que se quiera comprar, si este esta ocupado
     * se muestra un mensaje con el nombre de quien lo compro
     */
    private void generarPanelDetallesAsiento(){
        if(asiento.getEstadoAsiento() == EstadoAsiento.OCUPADO) JOptionPane.showMessageDialog(null, "Este asiento esta ocupado por: \n"
                + asiento.getPasajero().getNombre() + " " + asiento.getPasajero().getApellido());
        else panelCorridaAsientos.generarPanelDetallesAsiento(asiento);
    }
}
