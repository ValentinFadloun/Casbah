package panel;

import controller.ControlGroup;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ChoixCartePanel extends FondPanel {

    //Titre
    private JLabel text;
    private JLabel textBis;

    //Tableau de bouton
    private JButton[] tabBoutton;

    //Panel pour structurer
    private JPanel panelText;
    private JPanel panelBouton;
    private Box panelGeneral;

    private ControlGroup controlGroup;

    public ChoixCartePanel(Image imageFond, ControlGroup controlGroup) throws IOException {
        super(imageFond);
        this.controlGroup = controlGroup;
        text = new JLabel("Choisissez vos carte : joueur n° ");
        textBis = new JLabel("Nombre de tuiles à prendre : 45");
        tabBoutton = new JButton[45];
        for(int i = 0; i < tabBoutton.length; i++) {
            tabBoutton[i] = new JButton();
        }
        panelText = new JPanel();
        panelBouton = new JPanel(new GridLayout(5,9,10,10));
        panelGeneral = Box.createVerticalBox();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent2(g);

        for(int i = 0; i < 40; i++) {
            tabBoutton[i].setPreferredSize(new Dimension(80, 80));
            ImageIcon imgIcon = new ImageIcon("ressource/tuile/tuile_casbah_" + (i + 1) + ".jpg");
            tabBoutton[i].setIcon(imgIcon);
            panelBouton.add(tabBoutton[i]);
        }

        for(int i = 40; i < 45; i++) {
            tabBoutton[i].setPreferredSize(new Dimension(80, 80));
            tabBoutton[i].setIcon(new ImageIcon("ressource/tuile/tuile_jardin_" + (i - 39) + ".jpg"));
            panelBouton.add(tabBoutton[i]);
        }

        text = controlGroup.getControlChoixCarte().getTextIndiqueJoueur();
        textBis = controlGroup.getControlChoixCarte().getTextNombreTuileRestante();
        panelText.add(text);
        panelText.add(textBis);
        panelText.setBackground(new Color(225, 206, 154));
        //panelText.setOpaque( false );
        panelGeneral.add(panelText);
        panelBouton.setOpaque( false );
        panelGeneral.add(panelBouton);
        add(panelGeneral);

    }

    public JButton[] getButtonCarte() {
        return tabBoutton;
    }

}
