package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2437 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] weights = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i< N; i++){
            weights[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weights);

        //weight[i]
        //weight[0],..............,sum, weight[i] or weight[i]+weight[0] or .....
        //weight[i] <= sum +1,  --> weight[i] > sum +1

        int sum =0;
        for (int i=0; i<N; i++){

            if (weights[i] > sum+1){
                break;
            }

            sum += weights[i];
        }

        System.out.println(sum+1);

    }

}
