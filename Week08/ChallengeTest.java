package Week08;

import java.io.IOException;

public class ChallengeTest {
    public static void main(String[] args) throws IOException, InvalidInputException{
        Movies movies = new Movies();
        movies.makeRatingFile("PG-13");
        movies.makeScoreFile(6.5, false);
        movies.makeDurationFile(109, false);
        movies.makeYearFile(2019);
    }
}
