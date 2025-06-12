package d250612.ch9;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingUI_Test_Ex1_4 {
    public static void main(String[] args) {
        // 프레임에 버튼, 라벨 동시에 넣어보기
        JFrame frame = new JFrame("버튼 , 라벨 붙이기 예시");
        // 윈도우창에 하나의 도화지 화면을 추가로 붙이기.
        JPanel panel = new JPanel();
        // 도화지에 , 버튼, 라벨 추가 -> 도화지->프레임에 붙이기 작업
        // 버튼과 , 라벨 객체 필요.
        JButton button = new JButton("버튼1");
        JLabel label = new JLabel("라벨1");
        // 버튼, 라벨 -> 패널에 붙이기 작업
        panel.add(label);
        panel.add(button);
        // 패널 -> 프레임 창에 붙이기 작업
        frame.add(panel);
        // 창 크기, 창 닫기시 종료, 창 보이기 , 1세트
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
