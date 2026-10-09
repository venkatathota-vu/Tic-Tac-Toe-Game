import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };

    static void displayBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | "
                    + board[i][1] + " | " + board[i][2]);

            if (i < 2)
                System.out.println("---+---+---");
        }
    }

    static boolean checkWinner(char p) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == p && board[i][1] == p
                    && board[i][2] == p)
                return true;

            if (board[0][i] == p && board[1][i] == p
                    && board[2][i] == p)
                return true;
        }

        if (board[0][0] == p && board[1][1] == p
                && board[2][2] == p)
            return true;

        if (board[0][2] == p && board[1][1] == p
                && board[2][0] == p)
            return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char player = 'X';
        int moves = 0;

        System.out.println("=== TIC TAC TOE ===");
        System.out.println("Player 1: X | Player 2: O");
        System.out.println("Choose positions from 1 to 9.");

        while (true) {
            displayBoard();

            System.out.print("Player " + player + ", enter position: ");

            if (!sc.hasNextInt()) {
                System.out.println("Enter a number from 1 to 9.");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();

            if (choice < 1 || choice > 9) {
                System.out.println("Invalid position!");
                continue;
            }

            int row = (choice - 1) / 3;
            int col = (choice - 1) % 3;

            if (board[row][col] == 'X' || board[row][col] == 'O') {
                System.out.println("Position already occupied!");
                continue;
            }

            board[row][col] = player;
            moves++;

            if (checkWinner(player)) {
                displayBoard();
                System.out.println("Player " + player + " wins!");
                break;
            }

            if (moves == 9) {
                displayBoard();
                System.out.println("The game is a draw!");
                break;
            }

            player = (player == 'X') ? 'O' : 'X';
        }

        sc.close();
    }
}