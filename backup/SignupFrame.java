package backup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SignupFrame extends JFrame {
    public SignupFrame() {
        setTitle("회원가입 화면");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton signupButton = new JButton("회원가입");
        signupButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));

        signupButton.addActionListener(e -> {
            dispose();
            new CreateUserFrame();
        });

        JPanel panel = new JPanel();
        panel.add(signupButton);

        add(panel);
        setVisible(true);
    }
}