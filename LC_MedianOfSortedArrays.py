

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        list2=sorted(nums1+nums2)
        if len(list2)%2==0:
            k=len(list2)//2
            return (list2[k]+list2[(k-1)])/2
        else:
            k=len(list2)//2
            return list2[k]
k=Solution()
m=int(input())
n=int(input())
list1=[]
for i in range(m):
  list1.append(int(input()))
list2=[]
for i in range(n):
  list2.append(int(input()))
print(k.findMedianSortedArrays(list1,list2))
        
        
