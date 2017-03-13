package panel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ChoixNbrPanel extends FondPanel {

    //Label
    private JLabel text;

    //Groupe de boutons
    private ButtonGroup buttonGroupchoixNbrJoueur;

    //RadioButton pour le choix du nombre de joueurs
    private JRadioButton buttonDeuxJoueurs;
    private JRadioButton buttonTroisJoueurs;
    private JRadioButton buttonQuatreJoueurs;

    //Bouton pour valider avec son panel
    private JButton buttonValider;
    private JButton buttonArriere;
    private JPanel panelBoutonValider;

    //Panel pour structurer
    private JPanel panelText;
    private JPanel panelBouton;
    private JPanel panelTextButton;
    private JPanel panelGeneral;

    public ChoixNbrPanel(Image imageFond) throws IOException {
        super(imageFond);
        text = new JLabel("Choisissez le nombre de joueurs");
        buttonGroupchoixNbrJoueur = new ButtonGroup();
        buttonDeuxJoueurs = new JRadioButton("2", true);
        buttonTroisJoueurs = new JRadioButton("3", false);
        buttonQuatreJoueurs = new JRadioButton("4", false);
        buttonValider = new JButton();
        buttonArriere = new JButton();
        panelText = new JPanel();
        panelBouton = new JPanel();
        panelBoutonValider = new JPanel();
        panelTextButton = new JPanel(new BorderLayout());
        panelGeneral = new JPanel(new BorderLayout());
        panelGeneral.setPreferredSize(new Dimension(300,100));

    }

    public JRadioButton getButtonDeuxJoueurs() {
        return buttonDeuxJoueurs;
    }

    public JRadioButton getButtonTroisJoueurs() {
        return buttonTroisJoueurs;
    }

    public JRadioButton getButtonQuatreJoueurs() {
        return buttonQuatreJoueurs;
    }

    public JButton getButtonValider() {
        return buttonValider;
    }

    public JButton getButtonArriere() {
        return buttonArriere;
    }

    /**
     * Met les 3 boutons pour choisir le nbr de joueur ensemble
     * Ainsi il ne peut y avoir q'un seul bouton de sélectionné
     */
    private void buttonGroup() {
        buttonGroupchoixNbrJoueur.add(buttonDeuxJoueurs);
        buttonGroupchoixNbrJoueur.add(buttonTroisJoueurs);
        buttonGroupchoixNbrJoueur.add(buttonQuatreJoueurs);
    }

    /**
     * Va styliser les boutons
     */
    private void conceptionButton() {

        ImageIcon img1 = new ImageIcon("ressource/fond_bouton.jpg");
        buttonValider.setText("Suivant");
        buttonValider.setIcon(img1);
        buttonValider.setVerticalTextPosition(SwingConstants.CENTER);
        buttonValider.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonValider.setPreferredSize(new Dimension(90, 30));

        ImageIcon img2 = new ImageIcon("ressource/arriere_bouton.jpg");
        buttonArriere.setText("Retour");
        buttonArriere.setBackground(Color.white);
        buttonArriere.setIcon(img2);
        buttonArriere.setPreferredSize(new Dimension(90, 30));

    }

    /**
     * Place les éléments dans le label
     * @param g
     */
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        buttonGroup();
        conceptionButton();

        panelText.add(text);

        panelBouton.add(buttonDeuxJoueurs);
        panelBouton.add(buttonTroisJoueurs);
        panelBouton.add(buttonQuatreJoueurs);

        panelBoutonValider.add(buttonValider);
        panelBoutonValider.add(buttonArriere);

        panelTextButton.add(panelText, BorderLayout.NORTH);
        panelTextButton.add(panelBouton, BorderLayout.CENTER);
        panelTextButton.add(panelBoutonValider, BorderLayout.SOUTH);

        panelGeneral.add(panelTextButton);
        add(panelGeneral);

    }

}
