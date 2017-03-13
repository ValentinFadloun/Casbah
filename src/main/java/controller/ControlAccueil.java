package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlAccueil implements ActionListener {

    private ControlGroup controlGroup;

    public ControlAccueil(ControlGroup controlGroup) {
        this.controlGroup = controlGroup;
        this.controlGroup.getVueAccueil().setControlAccueil(this);
    }

    /**
     * Va appeler les pages par rapport au bouton cliqué
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == controlGroup.getVueAccueil().getFondPanel().getPlayBouton()) {
            controlGroup.getVueAccueil().undisplay();
            controlGroup.getVueChoixNbrJoueur().display();
        }

        if (e.getSource() == controlGroup.getVueAccueil().getFondPanel().getAboutBouton()) {
            ControlBrowser.displayURL("https://www.jeuxdenim.be/jeu-Casbah");
        }

    }

}
