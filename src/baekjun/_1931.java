package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class _1931 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //시작, 종료
        int[][] meetings = new int[N][2];
        for (int i=0; i< N; i++){
            String[] info = br.readLine().split(" ");
            meetings[i][0] = Integer.parseInt(info[0]);
            meetings[i][1] = Integer.parseInt(info[1]);
        }

        //정렬, 회의종료시간 오름차순
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]){
                    return o1[1] - o2[1];
                }else{ //종료 시간이 같은 경우 시작시작 오름차순
                    return o1[0] - o2[0];
                }
            }
        });

        //판단
        int end = 0;
        int count=0;
        for (int i=0; i<N; i++){
            int[] current = meetings[i];

            //현 회의 시작이 앞 종료시간보다 늦은지.
            if (current[0] >= end){
                count++;
                end = current[1];
            }
        }

        System.out.println(count);

    }
}
