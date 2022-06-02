package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1080 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        int[][] B = new int[N][M];

        makeMatrix(br, N, A);
        makeMatrix(br, N, B);

        int answer = 0;
        if (N >= 3 && M >= 3 ){

            for (int i=0; i<=N-3; i++){
                for (int j=0; j<=M-3; j++){
                    if (A[i][j] != B[i][j]){
                        for (int k=i; k<i+3; k++){
                            for (int l=j; l<j+3; l++){
                                A[k][l] = (A[k][l] == 0) ? 1 : 0;
                            }
                        }
                        answer++;
                    }
                }
            }

        }

        int code = isEqual(N, M, A, B);

        if (code == 0){
            System.out.println(answer);
        }else System.out.println(-1);


    }

    private static int isEqual(int N, int M, int[][] A, int[][] B) {
        int code = 0;
        for (int i = 0; i< N; i++){
            for (int j = 0; j< M; j++){
                if (A[i][j] != B[i][j]){
                    code = -1;
                    break;
                }
            }
            if (code == -1){
                break;
            }
        }
        return code;
    }

    private static void makeMatrix(BufferedReader br, int N, int[][] A) throws IOException {
        for (int i = 0; i< N; i++){
            String[] numArr = br.readLine().split("");
            for (int j=0; j< numArr.length; j++){
                A[i][j] = Integer.parseInt(numArr[j]);
            }
        }
    }


}