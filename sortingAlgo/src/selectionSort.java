public class selectionSort {
    private static final int MIN_VALUE = 0;

    public  static void main(String[] args)
    {
        int[] arr={14,33,10,27,-1,10,35,19,42,44,-1};
        System.out.println("Unsorted Array");
        for(int ele:arr)
            System.out.print(ele+"\t");
        System.out.println("\n");
        int[] rtn=sShort(arr);
        System.out.println("sorted Array");
        for(int ele:rtn)
            System.out.print(ele+"\t");

    }

    private static int[] sShort(int[] arr) {
     int      index=0;
        for(int j=0;j< arr.length;j++)
        {
            int min=arr[j];
            for(int i=j+1;i< arr.length;i++)
            {
                     if(arr[i]<min)
                     {
                         min=arr[i];
                         index=i;
                     }
            }

 m




        }






        return arr;
    }

}
