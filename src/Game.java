import javax.swing.*;

public class Game {

    JFrame gameFrame = new JFrame();
    JPanel gamePanel = new JPanel();

    Game(){
        this.gameFrame.setSize(1300, 1000);
        this.gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.gameFrame.setLayout(null);
        this.gameFrame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("icon.png");
        this.gameFrame.setIconImage(icon.getImage());
        this.gameFrame.setResizable(false);

        //this.gamePanel.setSize(800,800);
        //this.gamePanel.setBounds(250, 75,800,800);
        //this.gameFrame.add(gamePanel);
        //this.gamePanel.setBorder(BorderFactory.createEtchedBorder());




        this.gameFrame.setVisible(true);



    }
}
