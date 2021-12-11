import java.util.ArrayList;
import java.util.List;

/*
* given array of numbers having only two   unique no.find them and print.
* also do not use extra space.
* example [1,2,3,1,5,2,3,7]
* then print [5,7]
*
*
* easy solution is that we can easily use has set of arrayList but given we dont have to use extra space
*
* //if there have been
*
*
* */
public class UniqueNo2 {
    public  static void  main(String[] args)
    {
        int xor=0;
        int [] arr={1,2,3,1,5,2,3,7,3,3};//101 ^111=010
        for (int j : arr) {
            xor ^= j;
        }
        int index=findingIndexOfSetBit(xor);


        ArrayList<Integer> ar= (ArrayList<Integer>) noHavingSetBitAtIndex(xor,index,arr);
        for (Integer i:ar
             ) {
            System.out.println(i);

        }
       // System.out.println(xor+"  "+index);
    }

    private static List<Integer> noHavingSetBitAtIndex(int xor, int index, int[] arr) {
        ArrayList<Integer> al=new ArrayList<>();
        int firstNo=0;
        for(int i=0;i< arr.length;i++)
        {
            //System.out.println(i);
            int mask=1<<index;
            //int u=t&arr[i];
           /* System.out.println(u);
            System.out.println("\t\t"+t);*/
          if((mask & arr[i]) !=0)
          {
              firstNo=firstNo^arr[i];
             // System.out.println(arr[i]);
          }

        }
        System.out.println(firstNo);
        System.out.println(firstNo^xor);
        return  al;

    }

    private static int  findingIndexOfSetBit(int xor) {
        int index=0;
        while(xor>0)
        {

            if((xor&1)==1)break;
            index++;
            xor>>=1;
        }

        return index;
    }
}
