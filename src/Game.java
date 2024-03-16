import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.GridLayout;

public class Game {
    private JFrame frame = new JFrame("Tic Tac Toe");
    private TTTBoard board;
    private Player currentPlayer = new Player("X");

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new GridLayout(3, 3));
        frame.getContentPane().removeAll();

        board = new TTTBoard(this);
        board.initialize(frame);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void togglePlayer() {
        currentPlayer = currentPlayer.getSymbol().equals("X") ? new Player("O") : new Player("X");
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void endGame(String winner) {
        String message = winner.equals("It's a tie!") ? winner : winner + " wins!";
        JOptionPane.showMessageDialog(frame, message);

        int playAgain = JOptionPane.showConfirmDialog(frame, "Do you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
        if (playAgain == JOptionPane.YES_OPTION) {
            initializeGame();
        } else {
            frame.dispose();
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}
