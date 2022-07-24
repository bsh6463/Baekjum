package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class _9576 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nc = Integer.parseInt(br.readLine());

        for (int k=0; k<nc; k++ ){
            solution(br);
        }
    }

    private static void solution(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] books = new int[n+1]; //index ~ a,b matching
        Arrays.fill(books, 1);
        books[0] = 0;

        int ans = 0;
        int[][] arr = new int[m][2];
        for (int i=0; i<m ;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                int d1 = o1[1]-o1[0];
                int d2 = o2[1]-o2[0];

                if (d1 != d2){
                    return d1 - d2;
                }else if (o1[1] != o2[1]){
                    return o2[1]-o1[1];
                }else{
                    return o2[0]-o1[0];
                }
            }
        });

        for (int i=0; i< m; i++){

            if (IntStream.of(books).sum() == 0){
                break;
            }

            int a = arr[i][0];
            int b = arr[i][1];

            for (int j=b; j >= a; j--){
                if (books[j] == 1){
                    books[j] = 0;
                    ans++;
                    break;
                }
            }

        }

        System.out.println(ans);
    }
}
