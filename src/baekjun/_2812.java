package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2812 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n자리 숫자에서,k개 지워서 가장 큰 수 만들기
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] numbers = br.readLine().toCharArray();
        Queue<Integer> numberQueue = new LinkedList<>();

        for (char number : numbers) {
            numberQueue.add(number-'0');
        }

        int[] ans = new int[n-k];
        int ansIdx = 0;

        int savePoint = 0;
        StringBuilder sb = new StringBuilder();
        while (!numberQueue.isEmpty()){

            if (ans.length-ansIdx-1 == numberQueue.size()){
                ansIdx++;
                ans[ansIdx] = numberQueue.remove();
                ansIdx++;
                continue;
            }

            int current = numberQueue.peek();


            if (ans[ansIdx] < current && (ans.length-savePoint <= numberQueue.size())){
                //많이 남은 경우 savePoint부터 다시 시작
                ansIdx = savePoint;
                ans[ansIdx] = numberQueue.remove();
                continue;
            }

            if (ans[ansIdx] < current )
            //현재 위치 숫자 바꾸기
            if(ans[ansIdx] < current){
                ans[ansIdx] = numberQueue.remove();
                continue;
            }

            //현재 배열 마지막보다 같거나 작은 수가 들어온 경우
            if(ans[ansIdx] >= current){

                //꽉 차있는 경우.
                if(ansIdx == ans.length-1){
                    numberQueue.remove();
                    continue;
                }

                //꽉 차있지 않고, 더 작은 값이 들어온 경우
                if (ans[ansIdx] != current){

                    //더 작은 값이 나타난 순간부터 savePoint
                    savePoint = ++ansIdx;
                    ans[ansIdx] = numberQueue.remove();
                    continue;
                }

                if (ans[ansIdx] == current){
                    if (ans[ansIdx-1] < current){
                        ans[ansIdx-1] = numberQueue.remove();
                    }else{
                        ans[ansIdx+1] = numberQueue.remove();
                    }
                    ansIdx++;

                }

            }

        }

        for (int an : ans) {
            sb.append(an);
        }
        System.out.println(sb.toString());
    }
}
