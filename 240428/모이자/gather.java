import java.util.*;
import java.io.*;

/*
모이자

1~n까지의 좌표에 각각 집이 있고, 그 집에 사람들이 살고 있습니다.
회의를 위해서 n개의 집중 한곳에 전부모이려고한다.
적절한 집을 선택하고, 모든 사람들의 이동 거리 합이 "최소"가 되게 합시다.

이동거리는 해당좌표에 사는 인원수 * 실제로 떨어져 있는 거리가 됩니다.
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력기 셋팅
        int result = Integer.MAX_VALUE; //Integer 클래스의 내부 상수 이용
        int[] arr;
        int N = Integer.parseInt(br.readLine());
        int selected;
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        } 

        for(int i=0;i<N;i++){ //완전탐색 시작
            int sum = 0;
            selected = i;

            for(int j=0;j<N;j++){
                if(i==j) continue;
                sum += Math.abs(selected - j)*arr[j];
            }
            result = Math.min(sum,result);
        }

        System.out.println(result);

    }
}