package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _11501_v2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< n; i++){
            int d = Integer.parseInt(br.readLine());
            ArrayList<Integer> prices = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j=0; j < d; j++){
                prices.add(Integer.parseInt(st.nextToken()));
            }

            sb.append(solution(prices)).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static long solution(List<Integer>prices) {

     long max = 0;
     long profit = 0;

     for (int i=prices.size()-1; i>=0; i--){

         Integer price = prices.get(i);

         if (price >= max){
             max = price;
         }else{ //price < max
             profit += max-price;
         }
     }

        return profit;
    }


}
