package backup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class IntroFrame extends JFrame {
    private JLabel label;
    private int secondsLeft = 3;

    public IntroFrame() {
        setTitle("인트로 화면");
        setSize(400, 200);
        setLocationRelativeTo(null); // 화면 중앙
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        updateLabel(); // 초기 텍스트 설정

        add(label);
        setVisible(true);

        // 1초마다 줄어드는 타이머 설정
        Timer timer = new Timer(1000, e -> {
            secondsLeft--;
            if (secondsLeft > 0) {
                updateLabel(); // 텍스트 업데이트
            } else {
                ((Timer) e.getSource()).stop(); // 타이머 멈춤
                dispose(); // 현재 창 닫기
                new SignupFrame(); // 다음 화면 이동
            }
        });
        timer.start();
    }

    private void updateLabel() {
        label.setText(secondsLeft + "초 후 회원가입화면으로 이동합니다");
    }
}