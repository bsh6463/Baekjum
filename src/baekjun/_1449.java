package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1449 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int ans = 0;
        double position = 0; //position까지 고침

        st = new StringTokenizer(br.readLine());
        int[] leaks = new int[n];
        for (int i=0; i<n; i++){
            leaks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(leaks);

        for (int t : leaks) {

            if (position < t-0.5){ //안덮어짐
                position = t-0.5 + l;
                ans++;
            }else if (position >= t+0.5){ //이미 덮어짐
                continue;
            }else {
                position += l;
                ans++;
            }

        }
        System.out.println(ans);

    }
}
