package controller;

import model.Joueur;
import model.Tuile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static model.Tuile.DOUBLE_PORTE;
import static model.Tuile.PORTE;

public class ControlChoixCarte implements ActionListener {

    private ControlGroup controlGroup;
    private int indexJoueur;
    private int cptTuilePrise;
    private JLabel textIndiqueJoueur;
    private JLabel textNombreTuileRestante;

    public ControlChoixCarte(ControlGroup controlGroup) {
        this.controlGroup = controlGroup;
        this.controlGroup.getVueChoixCarte().setControlChoixTaille(this);
        textIndiqueJoueur = new JLabel("Choisissez vos carte : joueur n°1");
        textNombreTuileRestante = new JLabel("Nombre de tuiles à prendre : ?");;
        indexJoueur = 0;
        cptTuilePrise = 0;
    }

    public int getIndexJoueur() {
        return indexJoueur;
    }

    public int getCptTuilePrise() {
        return cptTuilePrise;
    }

    public JLabel getTextIndiqueJoueur() {
        return textIndiqueJoueur;
    }

    public JLabel getTextNombreTuileRestante() {
        return textNombreTuileRestante;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int  nbrTuileAPrendre = this.controlGroup.getJeu().getTailleXCasbah() * this.controlGroup.getJeu().getTailleYCasbah();

        for (int i = 0; i < 45; i++) {

            textIndiqueJoueur.setText("Choisissez vos carte : joueur n°" + (indexJoueur + 1));
            textNombreTuileRestante.setText("Nombre de tuiles à prendre : " + (nbrTuileAPrendre - cptTuilePrise));

            if (e.getSource() == controlGroup.getVueChoixCarte().getChoixCartePanel().getButtonCarte()[i]) {

                //faire disparaitre les boutons
                controlGroup.getVueChoixCarte().getChoixCartePanel().getButtonCarte()[i].setVisible(false);

                //les joueurs obtiennes leurs tuiles
                for (Joueur joueur : controlGroup.getJeu().getListJoueur()) {
                    if (indexJoueur == controlGroup.getJeu().getListJoueur().indexOf(joueur)) {
                        String nom = controlGroup.getJeu().getTuile(i).getNom();
                        String visu = controlGroup.getJeu().getTuile(i).getVisu();
                        int index = controlGroup.getJeu().getTuile(i).getIndex();
                        int point = controlGroup.getJeu().getTuile(i).getPoint();
                        int[] tabCote = new int[4];
                        for (int k = 0; k < controlGroup.getJeu().getTuile(i).getCote().length; k++) {
                            tabCote[k] = controlGroup.getJeu().getTuile(i).getCote()[k];
                        }
                        joueur.choixTuile(new Tuile(nom, visu, index, tabCote, point));
                    }
                }

                indexJoueur++;
                if (indexJoueur >= controlGroup.getJeu().getListJoueur().size()) indexJoueur = 0;
                cptTuilePrise++;

                /*vérifier si la tuile entré (index = 1) est déjà prise
                  si c'est le cas tout va bien, sinon le dernier joueur la prend automatiquement
                 */
                if (cptTuilePrise == nbrTuileAPrendre - 1) {

                    int cptCarte = 0;
                    for (Joueur joueur : controlGroup.getJeu().getListJoueur()) {
                        for(Tuile tuile : joueur.getCarteEnMain()){
                            if (tuile.getIndex() != 1) cptCarte++;
                        }
                    }

                    if (cptCarte == nbrTuileAPrendre - 1) {
                        controlGroup.getVueChoixCarte().getChoixCartePanel().getButtonCarte()[1].setVisible(false);
                        for (Joueur joueur : controlGroup.getJeu().getListJoueur()) {
                            if (indexJoueur == controlGroup.getJeu().getListJoueur().indexOf(joueur)) {
                                joueur.choixTuile(new Tuile("entre", "tuile_casbah_2.jpg", 1, new int[]{PORTE, PORTE, DOUBLE_PORTE, PORTE}, 1));
                            }
                        }
                        controlGroup.getVueChoixCarte().undisplay();
                        controlGroup.getControlJeu().setControl();
                        controlGroup.getVuePlateauJeu().display(true);
                    }

                }

                if (cptTuilePrise >= nbrTuileAPrendre) {
                    controlGroup.getVueChoixCarte().undisplay();
                    controlGroup.getControlJeu().setControl();
                    controlGroup.getVuePlateauJeu().display(false);
                }

            }
        }

    }
}
