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
        String[] numbers = new String[N];
        Set alphabetSet = new HashSet();
        int n = 0;
        for (int i=0; i<N; i++){
            numbers[i] = br.readLine();
            n = Math.max(n, numbers[i].length());
            for (String s : numbers[i].split("")) {
                alphabetSet.add(s);
            }
        }

        HashMap<String, Integer> alphabetNum = new HashMap<>();

        for (String number : numbers) {
            int tens = (int) Math.pow(10, number.length()-1);

            String[] splitAlphabet = number.split("");
            //앞에 자리수 붙이기.
            for (int i=0; i<splitAlphabet.length; i++){
                StringBuilder sb = new StringBuilder();
                sb.append(tens);
                sb.append(splitAlphabet[i]);
                splitAlphabet[i] = sb.toString();
                String k =splitAlphabet[i].substring(splitAlphabet[i].length()-1, splitAlphabet[i].length());
                int v = Integer.parseInt(splitAlphabet[i].substring(0, splitAlphabet[i].length()-1));
                alphabetNum.put(k, alphabetNum.getOrDefault(k, 0)+v);
                tens /= 10;
            }
        }

        int num = 9;
        int answer = 0;
        ArrayList<Integer> numArr = new ArrayList<>(alphabetNum.values());
        numArr.sort(Collections.reverseOrder());

        for (Integer integer : numArr) {
            answer += num*integer;
            num--;
        }

        System.out.println(answer);
    }
}

