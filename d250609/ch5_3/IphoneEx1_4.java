package d250609.ch5_3;

public class IphoneEx1_4 extends PhoneEx1_2 {
    // 자식 클래스
    private String sellPlace;

    public void sellInfo() {
        System.out.println("판매처 : " + sellPlace);
    }

    // 생성자 만들기.
    public IphoneEx1_4(String sellPlace) {
        // super() 기본 생성자 호출 생략이됨 (부모꺼) , 묵시적 , 생략
        this.sellPlace = sellPlace;
    }

    // 매개변수 4개인 생성자를 한번에 다 만들기.
    public IphoneEx1_4(String company, String name, String price, String sellPlace) {
        super(company, name, price); // 명시적으로, 표기함.
        this.sellPlace = sellPlace;
    }
}
