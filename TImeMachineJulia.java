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
  Marie invented a Time Machine and wants to test it by time-traveling to visit Russia on the Day of the Programmer (the 256th day of the year) during a 
  year in the inclusive range from 1700 to 2700. From 1700 to 1917, Russia's official calendar was the Julian calendar; since 1919 they used the Gregorian calendar 
  system. The transition from the Julian to Gregorian calendar system occurred in 1918, when the next day after January 31st was February 14th. 
  This means that in 1918, February 14th was the 32nd day of the year in Russia. 
  In both calendar systems, February is the only month with a variable amount of days;  it has 29 days during a leap year, and 28 days during all other years. 
  In the Julian calendar, leap years are divisible by 4; in the Gregorian calendar, leap years are either of the following:

Divisible by 400.
Divisible by 4 and not divisible by 100.
Given a year, y, find the date of the 256th day of that year according to the official Russian calendar during that year. Then print it in the format dd.mm.yyyy, 
where dd is the two-digit day, mm is the two-digit month, and yyyy is y .

For example, the given  = 1984. 1984 is divisible by 4, so it is a leap year. The 256th day of a leap year after 1918 is September 12, so the answer is 12.09.1984.
  
  
  */

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
    // Write your code here
    
        if(year==1918){
            return "26.09.1918";
        }
        else if((year<=1917 && year%4==0 )|| (year>1918 &&(year%400==0 || (year%4==0 && year%100!=0)))){
            return "12.09."+year;
        }
        else{
            return "13.09."+year;
        }
    

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
