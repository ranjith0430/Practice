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
     * Complete the 'timeConversion' function below.
     * Given a time in -hour AM/PM format, convert it to military (24-hour) time.
     * Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
     * - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
    String s1="";
    if(s.endsWith("PM")){
        int k=Integer.parseInt(s.substring(0,2));
        if(k<12){
            s1+=(k+12)+s.substring(2);
        }
        else if(k==12){
            s1+=s;
        }
    }
    else if(s.endsWith("AM")){
        int k=Integer.parseInt(s.substring(0,2));
        if(k==12){
            s1+="00"+s.substring(2);
        }
        else{
            s1+=s;//for single numbers<10
        }
    }
    
    return s1.substring(0,s1.length()-2);  

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
