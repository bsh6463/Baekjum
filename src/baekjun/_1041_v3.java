package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1041_v3 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        ArrayList<Integer> diceA= new ArrayList<>();
        ArrayList<Integer> diceB= new ArrayList<>();
        ArrayList<Integer> diceC= new ArrayList<>();
        int sum=0;
        for (int i=0; i<6; i++ ){
            int f = Integer.parseInt(st.nextToken());

            switch (i){
                case 0: diceA.add(f); //A, F
                    break;
                case 1: diceB.add(f); //B, E
                    break;
                case 2: diceC.add(f); //C, D
                    break;
                case 3: diceC.add(f); //D, C
                    break;
                case 4: diceB.add(f); //E, B
                    break;
                case 5: diceA.add(f); //F, A\
                    break;
            }

            sum += f;
            if (f >= max){
                max = f;
            }

        }

        if (n==1){

            System.out.println(sum-max);

        }else{
            int aMin = Math.min(diceA.get(0), diceA.get(1));
            int bMin = Math.min(diceB.get(0), diceB.get(1));
            int cMin = Math.min(diceC.get(0), diceC.get(1));
            int[] nums = {aMin, bMin, cMin};
            Arrays.sort(nums);

            //1면 보이는 주사위
            long A = nums[0]*(5L *n*n- 16L *n+12);
            //2면 보이는 주사위
            long B = (nums[0]+nums[1])*(8L *n-12);
            //3면 보이는 주사위
            long C = (nums[0]+nums[1]+nums[2])*(4L);

            System.out.println(A+B+C);
            }

        }




}

