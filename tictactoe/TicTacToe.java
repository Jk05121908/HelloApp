import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static char human;
    static char computer;
    static char currentPlayer;

    public static void main(String[] args) {

        initializeBoard();

        toss();

        printBoard();

        int slot = getUserInput();

        int[] pos = getRowCol(slot);

        int row = pos[0];
        int col = pos[1];

        boolean valid = isValidMove(row, col);

        if (valid) {

            System.out.println("Valid Move");

        } else {

            System.out.println("Invalid Move");
        }
    }

    // UC1: Initialize Board
    public static void initializeBoard() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                board[i][j] = '-';
            }
        }
    }

    // UC1: Print Board
    public static void printBoard() {

        for (int i = 0; i < 3; i++) {

            System.out.println(board[i][0] + " " + board[i][1] + " " + board[i][2]);
        }
    }

    // UC2: Toss
    public static void toss() {

        Random rand = new Random();

        int toss = rand.nextInt(2);

        if (toss == 0) {

            human = 'X';
            computer = 'O';
            currentPlayer = human;

            System.out.println("You won the toss! You are X");

        } else {

            human = 'O';
            computer = 'X';
            currentPlayer = computer;

            System.out.println("Computer won the toss! You are O");
        }
    }

    // UC3: User Input
    public static int getUserInput() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a slot (1-9): ");

        int slot = sc.nextInt();

        return slot;
    }

    // UC4: Convert slot to row and column
    public static int[] getRowCol(int slot) {

        int row = (slot - 1) / 3;

        int col = (slot - 1) % 3;

        return new int[]{row, col};
    }

    // UC5: Validate move
    public static boolean isValidMove(int row, int col) {

        if (row >= 0 && row < 3 && col >= 0 && col < 3) {

            if (board[row][col] == '-') {

                return true;
            }
        }

        return false;
    }
}