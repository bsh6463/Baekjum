package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13305_v2 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //개의 도시
        long[] distances = new long[N-1]; //0->1:0, 1->2:1 ..
        long[] prices = new long[N];
        long min = 1000000000;
        long totalPrice=0;

        String[] s = br.readLine().split(" ");
        String[] s1 = br.readLine().split(" ");
        for (int i=0; i<s.length; i++){
            distances[i] = Integer.parseInt(s[i]);
            prices[i] = Integer.parseInt(s1[i]);
        }



        for (int i=0; i<distances.length; i++){

            long current = prices[i];

            if (current < min){
                totalPrice += current*distances[i];
                min = current;
            }else{
                totalPrice += min*distances[i];
            }

        }


        System.out.println(totalPrice);
    }
}
