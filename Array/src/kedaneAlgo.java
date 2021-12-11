/*Given an array arr of N integers.
Find the contiguous sub-array with maximum sum.



Example 1:

Input:
N = 5
arr[] = {1,2,3,-2,5}
Output:
9
Explanation:
Max subarray sum is 9
of elements (1, 2, 3, -2, 5) which
is a contiguous subarray.
Example 2:

Input:
N = 4
arr[] = {-1,-2,-3,-4}
Output:
-1
Explanation:
Max subarray sum is -1
of element (-1)


Your Task:
You don't need to read input or print anything.
The task is to complete the function maxSubarraySum()
which takes arr and N as input parameters and
returns the sum of subarray with maximum sum.



Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)



Constraints:
1 ≤ N ≤ 10^6
-107 ≤ A[i] <= 10^7
*/


public class kedaneAlgo {
    public  static  void main(String[] args)
    {
        int [] arr=new int[]{1,2,3,-2,-1,5};
        int maxsf=Integer.MIN_VALUE;//maxsf=max_so_far

        int maxeh=0;//maxeh=   max_end_here
        for(int ele:arr)
        {
            maxeh+=ele;
            if(maxeh > maxsf)
            {
                maxsf=maxeh;
            }
            if(maxeh<0)
                maxeh=0;
        }
        System.out.println("Maximum sum of any subArray in the array is "+maxsf);

        int minsf=Integer.MAX_VALUE;
        int mineh=0;
        for(int ele:arr)
        {
            mineh+=ele;
            if(mineh < minsf)      //{1,2,3,-2,5,-1}
            {
                minsf=mineh;
            }
            if(mineh>0)
                mineh=0;
        }
        System.out.println(minsf);
    }

}
