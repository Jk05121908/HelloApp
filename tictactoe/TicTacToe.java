import java.util.Random;

public class TicTacToe {
    public static void main(String[] args) {

        // ===== UC1: Create and print empty board =====
        char[][] board = new char[3][3];

        // Initialize board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // Print board
        System.out.println("Tic Tac Toe Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        // ===== UC2: Toss for first player =====
        Random random = new Random();

        // 0 = Player, 1 = Computer
        int toss = random.nextInt(2);

        char playerSymbol;
        char computerSymbol;
        String currentPlayer;

        if (toss == 0) {
            playerSymbol = 'X';
            computerSymbol = 'O';
            currentPlayer = "Player";
        } else {
            playerSymbol = 'O';
            computerSymbol = 'X';
            currentPlayer = "Computer";
        }

        // Display result
        System.out.println("\n--- Toss Result ---");
        System.out.println("Player Symbol: " + playerSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
        System.out.println(currentPlayer + " will start first!");
    }
}