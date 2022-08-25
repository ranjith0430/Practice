class Solution:
    def isPalindrome(self, x: int) -> bool:
        sum=0
        temp=x
        while temp>0:
            sum=(sum*10)+(temp%10)
            temp//=10
        print(sum)
        if sum==x:
            return True
        return False
k=solution()
n=int(input())
print(k.isPalindrome(n))
