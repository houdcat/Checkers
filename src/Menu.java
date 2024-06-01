import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


/**
 * Creates the main menu and is the first class to load when the user executes the .jar file
 * Leads to the rules, enables the user to exit out of the program and leads to the Lobby, where the player can start the game
 */
public class Menu implements ActionListener{
    /**The menu's frame*/
    private JFrame menuFrame = new JFrame("Checkers");
    /**Button that shows the rules of Checkers*/
    private JButton rulesButton = new JButton("Rules");
    /**Button that closes the program*/
    private JButton exitButton = new JButton("Exit");
    /**Button that leads to the Lobby to create a new game*/
    private JButton playButton = new JButton("Play");
    /**Label for the title that appears at the top*/
    private JLabel title = new JLabel("Checkers");
    /**A black border that all buttons use*/
    private Border border = new LineBorder(Color.BLACK, 3);



    /**Constructor that initializes all components of the menu*/
    Menu(){
        this.menuFrame.setSize(750, 750);
        this.menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.menuFrame.setLayout(null);
        this.menuFrame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("src\\Images\\icon.png");
        this.menuFrame.setIconImage(icon.getImage());
        this.menuFrame.setResizable(false);


        this.title.setFont(new Font("Georgia", Font.BOLD, 72));
        this.title.setBounds(0,0,750,275);
        this.title.setHorizontalAlignment(SwingConstants.CENTER);
        this.title.setForeground(Color.BLACK);


        this.rulesButton.setFocusable(false);
        this.rulesButton.setBorder(BorderFactory.createEtchedBorder());
        this.rulesButton.setBackground(Color.white);
        this.rulesButton.setBounds(150,500, 200, 100);
        this.rulesButton.setBorder(border);
        this.rulesButton.setFont(new Font("Futura", Font.BOLD, 30));
        this.rulesButton.addActionListener(this);
        this.rulesButton.setForeground(Color.BLACK);

        this.exitButton.setFocusable(false);
        this.exitButton.setBorder(BorderFactory.createEtchedBorder());
        this.exitButton.setBackground(Color.white);
        this.exitButton.setBounds(400,500, 200, 100);
        this.exitButton.setBorder(border);
        this.exitButton.setFont(new Font("Futura", Font.BOLD, 30));
        this.exitButton.setForeground(Color.BLACK);

        this.playButton.setFocusable(false);
        this.playButton.setBorder(BorderFactory.createEtchedBorder());
        this.playButton.setBackground(Color.white);
        this.playButton.setBounds(250,300, 250, 150);
        this.playButton.setBorder(border);
        this.playButton.setFont(new Font("Futura", Font.BOLD, 40));
        this.playButton.addActionListener(this);
        this.playButton.setForeground(Color.BLACK);

        this.exitButton.addActionListener(e -> System.exit(0));

        this.menuFrame.add(rulesButton);
        this.menuFrame.add(exitButton);
        this.menuFrame.add(playButton);
        this.menuFrame.add(title);

        this.menuFrame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==rulesButton){
            menuFrame.dispose(); // Close menu
            new Rules(); // Open rules
        }else if(e.getSource()==playButton){
            menuFrame.dispose(); // Close menu
            new Lobby(); // Create new Lobby
        }
    }
}
