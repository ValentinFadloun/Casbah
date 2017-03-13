package view;

import controller.ControlGroup;
import panel.ChoixCartePanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VueChoixCarte extends JFrame{

    private ChoixCartePanel choixCartePanel;

    public VueChoixCarte(ControlGroup controlGroup) throws IOException {
        choixCartePanel = new ChoixCartePanel(new ImageIcon("ressource/fond_sable.jpg").getImage(), controlGroup);
        createWidnet();
        setSize(850, 600);
        setTitle("Casbah - Choix des cartes");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setControlChoixTaille(ActionListener listener) {
        for(int i = 0; i < 45; i++) {
            choixCartePanel.getButtonCarte()[i].addActionListener(listener);
        }
    }

    public ChoixCartePanel getChoixCartePanel() {
        return choixCartePanel;
    }

    /**
     * Créer la vue en créant les éléments et en les imbriquants l'un dan sles autres
     */
    private void createWidnet() throws IOException {
        setContentPane(choixCartePanel);
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

    public void removeTuile(int index) {
        choixCartePanel.remove(choixCartePanel.getButtonCarte()[index]);
    }

}
