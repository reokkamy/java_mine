package d250613.web_structure.ui;

import javax.swing.Timer; // 수동으로 해당 패키지 위치 설정.

import javax.swing.JFrame;
import javax.swing.JLabel;

// 인트로 화면을 약 3초 보여주고, 메인 화면으로 자동 전환
public class _2IntroFrame extends JFrame { // JFrame 부모 클래스를 상속 받아서, 기능이 많아짐.
    // 실행 클래스가 아니라, 설계 클래스 이므로,
    // 생성자에 필요한 기능을 넣고,
    // 이 클래스의 기본 생성자를 호출(인스턴스 생성시 ) 동작 하게끔 하는 원리.

    // 실행시,
    // 순서2
    public _2IntroFrame() {
        // JFrame frame = new JFrame("창의 제목 작성. ");
        // JFrame 상속을 받았기 때문에 , 이 클래스는 임의 기능을 탑재 하고 있음.
        setTitle("인트로 화면 예시"); // 창 제목
        setSize(400, 200); // 창 크기
        setLocationRelativeTo(null); // 화면 중앙 배치 기능.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 안내 문구 표시
        JLabel label = new JLabel("환영합니다. 3초후 메인 이동합니다. ", JLabel.CENTER);
        // 프레임에 붙이기
        add(label);
        // 화면에 보이기
        setVisible(true);

        // 3초 후, 다른 화면으로 이동하는 기능, 타이머 기능 사용하기.
        // Timer timer = new Timer(3000, 1)내부클래스 2) 익명클래스 3) 람다식)
        Timer timer = new Timer(3000,
                e -> {
                    new _3MainFrame(); // 메인 화면 생성, 해당 클래스 기본 생성자를 호출하면 기능 동작하는 구조.
                    // 현재 화면, 인트로 화면만 창 닫기.
                    dispose();
                });
        timer.setRepeats(false); // 타이머가 1회만 실행.
        timer.start();
    }

}
