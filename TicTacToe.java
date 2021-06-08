import java.util.Random;  // Import Java's Random utility to decide first player and computer moves
import java.util.Scanner; // Import Java's Scanner utilty to prompt player for moves

public class TicTacToe {
    private char[] gameBoard;
    private int turnNum;
    private boolean firstPlayer;
    private Random randomizer;
    private Scanner keyboard;

    // TicTacToe Object constructor, sets our default values
    public TicTacToe() {
        // Default values:
        this.gameBoard = new char[] {'-', '-', '-', '-', '-', '-', '-', '-', '-'};
        this.turnNum = 0;
        randomizer = new Random();
        keyboard = new Scanner(System.in);
    }

    // Determines and returns, false for computer and true for player, starting player for the game
    public boolean startGame() {
        firstPlayer = new Random().nextInt(2) != 0;
        if (firstPlayer) System.out.println("The first player is the: Player");
        else System.out.println("The first player is the: Computer");
        return firstPlayer;
    }

    // playGame plays our TicTacToe game
    public void playGame() {
        // While game is not won
        while(!checkWin()) {
            if (noMoves()) { // No moves left
                System.out.println("The game was a draw!");
                break;
            }
            if (firstPlayer) {
                // Player Move
                String play = promptPlayer();
                while (isNotValidPlay(play)) {
                   System.out.println("Invalid input, try again...");
                   play = promptPlayer();
                }
                acceptPlay(play, true);
                firstPlayer = false;
            } else {
                // Comp Move
                String play = compPlay();
                while (isNotValidPlay(play)) {
                    play = compPlay();
                }
                acceptPlay(play, false);
                System.out.println("Computer made their move.");
                firstPlayer = true;
            }
            // Display board and check for win at start of next iteration
            displayBoard();
        }
        System.out.println("Game over man");
    }

    // promptPlayer prompts our player for their next move
    public String promptPlayer() {
        System.out.print("Please select a square (A1 - C3): ");
        String input = keyboard.nextLine().toUpperCase();
        while (!(input.equals("A1") || input.equals("A2") || input.equals("A3") || input.equals("B1") || input.equals("B2") || input.equals("B3") || input.equals("C1") || input.equals("C2") || input.equals("C3")) ) {
            System.out.print("Invalid, please select a square (A1 - C3): ");
            input = keyboard.nextLine().toUpperCase();
        }

        return input;
    }

    // compPlay gets a randomized computer play
    public String compPlay() {
        switch (randomizer.nextInt(9)) {
            case 0:
                return "A1";
            case 1:
                return "B1";
            case 2:
                return "C1";
            case 3:
                return "A2";
            case 4:
                return "B2";
            case 5:
                return "C2";
            case 6:
                return "A3";
            case 7:
                return "B3";
            case 8:
                return "C3";
        }
        return "";
    }

    // checkWin checks if the game has been won
    public boolean checkWin() {
        // Rows:
        // A1 B1 C1 -> 0 1 2
        if (gameBoard[0] != '-' && gameBoard[0] == gameBoard[1] && gameBoard[1] == gameBoard[2]) {
            if (gameBoard[0] == 'X') System.out.println("Player Won!");
            else if (gameBoard[0] == 'O') System.out.println("Computer Won!");
            return true;
        // A2 B2 C2 -> 3 4 5
        } else if (gameBoard[3] != '-' && gameBoard[3] == gameBoard[4] && gameBoard[4] == gameBoard[5]) {
            if (gameBoard[3] == 'X') System.out.println("Player Won!");
            else if (gameBoard[3] == 'O') System.out.println("Computer Won!");
            return true;
        // A3 B3 C3 -> 6 7 8
        } else if (gameBoard[6] != '-' && gameBoard[6] == gameBoard[7] && gameBoard[7] == gameBoard[8]) {
            if (gameBoard[6] == 'X') System.out.println("Player Won!");
            else if (gameBoard[6] == 'O') System.out.println("Computer Won!");
            return true;
        // Cols:
        // A1 A2 A3 -> 0 3 6
        } else if (gameBoard[0] != '-' && gameBoard[0] == gameBoard[3] && gameBoard[3] == gameBoard[6]) {
            if (gameBoard[0] == 'X') System.out.println("Player Won!");
            else if (gameBoard[0] == 'O') System.out.println("Computer Won!");
            return true;
        // B1 B2 B3 -> 1 4 7
        } else if (gameBoard[1] != '-' && gameBoard[1] == gameBoard[4] && gameBoard[4] == gameBoard[7]) {
            if (gameBoard[1] == 'X') System.out.println("Player Won!");
            else if (gameBoard[1] == 'O') System.out.println("Computer Won!");
            return true;
        // C1 C2 C3 -> 2 5 8
        } else if (gameBoard[2] != '-' && gameBoard[2] == gameBoard[5] && gameBoard[5] == gameBoard[8]) {
            if (gameBoard[2] == 'X') System.out.println("Player Won!");
            else if (gameBoard[2] == 'O') System.out.println("Computer Won!");
            return true;
        // Diag:
        // A1 B2 C3 -> 0 4 8
        } else if (gameBoard[0] != '-' && gameBoard[0] == gameBoard[4] && gameBoard[4] == gameBoard[8]) {
            if (gameBoard[0] == 'X') System.out.println("Player Won!");
            else if (gameBoard[0] == 'O') System.out.println("Computer Won!");
            return true;
        // C1 B2 A3 -> 2 4 6
        } else if (gameBoard[2] != '-' && gameBoard[2] == gameBoard[4] && gameBoard[4] == gameBoard[6]) {
            if (gameBoard[2] == 'X') System.out.println("Player Won!");
            else if (gameBoard[2] == 'O') System.out.println("Computer Won!");
            return true;
        }

        // Game hasn't been won
        return false;
    }

    // displayBoard prints the game board to the screen
    public void displayBoard() {
        System.out.println("# A B C");
        System.out.printf("1 %c %c %c\n", gameBoard[0], gameBoard[1], gameBoard[2]);
        System.out.printf("2 %c %c %c\n", gameBoard[3], gameBoard[4], gameBoard[5]);
        System.out.printf("3 %c %c %c\n", gameBoard[6], gameBoard[7], gameBoard[8]);
    }

    // switchInput changes user input to the array index needed
    private int switchInput(String play) {
        switch (play) {
            case "A1":
                return 0;
            case "B1":
                return 1;
            case "C1":
                return 2;
            case "A2":
                return 3;
            case "B2":
                return 4;
            case "C2":
                return 5;
            case "A3":
                return 6;
            case "B3":
                return 7;
            case "C3":
                return 8;
        }
        return -1;
    }

    // isNotValidPlay checks if a play is currently valid
    public boolean isNotValidPlay(String play) {
        int intPlay = switchInput(play);
        return intPlay != -1 && gameBoard[intPlay] != '-';
    }

    // acceptPlay takes a play and player and updates the game board
    public void acceptPlay(String play, boolean player) {
        int intPlay = switchInput(play);
        char marker = 'O';
        if (player) marker = 'X';
        gameBoard[intPlay] = marker;
    }

    // noMoves checks if theres no valid moves left to make
    public boolean noMoves() {
        return gameBoard[0] != '-' && gameBoard[1] != '-' && gameBoard[2] != '-'
            && gameBoard[3] != '-' && gameBoard[4] != '-' && gameBoard[5] != '-'
            && gameBoard[6] != '-' && gameBoard[7] != '-' && gameBoard[8] != '-';
    }
}
