package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.LongStream;

public class _10610 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] stringNumbers = br.readLine().split("");
        long[] numbers = new long[stringNumbers.length];
        for (int i=0; i< stringNumbers.length; i++){
            numbers[i] = Long.parseLong(stringNumbers[i]);
        }

        int code = 0;

        //30의 배수가 될 수 있는지 확인.
        long sum = LongStream.of(numbers).sum();
        if (sum%3 == 0){//3의배수 통과
            //3의 배수이면서 10의 배수
            Arrays.sort(numbers);
            if (numbers[0] == 0){ //0가지고 있음?
                StringBuilder sb = new StringBuilder();
                for (int i=numbers.length-1; i>=0; i--){
                    sb.append(String.valueOf(numbers[i]));
                }

                System.out.println(sb.toString());
            }else{
                code = -1;
            }

        }else{
            code = -1;
        }

        if (code == -1 ){
            System.out.println(-1);
        }
    }
}
