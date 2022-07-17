package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _18310_v3 {

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


        Integer[] houses = map.keySet().toArray(new Integer[0]);

        Arrays.sort(houses); //오름차순.

        //이분탐색. 전체 합이 감소하는 방향으로.
        long left = getSum(map, houses, houses[0]);
        System.out.println("left: "+ left);
        long mid = getSum(map, houses, (houses[0]+houses[houses.length-1])/2);
        System.out.println("mid: "+mid);
        long right =getSum(map, houses, houses[houses.length-1]);
        System.out.println("right: "+right);

        if (mid >= left){

            if (left <= right){
                System.out.println(houses[0]);
            }else{
                System.out.println(houses[houses.length-1]);
            }

        }else {
            //증가 시작하면 답
            long beforeSum = left;
            int beforeIdx = 0;

           for (int i=1; i< houses.length-1; i++) {
               long sum = getSum(map, houses, houses[i]);

               if (sum > beforeSum) {
                   System.out.println(houses[beforeIdx]);
                   return;
               }

               if (sum < beforeSum){
                   beforeSum = sum;
                   beforeIdx = i;
               }

           }

            System.out.println(houses[beforeIdx]);
        }

    }

    private static long getSum(HashMap<Integer, Integer> map, Integer[] houses, Integer house) {
        long sum = 0;
        for (Integer integer : houses) {
            sum += (long) Math.abs(integer - house) * map.get(integer);
        }
        return sum;
    }
}
