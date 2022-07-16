package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _13904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //각 날짜별로 가장 큰 점수로 선택하기
        //한 날짜에 남은 점수들 중에서 앞의 날에 점수 낮은거에 넣어버리기.
        StringTokenizer st;
        HashMap<Integer, ArrayList<Integer>> plan = new HashMap<>();
        int maxDay = 0;
        for (int i=0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            maxDay = Math.max(d, maxDay);
            int s = Integer.parseInt(st.nextToken());

            if (plan.containsKey(d)){
                plan.get(d).add(s);
            }else{
                ArrayList<Integer> tmp= new ArrayList<>();
                tmp.add(s);
                plan.put(d, tmp);
            }
        }


        int[] dayArr = new int[maxDay];
        //maxDay ~ 1일 내림차순.
        for (int i=0; i< maxDay; i++){
            dayArr[i] = maxDay-i;
        }
        int ans = 0;
        for (int i=0; i < dayArr.length; i++){
            int d = dayArr[i];

            if (!plan.containsKey(d)){
                continue;
            }
            ArrayList<Integer> arr = plan.get(d);
            arr.sort((s1, s2)-> s2-s1); //점수 내림차순.
            ans += arr.get(0);
            if (arr.size() > 1 && i < dayArr.length-1) {
                // 바로 전 날 있음?
                List<Integer> removeArr;
                if (plan.containsKey(dayArr[i]-1)){
                    ArrayList<Integer> before = plan.get(dayArr[i]-1);
                    removeArr = arr.subList(1, arr.size());
                    before.addAll(removeArr);
                }else{
                    removeArr = arr.subList(1, arr.size());
                    plan.put(dayArr[i]-1, new ArrayList<>(removeArr));
                }

                arr.removeAll(removeArr);

            }
        }

        System.out.println(ans);

    }
}
