package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1339 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //목적: 합의 최댓값을 구하자.

        //문자열 받기.
        String[] alphabets = new String[N];

        for (int i=0; i<N; i++){
            alphabets[i] = br.readLine();
        }

        //HashMap에 알파벳 별 자리수 저장.
        HashMap<String, Integer> alphabetNum = new HashMap<>();


        //앞에 자리수 붙이기.
        for (String number : alphabets) {
            int tens = (int) Math.pow(10, number.length()-1);

            String[] splitAlphabet = number.split("");

            for (int i=0; i<splitAlphabet.length; i++){
                //StringBuilder가 더 빠름
                StringBuilder sb = new StringBuilder();
                sb.append(tens);
                sb.append(splitAlphabet[i]);
                splitAlphabet[i] = sb.toString();

                //알파벳과 숫자 부분 발라내기
                String s = splitAlphabet[i];
                String k =s.substring(s.length()-1, s.length());
                int v = Integer.parseInt(s.substring(0, s.length()-1));

                //Map에 알파벳, 자리수 저장, 이미 있는 경우 더해주기.
                alphabetNum.put(k, alphabetNum.getOrDefault(k, 0)+v);

                //자리수 감소
                tens /= 10;
            }
        }

        //max는 9부터 시작
        int num = 9;
        int answer = 0;
        ArrayList<Integer> numArr = new ArrayList<>(alphabetNum.values());

        //내림차순 정리
        numArr.sort(Collections.reverseOrder());
        for (Integer integer : numArr) {
            answer += num*integer;
            num--;
        }

        System.out.println(answer);
    }
}

