/*Method 4 (The Reversal Algorithm) :
Algorithm :


rotate(arr[], d, n)
  reverse(arr[], 1, d) ;
  reverse(arr[], d + 1, n);
  reverse(arr[], 1, n);
Let AB are the two parts of the input array where A = arr[0..d-1] and B = arr[d..n-1].
 The idea of the algorithm is :

Reverse A to get ArB, where Ar is reverse of A.
Reverse B to get ArBr, where Br is reverse of B.
Reverse all to get (ArBr) r = BA.
Example :
Let the array be arr[] = [1, 2, 3, 4, 5, 6, 7], d =2 and n = 7
A = [1, 2] and B = [3, 4, 5, 6, 7]


Reverse A, we get ArB = [2, 1, 3, 4, 5, 6, 7]
Reverse B, we get ArBr = [2, 1, 7, 6, 5, 4, 3]
Reverse all, we get (ArBr)r = [3, 4, 5, 6, 7, 1, 2]*/



public class ReversalAlgoForRotation {
    public static  void  main(String[] str)
    {
        int  arr[] = {1, 2, 3, 4, 5, 6, 7}; //rotate arr by two element left
        int d =2;                           //we can also rotate right by changing in the reverse function
        rotate(arr,d,arr.length);       //take last d element fist and reverse then rest at alast  all element

        for(int ele: arr)
            System.out.print(" "+ele);
    }

    private static void rotate(int[] arr, int d, int n) {
        reverse(arr,0,d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while(start < end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }


}
