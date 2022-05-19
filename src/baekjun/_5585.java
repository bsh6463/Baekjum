package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5585 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 1000-Integer.parseInt(br.readLine());
        int answer = 0;
        int[] coins = {500, 100, 50, 10, 5, 1};
        for (int c: coins){
            answer += N/c;
            N -= c*(N/c);
        }

        System.out.println(answer);


    }
}
