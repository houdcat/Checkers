import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules implements ActionListener { // menu for rules
    JFrame rulesFrame = new JFrame("Checkers");
    JButton backButton = new JButton("Back to main menu");
    JLabel rulesLabel = new JLabel("Rules");

    Rules(){
        this.rulesFrame.setSize(750, 750);
        this.rulesFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.rulesFrame.setLayout(null);
        this.rulesFrame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("icon.png");
        this.rulesFrame.setIconImage(icon.getImage());
        this.rulesFrame.setResizable(false);
        this.rulesFrame.setVisible(true);

        Border border = new LineBorder(Color.BLACK, 3);

        this.backButton.setFocusable(false);
        this.backButton.setBorder(BorderFactory.createEtchedBorder());
        this.backButton.setBackground(Color.white);
        this.backButton.setBounds(125,550, 500, 110);
        this.backButton.setBorder(border);
        this.backButton.setFont(new Font("Futura", Font.BOLD, 40));
        this.backButton.addActionListener(this);

        this.rulesFrame.add(backButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            rulesFrame.dispose();
            new Menu();
        }
    }
}
