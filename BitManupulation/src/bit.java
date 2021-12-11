import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class HelloWorld {
    public static void main(String[] args) throws IOException {
//        Scanner sc=new Scanner(System.in);
//        int tst=5;
//        while (true) {
//            double t = sc.nextDouble();
//            for (double i = 0; i < 20; i++) {
//                if (t < 3 * i && t > 3 * (i - 1)) {
//                    System.out.println("green");
//                    break;
//                }
//                if (t >= 3 * i && t < 3 * i + 1) {
//                    System.out.println("yellow");
//                    break;
//                }
//                if (t >= 3 * i + 1 && t < 3 * i + 2) {
//                    System.out.println("red");
//                    break;
//                }
//            }


       // }

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String a=br.readLine();
        int A=Integer.parseInt(a);
        String b=br.readLine();
        int B=Integer.parseInt(b);
        String c=br.readLine();
        int C=Integer.parseInt(c);

        if(A==B && B==C)
        {
            System.out.println(A+" "+B+" "+C);
        }


     else   if(A==C)
        {
            System.out.println(A+" "+C);
        }
     else   if(B==C)
        {
            System.out.println(C+" "+B);
        }
     else if(A==B)
            System.out.println(A+" "+B);
    }

}
