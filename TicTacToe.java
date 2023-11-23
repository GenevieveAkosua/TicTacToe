import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    public static void main(String[] args) {

        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        printBoard(board);

        playerMove(board);

        computerMove(board);

        printBoard(board);
    }

    private static void computerMove(char[][] board) {
        Random random = new Random();
        int computerMove;

        while (true) {
            computerMove = random.nextInt(9) + 1;
            if (isValidMove(board, computerMove)) {
                break;
            }
        }

        placeMove(board, Integer.toString(computerMove), 'O');
    }

    private static boolean isValidMove (char[][] board, int position) {
        switch (position) {
            case 1:
                return board[0][0] == ' ';
            case 2:
                return board[0][1] == ' ';
            case 3:
                return board[0][2] == ' ';
            case 4:
                return board[1][0] == ' ';
            case 5:
                return board[1][1] == ' ';
            case 6:
                return board[1][2] == ' ';
            case 7:
                return board[2][0] == ' ';
            case 8:
                return board[2][1] == ' ';
            case 9:
                return board[2][2] == ' ';
            default:
                return false;
        }
    }

    private static void playerMove(char[][] board) {
        Scanner input = new Scanner(System.in);
        System.out.println("Where would you like to play? (1-9)");
        String userPlay = input.nextLine();
        System.out.println();

        placeMove(board, userPlay, 'X');

        input.close();
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
