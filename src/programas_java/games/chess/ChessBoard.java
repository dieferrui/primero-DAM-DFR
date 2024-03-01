package programas_java.games.chess;

public class ChessBoard {

    Square[][] board = new Square[8][8];
    
    public void prepareBoard() {

        for (int fil = 0; fil < 8; fil++) {

            for (int col = 0; col < 8; col++) {

                char idLetra = (char)('A' + col);
                int idNum = 8 - fil;

                String idCompleta = "" + idLetra + idNum;

                board[fil][col] = new Square(idCompleta);
            }
        }
    }
}
