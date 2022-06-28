package baekjun;

public class UnionFind {

    static int[] nodes = new int[10];
    static int[] parents = new int[10];

    public int find(int x){

        //탈출 조건, 내가..부모?
        if (parents[x] == x){
            return x;
        }else{
            //나의 부모의 부모와 경로압축 및 반환.
           return parents[x] = find(parents[x]);
        }

    }

    public void union(int x, int y){
        //부모가 같은가..
        int parentX = find(x);
        int parentY = find(y);

        //부모가 다르면 작은 쪽으로 합쳐주기.
        if (parentX !=  parentY){

            if (parentX < parentY){
                parents[y] = parentX;
            }else{
                parents[x] = parentY;
            }
        }

    }
}
