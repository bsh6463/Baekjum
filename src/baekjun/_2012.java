package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());

        Integer[] expectations = new Integer[n];

        for (int i=0; i< n; i++){
            expectations[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(expectations);

        long ans = 0;
        for (int i=0; i<n; i++){
            ans += Math.abs(i+1-expectations[i]);
        }

        System.out.println(ans);

    }
}
