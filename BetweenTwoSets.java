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
      * There will be two arrays of integers. Determine all integers that satisfy the following two conditions:
      * The elements of the first array are all factors of the integer being considered
      * The integer being considered is a factor of all elements of the second array
      * These numbers are referred to as being between the two arrays. Determine how many such numbers exist.
       a=[2,6],b=[24,36] 

           There are two numbers between the arrays: 6  and 12.
           return 2
  
  */

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
     
    public static List<Integer> factorsNum(int a){
        List<Integer> list1=new ArrayList<>();
        int num=1;
        while(num<=a){
            if(a%num==0){
                list1.add(num);
            }
            num++;        
        }
        return list1;
    }
    
        public static List<Integer> factorCheck(List<Integer> a,List<Integer> b){
        //obtained factors-a , b- arr1/arr2
        List<Integer> list1=new ArrayList<>();
        for(int i=0;i<a.size();i++){
            boolean flag=true;
            for(int j=0;j<b.size();j++){
                if(b.get(j)%a.get(i)!=0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                list1.add(a.get(i));   
            }
        }
    return list1;
    }
    
    public static List<Integer> factorCheckAll(List<Integer> a,List<Integer> b){
        //obtained factors-a , b- arr1/arr2
        List<Integer> list1=new ArrayList<>();
        for(int i=0;i<a.size();i++){
            boolean flag=true;
            for(int j=0;j<b.size();j++){
                if(a.get(i)%b.get(j)!=0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                list1.add(a.get(i));   
            }
        }
    return list1;
    }
    

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
    List<Integer> list1=new ArrayList<>();
    for(int i=0;i<b.size();i++){
        int num=b.get(i);
        List<Integer> list2=factorsNum(num);
        list1.addAll(list2);
    }
    TreeSet<Integer> set1=new TreeSet<>();
    set1.addAll(list1);
    List<Integer> list2=new ArrayList<>();
    list2.addAll(set1);    
    list2=factorCheckAll(list2,a);
    list2=factorCheck( list2,b);
    return list2.size();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
