import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    static int ans = 0;

    public static void dfs(int x,int y,char cur,char[][] arr,int R,int C,int depth){

        
        if(x==R-1 && y==C-1){
            if(depth == 1) return; //바로 시작점에서 왓다면 제외시켜야함
            ans++;
            return;
        }

        int s = x+1;
        int c = y+1;

        if(s >= R || c >= C) return;

        //시작점을 잘 따져야합니다.
        for(int i=s;i<R;i++){
            for(int j=c;j<C;j++){ //조건에 맞는곳을 찾습니다.
                if(arr[i][j] != cur){
                    dfs(i,j,arr[i][j],arr,R,C,depth+1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int R; //행
        int C; //열
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] arr = new char[R][C];
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                arr[i][j]=st.nextToken().charAt(0); // String을 Char형으로
            }
        }

        // 출발지에서 목적지 까지 갈수 있는 경우의수를 찾아야합니다.

        dfs(0,0,arr[0][0],arr,R,C,0);
        System.out.println(ans);

    }
}