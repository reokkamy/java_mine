package d250612.ch9;

import javax.swing.JButton;
import javax.swing.JFrame;
// 자동으로 임포트 해주는데, 인식을 못해서 
// 수동으로 패키지 경로 잡기. 
import java.awt.event.*;

public class SwingUI_Test_Ex1_5 {
    public static void main(String[] args) {
        // 프레임 안에 닫기 버튼 추가해서,
        // 이벤트 처리를 , 클릭시(이벤트 핸들러) , 닫기 기능 구현 해보기.
        JFrame frame = new JFrame("닫기 버튼에 간단한 이벤트 추가");
        JButton button = new JButton("닫기");
        // 이벤트 리스너 작업,
        // 방법) 1) 내부 클래스 2) 익명 클래스 3) 람다식(화살표 함수)
        // 2) 익명 클래스 버전으로 설명 하기.
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 창을 종료하고, 메모리에서 자원해제
                // JFrame.EXIT_ON_CLOSE: 프로그램 자체 종료
                // DISPOSE_ON_CLOSE :현재창만 닫기
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
