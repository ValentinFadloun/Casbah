package panel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChoixTaillePanel extends FondPanel {

    //Groupe de bouton
    private ButtonGroup buttonGroupChoixTaille;
    private List<JRadioButton> listTaille;

    //RadioButton pour faire le choix de la taille du plateau
    private JRadioButton choixTaille;

    //Label
    private JLabel text;

    //Button pour valider avec son panel
    private JButton buttonValider;
    private JButton buttonArriere;
    private JPanel panelBoutonValider;

    //Panel pour structurer
    private JPanel panelText;
    private JPanel panelBouton;
    private JPanel panelTextButton;
    private Box panelGeneral;

    public ChoixTaillePanel(Image imageFond) throws IOException {

        super(imageFond);
        buttonGroupChoixTaille = new ButtonGroup();
        listTaille = new ArrayList<>();

        text = new JLabel("Choisissez la taille de la casbah");
        buttonValider = new JButton();
        buttonArriere = new JButton();

        panelText = new JPanel();
        panelBouton = new JPanel();
        panelBoutonValider = new JPanel();
        panelTextButton = new JPanel(new BorderLayout());
        panelGeneral = Box.createVerticalBox();
        panelGeneral.setPreferredSize(new Dimension(300,100));

    }

    public void setListTaille(ArrayList<String> listTaille) {
        for (int i = 0; i < listTaille.size(); i++) {
            if (i == 0) this.listTaille.add(new JRadioButton(listTaille.get(i), true));
            else this.listTaille.add(new JRadioButton(listTaille.get(i), false));
        }
    }

    public JButton getButtonValider() {
        return buttonValider;
    }

    public JButton getButtonArriere() {
        return buttonArriere;
    }

    public List<JRadioButton> getListTaille() {
        return listTaille;
    }

    public JRadioButton getRadioButtonSelect(int i) {
        return listTaille.get(i);
    }

    /**
     * Mes les boutons du choix de la taille ensemble
     * Ainsi il ne peut y avoir qu'un seul bouton de sélectionné
     */
    private void buttonGroup() {
        for (int i = 0; i < listTaille.size(); i++) {
            buttonGroupChoixTaille.add(listTaille.get(i));
        }
    }

    /**
     * Va styliser les boutons
     */
    private void conceptionButton() {

        ImageIcon img = new ImageIcon("ressource/fond_bouton.jpg");
        buttonValider.setText("Suivant");
        buttonValider.setIcon(img);
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

        System.out.println(listTaille.size());

        for (int i = 0; i < listTaille.size(); i++) {
            panelBouton.add(listTaille.get(i));
        }

        panelBoutonValider.add(buttonValider);
        panelBoutonValider.add(buttonArriere);

        panelTextButton.add(panelText, BorderLayout.NORTH);
        panelTextButton.add(panelBouton, BorderLayout.CENTER);
        panelTextButton.add(panelBoutonValider, BorderLayout.SOUTH);

        panelGeneral.add(panelTextButton);
        add(panelGeneral);

    }

}
