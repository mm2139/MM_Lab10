import java.util.Random;
import java.util.Scanner;

public class Main {

    private static String[][] board = new String[3][3];

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("hi welcome to tictactoe");

        boolean win = false;
        boolean tie = false;
        boolean play = true;
        String p1move = "X";
        String p2move = "O";
        clearBoard();

        displayBoard();

        do {

        do {

            boolean moves = false;
            int p1row = 0;
            int p1column = 0;
            int p2row = 0;
            int p2column = 0;
            boolean p1moved = false;
            boolean p2moved = false;

            do {

                do {
                    p1row = InputHelper.getRangedInt(scan, "P1 - What row do you want your move to be?", 1, 3) - 1;
                    p1column = InputHelper.getRangedInt(scan, "P1 - What column do you want your move to be?", 1, 3) - 1;
                    if (!isValidMove(p1row, p1column)) {
                        System.out.println("Invalid move.");
                    } else {
                        board[p1row][p1column] = p1move;
                        p1moved = true;
                        displayBoard();
                    }
                } while (!p1moved);

                if (isWin(p1move)) {
                        win = true;
                        System.out.println("GAME OVER: Player 1 WON");
                        break;
                }

                do {

                    p2row = InputHelper.getRangedInt(scan, "P2 - What row do you want your move to be?", 1, 3) - 1;
                    p2column = InputHelper.getRangedInt(scan, "P2 - What column do you want your move to be?", 1, 3) - 1;
                    if (!isValidMove(p2row, p2column)) {
                        System.out.println("Invalid move.");
                    } else {
                        board[p2row][p2column] = p2move;
                        p2moved = true;
                        displayBoard();
                    }
                } while (!p2moved);

                if (isWin(p2move)) {
                    win = true;
                    System.out.println("GAME OVER: Player 2 WON");
                    break;
                }

                if (isTie() || isTie()) {
                    tie = true;
                    System.out.println("GAME OVER: TIE");
                    break;
                }

                moves = true;

            } while (!moves);

        } while (!win && !tie);

        play = InputHelper.getYNConfirm("do u want to plau once more y/n", scan);

    } while (play);

    }

    private static void clearBoard() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c] = "-";
            }
        }
    }

    private static void displayBoard() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int col) {
        if (board[row][col].equals("-")) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isWin(String player) {
        return isRowWin(player) || isColumnWin(player) || isDiagonalWin(player);
    }

    private static boolean isRowWin(String player) {
        for (int r = 0; r<board.length; r++) {
            if (board[r][0].equalsIgnoreCase(player) && board[r][1].equalsIgnoreCase(player) && board[r][2].equalsIgnoreCase(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColumnWin(String player) {
        for (int c = 0; c<board.length; c++) {
            if (board[0][c].equalsIgnoreCase(player) && board[1][c].equalsIgnoreCase(player) && board[2][c].equalsIgnoreCase(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        if ((board[0][0].equalsIgnoreCase(player) && board[1][1].equalsIgnoreCase(player) && board[2][2].equalsIgnoreCase(player) || (board[2][0].equalsIgnoreCase(player) && board[1][1].equalsIgnoreCase(player) && board[0][2].equalsIgnoreCase(player)))) {
            return true;
        }
        return false;
    }

    private static boolean isTie() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if (board[r][c].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }
}