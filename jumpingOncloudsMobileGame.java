import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */
  
  /*
  here is a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads and others are cumulus. The player can jump on any
  cumulus cloud having a number that is equal to the number of the current cloud plus  1 or2 . The player must avoid the thunderheads. Determine the minimum number
  of jumps it will take to jump from the starting postion to the last cloud. It is always possible to win the game.

For each game, you will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided.

c=[0,1,0,0,0,1,0]

Index the array from 0...6. The number on each cloud is its index in the list so the player must avoid the clouds at indices 1 and 5. They could follow these two 
paths: 0->2->4->6 or 0->2->3->4->6. The first path takes 3 jumps while the second takes 4. 
Return 3.
  
  */

    public static int jumpingOnClouds(List<Integer> c) {
    // Write your code here
    int count=0,i=0;    
    while(i<c.size()){
        if(i+1<c.size() && c.get(i+1)==0){
            if(i+2<c.size() && c.get(i+2)==0){
                count+=1;          
                i++;
            }
            else{
                count+=1;
            }            
        }
        else{
            count+=1;
            System.out.println(count);
            i++;                  
        }
        i++;
    }
    return count-1;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
