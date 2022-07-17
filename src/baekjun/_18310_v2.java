package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _18310_v2 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //position, count
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min= 100000;
        int max= 0;
        for (int i=0; i < n; i++){
            int x = Integer.parseInt(st.nextToken());
            min = Math.min(x, min);
            max = Math.max(x, max);
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        long minSum = (max-min)*(n-1L);
        int ansX = 0;
        for (int p : map.keySet()){

            long sum = 0;
            for (int k : map.keySet()) {
                sum += (long) Math.abs(k - p) *map.get(k);
            }
            // System.out.println(p + "설치 시 : "+sum);

            if (minSum > sum){
                minSum = sum;
                ansX = p;
            }else if (minSum == sum){
                ansX = Math.min(ansX, p);
            }

        }

        long end = System.currentTimeMillis();
        System.out.println("시간:" + (end-start));
        System.out.println(ansX);
    }
}
