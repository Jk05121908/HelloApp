import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    static char[][] board = new char[3][3];

    static char human;
    static char computer;
    static char currentPlayer;

    static Random rand = new Random();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        initializeBoard();

        toss();

        boolean gameOver = false;

        while (!gameOver) {

            printBoard();

            if (currentPlayer == human) {

                System.out.print("Enter slot (1-9): ");

                int slot = sc.nextInt();

                int[] pos = getRowCol(slot);

                int row = pos[0];
                int col = pos[1];

                if (isValidMove(row, col)) {

                    placeMove(row, col, human);

                    if (hasWon(human)) {

                        printBoard();

                        System.out.println("You Win!");

                        gameOver = true;

                    } else {

                        currentPlayer = computer;
                    }

                } else {

                    System.out.println("Invalid Move");
                }

            } else {

                computerMove();

                if (hasWon(computer)) {

                    printBoard();

                    System.out.println("Computer Wins!");

                    gameOver = true;

                } else {

                    currentPlayer = human;
                }
            }

            if (isBoardFull() && !gameOver) {

                printBoard();

                System.out.println("Game Draw!");

                gameOver = true;
            }
        }
    }

    // Initialize board
    public static void initializeBoard() {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                board[row][col] = '-';
            }
        }
    }

    // Print board
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
            currentPlayer = human;

            System.out.println("You won toss. You are X");

        } else {

            human = 'O';
            computer = 'X';
            currentPlayer = computer;

            System.out.println("Computer won toss. You are O");
        }
    }

    // Get row and column
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

    // Computer move
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

    // UC9: Check win
    public static boolean hasWon(char symbol) {

        // Check rows
        for (int row = 0; row < 3; row++) {

            if (board[row][0] == symbol &&
                board[row][1] == symbol &&
                board[row][2] == symbol) {

                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {

            if (board[0][col] == symbol &&
                board[1][col] == symbol &&
                board[2][col] == symbol) {

                return true;
            }
        }

        // Check diagonal
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) {

            return true;
        }

        // Check opposite diagonal
        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol) {

            return true;
        }

        return false;
    }

    // Check draw
    public static boolean isBoardFull() {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                if (board[row][col] == '-') {

                    return false;
                }
            }
        }

        return true;
    }
}