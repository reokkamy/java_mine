package d250613.web_structure.main;

import javax.swing.SwingUtilities;

import d250613.web_structure.ui._2IntroFrame;

public class _1MainClass {
    public static void main(String[] args) {
        // 프로그램 시작, : 스윙 이벤트 스레드 이용해서, 인트로 실행.
        // 실행시,
        // 순서1
        SwingUtilities.invokeLater(() -> new _2IntroFrame());
    }
}
