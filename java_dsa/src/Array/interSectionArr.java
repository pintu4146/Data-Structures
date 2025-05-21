public class interSectionArr {
    public static void main(String[] str)
    {
        int[] arrs={1,2,3,4,5,6,7,8,9,10};
        int [] arrs1={1,4,11};
        // since array is sorted
          forSortedIntersection(arrs,arrs1);
    }

    private static void forSortedIntersection(int[] arrs, int[] arrs1) {
        int min=Math.min(arrs.length, arrs1.length);
        int[] intersectArr=new int[min];
        int i=0,j=0;
        while (i< arrs.length  && j< arrs1.length)
        {
            if(arrs[i] < arrs1[j])
            {
                i++;
            }
            else if( arrs[i] > arrs1[j])
            {
                j++;
            }
            else
            {
                intersectArr[j]=arrs[i];
                i++;
                j++;
            }



    }
        for(int ele: intersectArr)
        {
            if(ele !=0)
            {
                System.out.print(" "+ele);
            }

        }

    }

}
