package backup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp {
    public static void main(String[] args) {
        // Swing은 이벤트 디스패치 스레드(EDT)에서 실행해야 안정적
        SwingUtilities.invokeLater(() -> {
            new IntroFrame();
        });
    }
}