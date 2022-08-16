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
  Given a range of numbered days,[i....j]  and a number k , determine the number of days in the range that are beautiful. Beautiful numbers are defined as numbers
  where |i-reverse(i)| is evenly divisible by k.  If a day's value is a beautiful number, it is a beautiful day. Return the number of beautiful days in the range.
  */

    /*
     * Complete the 'beautifulDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER i
     *  2. INTEGER j
     *  3. INTEGER k
     */
    public static int reverse(int i){//reverse
        String s="";
        while(i>0){
            s=s+(i%10);
            i=i/10;
        }
        return Integer.parseInt(s);
    }

    public static int beautifulDays(int i, int j, int k) {
    // Write your code here
    int count=0;
    for(int m=i;m<=j;m++){
        if(Math.abs(m-reverse(m))%k==0){//|num-rev(num)|%k==0
            count++;
        }
    }
    return count;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
