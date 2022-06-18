package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2847 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n  = Integer.parseInt(br.readLine());
        int ans = 0;

        if (n != 1){

            int[] numArr = new int[n];

            for (int i=0; i<n; i++){
                numArr[i] = Integer.parseInt(br.readLine());
            }

            int before = numArr[n-1];

            for (int i=n-2; i>=0; i--){
                int tmp = numArr[i];

                if (tmp>= before){
                    ans += tmp-before+1;
                    numArr[i] = before-1;
                    before = before-1;
                }else{
                    before = tmp;
                }
            }
        }

        System.out.println(ans);
    }
}
