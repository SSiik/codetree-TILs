import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    static int res=0;

    // 결국엔 조합함수를 구현할줄 알아야합니다.
    // 조합함수는 다뽑았을때 로직을 실행할 if문과 뽑는과정을 진행하는 for문으로 나뉩니다.
    // 이제 if문에서 뽑은걸 어떻게 표현하고 어떻게 꺼낼지가 중요한데요.
    // visited배열을 사용하는게 맞는것 같습니다. 
    // 
    public static void combi(int[] arr,int[] output,boolean[] visited,int start,int n,int depth){
        if(depth==3){
            if(output[1]>=output[0] && output[2]>=output[1]){
                res++;
            }
            return;
        }
        for(int i=start;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                output[depth]=arr[i];
                combi(arr,output,visited,i+1,n,depth+1);
                visited[i]=false;
            }
        }

    }



    public static void main(String[] args) throws IOException {
        int N; // 소들의 숫자
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] height = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
                height[i]=Integer.parseInt(st.nextToken());
        }
        boolean[] visited = new boolean[N];
        int[] output = new int[N];
        //결국엔 3개를 뽑는 조합문제라고 생각합니다.
        // 뽑아놓고 조건에 맞는지 확인해야 한다고 생각.
        // 100C3 이므로 제한 시간 1초인 1억연산수에 해당은 안함
        

        combi(height,output,visited,0,N,0);
        System.out.println(res);
    }
}