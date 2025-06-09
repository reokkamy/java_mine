package d250609.ch5_3;

public class PhoneMainEx1_5 {
    public static void main(String[] args) {
        // 기본 인스턴스 2개 생성 후, 정보 확인.
        IphoneEx1_4 IphoneEx1_4 = new IphoneEx1_4("애플", "아이폰 16", "약200만원", "서면롯데백화점");
        IphoneEx1_4.showInfo();

        GalaxyEx1_3 galaxyEx1_3 = new GalaxyEx1_3("삼성", "갤럭시25", "약200만원", "삼성로고");
        galaxyEx1_3.showInfo();

        // 형 변환, 업 캐스팅, 또는 다운 캐스팅 확인.
        // 갤럭시 폰이다, 아이폰 폰이다. -> Is A 관계 , 상속 관계,
        // 갤럭시, 아이폰, 모두, 폰 타입으로 받아도 될까요?
        // 부모 클래스 자식 클래스, -> 이 인스턴의 타입은 무엇이냐? 부모 클래스 타입.PhoneEx1_2
        PhoneEx1_2 phoneIphone = new IphoneEx1_4("애플", "아이폰16", "약200만원", "프리비스");
        // 형 확인하는 연산자 이용해보기. -> 원래의 타입을 확인하는 절차.
        if (phoneIphone instanceof IphoneEx1_4) {
            // 다운 캐스팅 : 위 -> 아래 감. 부모 클래스에서 -> 자식 클래스 타입으로 변환.
            // 원래대로 본인의 형으로 변환함.
            IphoneEx1_4 IphoneEx1_42 = (IphoneEx1_4) phoneIphone;
            // 아이폰에 만 있는 기능.
            System.out.println("형이 아이폰 클래스 형이 맞다면, 여기에만 있는 기능 확인");
            IphoneEx1_42.sellInfo();
        } else if (phoneIphone instanceof GalaxyEx1_3) {
            GalaxyEx1_3 galaxyEx1_32 = (GalaxyEx1_3) phoneIphone;
            System.out.println("형이 갤럭시 클래스 형이 맞다면, 여기에만 있는 기능 확인");
            // 갤럭시 클래스에만 있는 기능.
            galaxyEx1_32.logoInfo();
        }

        // 다형성,
        // 갤력시는 폰이다.
        // 아이폰은 폰이다.
        // 현재는 A is B , A 가 다보임, 그래서, 이 타입 A라는 걸 알아요,
        // 폰타입(부모) 자식타입(아이폰) = new 자식클래스();

        // 받을 때는, 큰 범위로 받고서, 실제 사용시는 원래 클래스로 형을 맞춰서 사용을 해야함.
        // 모델 클래스를 만들어서, 형 일치 시켜놓고서 작업을 함.

        // 원래는 어떻게 만드나요?
        // A a =
        // A a = ,
        PhoneEx1_2 samsungPhone = new GalaxyEx1_3("삼성", "갤럭시24", "약200만원", "삼성로고");
        samsungPhone.showInfo();
        // samsungPhone.logoInfo(); // 주의사항, 현재 타입은 부모 타입이므로, 자식 타입의 인스턴스 메서드를 볼수가 없어서
        // 사용 못함.
        // 그래서, 원래 타입으로 변경하고, 사용함.
        // 막 , 아무타입으로 변경하면 안되니, 그래서 형을 확인하고서 변환을함.

        if (samsungPhone instanceof IphoneEx1_4) {
            // 다운 캐스팅 : 위 -> 아래 감. 부모 클래스에서 -> 자식 클래스 타입으로 변환.
            // 원래대로 본인의 형으로 변환함.
            IphoneEx1_4 IphoneEx1_42 = (IphoneEx1_4) samsungPhone;
            // 아이폰에 만 있는 기능.
            System.out.println("형이 아이폰 클래스 형이 맞다면, 여기에만 있는 기능 확인");
            IphoneEx1_42.sellInfo();
        } else if (samsungPhone instanceof GalaxyEx1_3) {
            GalaxyEx1_3 galaxyEx1_32 = (GalaxyEx1_3) samsungPhone;
            System.out.println("형이 갤럭시 클래스 형이 맞다면, 여기에만 있는 기능 확인");
            // 갤럭시 클래스에만 있는 기능.
            galaxyEx1_32.logoInfo();
        }

    }
}
