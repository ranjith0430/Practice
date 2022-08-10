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
  
  /*Sam's house has an apple tree and an orange tree that yield an abundance of fruit. Using the information given below, determine the number of apples and oranges that land on Sam's house.


The red region denotes the house, where  is the start point, and  is the endpoint. The apple tree is to the left of the house, and the orange tree is to its right.
Assume the trees are located on a single point, where the apple tree is at point , and the orange tree is at point .
When a fruit falls from its tree, it lands  units of distance from its tree of origin along the -axis. *A negative value of  means the fruit fell  units to the tree's left, and a positive value of  means it falls  units to the tree's right. *
Apple and orange(2).png

For example, Sam's house is between s=7 and t=10. The apple tree is located at a=4 and the orange at b=12 . 
There are  m=3 apples and  n=3 oranges. Apples are thrown  apples=[2,3,-4] units distance from a, and oranges=[3,-2,-4] units distance. 
Adding each apple distance to the position of the tree, they land at [4+2,4+3,4-4]=[6,7,0]. Oranges land at [12+3,12-2,12-4]=[15,10,8]. 
One apple and two oranges land in the inclusive range 7-10 so we print
1
2
Function Description

Complete the countApplesAndOranges function in the editor below. It should print the number of apples and oranges that land on Sam's house, each on a separate line.

countApplesAndOranges has the following parameter(s):

s: integer, starting point of Sam's house location.
t: integer, ending location of Sam's house location.
a: integer, location of the Apple tree.
b: integer, location of the Orange tree.
apples: integer array, distances at which each apple falls from the tree.
oranges: integer array, distances at which each orange falls from the tree.
Input Format:

The first line contains two space-separated integers denoting the respective values of s and t.
The second line contains two space-separated integers denoting the respective values of  a and b.
The third line contains two space-separated integers denoting the respective values of  m and n .
The fourth line contains m space-separated integers denoting the respective distances that each apple falls from point a .
The fifth line contains n space-separated integers denoting the respective distances that each orange falls from point b.



Given the value of  for  apples and  oranges, determine how many apples and oranges will fall on Sam's house (i.e., in the inclusive range )
*/

    /*
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER t
     *  3. INTEGER a
     *  4. INTEGER b
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
     */

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
    // Write your code here
    List<Integer> apple=new ArrayList<>();
    List<Integer> orange=new ArrayList<>();
    int count=0,count1=0;
    for(int i=0;i<apples.size();i++){
        apple.add(apples.get(i)+a);
    } 
    for(int i=0;i<oranges.size();i++){
        orange.add(oranges.get(i)+b);
    } 
    for(int i=0;i<apple.size();i++){
        int k=apple.get(i);
        if(k>=s && k<=t){
            count+=1;
        }
    } 
    for(int i=0;i<orange.size();i++){
        int k=orange.get(i);
        if(k>=s && k<=t){
            count1+=1;
        }
    } 
    
    System.out.println(count);
    System.out.println(count1);    
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int s = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int a = Integer.parseInt(secondMultipleInput[0]);

        int b = Integer.parseInt(secondMultipleInput[1]);

        String[] thirdMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(thirdMultipleInput[0]);

        int n = Integer.parseInt(thirdMultipleInput[1]);

        List<Integer> apples = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> oranges = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.countApplesAndOranges(s, t, a, b, apples, oranges);

        bufferedReader.close();
    }
}
