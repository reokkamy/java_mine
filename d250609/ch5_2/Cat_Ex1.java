package d250609.ch5_2;

import d250609.ch5.Animal_Ex1; // 다른 패키지의 클래스를 사용시 임포트해야함.

// 자식 클래스이므로, 부모의 protected 의 멤버에 접근이 가능함. 
public class Cat_Ex1 extends Animal_Ex1 {
    String favoriteFood;

    public void showInfo() {
        System.out.println("좋아하는 음식: " + favoriteFood);
        // 상속을 안받고 , 다른 패키지 다른 폴더의 클래스의 멤버에 접근.

    }

    // 기본 생성자 생략, .
    public Cat_Ex1() {
        super(); // 부모꺼 생략 , 왜 ? 기본 생성자라서,
    }

    // 초기화를 쉽게 하기 위해서, 매개변수 생성자를 만들기.
    public Cat_Ex1(String name, String favoriteFood) {
        super(name); // 부모꺼 생략 , 왜 ? 기본 생성자라서,
    }
}
