


/* Q.suppose given no 'a' and 'b'minimum number of bits required that i need to change so that
number 'a' converted in to 'b'.
ex.  a=1011
     b=1111
     in this we need to change 3rd bit in 'a' to get 'b'.
       so we have to return 1 since only one bit is required to change .
*/

public class convertAintoBbychangingBIts {
    public static void main(String[] abd)
    {
        int a=16; //10000
        int b=15; //1111
        int t=a^b;
       int NumofBitsRequired = countSetBit(t);
       System.out.println(NumofBitsRequired);
    }
 private static   int countSetBit(int t)
    {int count=0;
        while(t>0)
        {
            count++;
            t= t &(t-1);
        }
        return count;
    }
}
