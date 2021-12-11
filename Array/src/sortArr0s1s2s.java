/*problem statement below*/
/* one other approach also existy*/
public class sortArr0s1s2s {
    public static  void main(String[] args)
    {
        int arr[]= {0,1,2,0,2,1,0};
      //  sortArr(arr);                // need to traverse twice the array
//        for(int ele:arr)
//            System.out.print(ele+" ");
        famousDutchFlagApproach(arr);
        for(int ele:arr)
            System.out.print(ele+" ");/*The problem is similar to our old post Segregate 0s and 1s in an array,
         and both of these problems are variation of famous Dutch national flag problem*/
        //but in this need to traverse only once
    }

    private static void famousDutchFlagApproach(int[] arr) {
        int low=0,mid=0,hi= arr.length-1;
        while (mid<=hi){
            switch (arr[mid])
            {
                case 0: {
                        int temp=arr[mid];
                        arr[mid] = arr[low];
                        arr[low] = temp;
                        low++;
                        mid++;
                         break;
                }
                 case 1:       // 0 1 0
                    mid++;
                    break;
                case 2:
                {
                    int temp=arr[mid];
                    arr[mid]=arr[hi];
                    arr[hi]=temp;
                    hi--;
                    mid++;
                    break;
                }
            }

        }



    }

    private static void sortArr(int[] arr) {
        int count0=0,count1=0,count2=0;
        for(int ele:arr)
        {
            if (ele==0)
                count0++;
            else if(ele==1)
                count1 ++;
            else
                count2 ++;
        }
        int i=0;
        while(i<count0)
        {
            arr[i]=0;
            i++;
        }
        int n=i+count1;
        while(i<n)
        {
            arr[i]=1;
            i++;
        }
        int m=i+count2;
        while (i<m)
        {
            arr[i]=2;
            i++;
        }
    }
}













/*Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.


Example 1:

Input:
N = 5
arr[]= {0 2 1 2 0}
Output:
0 0 1 2 2
Explanation:
0s 1s and 2s are segregated
into ascending order.
Example 2:

Input:
N = 3
arr[] = {0 1 0}
Output:
0 0 1
Explanation:
0s 1s and 2s are segregated
into ascending order.

Your Task:
You don't need to read input or print anything. Your task is to complete the function sort012() that takes an array arr and N as input parameters and sorts the array in-place.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 10^6
0 <= A[i] <= 2*/