package Array;

import java.util.HashSet;

/*Given two arrays a[] and b[] of size n and n respectively. The task is to find union between these two arrays.

Union of the two arrays can be defined as the set containing distinct elements from both the arrays.
 If there are repetitions, then only one occurrence of element should be printed in union.

Example 1:

Input:
5 3
1 2 3 4 5
1 2 3

Output:
5

Explanation:
1, 2, 3, 4 and 5 are the
elements which comes in the union set
of both arrays. So count is 5.
Example 2:

Input:
6 2
85 25 1 32 54 6
85 2

Output:
7

Explanation:
85, 25, 1, 32, 54, 6, and
2 are the elements which comes in the
union set of both arrays. So count is 7.
Your Task:
Complete doUnion funciton that takes a, n, b, m as parameters and
returns the count of union elements of the two arrays.
The printing is done by the driver code.

Constraints:
1 ≤ n, m ≤ 105
1 ≤ a[i], b[i] < 105

Expected Time Complexity : O((n+m)log(n+m))
Expected Auxilliary Space : O(n+m)*/
public class unionSortedArr {
    public static void main(String[] args)
    {
      int [] arr={85, 25,1, 32, 54, 6};
      int[] arr1={85, 2};
      union(arr,arr1);//this will work for sorted as welll as unsorted
        int[] arrs={1,2,3,4,5,6,7,8,9};
        int [] arrs1={1,2};
        forSortedArr(arrs,arrs1);
    }

    private static void forSortedArr(int[] arrs, int[] arrs1) {
        int n=arrs.length;
        int m= arrs1.length;
        int max=Math.max(n,m);
        int min=Math.min(n,m);
        int [] unionArr=new int[max];
       int i=0,j=0;
       while(i< n && j<m)
       {
           if(arrs[i]>arrs1[j])
           {
               unionArr[i]=arrs[i];
               i++;
           }
           else  if(arrs[i] < arrs1[j])
           {
               unionArr[i]=arrs[j];
               j++;

           }
           else{
               unionArr[i]=arrs[i];
               i++;
               j++;
           }

       }
        while(i<n)
        {
            unionArr[i]=arrs[i];
            i++;
        }
        while (j<m)
        {
            unionArr[j]=arrs1[j];
            j++;
        }
        for (int eke:unionArr)
        {
            System.out.print(" "+eke);
        }
    }

    private static void union(int[] arr, int[] arr1) {
        HashSet<Integer>  hs=new HashSet<>();
        for(int ele:arr)
        {
            hs.add(ele);

        }
        for(int ele:arr1)
        {
            hs.add(ele);
        }
        System.out.println(hs.size());
        System.out.println(hs);
    }

}
