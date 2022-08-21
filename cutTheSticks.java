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
     * Complete the 'cutTheSticks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
  
  /*
  You are given a number of sticks of varying lengths. You will iteratively cut the sticks into smaller sticks, discarding the shortest pieces until there are none
  left. At each iteration you will determine the length of the shortest stick remaining, cut that length from each of the longer sticks and then discard all the 
  pieces of that shortest length. When all the remaining sticks are the same length, they cannot be shortened so discard them.

Given the lengths of n sticks, print the number of sticks that are left before each iteration until there are none left.
arr=[1,2,3]
The shortest stick length is 1, so cut that length from the longer two and discard the pieces of length 1. Now the lengths are [1,2]. Again, the shortest stick is 
of length 1, so cut that amount from the longer stick and discard those pieces. There is only one stick left, [1], so discard that stick.
The number of sticks at each iteration are [3,2,1].
  
  */
     
    

    public static List<Integer> cutTheSticks(List<Integer> arr) {
    // Write your code here
    
    //System.out.println(arr);
    List<Integer> list1=new ArrayList<>();
    while(arr.size()!=0){
        list1.add(arr.size());//size iteratively
        Collections.sort(arr);//sorting array of sticks
        int p=arr.get(0);
        for(int i=0;i<arr.size();i++){
            arr.set(i, arr.get(i)-p);
        }      
        arr.removeAll(Arrays.asList(0));   
    }
    return list1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.cutTheSticks(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
