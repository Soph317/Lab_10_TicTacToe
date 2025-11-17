import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];


    public static void main(String[] args) {
        int row;
        int column;
        boolean playAgain = true;
        boolean win;
        boolean tie;
        boolean endGame;
        String player;
        int move;

        Scanner in = new Scanner(System.in);

        while (playAgain) {
            clearBoard();
            endGame = false;
            player = "X";
            move = 0;
            do {
                display();

                do {


                    row = SafeInput.getRangedInt(in, "Enter row (1-3)", 1, 3) - 1;
                    column = SafeInput.getRangedInt(in, "Enter column (1-3)", 1, 3) - 1;


                    if (!isValidMove(row, column)) {
                        System.out.println("This space is taken. Try Again.");
                    }
                }
                while (!isValidMove(row,  column));
                board[row][column] = player;
                move++;

                win = isWin(player);
                tie = isTie();

                if (win) {
                    display();
                    System.out.println("Player " + player + " won in " + move + " moves!");
                    endGame = true;
                }
                else if (tie) {
                    display();
                    System.out.println("It's a tie");
                    endGame = true;
                }

                if (player.equals("X")) {
                    player = "O";
                } else {
                    player = "X";
                }
            }
            while (!endGame);
            playAgain = SafeInput.getYNConfirm(in, "Do you want to play again Y/N");
        }
    }
    private static void clearBoard(){
        for (int row=0; row < ROW; row++){
            for (int col=0; col < COL; col++) {
                board[row][col] = " ";
            }
        }
    }

    private static void display(){
        for (int row=0; row < ROW; row++){
            System.out.println(board[row][0] + " | " + board[row][1] + " | " + board[row][2]);
        }
    }

    private static boolean isValidMove(int row, int col) {

        if (board[row][col].equals(" ")) {

            return true;
        }
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        if (isColWin(player) || isRowWin(player) || isDiagonalWin(player)){
            return true;
        }
        else {
            return false;
        }
    }

    private static boolean isColWin(String player){
        for (int col = 0; col < COL; col++){
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)){
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(String player){
        for (int row = 0; row < ROW; row++){
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)){
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)){
            return true;
        } else if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }
        else {
            return false;
        }
    }

    private static boolean isTie() {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (board[r][c].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}
