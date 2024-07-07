import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    static int maxx = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        String org;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        org = br.readLine();

        // a의 맨앞은 무조건 0이 아니라고 가정할수 있다.
        // 1000000000 10억

        for(int i=0;i<(int)org.length();i++){ 
            // i번째 문자를 뒤집어야 하므로, i전까지를 자르고 / 중간이 뒤집는 로직 / i이후부터 자르고 이렇게 구분되어있습니다.
            // '0'+'1' - 문자열.charAt(i) , 해당 부분이 0이라면 앞쪽의 0과 - 연산을 물어서 '1'만 남을거고,
            //                           ,  해당 부분이 1이라면 앞쪽의 1과 - 연산을 물어서 '0'이 남을거다. (뒤집는 효과)
            org = org.substring(0, i) + (char)('0' + '1' - org.charAt(i)) + org.substring(i + 1);
            
            maxx = Math.max(maxx,Integer.parseInt(org,2));

            org = org.substring(0, i) + (char)('0' + '1' - org.charAt(i)) + org.substring(i + 1); //문자열 원위치
        }
        
        System.out.println(maxx);

    }
}