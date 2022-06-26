package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2812_v2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n자리 숫자에서,k개 지워서 가장 큰 수 만들기
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String numString = br.readLine();

        Stack<Integer> stack = new Stack<>();

        //삭제조건
        //1. current가 stack.peek()보다 크면 stack 맨 위 삭제
        //2. 언제까지? current보다 더 큰 값이 stack에 나올때 까지
        //3. 다 삭제했으면 stack에 추가.

        int removeCnt=0;
        for (int i=0; i<numString.length(); i++){
            int current = numString.charAt(i)-'0';

            if (!stack.isEmpty()){

                //current기준 stack에서 삭제할 문자 전부 삭제.
                while (!stack.isEmpty() && stack.peek() < current && removeCnt < k){
                    stack.pop();
                    removeCnt++;
                }
            }

            stack.push(current);
        }


        StringBuilder sb = new StringBuilder();

        //사이즈 맞지 않는 경우.
        //위의 조건으로 k개 만큼 삭제되지 않은 경우.
        //이 때 최소 숫자를 삭제해 주면 됨.
        if (stack.size() != n-k){
            //몇 번 더 삭제해야?
            int remain = k-removeCnt;

            for (int i=0; i<remain; i++){
                removeRemain(stack);
            }
        }

        for (int i=0; i<n-k; i++){
            sb.append(stack.get(i));
        }

        System.out.println(sb.toString());

    }

    //최소 숫자 제거
    private static void removeRemain(Stack<Integer> stack) {
        int min=10;
        int minIdx = 0;
        for (int i = 0; i< stack.size(); i++){
            if (stack.get(i) <= min){
                min = stack.get(i);
                minIdx = i;
            }
        }

        stack.remove(minIdx);
    }

}
