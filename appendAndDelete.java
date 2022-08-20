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
  You have two strings of lowercase English letters. You can perform two types of operations on the first string:
  1. Append a lowercase English letter to the end of the string.
  2.Delete the last character of the string. Performing this operation on an empty string results in an empty string.
Given an integer, k, and two strings, s  and t, determine whether or not you can convert s to t by performing exactly k of the above operations on s. If it's 
possible, print Yes. Otherwise, print No.

If there were more moves available, they could have been eliminated by performing multiple deletions on an empty string
  */

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */
     
    

    public static String appendAndDelete(String s, String t, int k) {
    // Write your code here
    
    if(s.length()<t.length() && s.indexOf(t.charAt(t.length()-1))==-1){//non empty string 
            return "No";
    }
    
        int n=s.length();
        int l=t.length();
        int index=0;
        while(n>0){
            //System.out.println(n);
            boolean flag=false;
            while(l>0){
                //System.out.println(s.substring(0,n-1)+"  "+t.substring(0,l-1));
            if((s.substring(0,n)).equals(t.substring(0,l))){
                index=n;
                flag=true;
                break;
            }
            
            l--;
            }
            if(flag){
                break;
            }
            l=t.length();
            n--;
        }
        System.out.println(index);
        int p1=s.length()-index;
        int p2=t.length()-index;
        System.out.println(p1);
        System.out.println(p2);

        return (p1+p2<=k) ? "Yes":"No";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
