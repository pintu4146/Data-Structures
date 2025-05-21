/* in this we going to write some basic function for
   1) get ith bit  of the number;
      ex. 5=101  now 2nd bit is 0;

* 2)set ith bit of number(means set ith bit to 1)
    ex. 5=101;  set 2nd bit  to 1,now  num= 111;
* 3)clear ith bit of number( means set ith bit to 0)
      ex. 5=101;    clear  2nd the 001 remains
*
*
* */



public class bitmaskingFun {
    public static  void  main(String [] t)
    {

        int a=10;//1010
        int i=2;  //100000
                  //000000
        int ithBit=getithBit(a,i);
        System.out.println(i+"th bit of "+a+" is "+ithBit);
        int setIthBit=setIthBit(a,i);
        System.out.println("after setting "+i+"th bit number "+setIthBit);
        int unset=unSetIthBit(a,i);
        System.out.println("After unsetting "+i+"th bit of the number is "+unset);
        //int num= ( a & (1<<i));
       // if(num !=0)
//        if(( a & (1<<i))==0)
//        {
//            System.out.println("0");
//        }
//        else
//            System.out.println("1");


    }

    private static int unSetIthBit(int a, int i) {


        return (a &(~(1<<i)));
    }

    private static int setIthBit(int a, int i) {


        return (a | (1<<i));
    }

    private  static int getithBit(int a,int i)
    {
        return (a & (1<<i))!=0 ? 1:0;
    }
}
