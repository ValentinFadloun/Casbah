package view;

import panel.ChoixNbrPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VueChoixNbrJoueur extends JFrame{

    //Panel
    private ChoixNbrPanel choixNbrPanel;

    public VueChoixNbrJoueur() throws IOException {
        choixNbrPanel = new ChoixNbrPanel(new ImageIcon("ressource/casbah.jpg").getImage());
        createWidnet();
        setSize(600, 600);
        setTitle("Casbah - Choix du nombre de joueur");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Le controller ControlChoixNbrJoueur pourra gérer les évenements liés à ce bouton
     * @param listener
     */
    public void setControlNbrJoueur(ActionListener listener){
        choixNbrPanel.getButtonValider().addActionListener(listener);
        choixNbrPanel.getButtonArriere().addActionListener(listener);
    }


    public ChoixNbrPanel getChoixNbrPanel() {
        return choixNbrPanel;
    }

    /**
     * Créer la vue en créant les éléments et en les imbriquants l'un dan sles autres
     */
    private void createWidnet() throws IOException {

        setContentPane(choixNbrPanel);
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
