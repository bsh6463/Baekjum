package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();

        //처음 시작 문자 확인.
        char[] numberArr = numbers.toCharArray();
        char start = numberArr[0];

        //배열 돌면서 처음 문자랑 달라지는 경우 cnt 추가
        int cnt = 0;
        char before = start;
        for (char c : numberArr) {
            if (c != start & c != before) {
                cnt++;
            }
            before = c;
        }

        System.out.println(cnt);

    }
}
