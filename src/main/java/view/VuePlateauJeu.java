package view;

import controller.ControlGroup;
import panel.FenetreDialog;
import panel.MainPanel;
import panel.PlateauPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VuePlateauJeu extends JFrame {

    private PlateauPanel plateauPanel;
    private MainPanel mainPanel;
    private JPanel jeuPanel;
    private ControlGroup controlGroup;
    private int hauteur;
    private int largeur;

    public VuePlateauJeu(ControlGroup controlGroup) throws IOException {
        this.controlGroup = controlGroup;
        System.out.println(controlGroup.getJeu());
        hauteur = controlGroup.getJeu().getTailleXCasbah();
        largeur = controlGroup.getJeu().getTailleYCasbah();
        plateauPanel = new PlateauPanel(new ImageIcon("ressource/fond_sable.jpg").getImage(), controlGroup);
        plateauPanel.setLargeur(largeur);
        plateauPanel.setHauteur(hauteur);
        mainPanel = new MainPanel(new ImageIcon("ressource/fond_sable.jpg").getImage(), controlGroup);
        jeuPanel = new JPanel(new GridBagLayout());
        createWidnet();
        setSize(1300, 700);
        setTitle("Casbah - Plateau de jeu");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public PlateauPanel getPlateauPanel() {
        return plateauPanel;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setControl(ActionListener listener) {

        mainPanel.getButtonTournerTuile().addActionListener(listener);

        for(int i = 0; i < mainPanel.getButtonMain().length; i++) {
            mainPanel.getButtonMain()[i].addActionListener(listener);
        }

        for(int x = 0; x < plateauPanel.getButtonPlateau().length; x++) {
            for (int y = 0; y < plateauPanel.getButtonPlateau()[0].length; y++) {
                plateauPanel.getButtonPlateau()[x][y].addActionListener(listener);
            }
        }

    }

    /**
     * Créer la vue en créant les éléments et en les imbriquants l'un dan sles autres
     */
    private void createWidnet() throws IOException {

        /* On ajoute un gridbagLauout au panel */
        plateauPanel.setLayout(new GridLayout());

        /* Le gridBagConstraints va définir la position et la taille des éléments */
        GridBagConstraints gbc = new GridBagConstraints();

        /* le parametre fill sert à définir comment le composant sera rempli GridBagConstraints.BOTH permet d'occuper tout l'espace                 disponible
		 * horizontalement et verticalement GridBagConstraints.HORIZONTAL maximise horizontalement GridBagConstraints.VERTICAL maximise                 verticalement
		 */
        gbc.fill = GridBagConstraints.BOTH;

        /* insets définir la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */
        //gbc.insets = new Insets(5, 5, 5, 5);

        /* ipady permet de savoir où on place le composant s'il n'occupe pas la totalité de l'espace disponnible */
        gbc.ipady = gbc.anchor = GridBagConstraints.CENTER;

        /* weightx définit le nombre de cases en abscisse */
        gbc.weightx = 3;

		/* weightx définit le nombre de cases en ordonnée */
        gbc.weighty = 1;

        /* On ajoute le composant au panel en précisant le GridBagConstraints */
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        jeuPanel.add(plateauPanel, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        jeuPanel.add(mainPanel, gbc);

        setContentPane(jeuPanel);

    }

    /**
     * Rend la fenètre visible
     */
    public void display(boolean avantDernier) {
        setVisible(true);
        if(avantDernier) {
            System.out.println("message");
            FenetreDialog fd = new FenetreDialog(this);
            fd.showMessageAvantDernier();
        }
    }

    /**
     * Rend la fenetre non visible
     */
    public void undisplay() {
        setVisible(false);
    }

}
