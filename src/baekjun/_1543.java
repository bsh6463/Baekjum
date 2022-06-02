package baekjun;

import java.io.*;

public class _1543 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence= br.readLine();
        String word = br.readLine();

        int answer = 0;
        int i= word.length()-1;
        while (i<sentence.length()){
            String sub = sentence.substring(i-word.length()+1, i+1);
            if (sub.equals(word)){
                answer++;
                i += word.length();
            }else i++;
        }

        System.out.println(answer);

    }
}
