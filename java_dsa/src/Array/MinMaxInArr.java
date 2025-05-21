/*Maximum and minimum of an array using *** minimum number of comparisons*/

class Pair{
    int min;
    int max;
}
public class MinMaxInArr {

    static Pair getMinMax(int[] arr,int n)
    {   Pair minmax=new Pair();
        if(n==1)
        {
            minmax.max=arr[0];
            minmax.min=arr[0];
              return  minmax;
        }
       if(arr[0] >arr[1])
       {
           minmax.max=arr[0];
           minmax.min=arr[1];
       }
       else{
           minmax.max=arr[1];
           minmax.min=arr[0];
       }
       for(int i=2;i<n;i++)
       {
           if(arr[i] > minmax.max)
           {
               minmax.max=arr[i];
           }
           else if( arr[i] < minmax.min)
           {
               minmax.min=arr[i];
           }
       }
        return minmax;
    }



    public static void main(String[] str)
    {
        int arr[] = {1000, 11, 445, 1, 330, 3000};  //except cycle sort selection sort does minimum no of swaping
           Pair minmax=getMinMax(arr,arr.length);                                           //but we need minimum no of comparision
           System.out.println("Maximum element "+minmax.max);
        System.out.println("Minimum element "+minmax.min);
    }
}
