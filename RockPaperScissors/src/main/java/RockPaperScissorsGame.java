import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        IO.println("Rock, Paper, Scissors");
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