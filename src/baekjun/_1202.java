package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1202 {

    public static class Jewel{
        long weight;
        long value;

        public Jewel(long weight, long value) {
            this.weight = weight;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        /*
        PriorityQueue<Jewel> jewelsQueue = new PriorityQueue<>(new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return (int) (o2.value - o1.value);
            }
        });*/

        ArrayList<Jewel> jewels = new ArrayList<>();
        for (int i=0; i< N; i++){
            String[] s = br.readLine().split(" ");
            //jewelsQueue.add(new Jewel(Integer.parseInt(s[0]),  Integer.parseInt(s[1])));
            jewels.add(new Jewel(Integer.parseInt(s[0]),  Integer.parseInt(s[1])));
        }

        Collections.sort(jewels, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                if (o1.value == o2.value){
                    return (int) (o2.value - o1.value); //내림차순
                }else{
                    return (int) (o2.weight - o1.weight);
                }
            }
        });

        Queue<Jewel> jewelsQueue = new LinkedList<>(jewels);
        jewels.clear();

        long[] bags = new long[K];
        long max = 0;
        for (int i=0; i< K; i++){
            bags[i] = Long.parseLong(br.readLine());
            max = Math.max(max, bags[i]);
        }
        Arrays.sort(bags);

        Queue<Jewel> remainQueue = new LinkedList<>();

        long answer = 0;
        for (long bag : bags) {
           while (!jewelsQueue.isEmpty()){
               Jewel jewel = jewelsQueue.remove();
               if (jewel.weight > max) continue;

               if (jewel.weight <= bag){
                   answer += jewel.value;
                   break;
               }else {
                   remainQueue.add(jewel);
               }
           }

            if (!remainQueue.isEmpty()){
                jewelsQueue = remainQueue;
                remainQueue.clear();
            }
        }

        System.out.println(answer);
    }


}
