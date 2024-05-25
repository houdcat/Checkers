import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener{

    JFrame menuFrame = new JFrame("Checkers");
    JButton rulesButton = new JButton("Rules");
    JButton exitButton = new JButton("Exit");
    JButton playButton = new JButton("Play");
    JLabel title = new JLabel("Checkers");
    Border border = new LineBorder(Color.BLACK, 3);



    Menu(){
        this.menuFrame.setSize(750, 750);
        this.menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.menuFrame.setLayout(null);
        this.menuFrame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("icon.png");
        this.menuFrame.setIconImage(icon.getImage());
        this.menuFrame.setResizable(false);



        this.title.setFont(new Font("Georgia", Font.BOLD, 72));
        this.title.setBounds(0,0,750,275);
        this.title.setHorizontalAlignment(SwingConstants.CENTER);


        this.rulesButton.setFocusable(false);
        this.rulesButton.setBorder(BorderFactory.createEtchedBorder());
        this.rulesButton.setBackground(Color.white);
        this.rulesButton.setBounds(150,500, 200, 100);
        this.rulesButton.setBorder(border);
        this.rulesButton.setFont(new Font("Futura", Font.BOLD, 30));
        this.rulesButton.addActionListener(this);

        this.exitButton.setFocusable(false);
        this.exitButton.setBorder(BorderFactory.createEtchedBorder());
        this.exitButton.setBackground(Color.white);
        this.exitButton.setBounds(400,500, 200, 100);
        this.exitButton.setBorder(border);
        this.exitButton.setFont(new Font("Futura", Font.BOLD, 30));

        this.playButton.setFocusable(false);
        this.playButton.setBorder(BorderFactory.createEtchedBorder());
        this.playButton.setBackground(Color.white);
        this.playButton.setBounds(250,300, 250, 150);
        this.playButton.setBorder(border);
        this.playButton.setFont(new Font("Futura", Font.BOLD, 40));

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
            menuFrame.dispose();
            new Rules();
        }
    }
}
