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
        System.out.println("You selected slot: " + slot);
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
}