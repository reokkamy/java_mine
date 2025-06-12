package d250612.ch9_2;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class _3Container_Layout_Ex3 {
    public static void main(String[] args) {
        // GridLayout 예시
        JFrame frame = new JFrame("GridLayout  예시");
        // 추가, JPanel
        JPanel panel = new JPanel();

        // =======================.===============================================
        // 패널에 배치관리자 , GridLayout 설정.
        panel.setLayout(new GridLayout(2, 2));
        // 패널에 버튼 4개 추가
        panel.add(new JButton("샘플1"));
        panel.add(new JButton("샘플2"));
        panel.add(new JButton("샘플3"));
        panel.add(new JButton("샘플4"));
        // 패널을 -> 프레임에 붙이기
        frame.add(panel);
        // ======================================================================
        //
        // 창 크기, 창 닫기시 종료, 창 보이기 , 1세트
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
