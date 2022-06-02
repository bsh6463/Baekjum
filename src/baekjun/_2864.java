package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2864 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        A = A.replace("5", "6");
        B = B.replace("5", "6");

        int max = Integer.parseInt(A) + Integer.parseInt(B);

        A = A.replace("6", "5");
        B = B.replace("6", "5");

        int min =  Integer.parseInt(A) + Integer.parseInt(B);

        System.out.println(min + " " + max);
    }
}
