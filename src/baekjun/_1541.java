package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class _1541 {
//split안되면 그대로 유지됨.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("-");
        int answer = 0;

        String[] plus = split[0].split("\\+");

        for (String s : plus) {
            answer += Integer.parseInt(s);
        }

        if (split.length != 1){ // "-" 없는 경우
            answer = getAnswer(split, answer);
        }
        System.out.println(answer);

    }

    private static int getAnswer(String[] split, int answer) {
        for (int i = 1; i < split.length; i++) {
            String[] plus = split[i].split("\\+");

            for (String s : plus) {
                answer -= Integer.parseInt(s);
            }
        }
        return answer;
    }
}
