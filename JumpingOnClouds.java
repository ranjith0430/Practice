import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
  
  /*
  A child is playing a cloud hopping game. In this game, there are sequentially numbered clouds that can be thunderheads or cumulus clouds. The character must jump 
  from cloud to cloud until it reaches the start again.

There is an array of clouds,  and an energy level e=100. The character starts from c[0] and uses 1 unit of energy to make a jump of size k to cloud c[i+k%n] . If it 
lands on a thundercloud,c[i]=1 , its energy (e) decreases by 2 additional units. The game ends when the character lands back on cloud c=0.
  */

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
        int i=0, n=c.length;
        int count=100;
        while((i+k)%n!=0){
            if(c[(i+k)%n]==1){
                count-=3;
            }
            else{
                count-=1;
            }
            i+=k;
        }
        if(c[0]==1){//initial state
            return count-3;
        }else{
            return count-1;
            }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
