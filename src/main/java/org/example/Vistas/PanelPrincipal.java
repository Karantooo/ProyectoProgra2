package org.example.Vistas;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    PanelMenuInicial panelMenuInicial;
    public PanelPrincipal(){
        this.setBackground(Color.orange);
        panelMenuInicial = new PanelMenuInicial();
        this.add(panelMenuInicial);
    }


}
