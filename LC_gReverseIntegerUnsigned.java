import java.lang.Math;
class Solution {
    public int reverse(int x) {    
      /*
      Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], 
      then return 0.
      */
        int temp=x;
        x=x<0?-x:x;        
        int sum=0;
        int preNum=0;
        while(x>0){
            int ar=x%10;
            sum=(r)+sum*10;  
            if ((sum - r)/10 != preNum)
            {
                return 0;
            }      
            preNum = sum;
            x/=10;
        }
        return temp<0?-sum:sum;       
    }
}
