import java.util.*;
import java.io.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;

/*
* n개의 집이 x = 1에서 x = n까지 순서대로 놓여있고, 각각 A 명의 사람이 살고 있습니다.
* 이들은 회의를 위해 n개의 집 중 한 곳에 전부 모이려고 합니다.
* "적절한 집을 선택"하여 "모든 사람들의 이동 거리의 합이 최소"가 되도록 하는 프로그램을 작성해보세요.
*
*  n은 최대 100까지 ,그리고 각 지점에 살수 있는 사람 최대의 수는 100명
*  사실 살 수 있는 사람 최대수는 별로 의미가 없습니다 어차피 거리 * 사람 수를 해주면 될거 같기때문이죠
*  최대 n이 100이라고 치면 , 하나의 지점에서, 나머지 99개가 거리를 계산할겁니다
*  그래서 100*100 => 10000 (만번 정도의 연산이면 완탐을 해도 될거같다는 각)
*  보통 1초에 1억이라고 생각하면 된다고 한다.
* */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.currentTimeMills() 를 통해서 시간측정 가능.


        int N; // N개의 좌표존재 (최대 100)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long beforeTime = System.currentTimeMillis();
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] xNum = new int[N];
        for(int i=0;i<N;i++){
            xNum[i] = Integer.parseInt(st.nextToken());
        }

        int minn = Integer.MAX_VALUE;
        //완전탐색문
        for(int i=0;i<N;i++){
            int res=0;
            for(int j=0;j<N;j++){
                if(i==j) continue;
                res += abs(j-i) * xNum[j];

            }
            minn = min(res,minn);
        }



        long afterTime = System.currentTimeMillis();
        //System.out.println("실행 시간은 : "+(afterTime-beforeTime)+" 입니다.");

        System.out.println(minn);
    }
}