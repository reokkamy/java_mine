package d250612.ch9_2;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

// BorderLayout 이용하고, 
// 북: 회원 가입 JLabel 붙이고, 
// 중앙: 2x2 GridLayout  JLabel ("아이디")
public class _6Container_Layout_Ex6 {
    public static void main(String[] args) {

        JFrame frame = new JFrame("회원가입 간단구조  예시4");
        // 프레임에 배치관리자 , BorderLayout 설정.
        frame.setLayout(new BorderLayout());

        // 북, 회원 가입 라벨 붙이기,
        frame.add(new JLabel("회원 가입", SwingConstants.CENTER), BorderLayout.NORTH);

        // 중앙 패널 생성하고, 샘플 버튼 2개 추가.
        JPanel centerPanel = new JPanel(new GridLayout(2, 2));
        centerPanel.add(new JLabel("이름"));
        centerPanel.add(new JTextField(20));
        centerPanel.add(new JLabel("패스워드"));
        centerPanel.add(new JPasswordField(20));
        // 프레임에 -> 패널 붙이기 작업,
        frame.add(centerPanel, BorderLayout.CENTER);

        frame.add(new JButton("가입"), BorderLayout.SOUTH);

        // ======================================================================
        // 창 크기, 창 닫기시 종료, 창 보이기 , 1세트
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // ======================================================================
    }
}
