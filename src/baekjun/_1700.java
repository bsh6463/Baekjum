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

            if (outlet.contains(gadget)){
                continue;
            }

            //꽉차있는데 안꽂혀 있는 경우.
            if (outlet.size() == n && !outlet.contains(gadget)){

                //어떤걸 뺄까
                //outlet을 확인하면서 queue에 있는지 확인.

                int removeIdx = -1;
                int max = -1;
                for (int i=0; i<n; i++){

                    //현재 꽂혀있는거
                    Integer using = outlet.get(i);
                    int upcoming = 0;
                    int cnt = 0;
                    for (int j=m+1; j<arr.size(); j++){
                        if (arr.get(j).equals(using)){
                            cnt++;

                            upcoming = j;
                            break;
                        }
                    }

                    if (cnt == 0){
                        removeIdx = i;
                        break;
                    }else{
                        if (upcoming > max){
                            max = upcoming;
                            removeIdx = i;
                        }
                    }

                }
                outlet.remove(removeIdx);
                outlet.add(removeIdx, gadget);
                ans++;

            }
        }

        System.out.println(ans);
    }
}
