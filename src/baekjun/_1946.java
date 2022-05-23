package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _1946 {

    static class Member{
        int paper;
        int interview;

        public Member(int paper, int interview) {
            this.paper = paper;
            this.interview = interview;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=1; i<=T; i++){
            int cnt = 0;
            int N = Integer.parseInt(br.readLine());
            ArrayList<Member> members = new ArrayList<>();
            for (int j=1; j<=N; j++){
                String[] s = br.readLine().split(" ");
                members.add(new Member(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
            }

            //서류 성적순
            members.sort((m1, m2) -> m1.paper - m2.paper);
            int interview = N; //꼴등
            //현재가 이전보다 낮으면 ok, 높으면 쳐냄.
            for (Member member : members) {
                if (member.interview <= interview) { //첫 번째가 꼴등일 경우 포함할 수 있도록. 등호.
                    cnt++;
                    interview = member.interview;
                }
            }

            System.out.println(cnt);
        }

    }
}

