import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TTTTileButton extends JButton implements ActionListener {
    private int row;
    private int col;
    private TTTBoard board;

    public TTTTileButton(TTTBoard board, int row, int col) {
        super();
        this.board = board;
        this.row = row;
        this.col = col;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!this.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "This tile is already taken. Please choose another tile.", "Tile Already Taken", JOptionPane.ERROR_MESSAGE);
        } else {

            this.setText(board.getGame().getCurrentPlayer().getSymbol());
            board.updateBoard(row, col, getText());
            board.checkForEndGame();
        }
    }
}

