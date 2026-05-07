import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    static char[][] board = new char[3][3];

    static char human;
    static char computer;

    static Random rand = new Random();

    public static void main(String[] args) {

        initializeBoard();

        toss();

        printBoard();

        // Human move
        int slot = getUserInput();

        int[] pos = getRowCol(slot);

        int row = pos[0];
        int col = pos[1];

        if (isValidMove(row, col)) {

            placeMove(row, col, human);

        } else {

            System.out.println("Invalid Move");
        }

        printBoard();

        // Computer move
        computerMove();

        printBoard();
    }

    // Initialize board
    public static void initializeBoard() {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                board[row][col] = '-';
            }
        }
    }

    // Print board properly
    public static void printBoard() {

        System.out.println("-------------");

        for (int row = 0; row < 3; row++) {

            System.out.print("| ");

            for (int col = 0; col < 3; col++) {

                System.out.print(board[row][col] + " | ");
            }

            System.out.println();

            System.out.println("-------------");
        }

        System.out.println();
    }

    // Toss
    public static void toss() {

        int toss = rand.nextInt(2);

        if (toss == 0) {

            human = 'X';
            computer = 'O';

            System.out.println("You won toss. You are X");

        } else {

            human = 'O';
            computer = 'X';

            System.out.println("Computer won toss. You are O");
        }
    }

    // User input
    public static int getUserInput() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter slot (1-9): ");

        return sc.nextInt();
    }

    // Convert slot to row and column
    public static int[] getRowCol(int slot) {

        int row = (slot - 1) / 3;

        int col = (slot - 1) % 3;

        return new int[]{row, col};
    }

    // Validate move
    public static boolean isValidMove(int row, int col) {

        return row >= 0 &&
               row < 3 &&
               col >= 0 &&
               col < 3 &&
               board[row][col] == '-';
    }

    // Place move
    public static void placeMove(int row, int col, char symbol) {

        board[row][col] = symbol;
    }

    // Computer random move
    public static void computerMove() {

        int slot;
        int row;
        int col;

        while (true) {

            slot = rand.nextInt(9) + 1;

            int[] pos = getRowCol(slot);

            row = pos[0];
            col = pos[1];

            if (isValidMove(row, col)) {

                placeMove(row, col, computer);

                System.out.println("Computer chose slot: " + slot);

                break;
            }
        }
    }
}