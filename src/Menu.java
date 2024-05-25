import javax.swing.*;

public class Menu {

    JFrame menuFrame = new JFrame("Checkers");
    JButton rulesButton = new JButton("Rules");

    Menu(){
        this.menuFrame.setSize(750, 750);
        this.menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.menuFrame.setLayout(null);
        this.menuFrame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("icon.png");
        this.menuFrame.setIconImage(icon.getImage());


        this.rulesButton.setFocusable(false);
        this.rulesButton.setBorder(BorderFactory.createEtchedBorder());
        this.rulesButton.setBounds(62,500, 200, 100);
        this.menuFrame.add(rulesButton);

        this.menuFrame.setVisible(true);



    }

}
