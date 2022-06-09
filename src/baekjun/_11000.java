package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _11000 {

    private static class Klass{
        int start;
        int end;

        public Klass(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Klass> klasses = new ArrayList<>();

        //시작 순서가 관심있음.
        PriorityQueue<Klass> room = new PriorityQueue<>((c1, c2) -> c1.end != c2.end ? c1.end-c2.end : c1.start-c2.start);
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int Si = Integer.parseInt(st.nextToken());
            int Ti = Integer.parseInt(st.nextToken());
            klasses.add(new Klass(Si, Ti));
        }

        //뭐가 먼저 끝나는지 관심있음.
        Collections.sort(klasses, (c1, c2) -> c1.start != c2.start ? c1.start-c2.start : c1.end-c2.end);

        room.offer(klasses.get(0));

        for (int i=1; i< N; i++){

            Klass klass = klasses.get(i);

            Klass ongoing = room.peek();

            if (klass.start >= ongoing.end){
                room.remove();
                room.add(klass);
            }else{
                room.add(klass);
            }

        }

        System.out.println(room.size());

    }
}

