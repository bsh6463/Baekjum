package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class _11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //N명


        String[] times = br.readLine().split(" ");
        int[] timeArray = new int[times.length];

        for (int i=0; i<times.length; i++) {
            timeArray[i] = Integer.parseInt(times[i]);
        }

        //정렬
        Arrays.sort(timeArray);

        int sum = 0;
        for (int i=0; i< timeArray.length; i++){

            sum += timeArray[i]*(N-i);
        }

        System.out.println(sum);

    }
}
