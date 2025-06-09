package d250609.ch5;

public class Dog_Ex1 extends Animal_Ex1 { // 자식클래스
    // 부모의 멤버 중에서 name이 있음.
    // 태어난 나라
    private String nation;

    // 부모의 기능중에서 speak
    // speak 기능을 수정해보기, 메소드 이름은 그대로 사용하고
    // 기능 구현만 다르게함 -> 오버라이딩 (@override)
    @Override // 애너테이션이라고 부르고
    // 내가 부모 클래스의 기능을 재사용하니 니가 검사시 잘 검사해줘
    // 자식클래스에서
    // 1) 상속후 기능 재정의를 안할때 부모의 speak()메소드 이용
    // 2) 상속후 기능 재정의할때, 자식의 speak() 메소드 이용
    public void speak() {
        System.out.println("난 멍멍이야, 그래서 멍멍할게");
    }

    // 생성자 만들기, 매개변수, 2개
    // 주의 ,기본생성자를 더이상 지원을 안해줌
    public Dog_Ex1() { // 부모의 생성자가없어? 기본생성자가 없다고 경고

    };

    public Dog_Ex1(String name, String nation) {
        // name 정의가, 부모클래스에서 정의를 했음.
        // 부모를 호출하는 키워드 필요함 : super()
        // 부모 클래스에서 기본생성자는 만들어줌.
        // 단 매개변수 생성자가 없을 경우에는
        super(name);

        // this, 현재 본인의 인스턴스를 가리킴 : Dog_Ex1
        this.nation = nation;
    }

    // 강아지 정보를 알려주는기능
    public void showInfo() {
        System.out.println("이름 : " + name);
        System.out.println("나라 : " + nation);
    }

}
