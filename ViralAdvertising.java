import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;import java.lang.Math;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
  
  /*
  HackerLand Enterprise is adopting a new viral advertising strategy. When they launch a new product, they advertise it to exactly  people on social media.
  On the first day, half of those 5 people (i.e., floor(5/2)=2) like the advertisement and each shares it with 3 of their friends. 
  At the beginning of the second day, floor(5/2)*3=6 people receive the advertisement.
  Each day,  floor(recipients/2) of the recipients like the advertisement and will share it with  friends on the following day. Assuming nobody receives the advertisement twice, determine how many people have liked the ad by the end of a given day, 
  beginning with launch day as day .
  */

    /*
     * Complete the 'viralAdvertising' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int viralAdvertising(int n) {
    // Write your code here
    int[] shared=new int[n];
    int[] liked=new int[n];
    shared[0]=5;
    liked[0]=(int)(Math.floor(5/2));
    int sum=liked[0];//cummilative likes
    //System.out.println(liked[0]);
    for(int i=1;i<n;i++){
        shared[i]=liked[i-1]*3;
        liked[i]=(int)(Math.floor(shared[i]/2));
        sum+=liked[i];
    }
    return sum;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
