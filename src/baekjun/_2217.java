package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2217 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        for (int i=0; i<N; i++){
            int c = Integer.parseInt(br.readLine());
           numbers[i] = c;
        }

        int max = 0;
        Arrays.sort(numbers);

        for (int i=0; i<N; i++){

            max = Math.max(max,numbers[i] * (N-i));
        }

        System.out.println(max);


    }
}
