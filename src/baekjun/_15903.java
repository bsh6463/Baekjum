package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _15903 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        PriorityQueue<Long> queue = new PriorityQueue<>();
        while (st.hasMoreTokens()){
            queue.add(Long.parseLong(st.nextToken()));
        }

        for (int i=0; i< m; i++){
            long x = queue.remove();
            long y = queue.remove();
            queue.add(x+y);
            queue.add(x+y);
        }

        long ans = queue.stream().mapToLong(t -> t).sum();

        System.out.println(ans);

    }
}
