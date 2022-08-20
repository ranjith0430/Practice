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
  Given an array of integers, determine the minimum number of elements to delete to leave only elements of equal value.
  
  */

    /*
     * Complete the 'equalizeArray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int equalizeArray(List<Integer> arr) {
    // Write your code here
    Map<Integer,Integer> arr1=new TreeMap<>();
    int count=0;
    for(int i=0;i<arr.size();i++){
        if(arr1.containsKey(arr.get(i))){
            arr1.put(arr.get(i), arr1.get(arr.get(i))+1);
        }
        else{
            arr1.put(arr.get(i),1);
        }
    }
    List<Integer> values1=new ArrayList<>(arr1.values());
    for(int i=0;i<values1.size();i++){
        if(count<values1.get(i)){
            count=values1.get(i);
        }
    }
    //System.out.println(arr1);
    return arr.size()-count;

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

        int result = Result.equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
