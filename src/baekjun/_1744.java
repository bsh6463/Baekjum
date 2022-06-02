package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class _1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Long> overZero = new ArrayList<>();
        ArrayList<Long> underZero = new ArrayList<>();
        int zero = 0;

        long answer = 0;

        for (int i=0; i<N; i++){
            long n = Long.parseLong(br.readLine());
           if (n > 0){
               overZero.add(n);
           }else if (n < 0){
               underZero.add(n);
           }else {
               zero++;
           }
        }

        long sumPlus = 0;
        overZero.sort(Collections.reverseOrder());
        for (int i=0; i< overZero.size() ; i+=2){

            if (overZero.size() == 1 && i == 0){
                sumPlus += overZero.get(i);
            }else if (i == overZero.size()-1){
                sumPlus+= overZero.get(i);
            }else {
                sumPlus += Math.max(overZero.get(i)*overZero.get(i+1), overZero.get(i)+overZero.get(i+1));
            }

        }

        long sumMinus = 0;
        underZero.sort((n1, n2)-> (int) (n1-n2)); //오름차순
        long tmp = 0; // 음수가 한개 남으면 잠시 보관, 0이랑 곱할 수 있음.
        for (int i=0; i< underZero.size() ; i+=2){

          if (i == underZero.size()-1){ //size가 1인 경우 바로 tmp에 저장하고 루프 나감.
                tmp = underZero.get(i);
            } else{
                sumMinus += underZero.get(i)*underZero.get(i+1);
            }
        }

        if (zero == 0){
            answer = sumPlus + sumMinus + tmp;
        }else{
            //0이 존재하는 경우
            //음수의 개수가 2개 이상인 경우 마지막 수(tmp)제외하고 sumMinus에 반영됨, 마지막수(tmp)는 0과 곱해져서 무의미
            //음수의 개수가 1개인 경우, tmp에 저장되고 0과 곱해짐.
            //음수의 개수가 0개이 경우, sumMinus = 0
            answer = sumPlus + (underZero.size() > 1 ? sumMinus : 0);
        }

        System.out.println(answer);
    }
}
