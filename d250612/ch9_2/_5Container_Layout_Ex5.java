package d250612.ch9_2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class _5Container_Layout_Ex5 {
    public static void main(String[] args) {
        // 패널 2개 생성, 각각 패널에 배치 관리자를
        // FlowLayout, GridLayout 적용하기,
        // 북 : FlowLayout, 중앙 : GridLayout

        JFrame frame = new JFrame("복합 패널 레이아웃 적용  예시3");
        // 추가, 패널 2개 생성, FlowLayout, GridLayout 적용하기,
        // JPanel northPanel = new JPanel(배치관리자 설정);
        JPanel northPanel = new JPanel(new FlowLayout());
        // 북 : 패널에 버튼 2개 예시 추가.
        northPanel.add(new JButton("샘플버튼1"));
        northPanel.add(new JButton("샘플버튼2"));

        // 중앙 패널 생성하고, 샘플 버튼 2개 추가.
        JPanel centerPanel = new JPanel(new GridLayout(2, 1));
        centerPanel.add(new JButton("샘플버튼3"));
        centerPanel.add(new JButton("샘플버튼4"));

        // ======================================================================
        // 프레임에 배치관리자 , BorderLayout 설정.
        frame.setLayout(new BorderLayout());

        // 프레임에 -> 패널 붙이기 작업,
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        // ======================================================================
        //
        // 창 크기, 창 닫기시 종료, 창 보이기 , 1세트
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
