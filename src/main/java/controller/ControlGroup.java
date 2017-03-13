package controller;

import model.Audio;
import model.Jeu;
import model.Joueur;
import model.Tuile;
import view.*;

import java.io.IOException;

public class ControlGroup {

    //Model
    private Jeu jeu;
    private Audio son;

    //Vue
    private VueAccueil vueAccueil;
    private VueChoixNbrJoueur vueChoixNbrJoueur;
    private VueChoixTaille vueChoixTaille;
    private VueChoixCarte vueChoixCarte;
    private VuePlateauJeu vuePlateauJeu;

    //Controller
    private ControlAccueil controlAccueil;
    private ControlChoixNbrJoueur controlChoixNbrJoueur;
    private ControlChoixTaille controlChoixTaille;
    private ControlChoixCarte controlChoixCarte;
    private ControlJeu controlJeu;

    public ControlGroup() throws IOException {

        jeu = new Jeu();
        son = new Audio();
        //son.start();

        //accueil
        vueAccueil = new VueAccueil();
        vueAccueil.display();
        controlAccueil = new ControlAccueil(this);

        //choix du nombre de joueur
        vueChoixNbrJoueur = new VueChoixNbrJoueur();
        controlChoixNbrJoueur = new ControlChoixNbrJoueur(this);

        // choix de la taille
        vueChoixTaille = new VueChoixTaille();
        controlChoixTaille = new ControlChoixTaille(this);

        //choisir ces cartes
        vueChoixCarte = new VueChoixCarte(this);
        controlChoixCarte = new ControlChoixCarte(this);

        //plateau
        vuePlateauJeu = new VuePlateauJeu(this);
        controlJeu = new ControlJeu(this);
    }

    public VueAccueil getVueAccueil() {
        return vueAccueil;
    }

    public VueChoixNbrJoueur getVueChoixNbrJoueur() {
        return vueChoixNbrJoueur;
    }

    public VueChoixTaille getVueChoixTaille() {
        return vueChoixTaille;
    }

    public VueChoixCarte getVueChoixCarte() {
        return vueChoixCarte;
    }

    public VuePlateauJeu getVuePlateauJeu() {
        return vuePlateauJeu;
    }

    public ControlAccueil getControlAccueil() {
        return controlAccueil;
    }

    public ControlChoixNbrJoueur getControlChoixNbrJoueur() {
        return controlChoixNbrJoueur;
    }

    public ControlChoixTaille getControlChoixTaille() {
        return controlChoixTaille;
    }

    public ControlChoixCarte getControlChoixCarte() {
        return controlChoixCarte;
    }

    public ControlJeu getControlJeu() {
        return controlJeu;
    }

    public Jeu getJeu() {
        return jeu;
    }

}
