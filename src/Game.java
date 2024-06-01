    import javax.swing.*;
    import javax.swing.border.Border;
    import javax.swing.border.LineBorder;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.util.ArrayList;
    /**Contains the actual game that is being played*/
    public class Game implements ActionListener {
        /**Frame of the game*/
        private JFrame gameFrame = new JFrame("Checkers");
        /**Contains the board*/
        private JPanel gamePanel = new JPanel();
        /**Border used for all buttons*/
        private Border border = new LineBorder(Color.BLACK, 3);
        /**The board that is being played on*/
        private Board board = new Board(this);
        /**Name of player 1 as seen on the bottom left of the jpanel*/
        private JLabel p1nameLabel = new JLabel();
        /**Name of player 2 as seen on the bottom left of the jpanel*/
        private JLabel p2nameLabel = new JLabel();

        /**Amount of pieces that player 1 has left*/
        int p1pieces = 12;
        /**Amount of pieces that player 2 has left*/
        int p2pieces = 12;
        /**Status of player 1 winning*/
        private boolean p1winner = false;
        /**Status of player 2 winning*/
        private boolean p2winner = false;

        /**Label for the amount of pieces player 1 has left*/
        JLabel p1piecesLabel = new JLabel(p1pieces + "");
        /**Label for the amount of pieces player 2 has left*/
        JLabel p2piecesLabel = new JLabel(p2pieces + "");
        /**Label that changes colors based on whose turn it is*/
        JLabel turnIndicator = new JLabel();
        /**The turn indicator image for player 1 (red)*/
        private ImageIcon p1turnIndicatorImage = new ImageIcon(new ImageIcon("src\\Images\\red_turn.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        /**The turn indicator image for player 1 (blue)*/
        private ImageIcon p2turnIndicatorImage = new ImageIcon(new ImageIcon("src\\Images\\blue_turn.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

        /**Ends the game with no real winner*/
        private JButton backButton = new JButton("End Game");

        /**The final screen which shows which player won and gives the option of a rematch*/
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
        /**Checks which player has lost all their pieces and shows the end screen*/
        public void checkVictoryByElimination(){
            if(p1pieces == 0 || p2pieces == 0){
                if(p1pieces == 0){
                    p2winner = true;
                }else if(p2pieces == 0){
                    p1winner = true;
                }
                p1timer.stop();
                p2timer.stop();
                showEndScreen();
            }
        }
        /**Checks which player has no more moves available and shows the end screen*/
        public void checkVictoryByNoMoves(){
            boolean blueHasMoves = hasAvailableMoves(PieceColor.BLUE);
            boolean redHasMoves = hasAvailableMoves(PieceColor.RED);
            if(!blueHasMoves || !redHasMoves){
                if(!blueHasMoves){
                    p1winner = true;
                }else if(!redHasMoves){
                    p2winner = true;
                }
                p1timer.stop();
                p2timer.stop();
                showEndScreen();
            }
        }
        /**Checks if either player has no more moves available
         @param color of the selected piece
         @return boolean of whether there are any available moves
         * */
        public boolean hasAvailableMoves(PieceColor color) {
            for (int y = 0; y < Board.BOARDSIZE; y++) {
                for (int x = 0; x < Board.BOARDSIZE; x++) {
                    Piece piece = board.getBoard()[y][x];
                    if (piece != null && piece.getPieceColor() == color) {
                        ArrayList<Move> moves = piece.generateMoves(board, x, y);
                        if (!moves.isEmpty()) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        Lobby lobby;

        /**Used as indicator of either player's turn. If blueTurn = false then it is player 1's turn (red)*/
        boolean blueTurn = false;
        /**Flag for if a piece has been selected*/
        boolean hasSelected;
        /**x coordinate of the selected piece*/
        int selectedx;
        /**y coordinate of the selected piece*/
        int selectedy;
        /**ArrayList of all available moves for the chosen piece*/
        ArrayList<Move> availableMoves = new ArrayList<>();

        /**Renders the timer of player 1*/
        JLabel p1timerLabel = new JLabel();
        /**Renders the timer of player 2*/
        JLabel p2timerLabel = new JLabel();

        /**The amount of time player 1 has left before they lose*/
        int p1TimeLeft = 300;
        /**The amount of time player 2 has left before they lose*/
        int p2TimeLeft = 300;

        Timer p1timer;
        Timer p2timer;
        /**Creates timers for both players. Ends game if either runs out. Sets first turn indicator images*/
        public void createTimers() {
            p1timer = new Timer(1000, e -> {
                p1TimeLeft--;
                p1timerLabel.setText(p1TimeLeft + "");
                if (p1TimeLeft <= 0) {
                    p2winner = true;
                    p1timer.stop();
                    p2timer.stop();
                    showEndScreen();
                }
            });

            p2timer = new Timer(1000, e -> {
                p2TimeLeft--;
                p2timerLabel.setText(p2TimeLeft + "");
                if (p2TimeLeft <= 0) {
                    p1winner = true;
                    p1timer.stop();
                    p2timer.stop();
                    showEndScreen();
                }
            });
            if (blueTurn) {
                p2timer.start();
                turnIndicator.setIcon(p2turnIndicatorImage);
            } else {
                p1timer.start();
                turnIndicator.setIcon(p1turnIndicatorImage);
            }
        }
        /**Switches timers and turn indicator images */
        public void switchTurns() {
            if (blueTurn) {
                p1timer.stop();
                p2timer.start();
                turnIndicator.setIcon(p2turnIndicatorImage);
            } else {
                p2timer.stop();
                p1timer.start();
                turnIndicator.setIcon(p1turnIndicatorImage);
            }
        }
        /**Creates a new game*/
        Game(Lobby lobby){
            this.lobby = lobby;

            this.gameFrame.setSize(1300, 1000);
            this.gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.gameFrame.setLayout(null);
            this.gameFrame.setLocationRelativeTo(null);
            ImageIcon icon = new ImageIcon("src\\Images\\icon.png");
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

            this.p1timerLabel.setFont(new Font("Futura", Font.BOLD,40));
            this.p1timerLabel.setBounds(610,865,300,80);
            this.p1timerLabel.setForeground(Color.RED);
            this.p1timerLabel.setText(p1TimeLeft + "");

            this.p2timerLabel.setFont(new Font("Futura", Font.BOLD,40));
            this.p2timerLabel.setBounds(610,0,300,80);
            this.p2timerLabel.setForeground(Color.BLUE);
            this.p2timerLabel.setText(p2TimeLeft + "");

            this.backButton.setFocusable(false);
            this.backButton.setBorder(BorderFactory.createEtchedBorder());
            this.backButton.setBackground(Color.white);
            this.backButton.setBounds(1065,425, 200, 100);
            this.backButton.setBorder(border);
            this.backButton.setFont(new Font("Futura", Font.BOLD, 30));
            this.backButton.addActionListener(this);
            this.backButton.setForeground(Color.BLACK);

            createTimers();


            this.turnIndicator.setBounds(100,430, 80,80);

            this.gameFrame.add(gamePanel);
            this.gameFrame.add(p1nameLabel);
            this.gameFrame.add(p2nameLabel);
            this.gameFrame.add(p1piecesLabel);
            this.gameFrame.add(p2piecesLabel);
            this.gameFrame.add(p1timerLabel);
            this.gameFrame.add(p2timerLabel);
            this.gameFrame.add(turnIndicator);
            this.gameFrame.add(backButton);

            this.gameFrame.setVisible(true);

            if(lobby.p1.isTurn()){
                blueTurn = false;
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == this.backButton){
                gameFrame.dispose();
                new Lobby();
            }
        }
    }
