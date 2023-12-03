package org.example.Vistas;

import org.example.Logica.Asiento;
import org.example.Logica.EstadoAsiento;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelAsiento extends JPanel {
    private Asiento asiento;
    private String tipoAsiento;
    private String codigoAsiento;
    private JTextArea informacionAsiento;
    private PanelCorridaAsientos panelCorridaAsientos;
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
        informacionAsiento.setText("Tipo de asiento: " + this.tipoAsiento);
        informacionAsiento.setText(informacionAsiento.getText() + "\nCodigo del asiento: " + this.codigoAsiento);
        informacionAsiento.setFont(new Font("SansSerif", Font.BOLD, 9));
        informacionAsiento.setLineWrap(true);
        informacionAsiento.setWrapStyleWord(true);
        informacionAsiento.setEditable(false);
        informacionAsiento.setBorder(new LineBorder(Color.BLACK, 2));
        informacionAsiento.setBounds(0, 0, getWidth(), getHeight());
    }
    private void generarPanelDetallesAsiento(){
        if(asiento.getEstadoAsiento() == EstadoAsiento.OCUPADO) JOptionPane.showMessageDialog(null, "Este asiento esta ocupado por: \n"
                + asiento.getPasajero().getNombre() + " " + asiento.getPasajero().getApellido());
        else panelCorridaAsientos.generarPanelDetallesAsiento(asiento);
    }
}
