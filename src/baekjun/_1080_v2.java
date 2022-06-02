package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _1080_v2 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        // 입력
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            String temp = sc.next();

            for (int j = 0; j < m; j++) {
                a[i][j] = temp.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            String temp = sc.next();

            for (int j = 0; j < m; j++) {
                b[i][j] = temp.charAt(j) - '0';
            }
        }

        // 행렬 변환
        int count = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (a[i][j] != b[i][j]) {
                    count++;
                    for (int p = i; p < i + 3; p++) {
                        for (int q = j; q < j + 3; q++) {
                            a[p][q] = (a[p][q] == 0) ? 1 : 0;
                        }
                    }
                }
            }
        }

        // 같은지 확인
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    flag = false;
                    break;
                }
            }
        }

        System.out.println((flag) ? count : -1);


    }
}

/**
 * 3 4
 *
 * 0000
 * 0010
 * 0000
 *
 * 1001
 * 1011
 * 1001
 *
 * 1001
 * 1001
 * 1001
 *------------
 * 3 3
 * 111
 * 111
 * 111
 *
 * 000
 * 000
 * 000
 *
 * 111
 * 111
 * 111
 * ----------
 * 1 1
 * 1
 *
 * 0
 *
 * 1
 * ----------
 *
 */