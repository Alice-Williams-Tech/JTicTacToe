import java.util.Scanner; // Import the Scanner utility for reading our user input

// Main, our Driver program, using our game classes
public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean firstRun = true;
        boolean eggFound = false;

        while (true) {
            // Spacer between runs
            if (!firstRun) System.out.println();
            else firstRun = false;

            // Greet our user
            System.out.println("Welcome User To Tic-Tac-Toe...\n"
                              +"Would you like you play (Y/N)?");      

            // Display user prompt
            System.out.print("> ");

            // Get initial user input
            String gameChoice = keyboard.nextLine();
            
            // Check for invalid input
            while(!(gameChoice.toUpperCase().equals("N") || gameChoice.toUpperCase().equals("Y"))) {
            
                // Reprompt for input
                System.out.println("Invalid Input Try Again (Y/N)?");
                System.out.print("> ");
                // Get new user input
                gameChoice = keyboard.nextLine();
            }
            
            // Exit program for Q inputs
            if (gameChoice.toUpperCase().equals("N")) break;
            
            System.out.println("\nTic-Tac-Toe Game Starting");
                    
            TicTacToe ticTacToe = new TicTacToe();
            // Start the game
            ticTacToe.startGame();
            // Explain board pieces
            System.out.println("Player plays as X, Computer as O");
            // Display initial board
            ticTacToe.displayBoard();

            // Play the game
            ticTacToe.playGame();
        }
        // Let user know program is exiting
        System.out.println("Goodbye User");
    }
}
