package controller;



import model.Joueur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ControlChoixNbrJoueur implements ActionListener{

    private int nbrJoueur;
    private List<String> listTaillePlateau;
    private ControlGroup controlGroup;

    public ControlChoixNbrJoueur(ControlGroup controlGroup)  {
        this.controlGroup = controlGroup;
        this.controlGroup.getVueChoixNbrJoueur().setControlNbrJoueur(this);
        listTaillePlateau = new ArrayList<>();
    }

    public int getNbrJoueur() {
        return nbrJoueur;
    }

    public List<String> getListTaillePlateau() {
        return listTaillePlateau;
    }

    /**
     * Permet de connaitre les nombre de joueur
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == controlGroup.getVueChoixNbrJoueur().getChoixNbrPanel().getButtonValider()) {
            if (controlGroup.getVueChoixNbrJoueur().getChoixNbrPanel().getButtonDeuxJoueurs().isSelected())  nbrJoueur = 2;
            if (controlGroup.getVueChoixNbrJoueur().getChoixNbrPanel().getButtonTroisJoueurs().isSelected())  nbrJoueur = 3;
            if (controlGroup.getVueChoixNbrJoueur().getChoixNbrPanel().getButtonQuatreJoueurs().isSelected())  nbrJoueur = 4;
            controlGroup.getVueChoixNbrJoueur().undisplay();
            controlGroup.getVueChoixTaille().getChoixTaillePanel().setListTaille(remplirListe());
            for (int i = 0; i < nbrJoueur; i++) {
                String nameJoueur = "joueur" + String.valueOf(i + 1);
                controlGroup.getJeu().addJoueur(new Joueur(nameJoueur, (i + 1)));
            }
            controlGroup.getVueChoixTaille().display();
        }

        if (e.getSource() == controlGroup.getVueChoixNbrJoueur().getChoixNbrPanel().getButtonArriere()) {
            controlGroup.getVueChoixNbrJoueur().undisplay();
            controlGroup.getVueAccueil().display();
        }

    }

    /**
     * Permet de remplir la liste des tailles du plateau possible par rapport aux nbr de joueurs
     */
    private ArrayList<String> remplirListe() {
        if (nbrJoueur == 2) {
            listTaillePlateau.add("6x6");
            listTaillePlateau.add("6x7");
            listTaillePlateau.add("5x8");
            listTaillePlateau.add("4x9");
            listTaillePlateau.add("4x10");
            listTaillePlateau.add("4x11");
        } else if (nbrJoueur == 3) {
            listTaillePlateau.add("6x6");
            listTaillePlateau.add("6x7");
            listTaillePlateau.add("5x9");
            listTaillePlateau.add("4x9");
        } else if (nbrJoueur == 4) {
            listTaillePlateau.add("6x6");
            listTaillePlateau.add("5x8");
            listTaillePlateau.add("4x9");
            listTaillePlateau.add("4x10");
            listTaillePlateau.add("4x11");
        }
        return (ArrayList<String>) listTaillePlateau;
    }
}
