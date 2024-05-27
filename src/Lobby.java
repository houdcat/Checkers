import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lobby implements ActionListener {
    JFrame lobbyFrame = new JFrame("Checkers");
    JButton player1button = new JButton("Choose Name");
    JButton player2button = new JButton("Choose Name");
    JLabel gameSettings = new JLabel("Game Settings");
    JLabel red = new JLabel("Red");
    JLabel blue = new JLabel("Blue");
    Border border = new LineBorder(Color.BLACK, 3);
    JRadioButton player1checkbox = new JRadioButton ();
    JRadioButton  player2checkbox = new JRadioButton ();
    ButtonGroup turnChoice = new ButtonGroup();
    JLabel player1turn = new JLabel("First turn");
    JLabel player2turn = new JLabel("First turn");
    JButton backButton = new JButton("Back");
    JButton startButton = new JButton("Start Game");

    Player p1 = new Player("", false);
    Player p2 = new Player("", false);
    String p1name;
    String p2name;


    ImageIcon emptyCircle = new ImageIcon(new ImageIcon("empty_circle.png").getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
    ImageIcon fullCircle = new ImageIcon(new ImageIcon("full_circle.png").getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));;

    Lobby(){
        this.lobbyFrame.setSize(750, 750);
        this.lobbyFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.lobbyFrame.setLayout(null);
        this.lobbyFrame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("icon.png");
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
        this.player1button.setFont(new Font("Futura", Font.BOLD, 40));
        this.player1button.addActionListener(this);

        this.player2button.setBounds(160,220,300,50);
        this.player2button.setBorder(BorderFactory.createEtchedBorder());
        this.player2button.setBackground(Color.white);
        this.player2button.setFocusable(false);
        this.player2button.setBorder(border);
        this.player2button.setFont(new Font("Futura", Font.BOLD, 40));
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

        this.lobbyFrame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == player1button){
            p1name = JOptionPane.showInputDialog(null, "Name:", p1name);
            if(p1name != null && p1name.matches("^[a-zA-Z0-9](?:[a-zA-Z0-9 ]{0,13}[a-zA-Z0-9])?$")){
                p1.setName(p1name);
            } else if (p1name != null) {
                JOptionPane.showMessageDialog(null, "Invalid Name");
            }
        } else if(e.getSource() == player2button){
            p2name = JOptionPane.showInputDialog(null, "Name:", p2name);
            if(p2name != null && p2name.matches("^[a-zA-Z0-9](?:[a-zA-Z0-9 ]{0,13}[a-zA-Z0-9])?$")){
                p2.setName(p2name);
            } else if (p2name != null) {
                JOptionPane.showMessageDialog(null, "Invalid Name");
            }
        }
        if(e.getSource() == player1checkbox){
            player2turn.setVisible(false);
            player1turn.setVisible(true);
            p1.setTurn(true);
            p2.setTurn(false);
        } else if(e.getSource() == player2checkbox){
            player1turn.setVisible(false);
            player2turn.setVisible(true);
            p2.setTurn(true);
            p1.setTurn(false);
        }
        if (e.getSource()==backButton){
            lobbyFrame.dispose();
            new Menu();
        }
    }

}
