import java.util.Random;
import java.util.Scanner;

public class Main {

    private static String[][] board = new String[3][3];

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("hi welcome to tictactoe");

        boolean win = false;
        clearBoard();

do {
        boolean moves = false;
        int p1row = 0;
        int p1column = 0;
        int p2row = 0;
        int p2column = 0;
        String p1move = "X";
        String p2move = "O";


        do {
            boolean p1moved = false;
            boolean p2moved = false;
            do {
                p1row = InputHelper.getRangedInt(scan, "P1 - What row do you want your move to be?", 1, 3) - 1;
                p1column = InputHelper.getRangedInt(scan, "P1 - What column do you want your move to be?", 1, 3) - 1;
                if (!isValidMove(p1row, p1column)) {
                    System.out.println("Invalid move.");
                } else {
                    board[p1row][p1column] = p1move;
                    p1moved = true;
                }
                do {
                    p2row = InputHelper.getRangedInt(scan, "P2 - What row do you want your move to be?", 1, 3) - 1;
                    p2column = InputHelper.getRangedInt(scan, "P2 - What column do you want your move to be?", 1, 3) - 1;
                    if (!isValidMove(p2row, p2column)) {
                        System.out.println("Invalid move.");
                    } else {
                        board[p2row][p2column] = p2move;
                        p2moved = true;
                    }
                } while (!p2moved);
            } while (!p1moved);
            moves = true;
        } while (!moves);

        displayBoard();

      win = isWinOrTie(p1move) || isWinOrTie(p2move);
      System.out.println(win);
    } while(!win);

    System.out.println("there was a win thanks");

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

    private static boolean isWinOrTie(String player) {
        boolean winOrTie = isRowWin(player) || isColumnWin(player) || isDiagonalWin(player) || isTie();
        return winOrTie;
    }

    private static boolean isRowWin(String player) {
        for (int r = 0; r<board.length; r++) {
            if (board[r][0].equalsIgnoreCase(board[r][1]) && board[r][1].equalsIgnoreCase(board[r][2])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColumnWin(String player) {
        for (int c = 0; c<board.length; c++) {
            if (board[0][c].equalsIgnoreCase(board[1][c]) && board[1][c].equalsIgnoreCase(board[2][c])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        if ((board[0][0].equalsIgnoreCase(board[1][1]) && board[1][1].equalsIgnoreCase(board[2][2])) || (board[2][0].equalsIgnoreCase(board[1][1]) && board[1][1].equalsIgnoreCase(board[0][2]))) {
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