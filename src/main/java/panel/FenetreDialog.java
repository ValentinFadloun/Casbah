package panel;

import javax.swing.*;

public class FenetreDialog {

    private JFrame fenetre;
    private JOptionPane messageAvantDernier;
    private JOptionPane messageErreurPlacement;

    public FenetreDialog(JFrame fenetre) {
        this.fenetre = fenetre;
        messageAvantDernier = new JOptionPane();
    }

    public void showMessageAvantDernier() {
        messageAvantDernier.showMessageDialog(this.fenetre,
                "La tuile \"entré\" a automatiquement été donné au joueur qui devait piocher",
                "Information",
                JOptionPane.INFORMATION_MESSAGE
        );
        JDialog fenInfo = messageAvantDernier.createDialog(this.fenetre, "Information");
    }

    public void showMessageErreurPlacement() {
        messageErreurPlacement.showMessageDialog(this.fenetre,
                "La tuile à mal été placé,",
                "Erreur",
                JOptionPane.ERROR_MESSAGE
        );
        JDialog fenInfo = messageAvantDernier.createDialog(this.fenetre, "Erreur");
    }

}
