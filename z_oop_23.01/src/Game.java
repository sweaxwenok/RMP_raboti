import java.util.Scanner;

public class Game {
    private char[][] board;
    private Player1 player1;
    private Player1 player2;
    private char currentPlayer;

    public Game(Player1 player1, Player1 player2) {
        this.board = new char[3][3];
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;
        int moves = 0;
        printBoard();
        while(!gameWon && moves < 9) {
            int[] move;
            if (currentPlayer == 'X') {
                System.out.println(player1.getName() + ", введите свой ход (строка и столбец, например, 0 0).");
                move = getPlayerMove(scanner);
                while(board[move[0]][move[1]] != '-'){
                    System.out.println("Неверный ход, пожалуйста, повторите попытку");
                    move = getPlayerMove(scanner);
                }
            } else {
                System.out.println(player2.getName() + ", введите свой ход (строка и столбец, например, 0 0).");
                move = getPlayerMove(scanner);
                while(board[move[0]][move[1]] != '-'){
                    System.out.println("Неверный ход, пожалуйста, повторите попытку");
                    move = getPlayerMove(scanner);
                }
            }
            board[move[0]][move[1]] = currentPlayer;
            printBoard();
            moves++;
            gameWon = checkWin();
            if(gameWon){
                System.out.println(currentPlayer + " Выиграл!");
            }else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
        if (moves == 9 && !gameWon){
            System.out.println("Это ничья");
        }
    }

    private int[] getPlayerMove(Scanner scanner) {
        int[] move = new int[2];
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        move[0] = Integer.parseInt(parts[0]);
        move[1] = Integer.parseInt(parts[1]);
        return move;
    }


    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}