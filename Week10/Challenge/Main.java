package Week10.Challenge;

public class Main {
    public static void main(String[] args) {
        try {
            MapNavigator[] mapNavigators = {
            new MapNavigator(1 , "Week10/Challenge/PlayerOneMoves.txt"), 
            new MapNavigator(2 , "Week10/Challenge/PlayerTwoMoves.txt"), 
            new MapNavigator(3 , "Week10/Challenge/PlayerThreeMoves.txt"), 
              new MapNavigator(4 , "Week10/Challenge/PlayerFourMoves.txt")}; 
    
            for (int i = 0; i < mapNavigators.length; i++) {
                mapNavigators[i].start();
            }
            for (int i = 0; i < mapNavigators.length; i++) {
                mapNavigators[i].join();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}
