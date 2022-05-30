package baekjun;

import java.io.*;
import java.util.StringTokenizer;

public class _1049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int setMin = 60000;
        int eachMin = 10000;


        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int set = Integer.parseInt(st.nextToken());
            int each = Integer.parseInt(st.nextToken());

            setMin = Math.min(setMin, set);
            eachMin = Math.min(eachMin, each);

        }

        //set 가격의최소, each가격의 최소
        //set로 다사는거 부터 하나씩 줄여가면더 each추가하기. 이때 최소 값찾기.
        int setCnt = N%6 != 0 ? N/6+1 : N/6;
        int min = 1000000;
        int eachCnt = 0;
        int idx = 0;
        while (setCnt >=0){

            min = Math.min(min, setMin*setCnt + eachMin*eachCnt);

            //set개수 하나 줄이기.
            setCnt--;

            if (N%6 == 0){ //6의 배수일때
                eachCnt += 6;
            }else{ //6의배수 아닐 때
                if (idx == 0){ //처음에만
                    eachCnt += N%6;
                    idx++;
                }else{ //이후부터
                    eachCnt += 6;
                }
            }
        }

        System.out.println(min);
    }
}