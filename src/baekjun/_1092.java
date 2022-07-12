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
        int maxCrane = 0;
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(st.nextToken());
            cranes.add(c);
            maxCrane = Math.max(maxCrane, c);
        }

        //박스의 수
        int m = Integer.parseInt(br.readLine());

        //각 박스의 무게
        int minPackage = 1000000;
        ArrayList<Integer> packages = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int p =  Integer.parseInt(st.nextToken());
            packages.add(p);
            minPackage = Math.min(minPackage, p);
        }

        //max 크레인 < min package
        if (maxCrane < minPackage) {
            System.out.println(-1);
        }else{
            int ans = 0;
            //크레인 내림차순
            cranes.sort((c1, c2) -> c2 - c1);

            //오름 차순
            packages.sort((p1, p2) -> p1 - p2);

            /*
            ArrayList<Integer> removeIdx = new ArrayList<>();
            for (int i = 0; i < cranes.size(); i++) {
                if (cranes.get(i) < minPackage) {
                    removeIdx.add(i);
                }
            }

            if (!removeIdx.isEmpty()) {

                removeIdx.sort((i1, i2) -> i2 - i1);

                //최소 무게 감당 못하는 크레인 제거.
                for (int idx : removeIdx) {
                    cranes.remove(idx);
                }
            }*/

            while (!packages.isEmpty()){
                for (int crane : cranes) {
                    int size = packages.size();
                    for (int i=size-1; i>=0; i--){
                        if (crane >= packages.get(i)){
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
}