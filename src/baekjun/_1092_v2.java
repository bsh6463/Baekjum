package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _1092_v2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //크레인 수
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        //크레인 별 무게 제한
        Integer[] cranes = new Integer[n];
        for (int i = 0; i < n; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        //박스의 수
        int m = Integer.parseInt(br.readLine());
        //각 박스의 무게
        Integer[] packages = new Integer[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            packages[i] = Integer.parseInt(st.nextToken());
        }

        //내림차순
        Arrays.sort(cranes, Collections.reverseOrder());
        Arrays.sort(packages, Collections.reverseOrder());

        //max 크레인 < min packagek, max 크레인 < max 패키지
        if (cranes[0]< packages[0]) {
            System.out.println(-1);
        }else{
            int ans = 0;
            int[] starts  = new int[n];
            Arrays.fill(starts, 0);
            while (m>0){

                for (int j=0; j< cranes.length; j++) {
                    if (m < 1) break;

                    for (int i=starts[j]; i<packages.length; i++){

                        //이미 처리한 package거나, 무게가 초과하는 경우 , 탐색 시작위치 1증가.
                        if (packages[i] == 0 || cranes[j] < packages[i]){
                            starts[j]++;
                            continue;
                        }

                        packages[i] = 0;
                        starts[j] = i+1;
                        m--;
                        break;
                    }

                }

                ans++;
            }

            System.out.println(ans);
        }
    }

}
