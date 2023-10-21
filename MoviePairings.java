import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoviePairings {

    private static final int TIME_BUFFER = 30;

    
    // we can use a hashmap to store the movie lengths as keys and their indices as values (constant lookup time)
    // I think it makes sense to sort the array in order to make the solution more efficient
    
    List<Integer> getMoviePair(List<Integer> movieLengths, int flightLength) {

        Map<Integer, Integer> movieLengthsMap = convertArrayListToHashMap(movieLengths);
        Collections.sort(movieLengths); // O(nlogn)

        System.out.println("Movie lengths sorted: " + movieLengths.toString());

        int maxRuntime = -1;
        int leftIndex = 0;
        int rightIndex = movieLengths.size() -1;
        int smallerMovieLength = -1;
        int longestMovieLength = -1;
        
        List<Integer> moviePair = new ArrayList<>();
        // Main idea is to have two pointers, one at the beginning and one at the end
        // If the sum of the two movies is less than the flight length, we increment the left pointer
        // If the sum of the two movies is greater than the flight length, we decrement the right pointer
        // If the sum is inbetween the flight length and the flight length minus the buffer, 
        // we perform a check to determine if the pair has greater sum from the previous one and 
        // if it does, we save the lengths of the movies and we increment the left pointer
        while (leftIndex < rightIndex) {
            int totalRuntime = movieLengths.get(leftIndex) + movieLengths.get(rightIndex);

            if (totalRuntime < flightLength - TIME_BUFFER) {
                leftIndex++;
            } else if (totalRuntime > flightLength) {
                rightIndex--;
            } else {
                if (totalRuntime > maxRuntime) {
                    maxRuntime = totalRuntime;
                    smallerMovieLength = movieLengths.get(leftIndex);
                    longestMovieLength = movieLengths.get(rightIndex);
                }
                leftIndex++;
            }

        }
        moviePair.add(movieLengthsMap.get(smallerMovieLength));
        moviePair.add(movieLengthsMap.get(longestMovieLength));

        return moviePair;

    }



    private static HashMap<Integer, Integer> 
    convertArrayListToHashMap(List<Integer> numList) 
    { 
  
        HashMap<Integer, Integer> lengthToInitialIndexMap = new HashMap<>(); 
  
        for (Integer  movieLength: numList) { 
  
            lengthToInitialIndexMap.put(movieLength, numList.indexOf(movieLength)); 
        } 
  
        return lengthToInitialIndexMap; 
    } 
    
}

