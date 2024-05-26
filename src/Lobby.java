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
    JCheckBox player1checkbox = new JCheckBox();
    JCheckBox player2checkbox = new JCheckBox();

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

        this.player1checkbox.setBorder(BorderFactory.createEtchedBorder());
        this.player1checkbox.setBackground(Color.white);
        this.player1checkbox.setFocusable(false);
        this.player1checkbox.setBorder(border);
        this.player1checkbox.addActionListener(this);
        this.player1checkbox.setBounds(50,50,100,100);

        this.lobbyFrame.add(gameSettings);
        this.lobbyFrame.add(red);
        this.lobbyFrame.add(blue);
        this.lobbyFrame.add(player1button);
        this.lobbyFrame.add(player2button);
        this.lobbyFrame.add(player1checkbox);
        this.lobbyFrame.add(player2checkbox);

        this.lobbyFrame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==player1button){

        }else if(e.getSource()==player2button){

        }
    }
}
