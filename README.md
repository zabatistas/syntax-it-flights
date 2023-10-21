# syntax-it-flights
An assesment from SyntaxIT that requested the maximum  duration sum of exactly two movies, from a list of movies, with the following constraint: 

flightDuration - 30 <= sum <= flightDuration

I approached it the following way:
1) I found a naive solution, using a nested for-loop that took O(n2)
2) I thought that it would help if my list was ordered, but then the original indexing would be lost
3) I created a HashMap(key -> movie duration, value -> original index), which has complexity of O(n) and then I sorted the list, with complexity O(nlogn) (I thinkJava uses TimSort) . That way I could hold on to the index, and find them in O(1).
4) I then kept two pointers, one that starts at the beginning of my list (smallest duration) and one that starts on the rightmost element.
5) At each iteration, the method calculates the combined length of the two movies pointed to by the pointers. If this combined length is less than the flight length minus a buffer of 30 minutes, the method increments the left pointer. If the combined length is greater than the flight length, the method decrements the right pointer. If the combined length is between the flight length and the flight length minus the buffer, the method checks if this combined length is greater than the current maximum combined length. If it is, the method updates the maxRuntime, smallerMovieLength, and longestMovieLength variables accordingly.  


Run instructions:
```
Java 17
javac Main.java
java Main 
```
