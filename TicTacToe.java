import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        printBoard(board);
        System.out.println();

        while(true) {
            playerMove(board, input);
            if (isGameFinished(board)) {
                break;
            }

            printBoard(board);
            System.out.println();

            computerMove(board);
            if (isGameFinished(board)) {
                break;
            }

            printBoard(board);
            System.out.println();
        }
        //input.close();
    }

    private static boolean isGameFinished(char[][] board) {

        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') || (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') || (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') || (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')) {
                printBoard(board);
                System.out.println("\nPlayer " + board[i][i] + " wins!\n");
                return true;
            }
        }

        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') || (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')) {
            printBoard(board);
            System.out.println("\nPlayer " + board[1][1] + " wins!\n");
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("\nNobody won. Losers.\n");
        return true;
    }

    private static void computerMove(char[][] board) {
        Random random = new Random();
        int computerMove;

        while (true) {
            computerMove = random.nextInt(9) + 1;
            if (isValidMove(board, Integer.toString(computerMove))) {
                break;
            }
        }

        System.out.println("Computer chose " + computerMove"\n");
        placeMove(board, Integer.toString(computerMove), 'O');
    }

    private static boolean isValidMove (char[][] board, String position) {
        switch (position) {
            case "1":
                return board[0][0] == ' ';
            case "2":
                return board[0][1] == ' ';
            case "3":
                return board[0][2] == ' ';
            case "4":
                return board[1][0] == ' ';
            case "5":
                return board[1][1] == ' ';
            case "6":
                return board[1][2] == ' ';
            case "7":
                return board[2][0] == ' ';
            case "8":
                return board[2][1] == ' ';
            case "9":
                return board[2][2] == ' ';
            default:
                return false;
        }
    }

    private static void playerMove(char[][] board, Scanner input) {
        String userPlay;
        while (true) {
            System.out.println("Where would you like to play? (1-9)");
            userPlay = input.nextLine();
            System.out.println();

            if (isValidMove(board, userPlay)) {
                break;
            } else {
                System.out.println("Computer already made that move! Try again.\n");
            }
        }
        placeMove(board, userPlay, 'X');
    }

    private static void placeMove(char[][] board, String position, char symbol) {
        switch(position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println(":(");
        }
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j != 2) {
                    System.out.print(board[i][j] + " | ");
                } else {
                    System.out.println(board[i][j]);
                    if (i != 2) {
                        System.out.println("__+___+__");
                    }
                }
            }
        }
    }
}
