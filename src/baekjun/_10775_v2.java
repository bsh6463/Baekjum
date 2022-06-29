package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 비행기를 가장 많이 배치하는 방법
 * Gi에 먼저 배치, 불가능하면 Gi-1에 배치
 * Gi Gate와 Gi-1 Gate에 대한 관심
 * 즉 현재 Gate(Node)와 다음 Gate(Parent)에 대한 관심으로 볼 수 있음.
 * 즉 Union Find 적용 가능.
 * parent = 현재 Gate 기준 다음 배치 가능한 Gate
 * parent = 0이다. 존재하지 않는 gate, 더 이상 배치 불가능.
 */
public class _10775_v2 {

    private static int[] gates;
    private static int[] parents; //parent = 다음 빈 gate

    /**
     * Union Find
     */
    public static int find(int x){
        if (parents[x] == x){
            return x;
        }

        //root가 내 부모(다음 gate), 경로압축
        return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);

        if (parentX != parentY){
            if (parentX < parentY){
                parents[y] = parentX;
            }else{
                parents[x] = parentY;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        gates = new int[g+1];
        parents = new int[g+1];

        for (int i=0; i<g+1; i++){
            gates[i] = i;
            parents[i] = i;
        }

        int ans = 0;
        for (int i=0; i<p; i++){
            int Gi = Integer.parseInt(br.readLine());
            int next = find(Gi);

            //부모(다음 gate)가 0이라면 배치 불가.
            if (next == 0){
                break;
            }

            //부모가 나라면, 직전 gate가 다음 gate
            if (next == Gi){
                union(Gi, Gi-1);
            }else{
                union(next, next-1);
            }
            ans++;


        }

        System.out.println(ans);
    }
}
