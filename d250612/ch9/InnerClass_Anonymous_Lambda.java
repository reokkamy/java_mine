package d250612.ch9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// 내부 클래스 
// 정의
// 클래스 안에 또 다른 클래스를 정의하고, 사용 
// 사용처
// 버튼, 이벤트 소스가 여러 곳에서 동일한 리스너를 공유하거나, 
// 또는 복잡한 로직을 분리할 때 사용. 
public class InnerClass_Anonymous_Lambda {
    JFrame frame = new JFrame("내부클래스 예시");
    JButton button = new JButton("닫기");

    // 생성자,
    public InnerClass_Anonymous_Lambda() {
        // 버튼에 , 이벤트 리스너 붙이기
        button.addActionListener(new SampleListener());
        // 화면에 버튼 붙이기 작업,
        frame.add(button);
        // 창 크기, 창 닫기시 종료, 창 보이기 , 1세트
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // 내부에 또 다른 클래스 정의
    class SampleListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // 이벤트 기능, 닫기 기능
            frame.dispose();
        }

    }

    public static void main(String[] args) {
        // 원래는 , A a = new A();
        // InnerClass_Anonymous_Lambda inClassEx = new InnerClass_Anonymous_Lambda();
        // 실행 순서,
        // 1) 메인 메서드 시작
        // 2) 메인 메서드 안에, 해당 클래스의 기본 생성자를 호출
        // 3) 호출하면, 정의한 생성자로 갑니다.
        // 4)
        new InnerClass_Anonymous_Lambda();
    }
}
