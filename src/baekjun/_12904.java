package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _12904 {

    static String s;
    static String t;
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();

        makeString(s);

        System.out.println(result);

    }

    private static void makeString(String x) {

        if (x.length() >= t.length()){

            if (x.equals(t)){
                result = 1;
            }

            return;
        }

        if (result == 1){
            return;
        }

            StringBuilder sb = new StringBuilder();
            makeString(sb.append(x).append("A").toString());

            sb = new StringBuilder();
            makeString(sb.append(x).reverse().append("B").toString());


    }
}
