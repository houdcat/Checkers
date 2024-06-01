import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**Lets the users change game settings*/
public class Lobby implements ActionListener {
    /** JFrame for Game Settings menu/lobby*/
    private JFrame lobbyFrame = new JFrame("Checkers");
    /** Button to choose the name of Player 1*/
    private JButton player1button = new JButton("Choose Name");
    /** Button to choose the name of Player 2*/
    private JButton player2button = new JButton("Choose Name");
    /** Title of the section*/
    private JLabel gameSettings = new JLabel("Game Settings");
    /** Red label*/
    private JLabel red = new JLabel("Red");
    /** Blue label*/
    private JLabel blue = new JLabel("Blue");
    /** Border used for all buttons*/
    private Border border = new LineBorder(Color.BLACK, 3);
    /** Checkbox for first turn for player 1*/
    private JRadioButton player1checkbox = new JRadioButton ();
    /**  Checkbox for first turn for player 2*/
    private JRadioButton  player2checkbox = new JRadioButton ();
    /** Button group for radio buttons used to pick the first turn, so that only one may be picked*/
    private ButtonGroup turnChoice = new ButtonGroup();
    /** Label indicating that Player 1 will be starting*/
    private JLabel player1turn = new JLabel("First turn");
    /** Label indicating that Player 2 will be starting*/
    private JLabel player2turn = new JLabel("First turn");
    /** Button to exit back to menu*/
    private JButton backButton = new JButton("Back");
    /** Starts the game*/
    private JButton startButton = new JButton("Start Game");
    /** Decides the first turn by random*/
    private JButton coinflipButton = new JButton("Decide first turn randomly");
    /** Used for deciding the first turn randomly*/
    private Random r = new Random();


    Player p1 = new Player("", false);
    Player p2 = new Player("", false);

    /** Name of player 1*/
    String p1name = "Player 1";
    /** Name of player 2*/
    String p2name = "Player 2";

    /** Image for the unchecked box for player turns*/
    ImageIcon emptyCircle = new ImageIcon(new ImageIcon("src\\Images\\empty_circle.png").getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
    /** Image for the checked box for player turns*/
    ImageIcon fullCircle = new ImageIcon(new ImageIcon("src\\Images\\full_circle.png").getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));;

    Lobby(){
        this.lobbyFrame.setSize(750, 750);
        this.lobbyFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.lobbyFrame.setLayout(null);
        this.lobbyFrame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("src\\Images\\icon.png");
        this.lobbyFrame.setIconImage(icon.getImage());
        this.lobbyFrame.setResizable(false);

        this.gameSettings.setFont(new Font("Futura", Font.BOLD,72));
        this.gameSettings.setForeground(Color.BLACK);
        this.gameSettings.setBounds(0,0,750,150);
        this.gameSettings.setHorizontalAlignment(SwingConstants.CENTER);

        this.red.setFont(new Font("Futura", Font.BOLD,40));
        this.red.setBounds(40,100,150,150);
        this.red.setForeground(Color.RED);

        this.blue.setFont(new Font("Futura", Font.BOLD,40));
        this.blue.setBounds(40,170,150,150);
        this.blue.setForeground(Color.BLUE);

        this.player1button.setBounds(160,150,300,50);
        this.player1button.setBorder(BorderFactory.createEtchedBorder());
        this.player1button.setBackground(Color.white);
        this.player1button.setFocusable(false);
        this.player1button.setBorder(border);
        this.player1button.setFont(new Font("Futura", Font.BOLD, 25));
        this.player1button.addActionListener(this);

        this.player2button.setBounds(160,220,300,50);
        this.player2button.setBorder(BorderFactory.createEtchedBorder());
        this.player2button.setBackground(Color.white);
        this.player2button.setFocusable(false);
        this.player2button.setBorder(border);
        this.player2button.setFont(new Font("Futura", Font.BOLD, 25));
        this.player2button.addActionListener(this);

        this.turnChoice.add(player1checkbox);
        this.turnChoice.add(player2checkbox);

        this.player1checkbox.setBounds(470,150,50,50);
        this.player1checkbox.setIcon(emptyCircle);
        this.player1checkbox.setSelectedIcon(fullCircle);
        this.player1checkbox.setSelected(true);
        this.player1checkbox.addActionListener(this);

        this.player2checkbox.setBounds(470,220,50,50);
        this.player2checkbox.setIcon(emptyCircle);
        this.player2checkbox.setSelectedIcon(fullCircle);
        this.player2checkbox.addActionListener(this);

        this.player1turn.setBounds(540,150,200,50);
        this.player1turn.setFont(new Font("Futura", Font.BOLD, 25));

        this.player2turn.setBounds(540,220,200,50);
        this.player2turn.setFont(new Font("Futura", Font.BOLD, 25));
        this.player2turn.setVisible(false);

        this.backButton.setFocusable(false);
        this.backButton.setBorder(BorderFactory.createEtchedBorder());
        this.backButton.setBackground(Color.white);
        this.backButton.setBounds(260,595, 230, 90);
        this.backButton.setBorder(border);
        this.backButton.setFont(new Font("Futura", Font.BOLD, 40));
        this.backButton.addActionListener(this);
        this.backButton.setForeground(Color.BLACK);

        this.startButton.setFocusable(false);
        this.startButton.setBorder(BorderFactory.createEtchedBorder());
        this.startButton.setBackground(Color.white);
        this.startButton.setBounds(210,440, 330, 130);
        this.startButton.setBorder(border);
        this.startButton.setFont(new Font("Futura", Font.BOLD, 40));
        this.startButton.addActionListener(this);
        this.startButton.setForeground(Color.BLACK);

        this.coinflipButton.setFocusable(false);
        this.coinflipButton.setBorder(BorderFactory.createEtchedBorder());
        this.coinflipButton.setBackground(Color.white);
        this.coinflipButton.setBounds(105,295, 540, 65);
        this.coinflipButton.setBorder(border);
        this.coinflipButton.setFont(new Font("Futura", Font.BOLD, 40));
        this.coinflipButton.addActionListener(this);

        this.lobbyFrame.add(gameSettings);
        this.lobbyFrame.add(red);
        this.lobbyFrame.add(blue);
        this.lobbyFrame.add(player1button);
        this.lobbyFrame.add(player2button);
        this.lobbyFrame.add(player1checkbox);
        this.lobbyFrame.add(player2checkbox);
        this.lobbyFrame.add(player1turn);
        this.lobbyFrame.add(player2turn);
        this.lobbyFrame.add(backButton);
        this.lobbyFrame.add(startButton);
        this.lobbyFrame.add(coinflipButton);

        this.lobbyFrame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == player1button) {
            p1name = JOptionPane.showInputDialog(null, "Name:", p1name);
            if (p1name != null && p1name.matches("^[a-zA-Z0-9](?:[a-zA-Z0-9 ]{0,13}[a-zA-Z0-9])?$")) { // Player names must only contain English letters, numbers and spaces in between words. They must be a maximum of 15 letters long
                this.p1.setName(p1name);
                player1button.setText(p1name);
            } else if (p1name != null) {
                JOptionPane.showMessageDialog(null, "Invalid Name");
                p1name = "Player 1";  // The default name is Player 1 or Player 2
            }
        } else if (e.getSource() == player2button) {
            p2name = JOptionPane.showInputDialog(null, "Name:", p2name);
            if (p2name != null && p2name.matches("^[a-zA-Z0-9](?:[a-zA-Z0-9 ]{0,13}[a-zA-Z0-9])?$")) {
                p2.setName(p2name);
                player2button.setText(p2name);
            } else if (p2name != null) {
                JOptionPane.showMessageDialog(null, "Invalid Name");
                p2name = "Player 2";
            }
        }
        if (e.getSource() == player1checkbox) {
            player2turn.setVisible(false);
            player1turn.setVisible(true);
            p1.setTurn(true);
            p2.setTurn(false);
        } else if (e.getSource() == player2checkbox) {
            player1turn.setVisible(false);
            player2turn.setVisible(true);
            p2.setTurn(true);
            p1.setTurn(false);
        }
        if (e.getSource() == backButton) {
            lobbyFrame.dispose();
            new Menu();
        }
        if (e.getSource() == coinflipButton) {
            if (r.nextInt(2) == 0) {
                player2turn.setVisible(false);
                player1turn.setVisible(true);
                p1.setTurn(true);
                p2.setTurn(false);
                player1checkbox.setSelected(true);
                JOptionPane.showMessageDialog(null, "Red goes first!", "Turn decided", JOptionPane.INFORMATION_MESSAGE);
            } else if (r.nextInt(2) == 1) {
                player1turn.setVisible(false);
                player2turn.setVisible(true);
                p2.setTurn(true);
                p1.setTurn(false);
                player2checkbox.setSelected(true);
                JOptionPane.showMessageDialog(null, "Blue goes first!", "Turn decided", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e.getSource() == startButton) {
            lobbyFrame.dispose();
            Game game = new Game(this);
            p1.setName(p1name);
            p2.setName(p2name);
        }
    }
}
