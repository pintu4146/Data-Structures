import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class xor {
    public static  void main(String[] args) throws IOException {
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            int a = Integer.parseInt(str);
            String str1 = br.readLine();
            int b = Integer.parseInt(str1);
            System.out.println(a ^ b);

        }

    }
}
