package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _3109 {
   private static int[][] map;
    private static boolean[][] visited;
    private static int ans;
    private static int r;
    private static int c;


    private static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {

       ans = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        HashMap<Character, Integer> translator = new HashMap<>();

        translator.put('.', 0); //열림
        translator.put('x', 1); //닫힘

        map = new int[r][c];
        visited = new boolean[r][c];

        for (int i=0; i<r; i++){
            char[] chars = br.readLine().toCharArray();

            for (int j=0 ; j<c; j++){
                map[i][j] = translator.get(chars[j]);
            }
        }

        for (int i=0; i<r; i++){
            Point start = new Point(0,i);
            makePipe(start);
        }

        System.out.println(ans);


    }

    private static boolean makePipe(Point point) {

        visited[point.y][point.x] = true;

        //탈출조건
        if (point.x >= c-1){
            ans++;

            return true;
        }

        //다음 이동 : 우상, 우, 우하

        if (point.y >= 1 && map[point.y-1][point.x+1] ==0 && !visited[point.y-1][point.x+1]){
            if (makePipe(new Point(point.x + 1, point.y - 1))){
                return  true;
            }
        }

        if (map[point.y][point.x+1] ==0 && !visited[point.y][point.x+1]){
            if (makePipe(new Point(point.x+1, point.y))){
                return true;
            }
        }

        if (point.y <= r-2 && map[point.y+1][point.x+1] ==0 && !visited[point.y+1][point.x+1]){
          if (makePipe(new Point(point.x+1, point.y+1))){
              return true;
          }
        }

        return false;
    }

}




/*
5 9
.x.....x.
.x..x..x.
.x..x..x.
....x....
.x..x..x.

 */