package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1461 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> plus = new PriorityQueue<>((n1, n2)-> n2-n1);
        PriorityQueue<Integer> minus = new PriorityQueue<>((n1, n2)-> n2-n1);

        st = new StringTokenizer(br.readLine());
        for (int i=0; i< n; i++){
            int c = Integer.parseInt(st.nextToken());

            if (c > 0) {
                plus.add(c);
            } else {
                minus.add(-1*c);
            }
        }

        int ans = 0;
        Integer maxMinus = minus.peek();
        Integer maxPlus = plus.peek();

        if (maxMinus != null && maxPlus != null){
            if (maxMinus > maxPlus){
                ans = getFarthest(m, minus, ans, 1);
            }else{
                ans = getFarthest(m, plus, ans, 1);
            }
        }else{
            if (maxMinus == null){
                ans = getFarthest(m, plus, ans, 1);
            }

            if(maxPlus == null){
                ans = getFarthest(m, minus, ans, 1);
            }
        }


        while (!minus.isEmpty() || !plus.isEmpty()){
            if (!minus.isEmpty()){
                ans = getFarthest(m, minus, ans, 2);
            }

            if (!plus.isEmpty()){
                ans = getFarthest(m, plus, ans, 2);
            }
        }


        System.out.println(ans);

    }

    private static int getFarthest(int m, PriorityQueue<Integer> arr, int ans, int multiple) {
        if (!arr.isEmpty()){
            ans += multiple * arr.poll();
            for (int i=1; i< m; i++){
                arr.poll();
            }
        }
        return ans;
    }
}
