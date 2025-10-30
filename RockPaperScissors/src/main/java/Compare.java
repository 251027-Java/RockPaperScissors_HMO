public class Compare {
    public static void winOrLoss(String computer, String player){
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

        System.out.println("\n" + result);
    }
}
