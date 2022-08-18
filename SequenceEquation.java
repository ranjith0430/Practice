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
  Given a sequence of n integers,p(1),p(2)..p(n)  where each element is distinct and satisfies 1<=p(x)<=n. 
  For each x where 2<=x<=n, that is s increments from  1 to n , find any integer y such that p(p(y))==x  and keep a history of the values of y in a return array.
  */

    /*
     * Complete the 'permutationEquation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static List<Integer> permutationEquation(List<Integer> p) {
    // Write your code here
    List<Integer> output=new ArrayList<>();
    int i=0;
    while(i<p.size()){
        for(int j=0;j<p.size();j++){
            if(i+1==p.get(j)){
                for(int k=0;k<p.size();k++){
                     if(j+1==p.get(k)){
                        output.add(k+1);
                         break;
                     }
                 }
            }
        }
        i++;
    }
    
    return output;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> p = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.permutationEquation(p);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
