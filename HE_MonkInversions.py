"""
Monk's best friend Micro, who happen to be an awesome programmer, got him an integer matrix M of size NxN for his birthday. Monk is taking coding classes from Micro.
They have just completed array inversions and Monk was successful in writing a program to count the number of inversions in an array. Now, Micro has asked Monk to 
find out the number of inversion in the matrix M. Number of inversions, in a matrix is defined as the number of unordered pairs of cells {(i,j),(p,q)} such that 
M[i][j]>M[p][q] & i<=p & j<=q.
Monk is facing a little trouble with this task and since you did not got him any birthday gift, you need to help him with this task.
"""

test_case = int(input())
for i in range(test_case):
    N=int(input())
    list1=[]
    for i in range(N):
        list1.append(list(map(int,input().split())))
    i,j=0,0
    count=0
    while(i<N and j<N):
        for p in range(0,N):
            for q in range(0,N):
                if list1[i][j]>list1[p][q] and i<=p and j<=q:
                    count+=1
        j+=1
        if j>=N:
            i+=1
            j=0
    print(count)
    
