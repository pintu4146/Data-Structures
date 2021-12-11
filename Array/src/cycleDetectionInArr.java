public class cycleDetectionInArr {
    public static void  main(String[] str)
    {
        int[] nums = {2,2,2,2,2};//other approach are also there like sort(nlogn, 1),hashset(n, n),floyed cycle detection(n , 1)
        int duplecates=Duplecates(nums);
        System.out.print("duplecate found="+ duplecates);
    }

    private static int Duplecates(int[] nums) {
        int turtoise=nums[0];
        int here=nums[0];
        do{
            turtoise=nums[turtoise];
            here=nums[nums[here]];


        }while (turtoise != here);
        turtoise=nums[0];
        while (turtoise != here)
        {
            turtoise=nums[turtoise];
            here=nums[here];
        }

        return here;
    }


}
