package d250609.ch5_2;

public class Cat_Main_Ex1 { // 실행 클래스이지, 자식 클래스가 아님.
    public static void main(String[] args) {
        Cat_Ex1 cat_Ex1 = new Cat_Ex1();
        cat_Ex1.favoriteFood = "소세지";
        cat_Ex1.showInfo();

        // 2번째 인스턴스 생성.
        Cat_Ex1 cat_Ex2 = new Cat_Ex1("야옹님", "햄");
        cat_Ex2.showInfo();
        // 결론, 접근 지정자 protected는 상속 받은 자식 클래스에서,
        // 접근이 가능하다,
        // 또는 같은 패키지이거나,
        // cat_Ex2.name = "이름 수정, 다른 외부 클래스에 접근 시도";
    }
}
