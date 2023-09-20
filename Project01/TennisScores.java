package Project01;
import java.util.Scanner;

/**
 * A Tennis Scores calculator. 
 *
 * @author Siddharth Sancheti - Section 33
 * @version September 18, 2023
 */

public class TennisScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Enter Player One Name: ");
        String playerOne = scanner.nextLine();
        System.out.println("Enter Player Two Name: ");
        String playerTwo = scanner.nextLine();        
        System.out.println("Enter Game Scores:");
        String scores = scanner.nextLine();
        
        scanner.close();

        // The values of each of the scores are defined below, you should use these int variables in your calculations. 
        int currentScoreIndex = 0;         
        int playerOneGameOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));        
        currentScoreIndex += 3; 
        int playerTwoGameOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        
        currentScoreIndex += 3;
        int playerOneGameTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        
        currentScoreIndex += 3;
        int playerOneGameThree = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameThree = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        
        currentScoreIndex += 3;
        int playerOneGameFour = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameFour = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        
        currentScoreIndex += 3;
        int playerOneGameFive = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameFive = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        
        currentScoreIndex += 3;
        int playerOneGameSix = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameSix = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        
        currentScoreIndex += 3;
        int playerOneGameSeven = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameSeven = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        
        currentScoreIndex += 3;
        int playerOneGameEight = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameEight = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));


        currentScoreIndex += 3;
        int playerOneGameNine = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameNine = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));        
        
       
        currentScoreIndex += 3;
        int playerOneGameTen = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameTen = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        
        currentScoreIndex += 3;
        int playerOneGameEleven = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameEleven = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        
        currentScoreIndex += 3;
        int playerOneGameTwelve = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameTwelve = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2)); 
        
        currentScoreIndex += 3;
        int playerOneGameThirteen = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameThirteen = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        
        // Making two arrays for the scores of each player so the data is easier to work with.
        int[] playerOneScores = {playerOneGameOne, playerOneGameTwo, playerOneGameThree, playerOneGameFour, playerOneGameFive, playerOneGameSix, playerOneGameSeven, playerOneGameEight, playerOneGameNine, playerOneGameTen, playerOneGameEleven, playerOneGameTwelve, playerOneGameThirteen};
        int[] playerTwoScores = {playerTwoGameOne, playerTwoGameTwo, playerTwoGameThree, playerTwoGameFour, playerTwoGameFive, playerTwoGameSix, playerTwoGameSeven, playerTwoGameEight, playerTwoGameNine, playerTwoGameTen, playerTwoGameEleven, playerTwoGameTwelve, playerTwoGameThirteen};

        // Total Number of Points the players scored.
        // Also using the totals to determine winner. May or may not work.
        
        int playerOneTotal = 0;
        int playerTwoTotal = 0;
        
        for (int i = 0; i < playerOneScores.length; ++i)
        	playerOneTotal += playerOneScores[i];
        
        for (int i = 0; i < playerOneScores.length; ++i)
        	playerTwoTotal += playerTwoScores[i];
        
        String winner = playerOneTotal > playerTwoTotal ? playerOne : playerTwo;
        
        System.out.printf("The winner is: %s\n", winner);
        
        System.out.printf("%s scored %d points.\n", playerOne, playerOneTotal);
        System.out.printf("%s scored %d points.\n", playerTwo, playerTwoTotal);
        
        // Printing the game logs
        String playerOneGameLog = "";
        String playerTwoGameLog = "";
        for (int i = 0; i < playerOneScores.length; ++i) {
        	if (didPlayerOneWin(playerOneScores[i], playerTwoScores[i])) {
        		playerOneGameLog += "-W";
        		playerTwoGameLog += "-L";
        	} else {
        		playerOneGameLog += "-L";
        		playerTwoGameLog += "-W";
        	}
        }
        playerOneGameLog = playerOneGameLog.substring(1);
        playerTwoGameLog = playerTwoGameLog.substring(1);
        
        System.out.printf("%s Game Log: %s\n", playerOne, playerOneGameLog);
        System.out.printf("%s Game Log: %s\n", playerTwo, playerTwoGameLog);
        
        // Printing the number of perfect scores for each player.
        System.out.printf("%s Perfect Games: %d\n", playerOne, perfectGames(playerOneScores, playerTwoScores));
        System.out.printf("%s Perfect Games: %d\n", playerTwo, perfectGames(playerTwoScores, playerOneScores));
        
    }
    
    
    /**
     * Determines whether player one won the game.
     * 
     * @param playerOne Player One's score for the game.
     * @param playerTwo Player Two's score for the game.
     * @return true if player one's score is greater than player two. Else, return false.
     */
    public static boolean didPlayerOneWin(int playerOne, int playerTwo) {
    	
    	return playerOne >= playerTwo;
    	
    }
    
    /**
     * Determines the number of perfect games a player has.
     * 
     * @param firstScores The player we want to find the number of perfect game for.
     * @param secondScores The player we are comparing against.
     * 
     * @return The number of perfect games the first player earned.
     */
    public static int perfectGames(int[] firstScores, int[] secondScores) {
    	int counter = 0;
    	for (int i = 0; i < firstScores.length; ++i) {
    		if (secondScores[i] == 0)
    			++counter;
    	}
    	
    	return counter;
    }
}
