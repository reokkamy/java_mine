package d250612.ch9;

import javax.swing.JButton;
import javax.swing.JFrame;

// 람다식(Lambda Expression) 
// 자바 8 이후부터 등장한,
// 함수형 인터페이스(메서드가 1개인 경우에만) 람다식으로 구현 가능. (화살표 함수라고도 함.)

// 기본 문법 구조, 
//  버튼.addActionListener(1)내부 클래스, 2) 익명 클래스 3) 화살표 함수) 
//  버튼.addActionListener(e -> {이벤트 처리 구조}) 
public class InnerClass_Anonymous_Lambda3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("람다식 표현, 이벤트 처리 ");
        JButton button = new JButton("닫기");

        // 이벤트 작업, 버튼에 이벤트 기능 탑재하기.
        button.addActionListener(e -> frame.dispose());

        frame.add(button);
        // 창 크기, 창 닫기시 종료, 창 보이기 , 1세트
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}