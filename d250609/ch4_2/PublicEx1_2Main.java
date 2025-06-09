package d250609.ch4_2;

import d250609.ch4.PublicEx1;

public class PublicEx1_2Main {
    // 다른 패키지의 클래스
    public static void main(String[] args) {
        PublicEx1 publicEx1 = new PublicEx1();
        // 인스턴스명. 멤버를 조회시, 보이는 것은 public으로 선언된 멤버만 보임.
        publicEx1.eamil = "lsy@naver.com";

    }

}
