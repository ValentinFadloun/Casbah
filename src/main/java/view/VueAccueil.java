package view;


import panel.AccueilPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VueAccueil extends JFrame{

    //Les panels
    private AccueilPanel fondPanel;

    public VueAccueil() throws IOException {
        fondPanel = new AccueilPanel(new ImageIcon("ressource/casbah.jpg").getImage());
        createWidnet();
        setSize(600, 600);
        setTitle("Casbah - Accueil");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Le controller ControlAccueil pourra gérer les évenements liés à ce bouton
     * @param listener
     */
    public void setControlAccueil(ActionListener listener){
        fondPanel.getAboutBouton().addActionListener(listener);
        fondPanel.getPlayBouton().addActionListener(listener);
    }

    public AccueilPanel getFondPanel() {
        return fondPanel;
    }

    /**
     * Créer la vue en créant les éléments et en les imbriquants l'un dan sles autres
     */
    private void createWidnet() throws IOException {
        setContentPane(fondPanel);
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
