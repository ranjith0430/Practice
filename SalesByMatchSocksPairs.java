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
  There is a large pile of socks that must be paired by color. 
  Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

Example n=7
ar=[1,2,1,2,3,2]


There is one pair of color 1 and one of color 2 . There are three odd socks left, one of each color. The number of pairs is 2.
  
  */

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
    // Write your code here
    //sorting keys
    Map<Integer,Integer> map1=new TreeMap<>();
    for(int i=0;i<ar.size();i++){
        if(map1.containsKey(ar.get(i))){
            map1.put(ar.get(i), map1.get(ar.get(i))+1);
        }
        else{
            map1.put(ar.get(i), 1);
        }
    }
    //counting pairs
    int count=0;
    for(int i :map1.keySet()){
        if(map1.get(i)%2==0){
            count+=map1.get(i)/2;
        }
        else{
            count+=map1.get(i)/2;
        }
    }
    return count;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
