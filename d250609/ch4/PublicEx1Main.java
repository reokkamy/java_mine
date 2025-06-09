package d250609.ch4;

public class PublicEx1Main {
    // 같은 패키지의 클래스
    public static void main(String[] args) {
        // 클래스, 활용 1) 인스턴스 만들기 , 2) 생성자를 이용해서 초기화 하는 방법,
        // 1) 인스턴스 만들기
        // [클래스명] [인스턴스 변수명] = new [클래스명]()
        // 생성자 : [클래스명]() "기본생성자"
        PublicEx1 publicEx1 = new PublicEx1();
        // 게터 세터를 사용하기 전에 직접 접근으로 알아보고,
        // 직접 접근은 인스턴스의 점(.)을 이용해서, 해당 멤버 변수에 접근.
        // 예) publicEx1.[멤버변수명] , 접근하기.
        publicEx1.eamil = "lsy@naver.com"; // 접근시, private 제외한 나머지 멤버는 보인다.
        publicEx1.hobby = "조깅";
        publicEx1.phone = "01076613709";
        publicEx1.showInfo();
    }

}
