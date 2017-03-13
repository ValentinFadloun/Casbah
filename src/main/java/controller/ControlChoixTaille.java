package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlChoixTaille implements ActionListener {

    private ControlGroup controlGroup;

    //Info pour le controlGroup.getJeu() et pour le test
    private String tailleString;
    private int hauteur;
    private int largeur;

    public ControlChoixTaille(ControlGroup controlGroup) {
        this.controlGroup = controlGroup;
        this.controlGroup.getVueChoixTaille().setControlChoixTaille(this);
    }

    public String getTailleString() {
        return tailleString;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == controlGroup.getVueChoixTaille().getChoixTaillePanel().getButtonValider()) {
            controlGroup.getVueChoixTaille().undisplay();
            for (int i = 0; i < controlGroup.getVueChoixTaille().getChoixTaillePanel().getListTaille().size(); i++) {
                if (controlGroup.getVueChoixTaille().getChoixTaillePanel().getRadioButtonSelect(i).isSelected()) {
                    tailleString = controlGroup.getVueChoixTaille().getChoixTaillePanel().getRadioButtonSelect(i).getText();
                    hauteur = Integer.parseInt(String.valueOf(tailleString.charAt(0)));
                    if (tailleString.length() == 3) largeur = Integer.parseInt(String.valueOf(tailleString.charAt(2)));
                    if (tailleString.length() == 4) largeur = Integer.parseInt(String.valueOf(tailleString.charAt(2)) + (String.valueOf(tailleString.charAt(3))));
                    controlGroup.getJeu().setTailleXCasbah(largeur);
                    controlGroup.getJeu().setTailleYCasbah(hauteur);
                    controlGroup.getVuePlateauJeu().getPlateauPanel().setHauteur(hauteur);
                    controlGroup.getVuePlateauJeu().getPlateauPanel().setLargeur(largeur);
                    controlGroup.getVuePlateauJeu().getPlateauPanel().setTabPlateau();
                    int nbrCarteEnMain = (hauteur * largeur) / controlGroup.getJeu().getTailleListJoueur();
                    controlGroup.getVuePlateauJeu().getMainPanel().setTabMain(nbrCarteEnMain);
                }
            }
            controlGroup.getVueChoixCarte().display();
        }

        if (e.getSource() == controlGroup.getVueChoixTaille().getChoixTaillePanel().getButtonArriere()) {
            controlGroup.getVueChoixTaille().undisplay();
            controlGroup.getVueChoixNbrJoueur().display();
        }

    }

}
