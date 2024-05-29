import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Game {

    JFrame gameFrame = new JFrame();
    JPanel gamePanel = new JPanel();
    Border border = new LineBorder(Color.BLACK, 3); // Border used for all buttons
    Board board = new Board();

    Game() {
        this.gameFrame.setSize(1300, 1000);
        this.gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.gameFrame.setLayout(null);
        this.gameFrame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("icon.png");
        this.gameFrame.setIconImage(icon.getImage());
        this.gameFrame.setResizable(false);

        this.gamePanel.setBounds(250, 75, 800, 800);
        this.gamePanel.setBorder(BorderFactory.createEtchedBorder());
        this.gamePanel.setLayout(new BorderLayout());
        this.gamePanel.setBorder(border);

        this.gamePanel.add(board);

        this.gameFrame.add(gamePanel);
        this.gameFrame.setVisible(true);
    }
}
