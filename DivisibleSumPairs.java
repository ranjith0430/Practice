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
  Given an array of integers and a positive integer , determine the number of (i,j) pairs where i<j and  arr[i]+arr[j]  is divisible by k.

Example
arr=[1,2,3,4,5,6]
k=5



Three pairs meet the criteria: [1,4] ,[2,3] and [4,6].
  */

    /*
     * Complete the 'divisibleSumPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY ar
     */

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
    // Write your code here
    int count=0;
    //List<ArrayList<Integer>> list1=new ArrayList<>();
    for(int i=0; i<ar.size();i++){
        for(int j=i+1;j<ar.size();j++){
            //System.out.println(ar.get(i)+ar.get(j));
            if((ar.get(i)+ar.get(j))%k==0){
                count+=1;
            }
        }
        //System.out.println("---------");
    }
return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
