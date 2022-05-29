package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4796 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNumber = 1;
        while(true){
            String s = br.readLine();

            if (s.equals("0 0 0")) break;

            String[] caseString = s.split(" ");

            int[] each = new int[3];
            for (int i=0; i<3; i++){
                each[i] = Integer.parseInt(caseString[i]);
            }


            int answer = (each[2] / each[1])*each[0] + Math.min(each[0], each[2]%each[1]);
            System.out.println("Case "+caseNumber+": "+answer);
            caseNumber++;
        }

    }
}
