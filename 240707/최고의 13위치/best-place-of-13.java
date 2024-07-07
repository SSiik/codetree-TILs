import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 
        int[][] arr = new int[N][N];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        // 1*3 구역을 살펴야 하는 입장입니다.
        // N이 최대 20입니다. 
        // 20*20 이면 400정도. 완전탐색도 가능하겠다.

        int maxx = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            for(int j=0;j<=N-3;j++){ // 여기까지가 시작할 수 있는 포인트를 이중 for문으로 잡았다 . (이게 굉장히 중요)
                
                // 내부로직을 이렇게 잡는게 굉장히 중요합니다. 아래 코드 인덱싱을 이용
                int cnt = arr[i][j] + arr[i][j+1] + arr[i][j+2];
                maxx = Math.max(cnt,maxx);

            }
        }
        
        System.out.println(maxx);
        
    }
}