package d250609.ch5;

public class InheritanceMain_Ex1 {
    public static void main(String[] args) {
        // A a = new A();
        Dog_Ex1 dog_Ex1 = new Dog_Ex1();
        dog_Ex1.speak();
        // 2번째 멍멍이 인스턴스
        Dog_Ex1 dog_Ex12 = new Dog_Ex1("비글멍멍이", "영국");
        dog_Ex12.showInfo();
    }
}
