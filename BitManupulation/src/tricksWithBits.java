public class tricksWithBits {
    public  static void  main(String[] args)
    {
        int x=10;
        System.out.println("TRICK 1:\n\n"+"x & (x-1) ,will clear the lowest set bit of x" +
                "x=10:-" +
                "1010" +
                "BInary representation");
        int res1=x & (x-1);
        System.out.println("REsult of trick1 is  " +res1+"\n") ;
        System.out.println("TRICK 2:\n\n"+"x & ~(x-1) extracts the lowest set bit of x (all others are clear)." +
                " Pretty patterns when applied to a linear sequence.");
           //int tem=~(x-1);
         int res2=x & ~(x-1);
        System.out.println("  REsult of trick2 is  " +res2+"\n") ;


        System.out.println("TRICK 3:\n\n"+"x | (x + 1) = x with the lowest cleared bit set." +
                "  this is dual of Trick 1");
        int res3=x | (x-1);
        System.out.println("Result of tricck3= "+res3+"\n");
        System.out.println("TRICK 4:\n\n"+"x | ~(x + 1) = extracts the lowest cleared bit of x (all others are set)." +
                "  this is dual of Trick 1");
        int res4=x | ~(x+1);
        System.out.println("Result of tricck4= "+res4+"\n");
        System.out.println(1L<<30);
    }
}
