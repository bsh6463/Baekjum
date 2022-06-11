package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1700 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int ans = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        ArrayList<Integer> outlet = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<k; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }


        for (int m = 0; m < arr.size(); m++){
            int gadget = arr.get(m);

            //콘센트가 텅비어있음?
            if (outlet.size() == 0){
                outlet.add(gadget);
                continue;
            }

            //여유 있는데 안꽂혀 있는 경우
            if (outlet.size() < n && !outlet.contains(gadget)){
                outlet.add(gadget);
                continue;
            }

            //꽉차있는데 안꽂혀 있는 경우.
            if (outlet.size() == n && !outlet.contains(gadget)){

                //어떤걸 뺄까
                //outlet을 확인하면서 queue에 있는지 확인.

                int removeIdx = -1;
                int maxUpcoming = -1;
                int minCnt = k;

                for (int i=0; i<n; i++){

                    //현재 꽂혀있는거
                    Integer using = outlet.get(i);

                    int upcomingIdx =-1; //-1이면 안나옴.
                    int cnt = 0;

                    //다음에 안쓰이는애 찾기
                    for (int j=m+1; j<arr.size(); j++){

                        if (using.equals(arr.get(j))){
                            cnt++;

                            if (cnt == 1){
                                upcomingIdx = j;
                            }
                        }


                    }

                    //using은 이후에 등장하지 않음 빼버리자.
                    if ( upcomingIdx == -1){
                        removeIdx = i;
                        break;
                    }

                    // 등장은 하나 한참 나중에 나오는 경우
                    if (upcomingIdx >= maxUpcoming){
                        removeIdx = i;
                        maxUpcoming = upcomingIdx;
                        continue;
                    }

                    //곧 쓰임, 횟수 작은애를 빼자.
                    if (minCnt >= cnt){
                        removeIdx = i;
                        minCnt = cnt;

                    }

                }

                System.out.println(removeIdx + ": " +outlet.get(removeIdx) + "->" +gadget);
                outlet.remove(removeIdx);
                outlet.add(removeIdx, gadget);
                ans++;


            }
        }

        System.out.println(ans);
    }
}
