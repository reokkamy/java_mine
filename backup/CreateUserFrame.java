package backup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CreateUserFrame extends JFrame {
    public CreateUserFrame() {
        setTitle("회원 생성");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("회원 생성 화면입니다", SwingConstants.CENTER);
        label.setFont(new Font("맑은 고딕", Font.PLAIN, 16));

        add(label);
        setVisible(true);
    }
}