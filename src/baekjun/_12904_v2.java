package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12904_v2 {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        int result = 0;

        // 몇 번 추가됨?
        int n = t.length() - s.length();
        StringBuilder sb;

        for (int i=0; i< n; i++){
            char c = t.charAt(t.length() - 1);

            if (c == 'A'){
                t = t.substring(0, t.length()-1);
            }else{
                sb = new StringBuilder();
                t = sb.append(t.substring(0, t.length() - 1)).reverse().toString();
            }

            if (t.equals(s)){
                result = 1;
                break;
            }
        }

        if (result == 1){
            System.out.println(1);
        }else{
            System.out.println(0);
        }


    }


}
