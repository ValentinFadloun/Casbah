package panel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class FondPanel extends JPanel{

    //Image de fond
    protected Image imageFond;

    public FondPanel(Image imageFond) throws IOException {
        this.imageFond = imageFond;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(imageFond, 0, 0, 600, 600, null);
    }

    public void paintComponent2(Graphics g) { g.drawImage(imageFond, 0, 0, 850, 600, null); }

    public void paintComponent3(Graphics g) { g.drawImage(imageFond, 0, 0, 600, 700, null); }

}