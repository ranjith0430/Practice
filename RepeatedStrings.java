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
  There is a string,s , of lowercase English letters that is repeated infinitely many times. Given an integer,n , find and print the number of letter a's in the 
  first n letters of the infinite string.

Example s='abcac' n=10
 


The substring we consider is abcacabcac, the first  10 characters of the infinite string. There are 4 occurrences of a in the substring.
  
  */

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */
     
    

    public static long repeatedString(String s, long n) {
    // Write your code here
    
    long count=0;
    //System.out.println(s);
    if(s.length()==1 && s.equals("a")){
        return n;
    }
    if(n<=s.length()){
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a'){
                count++;
            }
        }
        return count;
    }
    else{
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                count++;
            }
        }
        long rem=n-s.length();
        long k=rem%s.length();
        if(k==0){
            return count+(count*(rem/s.length()));
        }else{
            int i=0;
            count+=(count*(rem/s.length()));
            while(i<k){
                if(s.charAt(i)=='a'){
                    count++;
                }
                i++;
            }
        return count;
        }
    }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
