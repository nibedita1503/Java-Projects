package tic_tac_toe_game;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        Scanner sc = new Scanner(System.in);
        char player = 'X';

        for (int moves = 0; moves < 9; moves++) {
            printBoard(board);
            System.out.println("Player " + player + ", enter row and column (0-2): ");
            int r = sc.nextInt();
            int c = sc.nextInt();

            if (board[r][c] != ' ') {
                System.out.println("Cell already taken. Try again.");
                moves--; // retry move
                continue;
            }

            board[r][c] = player;

            if (win(board, player)) {
                printBoard(board);
                System.out.println("Player " + player + " wins!");
                return;
            }

            player = (player == 'X') ? 'O' : 'X';
        }

        printBoard(board);
        System.out.println("It's a draw!");
    }

    static void printBoard(char[][] b) {
        System.out.println("-------");
        for (char[] row : b) {
            for (char cell : row) System.out.print("|" + cell);
            System.out.println("|");
        }
        System.out.println("-------");
    }

    static boolean win(char[][] b, char p) {
        for (int i = 0; i < 3; i++)
            if ((b[i][0] == p && b[i][1] == p && b[i][2] == p) || // row
                    (b[0][i] == p && b[1][i] == p && b[2][i] == p))   // col
                return true;
        return (b[0][0] == p && b[1][1] == p && b[2][2] == p) ||   // diagonal
                (b[0][2] == p && b[1][1] == p && b[2][0] == p);     // anti-diagonal
    }
}
