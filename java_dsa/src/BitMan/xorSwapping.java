package BitMan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class xorSwapping {
    public static void main(String[] abc) throws IOException
    {
        System.out.println("enter the no of test case you wann run");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String strtc=br.readLine();
        int tc=Integer.parseInt(strtc);
        while(tc>0)
        {
            System.out.println("enter 1st num");
            String stra= br.readLine();
            int a=Integer.parseInt(stra);
            System.out.println("enter 2nd num");
            String strb= br.readLine();
            int b=Integer.parseInt(strb);
            System.out.print("before Swap:-"+a+" "+b);
            a=a^b;
            b=b^a;//b=b^a^b; due to xor  operation same bits give zero so b^b=0 so anly a will remain.
            a=a^b;//a=a^b^a; here only b will remain;
            System.out.println("\n"+"after Swap:-"+a+" "+b);
            tc--;
        }

    }
}
