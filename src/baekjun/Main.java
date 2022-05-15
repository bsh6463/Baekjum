package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

       int five = N/5;
       int answer = 0;

       while (five>=0){
           int three = (N-5*five) / 3;
           int sum = five*5 + three*3;

           if (sum == N){
              answer = three+five;
              break;
           }else{
              five--;
           }
       }

       if (answer != 0){
           System.out.println(answer);
       }else {
           System.out.println(-1);
       }

    }
}
