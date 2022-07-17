package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.*;

public class _18310 {

    public static void main(String[] args) throws IOException {

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

        long minSum = (max-min)*(n-1L); //wow
        int ansX = 0;
        Integer[] houses = map.keySet().toArray(new Integer[0]);

        Arrays.sort(houses, new Comparator<Integer>() {
            /**
             * 1. 각 위치의 집의 수.
             * 2. 위치 순서대로 오름차순.
             */
            @Override
            public int compare(Integer o1, Integer o2) {
                if (!map.get(o1).equals(map.get(o2))){
                    return map.get(o2) - map.get(o1);
                }else{
                    return o1-o2;
                }

            }
        });

        for (int i=0; i<houses.length; i++){

            long sum = 0;
            for (int j=0; j<houses.length; j++) {
                sum += (long) Math.abs(houses[j] - houses[i]) *map.get(houses[j]);
            }
            // System.out.println(p + "설치 시 : "+sum);

            if (minSum > sum){
                minSum = sum;
                ansX = houses[i];
            }else if (minSum == sum){
                ansX = Math.min(ansX, houses[i]);
            }
        }

        System.out.println(ansX);

    }
}
