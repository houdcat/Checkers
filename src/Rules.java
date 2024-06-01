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
    JLabel rulesBlock = new JLabel();

    Rules(){
        this.rulesFrame.setSize(750, 750);
        this.rulesFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.rulesFrame.setLayout(null);
        this.rulesFrame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("src\\Images\\icon.png");
        this.rulesFrame.setIconImage(icon.getImage());
        this.rulesFrame.setResizable(false);
        this.rulesFrame.setVisible(true);

        Border border = new LineBorder(Color.BLACK, 3);

        this.backButton.setFocusable(false);
        this.backButton.setBorder(BorderFactory.createEtchedBorder());
        this.backButton.setBackground(Color.white);
        this.backButton.setBounds(125,570, 500, 110);
        this.backButton.setBorder(border);
        this.backButton.setFont(new Font("Futura", Font.BOLD, 40));
        this.backButton.addActionListener(this);

        this.rulesLabel.setFont(new Font("Georgia", Font.BOLD, 72));
        this.rulesLabel.setBounds(0,0,750,100);
        this.rulesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.rulesLabel.setForeground(Color.BLACK);

        this.rulesBlock.setText("<html> 1. The player that goes first can be picked manually or decided randomly<br><br>2. Regular pieces can only move forward by one tile diagonally on dark squares<br><br>3. Pieces are captured by jumping over them<br><br>4. If a regular piece reaches the other side of the board, it turns into a King. A king can move forward and back along the diagonal lines<br><br></html>");
        this.rulesBlock.setBounds(20,65,700,500);
        this.rulesBlock.setFont(new Font("Futura", Font.BOLD, 24));



        this.rulesFrame.add(backButton);
        this.rulesFrame.add(rulesBlock);
        this.rulesFrame.add(rulesLabel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            rulesFrame.dispose();
            new Menu();
        }
    }
}
