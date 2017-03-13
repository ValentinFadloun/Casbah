package view;

import panel.ChoixTaillePanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VueChoixTaille extends JFrame {

    //Panel
    private ChoixTaillePanel choixTaillePanel;

    public VueChoixTaille() throws IOException {
        choixTaillePanel = new ChoixTaillePanel(new ImageIcon("ressource/casbah.jpg").getImage());
        createWidnet();
        setSize(600, 600);
        setTitle("Casbah - Choix de la taille");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setControlChoixTaille(ActionListener listener) {
        choixTaillePanel.getButtonValider().addActionListener(listener);
        choixTaillePanel.getButtonArriere().addActionListener(listener);
    }

    public ChoixTaillePanel getChoixTaillePanel() {
        return choixTaillePanel;
    }

    /**
     * Créer la vue en créant les éléments et en les imbriquants l'un dan sles autres
     */
    private void createWidnet() throws IOException {
        setContentPane(choixTaillePanel);
    }

    /**
     * Rend la fenètre visible
     */
    public void display() {
        setVisible(true);
    }

    /**
     * Rend la fenetre non visible
     */
    public void undisplay() {
        setVisible(false);
    }

}
