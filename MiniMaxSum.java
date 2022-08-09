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
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. 
     * Then print the respective minimum and maximum values as a single line of two space-separated long integers.
     
     */
     
    
    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
    //sort the array
    Integer[] arr1=new Integer[arr.size()];
    for(int i=0;i<arr.size();i++){
        arr1[i]=arr.get(i);
    }
    Arrays.sort(arr1);
    
    /*for(int i:arr1){
        System.out.println(i);
    }*/
    
    long sum=0,sum1=0;
    for(int i=0;i<5;i++){
        if(i<4){
            sum+=arr1[i];//min sum
        }
        if(i>=1){
            //System.out.println(i);
            sum1+=arr1[i];//max sum
        }
    }
    System.out.println((sum +" "+sum1));

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
