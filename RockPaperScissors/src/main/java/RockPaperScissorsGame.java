
public class RockPaperScissorsGame {
    public static void main(String[] args) {
        // Computer computer = new Computer();
        // Player player = new Player();
        boolean playGame = true;
        do {
            //loop until game is won
            boolean gameWon = false;
            while(!gameWon) {
                //TODO: Change these
                String computerChoice = computer.ComputerMethod();
                String playerChoice = player.UserInput();

                // Find the winner
                // Will compare method update scores?
                winner = compare(computerChoice, playerChoice);

                // Generate Display
                displayResults(playerChoice, computerChoice, winner); // optional pictures
                displayScore(player.score, computer.score);

                // Check if game has been won
                if(player.score == 2 || computer.score == 2) {
                    gameWon = true;
                }
                displayGameEnd(player.score, computer.score, gameWon);

            }

            // Check if user wants to play again
            String response = IO.readln("Do you want to play again? (Y/N)");
            if(response.equals("Y")) {
                playGame = true; // Game will start again
            }
            else {
                playGame = false; // Game will end
            }

        }while(playGame);
    }

    // Display results of game
    public static void displayResults(String playerChoice, String computerChoice, winner) {
        IO.println("You chose " + playerChoice);
        IO.println("Computer chose " + computerChoice);

        if(winner.equals("player")) {
            IO.println(playerChoice + " beats " + computerChoice);
            // Optional: add pictures here
        }
        else {
            IO.println(computerChoice + " beats " + playerChoice);
            // Optional: add pictures here
        }
    }

    // Display scores
    public static void displayScore(int playerScore, int computerScore)
    {
        // Print scores
        IO.println("Lets look at the scores!");
        IO.println("Player Score: " + playerScore);
        IO.println("Computer Score: " + computerScore);
        IO.println();
    }

    //Display game win screen or tell user how many games they need to win
    public static void displayGameEnd(int playerScore, int computerScore, boolean gameWon) {
        if(gameWon) {
            if(playerScore > computerScore) {
                IO.println("Congrats! You won the game!");
            }
            else if(computerScore > playerScore) {
                IO.println("Sorry, you lost the game :(");
            }
        }else {
            if(playerScore > computerScore) {
                IO.println("You are so close! Keep going!");
            }
            else if(computerScore > playerScore) {
                IO.println("Look out! You are close to losing!");
            }
            else {
                IO.println("You are tied with the computer. Keep playing!");
            }
        }
    }
}

// Have a computer class here

// Have a player class here