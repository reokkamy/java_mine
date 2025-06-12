package d250612.ch9;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingUI_Test_Ex1_3 {
    public static void main(String[] args) {
        // 프레임에 라벨 붙이기
        JFrame frame = new JFrame("라벨 붙이기 예시");
        // 라벨 객체 생성
        JLabel jLabel = new JLabel("Hello 스윙의 JLabel");
        // 프레임에 라벨 붙이기
        frame.add(jLabel);
        // 창 크기, 창 닫기시 종료, 창 보이기 , 1세트
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
