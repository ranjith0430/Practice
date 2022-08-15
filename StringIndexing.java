import java.io.*;
import java.util.*;

public class Solution {
  /*
  Given a string, S, of length N that is indexed from 0 to N-1, print its even-indexed and odd-indexed characters as 2 space-separated strings on a single line 
Note: 0 is considered to be an even index.

Print abc def for s=adbecf
  
  */

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int testCases=sc.nextInt();
        for(int i=0;i<testCases;i++){
            String s=sc.next();
            String evenStr1="";
            String oddStr1="";
        //System.out.println(s);
            for(int j=0;j<s.length();j++){
                if(j%2==0){
                    evenStr1=evenStr1+s.charAt(j);   //System.out.println(evenStr1);
                 }
                 else{
                    oddStr1=oddStr1+s.charAt(j);
                 }
            }
        System.out.println(evenStr1 +" "+oddStr1);
        }
       
        sc.close();
    }
}
