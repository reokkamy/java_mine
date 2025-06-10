package d250610.ch6_2;

import java.util.StringTokenizer;

public class StringTokenizer_Ex1 {
    // 문자열을 구분자 기준으로 나누는 방법.
    // 기본 문법
    //
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("사과,배, 바나나, 포도", ",");
        while (st.hasMoreTokens()) {
            System.out.println("구분자로 나누어진 배열에서 하나씩 꺼내서 확인하기 " + st.nextToken());

        }

    }

}
