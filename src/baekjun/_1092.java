package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1092 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //크레인 수
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        //크레인 별 무게 제한
        ArrayList<Integer> cranes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }

        //박스의 수
        int m = Integer.parseInt(br.readLine());

        //각 박스의 무게
        ArrayList<Integer> packages = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            packages.add(Integer.parseInt(st.nextToken()));
        }

        //크레인 내림차순
        cranes.sort((c1, c2) -> c2 - c1);
        //내림 차순
        packages.sort((p1, p2) -> p2 - p1);

        //max 크레인 < min package
        if (cranes.get(0)< packages.get(packages.size()-1)) {
            System.out.println(-1);
            return ;
        }


        for (int i = cranes.size()-1; i >=0; i--) {
            if (cranes.get(i) < packages.get(packages.size()-1)) {
                cranes.remove(i);
            }
        }

        int ans = 0;
        while (!packages.isEmpty()){

            for (int j=0; j<cranes.size(); j++) {

                for (int i=0; i<packages.size(); i++){

                    if (cranes.get(i) >= packages.get(i)){
                        packages.remove(i);
                        break;
                    }
                }

            }
            ans++;

        }

        System.out.println(ans);


    }
}