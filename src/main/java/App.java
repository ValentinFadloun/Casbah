import controller.ControlGroup;

import java.io.IOException;

public class App {

    public static void main(String[] args){

        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                try {
                    ControlGroup control = new ControlGroup();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
