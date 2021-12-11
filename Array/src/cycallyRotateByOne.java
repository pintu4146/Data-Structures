/*
Given an array, rotate the array by one position in clock-wise direction.
 Example 1:

Input:
N = 5
A[] = {1, 2, 3, 4, 5}
Output:
5 1 2 3 4


Example 2:

Input:
N = 8
A[] = {9, 8, 7, 6, 4, 2, 1, 3}
Output:
3 9 8 7 6 4 2 1
 Your Task:
You don't need to read input or print anything.
Your task is to complete the function rotate() which
takes the array A[] and its size N as inputs and modify the array.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1<=N<=105
0<=a[i]<=105*/






public class cycallyRotateByOne {
    public  static  void  main(String[] args)
    {
        int  A[] = {9, 8, 7, 6, 4, 2, 1, 3};// 5 1 2 3 4
        int last=A[A.length-1];
        for(int i= A.length-1;i>0;i--)
        {
            A[i]=A[i-1];
        }
        A[0]=last;
        for (int ele :A)
        {
            System.out.print(ele+ " ");
        }

    }
}
