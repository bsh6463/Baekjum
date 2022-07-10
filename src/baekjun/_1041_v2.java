package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1041_v2 {

    static class Face{
        int value;

        ArrayList<Face> neighbor = new ArrayList<>();

        public Face() {

        }

    }

    static Face A = new Face();
    static Face B = new Face();
    static Face C = new Face();
    static Face D = new Face();
    static Face E = new Face();
    static Face F = new Face();

    static ArrayList<Face> dice = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        init();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int minIdx = -1;
        int min = 100;
        for (int i=0; i<6; i++ ){
            Face face = dice.get(i);
            int t = Integer.parseInt(st.nextToken());
            face.value = t;

            if (t <= min){
                min = t;
                minIdx = i;
            }
        }

        if (n==1){
            int sum = dice.stream().mapToInt(f -> f.value).sum();
            int max = dice.stream().mapToInt(f -> f.value).max().getAsInt();

            System.out.println(sum-max);

        }else{
            //최소 값 면.
            Face minFace = dice.get(minIdx);

            //minFace의 neighbor 정렬
            minFace.neighbor.sort((f1, f2) -> f1.value - f2.value);

            //최소값 몇 & 최소값 면의 이웃 중 최솟값 공통 이웃 찾기
            ArrayList<Face> neighborNeighbor= new ArrayList<>();

            for (Face face1 : minFace.neighbor) {
                for (Face face2 : minFace.neighbor.get(0).neighbor) {
                    if (face1.value == face2.value){

                        if (!neighborNeighbor.contains(face1)){
                            neighborNeighbor.add(face1);
                        }
                    }
                }
            }

            int nextNeighbor = Math.min(neighborNeighbor.get(0).value, neighborNeighbor.get(1).value);

            //1면 보이는 주사위(최소값)
            long a = min*(5L *n*n- 16L *n+12);
            //2면 보이는 주사위(최소값+이웃 중 가장 최솟값)
            long b = (min+minFace.neighbor.get(0).value)*(8L *n-12);
            //3면 보이는 주사위(최솟값+이웃 중 가장 최솟값+두 면의 공통 이웃 중 최솟값)
            long c = (min+minFace.neighbor.get(0).value + nextNeighbor)*(4L);

            System.out.println(a+b+c);
        }




    }

    private static void init() {
        A.neighbor.add(D);
        A.neighbor.add(E);
        A.neighbor.add(B);
        A.neighbor.add(C);

        B.neighbor.add(A);
        B.neighbor.add(D);
        B.neighbor.add(C);
        B.neighbor.add(F);

        C.neighbor.add(A);
        C.neighbor.add(B);
        C.neighbor.add(E);
        C.neighbor.add(F);


        D.neighbor.add(A);
        D.neighbor.add(B);
        D.neighbor.add(E);
        D.neighbor.add(F);


        E.neighbor.add(A);
        E.neighbor.add(C);
        E.neighbor.add(D);
        E.neighbor.add(F);


        F.neighbor.add(B);
        F.neighbor.add(C);
        F.neighbor.add(D);
        F.neighbor.add(E);


        dice.add(A);
        dice.add(B);
        dice.add(C);
        dice.add(D);
        dice.add(E);
        dice.add(F);
    }
}
