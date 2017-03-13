package panel;

import controller.ControlGroup;
import model.Joueur;
import model.Tuile;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

public class MainPanel extends FondPanel {

    //Titre
    private JLabel textJoueur;

    //Tableaux de bouton
    private JButton[] tabMain;

    private JButton buttonTournerTuile;

    //Panel pour structurer
    private JPanel panelTextJoueur;
    private JPanel panelTabMain;
    private JPanel panelGlobal;
    private Box panelGeneral;

    private ControlGroup controlGroup;
    private int joueurIndex;
    private int cpt;
    private int nbrCarteEnMain;

    public MainPanel(Image imageFond, ControlGroup controlGroup) throws IOException {
        super(imageFond);
        this.controlGroup = controlGroup;
        textJoueur = new JLabel("Joueur X");
        tabMain = new JButton[10];
        panelGlobal = new JPanel(new BorderLayout());
        buttonTournerTuile = new JButton(new ImageIcon("ressource/buttonTourne.png"));
        panelTabMain = new JPanel(new GridLayout(5, 5));
        panelTextJoueur = new JPanel();
        panelGeneral = Box.createHorizontalBox();
        cpt = 0;
        nbrCarteEnMain = 0;
    }

    public JButton getButtonTournerTuile() {
        return buttonTournerTuile;
    }

    public JButton[] getButtonMain() {
        return tabMain;
    }

    public int getJoueurIndex() {
        return joueurIndex;
    }

    public int getCpt() {
        return cpt;
    }

    public void setJoueurIndex() {
        this.joueurIndex++;
        System.out.println(joueurIndex);
    }

    public void setTabMain(int nbr) {
        this.nbrCarteEnMain = nbr;
        System.out.println("nbr = " + nbr);
        tabMain = new JButton[this.nbrCarteEnMain];
        for (int i = 0; i < tabMain.length; i++) {
            tabMain[i] = new JButton();
        }
        System.out.println(Arrays.toString(tabMain));
    }

    public void paintComponent(Graphics g) {

        super.paintComponent3(g);

        joueurIndex = controlGroup.getJeu().premierJoueur().getIndex();
        System.out.println("joueurIndex = " + joueurIndex);

        for (Joueur joueur : controlGroup.getJeu().getListJoueur()) {
            if (joueur.getIndex() == joueurIndex) {
                for (Tuile tuile : joueur.getCarteEnMain()) {
                    if (cpt >= nbrCarteEnMain) break;
                    tabMain[cpt].setPreferredSize(new Dimension(80, 80));
                    ImageIcon img = null;
                    if (tuile.getNom().equals("entre") || tuile.getNom().equals("salle"))
                        img = new ImageIcon("ressource/tuile/tuile_casbah_" + (tuile.getIndex() + 1) + ".jpg");
                    if (tuile.getNom().equals("jardin"))
                        img = new ImageIcon("ressource/tuile/tuile_jardin_" + (tuile.getIndex() - 39) + ".jpg");
                    tabMain[cpt].setIcon(img);
                    panelTabMain.add(tabMain[cpt]);
                    cpt++;
                }
            }
        }

        buttonTournerTuile.setPreferredSize(new Dimension(80, 80));

        textJoueur.setText("Joueur " + joueurIndex);

        panelTabMain.setOpaque(false);
        panelTextJoueur.add(textJoueur);
        panelTextJoueur.setOpaque(false);
        panelGlobal.add(panelTextJoueur, BorderLayout.NORTH);
        panelGlobal.add(panelTabMain, BorderLayout.CENTER);
        panelGlobal.add(buttonTournerTuile, BorderLayout.SOUTH);
        panelGlobal.setOpaque(false);
        panelGeneral.add(panelGlobal);
        add(panelGeneral);

    }

    public void rotationImgTuile(ImageIcon imageIcon, JButton button) throws IOException {
        Image img = imageIcon.getImage();
        System.out.println("img" + img);
        BufferedImage image = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_BYTE_INDEXED);
        AffineTransform transformer = new AffineTransform();
        transformer.rotate(Math.toRadians(90), image.getWidth() / 2, image.getHeight() / 2);
        AffineTransformOp op = new AffineTransformOp(transformer, AffineTransformOp.TYPE_BILINEAR);
        img = op.filter(image, null);
        ImageIcon imageIcon1 = new ImageIcon(image);
        System.out.println("imageIcon1" + imageIcon1);
        button.setIcon(imageIcon1);
        panelGeneral.repaint();
    }

}