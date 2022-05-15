package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" "); //0 : N, 1: K
        int N = Integer.parseInt(info[0]);
        int K = Integer.parseInt(info[1]);

        int[] coins = new int[N];
        for (int i=0; i<=N-1; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);

        int answer=0;
        int remain=K;
        for (int i=N-1; i>=0; i--){

            if (coins[i] <= remain){

                answer += remain/coins[i];
                remain = remain%coins[i];

                if (remain == 0){
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
