package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _16953_v2 {

    static long count=0L;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long A = Long.parseLong(s[0]);
        long B = Long.parseLong(s[1]);

        if (B < A*2L){
            count = -1L;
        }else{

            while(true){
                //판단
                if (B == A){
                    count++;
                    break;
                }else if (B < A*2L){
                    count = -1L;
                    break;
                }

                if (B%2L != 0L){

                    if (B%10L == 1L){
                        count++;
                        B /= 10L;
                    }else{
                        count = -1L;
                        break;
                    }

                }else{ //짝수
                    count++;
                    B /= 2L;
                }
            }

        }
        System.out.println(count);
    }


}
