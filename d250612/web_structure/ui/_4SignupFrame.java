package d250612.web_structure.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class _4SignupFrame extends JFrame {
    public _4SignupFrame() {
        setTitle("회원 가입");
        setSize(400, 200);
        setLocationRelativeTo(null); // 화면에 중앙 배치.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 안내 문구 표시
        JLabel label = new JLabel("여기는 회원 가입 화면입니다.", JLabel.CENTER);
        add(label);
        setVisible(true);

    }

}
