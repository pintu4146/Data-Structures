/*
count the number of set bit in binarey of the given number
ex.
     int a=5;  101
       ans=2
 */

import java.io.*;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

public class countNoOfSetBits {
    public static void main(String[] args) throws IOException {
        //  ##################  this is one approach but complexity is too high ##################
     /*   int a=64-1,t=0,count=0;
        ArrayList<Integer> al=new ArrayList<Integer>();
        while(a>0)
        {
            t=a%2;
            al.add(t);
            a=a/2;

        }
        for (int i=al.size()-1;i>=0;i--)
        {
            if(al.get(i)==1)
            {
                count++;
            }

            System.out.print(al.get(i));

        }
        System.out.print("\n"+count);   */

        //@@@@@@@@@@@@@@@@@@  another   approach  using bit manupulation #complexity:- O(no. of bits)  ##############

    /*    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the no of test case you wann run");
        String tc= br.readLine();
        int tst=Integer.parseInt(tc),count=0;
        while (tst>0)
        {
            System.out.println("enter the no you wann count SETbit");
            String strnum=br.readLine();
            int num=Integer.parseInt(strnum);
            while(num>0)
            {
                int bit=num & 1;
                count+=bit;
                num=num>>1;
            }
            System.out.println(count);
   count=0;
            tst--;
        }

     */
        //***********  one more Approach is efficient from all other approach    #complexity O(no. of set only not all bits)
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the no of test case you wann run");
        String tc= br.readLine();
        int tst=Integer.parseInt(tc),count=0;
        while (tst>0)
        {
            System.out.println("enter the no you wann count SETbit");
            String strnum=br.readLine();
            int num=Integer.parseInt(strnum);
            while(num>0)
            {
                count++;
                num = num & (num-1);
//                int bit=num & 1;
//                count+=bit;
//                num=num>>1;
            }
            System.out.println(count);
            count=0;
            tst--;
        }
    }

}

