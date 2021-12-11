//import static jdk.nashorn.internal.objects.NativeArray.reverse;

public class ReverseArray {
    public static void main(String[] args)
    {
        int[] arr={1,2,3,4,5,6,7};
        reverseArr(arr);
        for(int ele:arr)
        {
            System.out.print(ele + " ");
        }
    }

    private static void reverseArr(int[] arr) {
        int n= arr.length;
        for(int i=0;i<n/2;i++)
        {
            int temp=arr[i];
            arr[i]=arr[n-1-i];
            arr[n-1-i]=temp;
            //
            // arr[i]=swap(i,n-1-i);
        }
    }
}
