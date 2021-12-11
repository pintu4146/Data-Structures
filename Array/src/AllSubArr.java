public class AllSubArr {
    public static void main(String[] args)
    {
        int sum=0;
        int max=Integer.MIN_VALUE;
        int[] arr={1,2,3,-8};
      //  SubArrRecursive(arr,0,arr.length-1);
        for(int i=0;i< arr.length;i++)
        {
            for(int j=i;j< arr.length;j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                    sum+=arr[k];
                }
                System.out.println(" ->Sum= "+sum);
                 max=Math.max(max,sum);
                System.out.println("MAX till now  "+ max);
                sum=0;
            }
        }
    }

//    private static void SubArrRecursive(int[] arr, int start, int end) {
//        if(arr.length == 0) return;
//        SubArrRecursive(arr, 0, arr.length - 1);
//    }
}
