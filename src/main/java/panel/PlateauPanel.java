package panel;

import controller.ControlGroup;
import model.Jeu;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PlateauPanel extends FondPanel {

    private Jeu jeu;

    //Tableaux de bouton
    private JButton[][] tabPlateau;

    //Panel pour structurer
    private JPanel panelTabPlateau;
    private Box panelGeneral;

    //taille
    private int largeur;
    private int hauteur;

    public PlateauPanel(Image imageFond, ControlGroup controlGroup) throws IOException {
        super(imageFond);
        System.out.println(controlGroup.getJeu());
        hauteur = 6;
        largeur = 6;
        tabPlateau = new JButton[hauteur][largeur];
        System.out.println("hauteur = " + hauteur + ", largeur = " + largeur);
        panelTabPlateau = new JPanel(new GridLayout(hauteur,largeur));
        panelGeneral = Box.createHorizontalBox();
    }

    public JButton[][] getButtonPlateau() {
        return tabPlateau;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
        System.out.println("largeur panel = "  +this.largeur);
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
        System.out.println("hauteur panel = " + this.hauteur);
    }

    public void setTabPlateau() {
        tabPlateau = new JButton[hauteur][largeur];
        for(int x = 0; x < hauteur; x++) {
            for (int y = 0; y < largeur; y++) {
                tabPlateau[x][y] = new JButton();
            }
        }
        panelTabPlateau = new JPanel(new GridLayout(hauteur,largeur));
    }

    public void paintComponent(Graphics g) {

        super.paintComponent2(g);

        for(int x = 0; x < hauteur; x++) {
            for(int y = 0; y < largeur; y++) {
                tabPlateau[x][y].setIcon(new ImageIcon("ressource/fond_bouton.jpg"));
                tabPlateau[x][y].setPreferredSize(new Dimension(60, 60));
                panelTabPlateau.add(tabPlateau[x][y]);
            }
        }

        panelGeneral.add(panelTabPlateau);
        add(panelGeneral);

    }

}
