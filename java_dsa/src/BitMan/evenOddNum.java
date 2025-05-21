import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class evenOddNum {
    public static void  main(String[] abc) throws IOException
    { int n=10;
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        while(n>0)
        {System.out.println("enter no");
            String str= br.readLine();

            long num=Integer.parseInt(str);
            long nt=num & 1;
            System.out.println(nt);
            if((num & 1) ==1)
            {
                System.out.println("odd");

            }
            else
                System.out.println("even");
            n--;
        }
    }
}
