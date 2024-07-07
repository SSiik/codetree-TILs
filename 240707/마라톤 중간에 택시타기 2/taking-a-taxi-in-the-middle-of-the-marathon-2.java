import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static int taxi(Info a,Info b){
        return Math.abs(a.x-b.x) + Math.abs(a.y-b.y);

    }

    static int minn = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        N = Integer.parseInt(br.readLine());
        Info[] arr = new Info[N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Info(a,b);
        }


        
        int startFlag = 1;
        while(startFlag < N-1 ){ // while문 의 flag를 통해서 내부 for문과 매핑 완전탐색 진행.
            int sum = 0;
            Info cur = new Info(arr[0].x,arr[0].y);
            for(int j=1;j<N-1;j++){ 
                if(startFlag == j) continue; //첫번째와 마지막 체크포인트는 제외해야함
                sum += taxi(cur,arr[j]);
                cur=arr[j];
            }
            startFlag++;
            sum += taxi(cur,arr[N-1]); //마지막쪽 거리는 수동으로 더해줍니다.
            minn = Math.min(minn,sum);
        }

        
        
        System.out.println(minn);

    }

    static class Info{

        int x;
        int y;

        Info(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}