package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2720 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] c = new int[]{25, 10, 5, 1};
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< n; i++){
            int money = Integer.parseInt(br.readLine());

            for (int t : c){
                sb.append(money/t).append(" ");
                money %= t;
            }

            System.out.println(sb);
        }

    }
}
