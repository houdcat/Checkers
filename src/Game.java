import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class Game {
    JFrame gameFrame = new JFrame("Checkers");
    JPanel gamePanel = new JPanel();
    Border border = new LineBorder(Color.BLACK, 3); // Border used for all buttons
    Board board = new Board(this);
    JLabel p1nameLabel = new JLabel();
    JLabel p2nameLabel = new JLabel();

    int p1pieces = 1;
    int p2pieces = 12;
    boolean p1winner = false;
    boolean p2winner = false;

    JLabel p1piecesLabel = new JLabel(p1pieces + "");
    JLabel p2piecesLabel = new JLabel(p2pieces + "");

    public void showEndScreen(){
        int answer = 0;
        if(p1winner){
            answer = JOptionPane.showConfirmDialog(gameFrame, "Would you like a rematch?", p1nameLabel.getText() + " wins!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        }else if(p2winner){
            answer = JOptionPane.showConfirmDialog(gameFrame, "Would you like a rematch?", p2nameLabel.getText() + " wins!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
        if(answer == 0){
            gameFrame.dispose();
            new Game(lobby);
        }else if(answer == 1){
            gameFrame.dispose();
            new Lobby();
        }
    }
    public void checkVictoryByElimination(){
        if(p1pieces == 0 || p2pieces == 0){
            if(p1pieces == 0){
                p2winner = true;
            }else if(p2pieces == 0){
                p1winner = true;
            }
            showEndScreen();
        }
    }

    Lobby lobby;

    boolean blueTurn = false;
    boolean hasSelected;
    int selectedx;
    int selectedy;
    ArrayList<Move> availableMoves = new ArrayList<>();

    Game(Lobby lobby) {
        this.lobby = lobby;

        this.gameFrame.setSize(1300, 1000);
        this.gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.gameFrame.setLayout(null);
        this.gameFrame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("icon.png");
        this.gameFrame.setIconImage(icon.getImage());
        this.gameFrame.setResizable(false);

        this.gamePanel.setBounds(250, 75, Board.BOARDSIZE * Board.TILESIZE, Board.BOARDSIZE * Board.TILESIZE);
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

        p1nameLabel.setText(lobby.p1name);
        p2nameLabel.setText(lobby.p2name);

        this.p1piecesLabel.setFont(new Font("Futura", Font.BOLD,40));
        this.p1piecesLabel.setBounds(1000,865,300,80);
        this.p1piecesLabel.setForeground(Color.RED);

        this.p2piecesLabel.setFont(new Font("Futura", Font.BOLD,40));
        this.p2piecesLabel.setBounds(1000,0,300,80);
        this.p2piecesLabel.setForeground(Color.BLUE);


        this.gameFrame.add(gamePanel);
        this.gameFrame.add(p1nameLabel);
        this.gameFrame.add(p2nameLabel);
        this.gameFrame.add(p1piecesLabel);
        this.gameFrame.add(p2piecesLabel);

        this.gameFrame.setVisible(true);

        if(lobby.p1.isTurn()){
            blueTurn = false;
        }
    }
}
