package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13305 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //개의 도시
        long[] distances = new long[N-1]; //0->1:0, 1->2:1 ..
        long[] prices = new long[N];
        int minIdx = 0;
        long totalPrice=0;

        String[] s = br.readLine().split(" ");
        String[] s1 = br.readLine().split(" ");
        for (int i=0; i<s.length; i++){
            distances[i] = Long.parseLong(s[i]);
            prices[i] = Long.parseLong(s1[i]);
        }



        int i=0;
        while (i <= distances.length-2){
            // 다음 최소값 찾기
            long crnt = prices[i];

            for (int j=i+1; j<distances.length; j++){
                if (crnt > prices[j]){
                    minIdx = j;
                    break; //바로 다음 최소값 찾기.
                }
            }

            //다음 최소값 있는 경우
            if (i != minIdx){
                int distance = 0;
                for (int k=i; k<minIdx; k++){
                    distance += distances[k];
                }

                totalPrice += prices[i]*distance;
                i = minIdx;

            }else{

                int distance = 0;
                for (int k=i; k<N-1; k++){
                    distance += distances[k];
                }
                totalPrice += distance*prices[i];
                i = distances.length-1;
            }

        }


        System.out.println(totalPrice);

    }
}
