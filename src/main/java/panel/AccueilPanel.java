package panel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AccueilPanel extends FondPanel {

    //Les boutons
    private JButton playBouton;
    private JButton aboutBouton;

    public AccueilPanel(Image imageFond) throws IOException {
        super(imageFond);
        conceptionButton();
    }

    public JButton getPlayBouton() {
        return playBouton;
    }

    public JButton getAboutBouton() {
        return aboutBouton;
    }

    /**
     * Va styliser les boutons
     */
    public void conceptionButton() {

        ImageIcon img = new ImageIcon("ressource/fond_bouton.jpg");

        playBouton = new JButton();
        playBouton.setText("Jouer");
        playBouton.setIcon(img);
        playBouton.setVerticalTextPosition(SwingConstants.CENTER);
        playBouton.setHorizontalTextPosition(SwingConstants.CENTER);
        playBouton.setPreferredSize(new Dimension(90, 30));

        aboutBouton = new JButton();
        aboutBouton.setText("A propos");
        aboutBouton.setIcon(img);
        aboutBouton.setVerticalTextPosition(SwingConstants.CENTER);
        aboutBouton.setHorizontalTextPosition(SwingConstants.CENTER);
        aboutBouton.setPreferredSize(new Dimension(90, 30));

    }

    /**
     * Ajoute les boutons au panel
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        add(playBouton);
        add(aboutBouton);
    }

}
