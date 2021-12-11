/* tutorial   for subSequence  using bit Masking
Str="abc";
bits        masking set bits
000          " ";   //empty
001           00c;  //c
010           0b0;  b
011           0bc;  bc
100           a00;  a
101           a0c;  ac
110           ab0;  ab
111           abc;  abc
  total      2^n-1 string     (1<<n-1);
*
*
*
*
*
*
*
*
* */




import  java.util.*;
public class AllSubSequenceOfString {
    public static void main(String[] args)
    {
        System.out.println("Enter the word ");
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        //String str="abc";
        int n=1<<(str.length());
        for(int i=1;i<n;i++)
        {

            fun(i,str);
        }

    }

    private static void fun(int num, String str) {
        int i=0;
        ArrayList<String> arrayList=new ArrayList<>();
        String str1="";
        while (num>0)
        {
            if ((num&1)==1) {
//                str1 = str1+str.charAt(i);
//            }
                            System.out.print(str.charAt(i));
                            }
            else System.out.print("");
            i++;
            num=num>>1;
        }
        arrayList.add(str1);
        for (String s:arrayList) {
            System.out.print(s);

        }
        System.out.print("\n");
    }
}
