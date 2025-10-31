import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();
        boolean playGame = true;
        do {
            //loop until game is won
            boolean gameWon = false;
            while(!gameWon) {
                //TODO: Change these
                String computerChoice = computer.ComputerTurn();
                String userChoice = user.userTurn();

                // Find the winner
                // Will compare method update scores?
                String winner = Compare.winOrLoss(computerChoice, userChoice);

                // Generate Display
                displayResults(userChoice, computerChoice, winner); // optional pictures
                displayScore(user.score, computer.score);

                // Check if game has been won
                if(user.score == 2 || computer.score == 2) {
                    gameWon = true;
                }
                displayGameEnd(user.score, computer.score, gameWon);

            }

            // Check if user wants to play again
            String response = IO.readln("Do you want to play again? (Y/N)");
            if(!response.equals("Y")) {
                playGame = false; // If response is not "Y", game will end
            }

        }while(playGame);
    }

    // Display results of game
    public static void displayResults(String playerChoice, String computerChoice, String winner) {
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

class Compare {
    public static String winOrLoss(String computer, String player){
        //MAIN: Compare.winOrLoss("rock", "scissors");

        //read computer and player choices
        // win cases
        // rock vs paper -> paper
        // paper vs scissors -> scissors
        // rock vs scissors -> rock
        String result ="";
        //Combinations
        // rock, paper -> player
        if (computer.equals("rock") && player.equals("paper")){
            result = "Player Won!";
        }
        // rock, scissors -> computer
        if (computer.equals("rock") && player.equals("scissors")){
            result = "Computer Won!";
        }
        // rock, rock -> tie
        if (computer.equals("rock") && player.equals("rock")){
            result = "Tie!";
        }

        //paper, rock -> computer
        if (computer.equals("paper") && player.equals("rock")){
            result = "Computer Won!";
        }
        //paper, scissors -> player
        if (computer.equals("paper") && player.equals("scissors")){
            result = "Player Won!";
        }
        //paper, paper -> tie
        if (computer.equals("paper") && player.equals("paper")){
            result = "Tie!";
        }

        //scissors, rock -> player
        if (computer.equals("scissors") && player.equals("rock")){
            result = "Player Won!";
        }
        //scissors, paper -> computer
        if (computer.equals("scissors") && player.equals("paper")){
            result = "Computer Won!";
        }
        //scissors, scissors -> tie
        if (computer.equals("scissors") && player.equals("scissors")){
            result = "Tie!";
        }


        return result;
    }
}




class Computer{
    //computer score
    int score;
    //array for computer choices
    String[] choices = {"Rock", "Paper", "Scissors"};
    //random object to be used for computer choice
    Random compChoice = new Random();

    public Computer(){};

    public String ComputerTurn(){
        int randomIndex = compChoice.nextInt(choices.length);
        String pickedObj = choices[randomIndex];
        return pickedObj;
    }
}

class User {
    //user score
    int score;
    Scanner userInput = new Scanner(System.in);
    String[] choices = {"Rock", "Paper", "Scissors"};
    String answer;

    public User() {
    }

    public String userTurn() {
        try {
            IO.println("Rock...Paper...Scissors...SHOOT!! Which object would the user like to choose?");
            String answer = userInput.next();
            if (!answer.equalsIgnoreCase(choices[0]) || !answer.equalsIgnoreCase(choices[1]) || !answer.equalsIgnoreCase(choices[2])) {
                throw new IllegalArgumentException("INAPPROPRIATE OBJECT!!! plz choose rock paper or scissors only plz");
            }
            IO.println("Rock...Paper...Scissors...SHOOT!! Which object would the user like to choose?");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            IO.println("Terrible choice. It's not even allowed please pick on of the GAME OBJECTS :( ");
        }
        return answer;
    }
}
