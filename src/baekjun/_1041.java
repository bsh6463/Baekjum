package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1041 {

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
        int n = Integer.parseInt(br.readLine());

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

        //최소 값 면.
        Face minFace = dice.get(minIdx);
        ArrayList<Face> minNeighbor = new ArrayList<>();
        minNeighbor.add(minFace.neighbor.get(0));
        minNeighbor.add(minFace.neighbor.get(1));
        minNeighbor.add(minFace.neighbor.get(2));
        minNeighbor.add(minFace.neighbor.get(3));

        minNeighbor.sort((f1, f2) -> f1.value - f2.value);

        long minSum = min *(5L *n*n- 8L *n+4);
        long neighborMinSum = (long) minNeighbor.get(0).value*(8L*n-8);

        //공통 이웃 두개 찾기.
        ArrayList<Face> neighbor = minFace.neighbor;
        ArrayList<Face> neighborNeighbor = minNeighbor.get(0).neighbor;
        ArrayList<Face> next= new ArrayList<>();

        for (Face face1 : neighbor) {
            for (Face face2 : neighborNeighbor) {
                if (face1.value == face2.value){
                    if (!next.contains(face1)){
                        next.add(face1);
                    }
                }
            }
        }

        long rightSum = (long) next.get(0).value *(2);
        long leftSum = (long) next.get(1).value *(2);

        long ans = minSum+neighborMinSum+rightSum+leftSum;

        System.out.println(ans);


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
