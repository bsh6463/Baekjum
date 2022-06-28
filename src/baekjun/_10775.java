package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _10775 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        boolean[] gate = new boolean[g+1];

        int ans = 0;
        int code = 0;
        for (int i=0; i<p; i++){
            int Gi = Integer.parseInt(br.readLine());

            for (int j=Gi; j>=0; j--){

                if (j == 0){
                    code = -1;
                    break;
                }

                if (!gate[j]){
                    gate[j] = true;
                    ans++;
                    break;
                }

            }

            if (code == -1){
                break;
            }
        }

        System.out.println(ans);
    }
}
