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
  Given an array of bird sightings where every element represents a bird type id, determine the id of the most frequently sighted type. 
  If more than 1 type has been spotted that maximum amount, return the smallest of their ids.
Example: arr=[1,1,2,2,3]

There are two each of types 1 and 2, and one sighting of type 3. Pick the lower of the two types seen twice: type 1 .
  
  */

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
    // Write your code here
    Map<Integer,Integer> map1=new TreeMap<>();// sorted dictionary
    for(int i=0;i<arr.size();i++){
        if(map1.containsKey(arr.get(i))){//count+1
            map1.put(arr.get(i), map1.get(arr.get(i))+1);
        }
        else{//count=1
            map1.put(arr.get(i), 1);
        }
    }
    int max=Integer.MIN_VALUE;
    for(Integer i: map1.values()){
        if(i>max){//for max count
            max=i;
        }
    }
    int count=0;
    int k=0;
    for(Integer i: map1.keySet()){
        if(map1.get(i)==max && count<1){//need least id
            k=i;
            count++;
        }
    }
    return k;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
