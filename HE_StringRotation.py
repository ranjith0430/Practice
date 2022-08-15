"""
Rotate a string by k times
Monk loves to preform different operations on arrays, and so being the principal of Hackerearth School, he assigned a task to his new student Mishki. 
Mishki will be provided with an integer array A of size N and an integer K , where she needs to rotate the array in the right direction by K steps and 
then print the resultant array. As she is new to the school, please help her to complete the task.
"""

tc = int(input())                  # Reading input from STDIN
for _ in range(tc):
    N,K=map(int,input().split())
    arr=input().split()
    k=K%N
    arr=arr[N-k:]+arr[:N-k]
    print(" ".join(arr))
