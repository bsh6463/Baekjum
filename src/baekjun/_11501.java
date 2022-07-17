package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _11501 {

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

            sb.append(solution(prices));
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static long solution(List<Integer>prices) {

        if (prices.size() == 1){
            return 0L;
        }
        int maxIdx = 0;
        long max = 0;
        for (int j=0; j < prices.size(); j++){
            if (prices.get(j) >= max){
                max = prices.get(j);
                maxIdx = j;
            }
        }

        if (maxIdx == 0){
            //System.out.println(0);
            long profit = 0;
            if (prices.size() >= 3){
                List<Integer> remainPrices = prices.subList(maxIdx + 1, prices.size());
                profit += solution(remainPrices);
            }


            return profit;
        }

        if (maxIdx == prices.size()-1){
            long buy = 0;
            long profit = 0;
            profit = getProfit(prices, buy, profit, prices.size());

            //System.out.println(profit);
            return profit;
        }

            //나머지 경우
             long buy = 0;
             long profit = 0;
            profit = getProfit(prices, buy, profit, maxIdx+1);

            List<Integer> remainPrices = prices.subList(maxIdx + 1, prices.size());

            profit += solution(remainPrices);
            return profit;

    }

    private static long getProfit(List<Integer> prices, long buy, long profit, int lastIdx) {
        for (int i = 0; i< lastIdx; i++){

            if (i== lastIdx-1){
                profit = prices.get(i)*(lastIdx-1)- buy;
                break;
            }
            buy += prices.get(i);
        }
        return profit;
    }
}
