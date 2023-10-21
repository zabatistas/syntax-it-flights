import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("Example with 7 movies, flight length of 250 minutes, and a 30 minute buffer");
        List<Integer> movieLengths = new ArrayList<>(Arrays.asList(90, 85, 75, 60, 120, 150, 125));
        System.out.println("Initial movie lengths: " + movieLengths.toString());
        int flightLength = 250;
        MoviePairings moviePairings = new MoviePairings();
        System.out.println("Movie indexes with the optimal viewing time: " + moviePairings.getMoviePair(movieLengths, flightLength));

        System.out.println("Example with 10 movies, flight length of 170 minutes, and a 30 minute buffer");
        movieLengths = new ArrayList<>(Arrays.asList(90, 85, 75, 60, 120, 150, 125, 100, 110, 80));
        System.out.println("Initial movie lengths: " + movieLengths.toString());
        flightLength = 170;
        System.out.println("Movie indexes with the optimal viewing time: " + moviePairings.getMoviePair(movieLengths, flightLength));

        System.out.println("Example with 2 movies, flight length of 170 minutes, and movies that are too long");
        movieLengths = new ArrayList<>(Arrays.asList(90, 85));
        System.out.println("Initial movie lengths: " + movieLengths.toString());
    }
}
