/*You will be given a list of 32 bit unsigned integers.
 Flip all the bits (1->0 and 0->1 ) and return the result as an unsigned integer
*
*
*
*
* */
public class flipBits {
    public static void main(String[] args)
    {int count=0;
//        int a=5;//000000000000000000000000000000101    32 bits
//        int flip=~a;
//        System.out.println(flip);
        long i=(1<<32);
        System.out.println(i);
        while(i>0) {
            count++;
            i=i>>1;
        }
        System.out.println(count);

    }
}
