import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdditionWithoutplusSign {
    public static void main(String[] args) throws IOException {

        System.out.println("enter the no of test case you wann run");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strtc = br.readLine();
        int tc = Integer.parseInt(strtc);
        while (tc > 0) {
            System.out.println("enter 1st num");
            String stra = br.readLine();
            int a = Integer.parseInt(stra);
            System.out.println("enter 2nd num");
            String strb = br.readLine();
            int b = Integer.parseInt(strb);

            int sum = a | b;

            System.out.println( "sum of the numbers "+sum);
            tc--;
        }
    }
}