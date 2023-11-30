package org.example.Vistas;

import org.example.Logica.Asiento;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelAsiento extends JPanel {
    private Asiento asiento;
    private String tipoAsiento;
    private String codigoAsiento;
    JTextArea informacionAsiento;
    public PanelAsiento(Asiento asiento){
        this.asiento = asiento;
        this.setLayout(new GridLayout(1,1));
        informacionAsiento = new JTextArea();
        if(asiento != null) determinarTipoAsiento();
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
        informacionAsiento.setFont(new Font("SansSerif", Font.BOLD, 10));
        informacionAsiento.setLineWrap(true);
        informacionAsiento.setWrapStyleWord(true);
        informacionAsiento.setEditable(false);
        informacionAsiento.setBorder(new LineBorder(Color.BLACK, 2));
        informacionAsiento.setBounds(0, 0, getWidth(), getHeight());
    }

}
