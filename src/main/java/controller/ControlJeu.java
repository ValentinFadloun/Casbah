package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlJeu  implements ActionListener {

    private ControlGroup controlGroup;
    private ImageIcon img;
    private JButton button;
    private int indexJoueur;
    private JLabel indiqueJoueur;

    public ControlJeu(ControlGroup controlGroup) {
        this.controlGroup = controlGroup;
        img = null;
        button = null;
        indiqueJoueur = new JLabel("Joueur X");
        indexJoueur = 0;
    }

    public void setControl() {
        this.controlGroup.getVuePlateauJeu().setControl(this);
    }

    public JLabel getIndiqueJoueur() {
        return indiqueJoueur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        indexJoueur = controlGroup.getJeu().premierJoueur().getIndex();
        indiqueJoueur = new JLabel("Joueur " + indexJoueur);

        //choisir tuile dans la main
        for(int i = 0; i < controlGroup.getVuePlateauJeu().getMainPanel().getCpt(); i++) {
            if (e.getSource() == controlGroup.getVuePlateauJeu().getMainPanel().getButtonMain()[i]) {
                for(int y = 0; y < controlGroup.getVuePlateauJeu().getMainPanel().getCpt(); y++) {
                    controlGroup.getVuePlateauJeu().getMainPanel().getButtonMain()[y].setBorder(BorderFactory.createLineBorder(Color.RED, 0));
                }
                img = (ImageIcon) ((JButton)e.getSource()).getIcon();
                button = (JButton)e.getSource();
                controlGroup.getVuePlateauJeu().getMainPanel().getButtonMain()[i].setBorder(BorderFactory.createLineBorder(Color.RED, 5));
            }
        }

        // bouton tourner
        /*if (e.getSource() == controlGroup.getVuePlateauJeu().getMainPanel().getButtonTournerTuile()) {
            try {
                controlGroup.getVuePlateauJeu().undisplay();
                controlGroup.getVuePlateauJeu().getMainPanel().rotationImgTuile(img, button);
                controlGroup.getVuePlateauJeu().display(false);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }*/

        //placer tuile sur le plateau
        for(int x = 0; x < controlGroup.getVuePlateauJeu().getPlateauPanel().getButtonPlateau().length; x++) {
            for(int y = 0; y < controlGroup.getVuePlateauJeu().getPlateauPanel().getButtonPlateau()[0].length; y++) {
                if (e.getSource() ==  controlGroup.getVuePlateauJeu().getPlateauPanel().getButtonPlateau()[x][y]) {
                    controlGroup.getVuePlateauJeu().getPlateauPanel().getButtonPlateau()[x][y].setIcon(img);
                    controlGroup.getVuePlateauJeu().getPlateauPanel().getButtonPlateau()[x][y].removeActionListener(this);
                    button.setVisible(false);
                    img = new ImageIcon("ressource/fond_bouton.jpg");
                    //Joueur joueur = controlGroup.getJeu().getListJoueur().get(controlGroup.getVuePlateauJeu().getMainPanel().getJoueurIndex());
                    //joueur.removeTuile();
                    controlGroup.getVuePlateauJeu().getMainPanel().setJoueurIndex();
                    controlGroup.getVuePlateauJeu().getMainPanel().repaint();
                }
            }
        }

        indexJoueur++;
        if (indexJoueur >= controlGroup.getJeu().getListJoueur().size()) indexJoueur = 0;

    }
}
