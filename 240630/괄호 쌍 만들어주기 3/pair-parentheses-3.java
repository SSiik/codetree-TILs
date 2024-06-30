import java.util.*;
import java.io.*;
import java.lang.*; // Math 관련 

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); 

        //입력받은문자열 중에서 ( .... ) 쌍이 몇개나 나오는지 찾아봐라!

        // 일단 문자열 최대길이가 100입니다.
        // 첫번째 ( 가 맨앞에 있다고 가정하면 뒤에 99개를 뒤져봐야한다.
        // 이렇게 뒤에 있는 ( 문자일수록 찾는 범위는 줄어듭니다.
        // 시간제한은 1초 즉 , 1억번의 operation 완탐으로 충분히 커버 가능해보입니다.

        int cnt=0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='('){
                for(int j=i+1;j<input.length();j++){
                    if(input.charAt(j)==')') cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}