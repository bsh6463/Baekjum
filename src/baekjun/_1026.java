package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1026 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] aString = br.readLine().split(" ");
        String[] bString = br.readLine().split(" ");
        Integer[] a = new Integer[N];
        Integer[] b = new Integer[N];
        for (int i=0; i< N; i++){
            a[i] = Integer.parseInt(aString[i]);
            b[i] = Integer.parseInt(bString[i]);
        }

        //오름차순
        Arrays.sort(a);
        //내림차순
        Arrays.sort(b, Collections.reverseOrder());

        int sum = 0;
        for (int i=0; i<N; i++){
            sum += a[i] * b[i];
        }

        System.out.println(sum);
    }
}
