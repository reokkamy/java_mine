package ch4;

public class MainClassCh4 {
    // 실행 하는 클래스
    public static void main(String[] args) {

        // 퀴즈
        // 본인 만들 Phone 클래스를 , 담을 배열을 만들어서,
        // 1) 담기 2) 출력하기. 3) 각 멤버의 주소값 확인 해보기.

        Quiz1[] quiz = new Quiz1[5];

        Quiz1 Quiz1 = new Quiz1("사탕", "1111", "쿠팡");
        Quiz1 Quiz2 = new Quiz1("세제", "2222", "네이버");
        Quiz1 Quiz3 = new Quiz1("비누", "3333", "다음");
        Quiz1 Quiz4 = new Quiz1("과자", "8444", "홈플러스");
        Quiz1 Quiz5 = new Quiz1("생수", "9442", "이마트");

        quiz[0] = Quiz1;
        quiz[1] = Quiz2;
        quiz[2] = Quiz3;
        quiz[3] = Quiz4;
        quiz[4] = Quiz5;

        Quiz1.showInfo();
        System.out.println("-----------------");
        Quiz2.showInfo();
        System.out.println("-----------------");
        Quiz3.showInfo();
        System.out.println("-----------------");
        Quiz4.showInfo();
        System.out.println("-----------------");
        Quiz5.showInfo();

        System.out.println("Quiz1 주소: " + System.identityHashCode(Quiz1));
        System.out.println("Quiz2 주소: " + System.identityHashCode(Quiz2));

        // 앞에서 배운 배열을 이용해서, 클래스 객체를 배열의 요소로 사용하기
        // Phone 클래스 타입을 요소로 가지는 배열.
        Phone[] phones = new Phone[5]; // Phone 타입의 배열 생성, 5개 요소
        // 우리는 기본형으로 정수형, 실수형, 불린형, char, 문자형
        // 클래스 타입으로 인식을 함. -> 참조형 변수(타입)= 레퍼런스 타입
        // 중요한 정보 ,
        // phone1 에는 뭐가 들어가 있을까?
        // 정답은 해당 내용이 저장된 메모리 위치 주솟값이 들어감.
        // 비유, 여러분 돈 -> 은행 통장 -> 계좌번호 -> 돈이 들어있는 통장
        // 내용은 메모리에 넣어두고, 우리 그 메모리 위치 주소만 알면됨 -> 0x100,
        Phone phone1 = new Phone("Galaxy S23", "100만원", "삼성전자");
        Phone phone2 = new Phone("iPhone 14", "120만원", "Apple");
        Phone phone3 = new Phone("Pixel 7", "90만원", "Google");
        Phone phone4 = new Phone("OnePlus 11", "80만원", "OnePlus");
        Phone phone5 = new Phone("Xiaomi 13", "70만원", "Xiaomi");
        // 배열에 객체를 할당
        phones[0] = phone1; // 0번째 요소에 phone1 객체 할당
        phones[1] = phone2; // 1번째 요소에 phone2 객체 할당
        phones[2] = phone3; // 2번째 요소에 phone3 객체 할당
        phones[3] = phone4; // 3번째 요소에 phone4 객체 할당
        phones[4] = phone5; // 4번째 요소에 phone5 객체 할당

        // 직접 할당.
        Phone[] phones2 = {
                phone1,
                phone2,
                phone3,
                phone4,
                phone5
        };

        // 그래서, 각 인스턴스 주소는 , 독립적이다, 다 다른 메모리 위치 주소에 저장이된다.
        // 그러면, 그 위치 주소를 직접확인. 자바스크립트, 힘들고, '
        // 자바는 기능을 지원 해줌.
        // phone1, phone2 의 메모리 주소를 비교 및 확인.
        System.out.println("phone1 주소: " + System.identityHashCode(phone1));
        System.out.println("phone2 주소: " + System.identityHashCode(phone2));

        // 반복문을 이요해서 순회해서 출력

        // 문자열 타입을 요소로 가지는 배열.
        String[] carModels = { "suv", "k5세단", "아반떼", "소나타", "그랜저" };
        // 정수 타입을 요소로 가지는 배열.
        int[] carPrices = { 4000, 3000, 2500, 3500, 5000 }; // 단위 : 만원

        // 설계한 클래스를 이용해서
        // 객체 생성 ,
        // 순서1
        // [클래스명] 객체명(인스턴스 변수명) = new [클래스명]();
        // new Car() : 기본 생성자,
        Car car1 = new Car(); // 기본 생성자 호출
        // 순서2
        // 해당 자동차의 멤버 변수에 값 대입, 직접 값을 할당, 실무에서는 이렇게 사용안하고,
        // getter/setter 메소드를 사용 -> 불변성을 이용해서, 캡슐화, 밖에서 안보이게 , 접근 지정자로
        // 꽁꽁 숨길 예정. 지금은 기본이니, 참고만 함.
        car1.model = "suv";
        car1.price = "4000만원";
        car1.company = "기아자동차";
        // 순서3, 기능 확인. 객체명.메소드명(); 이런 형식으로 사용함,
        // 이전에 정적인 메소드는 , 사용 모양 : 클래스명.메소드명() , 비교.
        car1.showInfo();

        // 마치 공장에서 자동차를 찍어 내듯이, 또다른 인스턴스를 생성.
        Car car2 = new Car(); // 기본 생성자 호출
        car2.model = "k5세단";
        car2.price = "3000만원";
        car2.company = "기아자동차";
        car2.showInfo();
    }
}