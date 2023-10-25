package Week10.Challenge;

public class Main {
    public static void main(String[] args) {
        try {
            MapNavigator[] mapNavigators = {
            new MapNavigator(1 , "PlayerOneMoves.txt"), 
            new MapNavigator(2 , "PlayerTwoMoves.txt"), 
            new MapNavigator(3 , "PlayerThreeMoves.txt"), 
              new MapNavigator(4 , "PlayerFourMoves.txt")}; 
    
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
