package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class _1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> numbers = new PriorityQueue<>();
        for (int i=0; i<N; i++){
            numbers.add(Long.parseLong(br.readLine()));
        }

        long answer = 0;
        for (int i=0; i<N-1; i++){
            long a = numbers.poll();
            long b = numbers.poll();

            answer += a+b;
            numbers.add(a+b);
        }

        System.out.println(answer);
    }
}
