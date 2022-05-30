package baekjun;

import java.io.*;
import java.util.*;

public class _1202_v2 {

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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //ArrayList, array 속도차이?
        Jewel[] jewels = new Jewel[N];
        for (int i=0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()),  Integer.parseInt(st.nextToken()));
        }


        long[] bags = new long[K];
        for (int i=0; i< K; i++){
            bags[i] = Long.parseLong(br.readLine());
        }


        Arrays.sort(bags);

        Arrays.sort(jewels, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                if (o1.weight == o2.weight){
                    return (int) (o1.value - o2.value);
                }else{
                    return (int) (o1.weight - o2.weight);
                }
            }
        });

        PriorityQueue<Long> jewelsQueue = new PriorityQueue<>(Collections.reverseOrder());

        long answer = 0;
        int i=0; //i를 여기서 정의하면 while문 끝났을 때의 i부터 다시 시작됨. 먼저 탐색한 이후부터 이어서 탐색함.
        for (long bag : bags) { //무게 오름차순 가벼운거 -> 큰거
            while (i < N && jewels[i].weight <= bag){
                jewelsQueue.add(jewels[i++].value);
            }
          //Queue의 맨 앞은 현재 가방에 넣을 수 있는 보석 중,  가장 가치가 큰 보석
            if (!jewelsQueue.isEmpty()){
                answer+= jewelsQueue.poll();
            }

          //다음은 현재 가방보다 무거운 가방임.\
          //따라서 다음 가방 기준으로 보석을 넣을 때 무게가 더 무거운 보석이 추가 가능.
          //현재 추가된 보석 과, 다음에 추가될 보석 중 가장 가치가 큰 보석을 찾으면 됨.

        }

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
