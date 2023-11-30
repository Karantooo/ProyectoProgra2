package org.example.Vistas;

import org.example.Logica.Asiento;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelAsiento extends JPanel {
    private Asiento asiento;
    private String tipoAsiento;
    private String codigoAsiento;
    public PanelAsiento(Asiento asiento){
        this.asiento = asiento;
        if(asiento != null) determinarTipoAsiento();

        JTextArea informacionAsiento = new JTextArea("Tipo de asiento: " + this.tipoAsiento);
        informacionAsiento.setText(informacionAsiento.getText() + "\nCodigo del asiento: " + this.codigoAsiento);
        informacionAsiento.setBackground(Color.cyan);
        informacionAsiento.setFont(new Font("SansSerif", Font.PLAIN, 15));
        informacionAsiento.setLineWrap(true);
        informacionAsiento.setWrapStyleWord(true);
        informacionAsiento.setEditable(false);
        informacionAsiento.setBorder(new LineBorder(Color.BLACK, 2));
        informacionAsiento.setBounds(0, 0, getWidth(), getHeight());
        this.add(informacionAsiento);

    }
    public void determinarTipoAsiento() {
        switch (asiento.getDescripcionAsiento()){
            case "Asiento Premium":
                this.setBackground(Color.magenta);
                break;
            case "Asiento Economico":
                this.setBackground(Color.blue);
                break;
            case "Asiento Ejecutivo":
                this.setBackground(Color.orange);
                break;
            default:
                break;
        }
        this.tipoAsiento = asiento.getDescripcionAsiento();
        this.codigoAsiento = asiento.getCodigoAsiento();
    }

}
