package d250612.ch9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// 익명 클래스 (= 1회용 클래스), 이벤트 처리하는 한번 만 사용하는 구조에서 많이 사용함. 
// 이름 없는 클래스, => 모바일 앱 개발할 때 , 주로 많이 활용이 됨. 
// 보통 객체를 생성할 때는 new 클래스명() ,
// 모양 
// new 인터페이스명() 또는 new 부모 클래스 이름() 
// 과정, 
// 원래는 이름이 있는 버전이 
//  class SampleListener implements ActionListener {

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         // 이벤트 기능, 닫기 기능
//         frame.dispose();
//     }

// }
// 1) 해당 클래스의 이름이 없으므로 , 이름 부분 생략, 
// (클래스명 생략) ActionListener {

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         // 이벤트 기능, 닫기 기능
//         frame.dispose();
//     }

// }

// 2) 익명 클래스로 인스턴스를 생성 할려고 보니, 이름이 없네, 어떡하죠? 
// 인터페이스명 변수 = new 인터페이스명() {
// 이벤트 처리 구조 , 메서드 구현
//}

public class InnerClass_Anonymous_Lambda2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("익명 클래스 예시");
        JButton button = new JButton("닫기");

        // 내부 클래스는
        // 내부에 또 다른 클래스 정의
        // class SampleListener implements ActionListener {

        // @Override
        // public void actionPerformed(ActionEvent e) {
        // // 이벤트 기능, 닫기 기능
        // frame.dispose();
        // }

        // }
        // button.addActionListener(new SampleListener());

        // 익명 클래스 할당 부분,
        // new 인터페이스 명 () {메서드 구현}
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.add(button);
        // 창 크기, 창 닫기시 종료, 창 보이기 , 1세트
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
