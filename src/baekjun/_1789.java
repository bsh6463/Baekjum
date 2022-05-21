package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine()); //서로 다른 N개의 자연수의 합.

        long sum=0;
        long i=0;
        while(sum <= S){
            i++;
            sum += i;
        }

        System.out.println(i-1);
    }
}
