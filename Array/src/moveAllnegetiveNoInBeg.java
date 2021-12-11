/*Move all negative numbers to beginning and positive to end with constant extra space
Difficulty Level : Easy
Last Updated : 05 May, 2021
An array contains both positive and negative numbers in random order.
Rearrange the array elements so that all negative numbers appear before all positive numbers.
Examples :

Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
Output: -12 -13 -5 -7 -3 -6 11 6 5
Note: Order of elements is not important here.*/

public class moveAllnegetiveNoInBeg {
    public static void main(String[] str)
    {
        int[] arr={-12, 11, -13, -5, 6, -7, 5, -3, -6};
        int[] arr1={12, 11, -13, -5, 6, -7, 5, -3, -6};
        maintainOrder(arr1);
        int low=0,mid=0,hi= arr.length-1;
        while(mid<=hi)
        {
            if(arr[mid] < 0)
            {
                int temp=arr[mid];
                arr[mid]=arr[low];
                arr[low]=temp;
                low++;
                mid++;
            }
            else{
                mid++;
            }
        }
        for(int ele:arr)
            System.out.print(ele+ " ");
    }

    private static void maintainOrder(int[] arr1) {
        int low=0,high= arr1.length-1;
        int i=0;
        int j= arr1.length-1;
        while (low<high)              //12 11 -13 -5 6 -7 5 -3 -6
        {
            if(arr1[i] <0)
            {
                //int
            }
        }

    }
    /*Rearrange positive and negative numbers with constant extra space
Difficulty Level : Medium
Last Updated : 05 May, 2021
Given an array of positive and negative numbers,
arrange them such that all negative integers appear before all the positive
integers in the array without using any additional data structure like hash table, arrays, etc. The order of appearance should be maintained.

Examples:

Input:  [12 11 -13 -5 6 -7 5 -3 -6]
Output: [-13 -5 -7 -3 -6 12 11 6 5]*/
}
