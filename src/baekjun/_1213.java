package baekjun;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class _1213 {

    static String ERROR = "I'm Sorry Hansoo";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        char[] chars = s.toCharArray();
        int length = chars.length;

        HashMap<Character, Integer> map = new HashMap<>();

        int code = 0;
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        Character[] characters = map.keySet().toArray(new Character[0]);
        Arrays.sort(characters);

        String[] answer = new String[length];

        if (length%2 == 0){

            for (Integer value : map.values()) {
                if (value%2 != 0){
                    code = -1;
                    break;
                }
            }
        }else{
            int cnt=0;
            for (Integer value : map.values()) {
                if (value%2 != 0){
                    cnt++;
                    if (cnt > 1){
                        code = -1;
                        break;
                    }
                }
            }
        }

        if (code == -1){
            sb.append(ERROR);
        }else{

            for (int i=0; i<= answer.length/2; i++){

                for (Character c : characters) {
                    Integer cnt = map.get(c);

                   if (answer[i] == null){

                       if (cnt >= 2){
                           answer[i] = c+"";
                           answer[answer.length-1-i] = c+"";
                           map.put(c, map.get(c)-2);
                           break;
                       }

                       if (length%2 != 0 && i ==answer.length/2 && cnt == 1){
                           answer[answer.length/2] = c+"";
                           map.put(c, map.get(c)-1);
                           break;
                       }
                   }
                }
            }

            for (String ans : answer) {
                sb.append(ans);
            }

        }

       bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
