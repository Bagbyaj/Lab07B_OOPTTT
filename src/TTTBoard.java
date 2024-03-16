import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TTTBoard {
    private Game game;
    private TTTTileButton[][] buttons = new TTTTileButton[3][3];
    private String[][] boardState = new String[3][3];

    public TTTBoard(Game game) {
        this.game = game;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardState[i][j] = "";
            }
        }
    }

    public void initialize(JFrame frame) {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new TTTTileButton(this, i, j);
                frame.add(buttons[i][j]);
            }
        }
    }

    public Game getGame() {
        return game;
    }

    public void updateBoard(int row, int col, String symbol) {
        boardState[row][col] = symbol;
    }

    public void checkForEndGame() {

        if (isWinningMove()) {
            game.endGame(game.getCurrentPlayer().getSymbol());
            return;
        }


        if (isBoardFull()) {
            game.endGame("It's a tie!");
            return;
        }


        game.togglePlayer();
    }

    private boolean isWinningMove() {

        for (int i = 0; i < 3; i++) {
            if (!boardState[i][0].equals("") && boardState[i][0].equals(boardState[i][1]) && boardState[i][1].equals(boardState[i][2]))
                return true;
            if (!boardState[0][i].equals("") && boardState[0][i].equals(boardState[1][i]) && boardState[1][i].equals(boardState[2][i]))
                return true;
        }


        if (!boardState[0][0].equals("") && boardState[0][0].equals(boardState[1][1]) && boardState[1][1].equals(boardState[2][2]))
            return true;
        if (!boardState[0][2].equals("") && boardState[0][2].equals(boardState[1][1]) && boardState[1][1].equals(boardState[2][0]))
            return true;

        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardState[i][j].equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void clearBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardState[i][j] = "";
                buttons[i][j].setText("");
            }
        }
    }
}
