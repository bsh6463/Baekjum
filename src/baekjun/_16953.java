package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _16953 {

    static long count=0L;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long A = Long.parseLong(s[0]);
        long B = Long.parseLong(s[1]);

        if (B < A*2L){
           count = -1L;
        }else{
            if (B%2L != 0L ){//홀수
               long end = B%10L;
                //1의 자리가 1인 경우
                if (end == 1){
                    findCount(A, B);
                }else{
                    //그렇지 않은 경우 : -1
                    count = -1L;
                }
            }else{//짝수
                findCount(A, B);
            }
        }
        System.out.println(count);
    }
    
    private static void findCount(long A, long number){
        //탈출 조건
        if (number == A){
            count++;
            return;
        }else if (number < 2L*A){
            count = -1L;
            return;
        }

        //짝수이거나
        if (number % 2 == 0){
            count++;
            findCount(A, number/2L);
        }else{ //홀수 인 경우
            if (number%10 == 1){
                count++;
                findCount(A, number/10L);
            }else {
                count = -1;
                return;
            }

        }

    }
}
