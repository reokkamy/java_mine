package d250612.ch9_2;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class _4Container_Layout_Ex4 {
    public static void main(String[] args) {
        // BorderLayout 이용해서, 북: 제목, 중앙: JTextArea(5행 20열),
        // 남: 저장 버튼 배치.해보기.
        JFrame frame = new JFrame("BorderLayout  예시2");

        // ======================================================================
        // 프레임에 배치관리자 , BorderLayout 설정.
        frame.setLayout(new BorderLayout());
        // 동,서,남,북, 중앙
        frame.add(new JLabel("제목", SwingConstants.CENTER), BorderLayout.NORTH);
        frame.add(new JTextArea(5, 20), BorderLayout.CENTER);
        frame.add(new JButton("저장"), BorderLayout.SOUTH);

        // ======================================================================
        //
        // 창 크기, 창 닫기시 종료, 창 보이기 , 1세트
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
