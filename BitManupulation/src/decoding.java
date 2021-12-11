import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class decoding {
    public static  void main(String [] args) throws IOException {
        System.out.println("enter no of test case wann run");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            System.out.println("enter String");
            String str= br.readLine();
            //String str = "abababbbbbbbba";
            int i = 0, count = 0, t = 0;
            String str1 = "";
            char y = '$';
            while (i < str.length()) {
                y = str.charAt(i);
                str1 = str1 + y;
                for (int j = t; j < str.length(); j++) {
                    if (str.charAt(j) == y) {
                        count++;
                    } else
                        break;

                }
                t = t + count;
                i = i + count;

                count = 0;
                //i++;
            }
            System.out.println("chipta string:  "+str1);

        }
    }

}
