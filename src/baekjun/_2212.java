package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 각 집궁국의 수신 가능 길이의 합이 최소가 되기 위해서는 센서와의 연결을 최대한 분산 시켜야 함.
 * 따라서 집중국은 K 개  모두 사용
 *
 * K개의 집중국을 설치하기 위해서는 센서배열을 k-1번 잘아야 함.(= k개 그룹으로 나눔, k-1 개의 수신 불가능 영역)
 * (1번)~(2번)~...(k-1번)~(k번) --> ~ 개수 == k-1
 *
 * 수신 가능 길이의 합이 최소가 되기 위해서는 수신 불가능 영역이 최대가 되어야 한다.
 *
 * 이를 위해서는 현재 배치된 센서들의 간격을 내림차순으로 정렬하고,
 * k-1개의 수신 불가능 영역을 선택한다.
 *
 * 전체 거리에서 수신 불가능 영역의 합을 빼면 정답.
 */
public class _2212 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Integer> sensors = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            sensors.add(Integer.parseInt(st.nextToken()));
        }

        if (sensors.size() == 1){
            System.out.println(0);
        }else{
            //센서 오름차순 정렬렬
            sensors.sort((a, b) -> a-b);


            //서로 떨어져 있는 센서들의 간격
            ArrayList<Integer> distances = new ArrayList<>();
            for (int i=1; i<sensors.size(); i++){
                int distance = sensors.get(i) - sensors.get(i-1);
                if (distance > 1){
                    distances.add(distance);
                }
            }

            //센서 간격 내림차순 정렬
            distances.sort((a, b) -> b-a);

            int ans = sensors.get(sensors.size()-1)-sensors.get(0);
            //센서 거리 중 가장 큰 k-1개 버리기.
            int tmp = 0;
            for (int i=0; i < k-1; i++){
                tmp += distances.get(i);
            }

            System.out.println(ans-tmp);
        }


    }
}
