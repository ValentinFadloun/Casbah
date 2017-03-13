package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static model.Tuile.*;

public class Jeu {

    private List<Joueur> listJoueur;
    private List<Tuile> paquetDeJeu;
    private int tailleXCasbah;
    private int tailleYCasbah;

    public Jeu() {
        listJoueur = new ArrayList<>();
        paquetDeJeu = new ArrayList<>();
        remplirPaquet();
    }

    public int getTailleXCasbah() {
        return tailleXCasbah;
    }

    public void setTailleXCasbah(int tailleXCasbah) {
        this.tailleXCasbah = tailleXCasbah;
    }

    public int getTailleYCasbah() {
        return tailleYCasbah;
    }

    public void setTailleYCasbah(int tailleYCasbah) {
        this.tailleYCasbah = tailleYCasbah;
    }

    public List<Joueur> getListJoueur() {
        return listJoueur;
    }

    public void setListJoueur(List<Joueur> listJoueur) {
        this.listJoueur = listJoueur;
    }

    public int getTailleListJoueur() {
        return listJoueur.size();
    }

    public int getTaillePaquetDeJeu() {
        return paquetDeJeu.size();
    }

    public List<Tuile> getPaquet() {
        return paquetDeJeu;
    }

    public Tuile getTuile(int index) {
        return paquetDeJeu.get(index);
    }

    public void addTuileInPaquet(Tuile tuile) {
        paquetDeJeu.add(tuile);
    }

    public void addJoueur(Joueur joueur) {
        listJoueur.add(joueur);
    }

    public void remplirPaquet() {
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_1.jpg", 0, new int[]{PORTE, FENETRE, FENETRE, PORTE}, 1));
        addTuileInPaquet(new Tuile("entre", "tuile_casbah_2.jpg", 1, new int[]{PORTE, PORTE, DOUBLE_PORTE, PORTE}, 1));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_3.jpg", 2, new int[]{PORTE, PORTE, FENETRE, PORTE}, 1));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_4.jpg", 3, new int[]{RIEN, PORTE, FENETRE, PORTE}, 1));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_5.jpg", 4, new int[]{FENETRE, PORTE, FENETRE, FENETRE}, 2));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_6.jpg", 5, new int[]{RIEN, FENETRE, PORTE, PORTE}, 2));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_7.jpg", 6, new int[]{FENETRE, PORTE, PORTE, PORTE}, 2));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_8.jpg", 7, new int[]{PORTE, PORTE, PORTE, PORTE}, 2));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_9.jpg", 8, new int[]{FENETRE, PORTE, RIEN, FENETRE}, 3));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_10.jpg", 9, new int[]{PORTE, FENETRE, RIEN, PORTE}, 3));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_11.jpg", 10, new int[]{PORTE, FENETRE, PORTE, FENETRE}, 3));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_12.jpg", 11, new int[]{FENETRE, FENETRE, FENETRE, FENETRE}, 3));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_13.jpg", 12, new int[]{PORTE, FENETRE, PORTE, RIEN}, 4));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_14.jpg", 13, new int[]{FENETRE, RIEN, FENETRE, PORTE}, 4));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_15.jpg", 14, new int[]{RIEN, PORTE, PORTE, PORTE}, 4));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_16.jpg", 15, new int[]{RIEN, PORTE, FENETRE, FENETRE}, 4));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_17.jpg", 16, new int[]{PORTE, FENETRE, PORTE, FENETRE}, 5));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_18.jpg", 17, new int[]{PORTE, FENETRE, RIEN, RIEN}, 5));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_19.jpg", 18, new int[]{PORTE, RIEN, RIEN, PORTE}, 5));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_20.jpg", 19, new int[]{PORTE, PORTE, FENETRE, FENETRE}, 5));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_21.jpg", 20, new int[]{RIEN, FENETRE, PORTE, RIEN}, 6));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_22.jpg", 21, new int[]{PORTE, RIEN, FENETRE, RIEN}, 6));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_23.jpg", 22, new int[]{PORTE, RIEN, PORTE, RIEN}, 6));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_24.jpg", 23, new int[]{RIEN, RIEN, PORTE, RIEN}, 6));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_25.jpg", 24, new int[]{RIEN, RIEN, PORTE, FENETRE}, 7));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_26.jpg", 25, new int[]{RIEN, FENETRE, RIEN, PORTE}, 7));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_27.jpg", 26, new int[]{PORTE, PORTE, PORTE, RIEN}, 7));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_28.jpg", 27, new int[]{RIEN, RIEN, PORTE, PORTE}, 8));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_29.jpg", 28, new int[]{RIEN, PORTE, RIEN, PORTE}, 8));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_30.jpg", 29, new int[]{PORTE, PORTE, RIEN, FENETRE}, 8));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_31.jpg", 30, new int[]{PORTE, FENETRE, RIEN, PORTE}, 9));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_32.jpg", 31, new int[]{PORTE, PORTE, PORTE, PORTE}, 9));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_33.jpg", 32, new int[]{RIEN, PORTE, RIEN, PORTE}, 9));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_34.jpg", 33, new int[]{RIEN, PORTE, RIEN, RIEN}, 10));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_35.jpg", 34, new int[]{PORTE, RIEN, PORTE, FENETRE}, 10));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_36.jpg", 35, new int[]{FENETRE, FENETRE, PORTE, RIEN}, 11));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_37.jpg", 36, new int[]{FENETRE, RIEN, PORTE, PORTE}, 11));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_38.jpg", 37, new int[]{FENETRE, PORTE, RIEN, PORTE}, 12));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_39.jpg", 38, new int[]{FENETRE, PORTE, RIEN, RIEN}, 14));
        addTuileInPaquet(new Tuile("salle", "tuile_casbah_40.jpg", 39, new int[]{FENETRE, RIEN, PORTE, FENETRE}, 15));
        addTuileInPaquet(new Tuile("jardin", "tuile_jardin_1.jpg", 40, new int[]{JARDIN, JARDIN, JARDIN, JARDIN}, 1));
        addTuileInPaquet(new Tuile("jardin", "tuile_jardin_2.jpg", 41, new int[]{JARDIN, JARDIN, JARDIN, JARDIN}, 1));
        addTuileInPaquet(new Tuile("jardin", "tuile_jardin_3.jpg", 42, new int[]{JARDIN, JARDIN, JARDIN, JARDIN}, 2));
        addTuileInPaquet(new Tuile("jardin", "tuile_jardin_4.jpg", 43, new int[]{JARDIN, JARDIN, JARDIN, JARDIN}, 2));
        addTuileInPaquet(new Tuile("jardin", "tuile_jardin_5.jpg", 44, new int[]{JARDIN, JARDIN, JARDIN, JARDIN}, 3));
    }
    
    public Joueur premierJoueur(){
        for (Joueur joueur: listJoueur){
            for (Tuile tuile: joueur.getCarteEnMain()){
                if (Objects.equals(tuile.getNom(), "entre")){
                    return joueur;
                }
            }
        }
        return null;
    }

    public void selectionCarte() {
        int indexCarte = 0;
        for (Joueur joueur: listJoueur) {
            while(joueur.getCarteEnMain().size() < (tailleXCasbah * tailleYCasbah) / listJoueur.size()) {
                Tuile tuile = getTuile(indexCarte);
                joueur.choixTuile(tuile);
                paquetDeJeu.remove(tuile);
            }
            indexCarte++;
        }
    }

}
