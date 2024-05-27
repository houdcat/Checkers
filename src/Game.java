import javax.swing.*;

public class Game {

    JFrame gameFrame = new JFrame();

    Game(){
        this.gameFrame.setSize(1500, 1000);
        this.gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.gameFrame.setLayout(null);
        this.gameFrame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("icon.png");
        this.gameFrame.setIconImage(icon.getImage());
        this.gameFrame.setResizable(false);

        this.gameFrame.setVisible(true);



    }
}
