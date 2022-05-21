package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10162 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //N초


        if (N%10 != 0){
            System.out.println(-1);
        }else {
            int aCnt = N/300;
            N= N%300;
            int bCnt = N/60;
            N = N%60;
            int cCnt = N/10;

            System.out.println(aCnt+" "+bCnt+" "+cCnt);
        }


    }
}
