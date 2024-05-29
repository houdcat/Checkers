import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Game {
    JFrame gameFrame = new JFrame();
    JPanel gamePanel = new JPanel();
    Border border = new LineBorder(Color.BLACK, 3); // Border used for all buttons
    Board board = new Board();
    JLabel p1nameLabel = new JLabel();
    JLabel p2nameLabel = new JLabel();
    JLabel p1piecesLabel = new JLabel();
    JLabel p2piecesLabel = new JLabel();

    public void setVisiblePlayerNames(String p1name, String p2name){
        p1nameLabel.setText(p1name);
        p2nameLabel.setText(p2name);
    }
    public void setVisiblePiecesCounts(int p1pieces, int p2pieces){
        p1piecesLabel.setText(p1pieces + "");
        p2piecesLabel.setText(p1pieces + "");
    }


    public void checkPiecesCount(int p1pieces, int p2pieces){
        if(p1pieces == 0){

        }
    }

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


        this.p1nameLabel.setFont(new Font("Futura", Font.BOLD,40));
        this.p1nameLabel.setBounds(250,865,300,80);
        this.p1nameLabel.setForeground(Color.RED);

        this.p2nameLabel.setFont(new Font("Futura", Font.BOLD,40));
        this.p2nameLabel.setBounds(250,0,300,80);
        this.p2nameLabel.setForeground(Color.BLUE);


        this.gameFrame.add(gamePanel);
        this.gameFrame.add(p1nameLabel);
        this.gameFrame.add(p2nameLabel);

        this.gameFrame.setVisible(true);
    }
}
