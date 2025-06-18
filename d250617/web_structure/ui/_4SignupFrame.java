package d250617.web_structure.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import d250617.web_structure.dto._10Member;
import d250617.web_structure.service._5MemberService;
import d250617.web_structure.util.DateUtil;

// 원래 목적, 화면 제공, + 기능 : 결과, 코드가 길어짐. 
// 기능 테스트, 
// 기능 분리, 
public class _4SignupFrame extends JFrame {

    // =============================================================
    // 추가1

    // Swing 관련 변수
    // 전체 흐름
    // 테이블 구성 -> DefaultTableModel 에 데이터 입력 -> JTable 이 모델을 받아 화면에 테이블로 출력
    // 테이블에서 수정, 추가, 삭제, 검색하거나 tableModel 갱싱됨.
    private DefaultTableModel tableModel; // Swing에서 테이블 데이터를 저장/관리하는 기본 모델 클래스
    private JTable memberTable; // Swing에서 표 형태(UI) 의 테이블 컴포넌트

    // 검색 관련 컴포넌트
    private JTextField searchField; // 검색어를 입력할수 있는 검색어 입력창. 선언만, 전역으로 사용가능.
    private JButton searchBtn; // 검색 버튼
    private JButton resetBtn; // 검색 초기화 버튼
    // =============================================================
    // 리팩토리 중,
    // 필요한 요소 1) tableModel 2)searchField
    private _5MemberService service = new _5MemberService();

    public _4SignupFrame() {
        setTitle("회원 가입");
        setSize(900, 500);
        setLocationRelativeTo(null); // 화면에 중앙 배치.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // =================================================================
        // 추가2.
        // 테이블 작업 부터 진행 하기.
        // 1) 테이블 헤더 만들기, 이름, 이메일, 패스워드, 가입일 ,

        // 0617, 변경 전,
        // String[] cols = { "이름", "이메일", "패스워드", "가입일" };

        // 0617, 변경 후,
        String[] cols = { "아이디", "이름", "이메일", "패스워드", "가입일" };
        tableModel = new DefaultTableModel(cols, 0) { // 익명클래스,
            public boolean isCellEditable(int row, int column) {
                return false; // 각테이블의 셀 클릭시 값이 변경이 되는 모드 기본, 안되게 변경함.
            }
        }; // 헤더제목, 0 빈테이블 생성,

        // 추가
        service.setTableModel(tableModel);
        // 코드 분리를 하면서, 기능, 화면을 따로 분리, 자바 특성상, 클래스 그림을 그리기 위해서
        // JFrame 필요함. 다이얼로그 알림창 이용을 하려면, 4번의 인스턴스를 서비스 클래스에 포함해서
        // 이용함, -> 단, 억지로 화면을 나타내기 위해서 구현을 했지만, 추천하는 형태는 아님.
        // 나중에, 정확히, 화면, 기능을 명확히 분리를 할 예정. 지금 단순 구현 위주로 진행을 했음.
        service.setSignupFrame(this);

        // 표 형태의 데이터를 ,-> 화면 출력용 테이블에 데이터 연결.
        memberTable = new JTable(tableModel);
        // 보여주는 테이블에, 데이터 많아지면, 스크롤이 가능하게, 스크롤 기능 첨부,
        JScrollPane scrollPane = new JScrollPane(memberTable); // 스크롤 기능이 있는 패널에 테이블 연결.

        // 버튼 있는 패널 생성.
        JPanel btnPanel = new JPanel(); // JPanel 의 기본 배치 관리자, FlowLayout ,나란히 배치.
        JButton addBtn = new JButton("회원가입");
        JButton updateBtn = new JButton("수정");
        JButton deleteBtn = new JButton("삭제");
        JButton reloadBtn = new JButton("새로고침");
        // 더미 데이터 버튼
        JButton dummyBtn = new JButton("더미데이터추가");

        // 버튼을 패널에 붙이기.
        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);
        btnPanel.add(reloadBtn);
        btnPanel.add(dummyBtn);

        // 검색 패널 생성
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);

        // 추가.
        service.setSearchField(searchField);

        searchBtn = new JButton("검색");
        resetBtn = new JButton("검색 초기화");
        // 검색 패널에 버튼 붙이기 작업.
        searchPanel.add(new JLabel("이름 또는 이메일 검색: "));
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);
        searchPanel.add(resetBtn);

        // 레이아웃 배치 패널들 1) scrollPane : 데이터 테이블 2) btnPanel 버튼 3) searchPanel
        setLayout(new BorderLayout());
        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
        // =================================================================

        // =================================================================
        // 추가3

        // 0617 , 변경 전
        // 파일에서 데이터 불러오고 , 테이블 표시, 메서드 호출
        // service.loadMembersFromFile();

        // 0617 , 변경 후
        // 디비에서 전체 데이터를 받고 -> 메모리에 멤버 리스트에 추가
        service.loadMembersFromDB();

        // 새로고침 기능 호출.
        service.refreshTable();

        // 각각의 버튼에 , 기능들을 붙이는 작업 이벤트 핸들러 작업.
        // 회원 가입
        addBtn.addActionListener(e -> showAddDialog());
        // 수정.
        updateBtn.addActionListener(e -> showUpdateDialog());
        // 삭제
        deleteBtn.addActionListener(e -> deleteSelectedMemberDialog());
        // 새로고침
        reloadBtn.addActionListener(e -> {
            // service.loadMembersFromFile();
            service.refreshTable();
        });
        // 검색
        // 변경 전, 검색 호출,
        // 0618, 검색
        // searchBtn.addActionListener(e -> service.searchMembers());

        // 변경 후, 검색 호출,
        // 0618, 검색
        searchBtn.addActionListener(e -> service.searchMembersDB());
        // 검색 초기화
        resetBtn.addActionListener(e -> {
            searchField.setText("");
            service.refreshTable();
        });
        // 검색어에서, 엔터를 입력해도, 실행이 되게끔.

        // 검색
        // 변경 전, 검색 호출,
        // 0618, 검색
        // searchField.addActionListener(e -> service.searchMembers());

        // 변경 후, 검색 호출,
        // 0618, 검색
        searchField.addActionListener(e -> service.searchMembersDB());

        // 더미 데이터 기능 추가 이벤트 리스너 연결.
        dummyBtn.addActionListener(e -> service.dummyMake());

        // 안내 문구 표시
        // JLabel label = new JLabel("여기는 회원 가입 화면입니다.", JLabel.CENTER);
        // add(label);

        // =================================================================

    }

    // =================================================================
    // 추가4
    // 각 기능들 정의,
    public void showDialog(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    // 6) 회원 가입 입력 품, 다이얼 로그 창으로 작업, 자바버전으로
    private void showAddDialog() {
        // 이름, 이메일, 패스워드, 입력 창(한줄 공간)
        JTextField nameField = new JTextField(10);
        JTextField emailField = new JTextField(15);
        JTextField passwordField = new JPasswordField(10);

        // 그리드 레이아웃을 통해서, 2열짜리 배치 작업,
        // 행을 0으로(행의 갯수 자동 생성), 열 표기,
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("이름 :"));
        panel.add(nameField);

        panel.add(new JLabel("이메일 :"));
        panel.add(emailField);

        panel.add(new JLabel("패스워드 :"));
        panel.add(passwordField);

        // 회원 가입 버튼 누를 경우, 확인 알림창 띄우기.
        // 확인 버튼 클릭 -> JOptionPane.showConfirmDialog() -> 특정 값을 반환.
        // 수락 -> 결과 OK 옵션 지정한 상수값 , 외우지, 이름으로 지정.
        // 수락 -> JOptionPane.OK_OPTION
        int result = JOptionPane.showConfirmDialog(
                this, // 이 알림창을 어디에 나타나게 할거냐? this : 현재 윈도우 창
                panel, // 사용자에게 보여줄 콘텐츠 ( JPanel )
                "회원 가입", // 알림 창에서의 제목
                JOptionPane.OK_CANCEL_OPTION, // 확인, 취소 버튼을 구성하는 옵션
                JOptionPane.PLAIN_MESSAGE // 아이콘이 없는 일반 메시지 형식의 알림창을 의미함. 기본 알림창
        );

        // 확인 알림창에서 수락시, 데이터를 파일 저장 시스템.
        if (result == JOptionPane.OK_OPTION) {
            // 화면에서, 입력창에 입력 했던 데이터 들을 다 가지고 와서, 임의의 변수 담고,
            // Member 클래스 형식으로 인스턴스 만들고, , 리스트 members 추가하고,
            // 파일에 쓰기 작업함.
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String password = passwordField.getText().trim();
            String regDate = DateUtil.getCurrentDateTime();
            // 값 입출력시, 유효성 체크 하기.
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "모든 항목을 입력해주세요.");
                // 리턴 추가 예정.
                return;
            }
            // 입력이 다 했고,
            // 인스턴스
            // _10Member member = new _10Member(name, password, email, regDate);
            // members.add(member);
            // 0617, 회원가입 적용 변경 전
            // service.addMember(null);
            // JOptionPane.showMessageDialog(this, "회원 가입 되었습니다.");
            // service.saveMembersToFile();

            // 0617, 회원가입 적용 변경 후
            // 1) 회원가입 화면에서 넘겨 받은 데이터 -> member 객체 생성
            // 매개변수에서 id 부분은 큰 의미가 없다 -> 왜? 디비에 넣을 때, 필요 없어서, -> 자동생성이라서
            _10Member member = new _10Member(1, name, email, password, regDate);
            // 2) insert 메서드에, 입력받은 회원 정보 member 전달,
            service.addMemberDB(member);
            JOptionPane.showMessageDialog(this, "회원 가입 되었습니다.");

            // 0617 , 회원 가입 후, 변경 사항 부분에 추가
            // 회원 가입 후, 디비에서 변경된 데이터를 다시 불러오기
            service.loadMembersFromDB();

            // 변경사항 새로고침, 즉 다 지우고, 전체 회원을 다시 그리기.
            service.refreshTable();
        }
    }

    // 7) 회원 수정 창
    private void showUpdateDialog() {
        // 0617, 회원 수정 변경 전,
        // 테이블 상에서, 선택된 행의 번호를 가져와서, 수정 작업,
        int row = memberTable.getSelectedRow();

        // 0617, 회원 수정 변경 후,
        // 테이블 상에서, 선택된 실제 ID 값만 가져오기,
        Object value = memberTable.getValueAt(row, 0);
        System.out.println("클릭시 가져온 값 확인 테스트 : " + value);
        // 실제 멤버의 아이디를 , int 타입으로 변환.
        // 전역으로 사용할 , 변환된 ID를 따로 선언
        int member_id;
        if (value instanceof Integer) {
            member_id = ((Integer) value).intValue();
            System.out.println("선택된 ID 정수화 : " + member_id);
        }
        member_id = ((Integer) value).intValue();
        System.out.println("선택된 ID 정수화 2: " + member_id);
        // 유효성 체크.
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "수정 할 회원을 선택하세요.");
            return;
        }
        // 전체 회원 목록 리스트에, 해당 회원 정보를 가져오기. .
        // Member oldMember = members.get(row);

        // 0617 , 회원 수정 변경 전,
        // 단순 리스트에 등록된 순서로 데이터를 가져오고 있음.
        // _10Member oldMember = service.getMembers().get(row);

        // 0617 , 회원 수정 변경 후,
        // 실제 데이터에서, 해당 ID 번호로 회원의 정보를 가져오기.
        // 여기서, 한명의 회원 정보를 가져오는 DAO 메서드가 필요함.
        // 추가 작업 필요함. -> 한명 회원 정보 가져오기 작업.
        _10Member oldMember = service.getMemberOne(member_id);

        // 이름, 이메일, 패스워드, 입력 창(한줄 공간)
        // 가입시에, 새롭게 내용을 입력을 했다면,
        // 기존 회원의 정보를 먼저 불러오고, 필요한 부분만 수정 할 예정
        JTextField nameField = new JTextField(oldMember.getName(), 10);
        JTextField emailField = new JTextField(oldMember.getEmail(), 15);
        JTextField passwordField = new JPasswordField(oldMember.getPassword(), 10);

        // 그리드 레이아웃을 통해서, 2열짜리 배치 작업,
        // 행을 0으로(행의 갯수 자동 생성), 열 표기,
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("이름 :"));
        panel.add(nameField);

        panel.add(new JLabel("이메일 :"));
        panel.add(emailField);

        panel.add(new JLabel("패스워드 :"));
        panel.add(passwordField);

        // 회원 수정 확인 버튼 누를 경우, 확인 알림창 띄우기.
        // 확인 버튼 클릭 -> JOptionPane.showConfirmDialog() -> 특정 값을 반환.
        // 수락 -> 결과 OK 옵션 지정한 상수값 , 외우지, 이름으로 지정.
        // 수락 -> JOptionPane.OK_OPTION
        int result = JOptionPane.showConfirmDialog(
                this, // 이 알림창을 어디에 나타나게 할거냐? this : 현재 윈도우 창
                panel, // 사용자에게 보여줄 콘텐츠 ( JPanel )
                "회원 정보 수정", // 알림 창에서의 제목
                JOptionPane.OK_CANCEL_OPTION, // 확인, 취소 버튼을 구성하는 옵션
                JOptionPane.PLAIN_MESSAGE // 아이콘이 없는 일반 메시지 형식의 알림창을 의미함. 기본 알림창
        );

        // 확인 알림창에서 수락시, 데이터를 파일 저장 시스템.
        if (result == JOptionPane.OK_OPTION) {
            // 화면에서, 입력창에 입력 했던 데이터 들을 다 가지고 와서, 임의의 변수 담고,
            // Member 클래스 형식으로 인스턴스 만들고, , 리스트 members 추가하고,
            // 파일에 쓰기 작업함.
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String password = passwordField.getText().trim();
            String regDate = DateUtil.getCurrentDateTime();
            // 값 입출력시, 유효성 체크 하기.
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "모든 항목을 입력해주세요.");
                // 리턴 추가 예정.
                return;
            }
            // 입력이 다 했고,
            // 인스턴스
            // 가입시
            // Member member = new Member(name, password, email, regDate);
            // 수정 할 경우

            // 0617, 회원 수정, 변경 전,
            // oldMember.setName(name);
            // oldMember.setEmail(email);
            // oldMember.setPassword(password);
            // // oldMember.setRegDate(regDate);
            // service.saveMembersToFile();
            // // 변경사항 새로고침, 즉 다 지우고, 전체 회원을 다시 그리기.
            // service.refreshTable();

            // 0617, 회원 수정, 변경 후,
            // 1) 화면에서 변경할 데이터를 멤버에 담기.
            oldMember.setName(name);
            oldMember.setEmail(email);
            oldMember.setPassword(password);

            // 0617, 회원 수정 디버깅 1,
            // 디비에 수정 된 내용 반영하기 전에, 데이터 확인.
            System.out.println("수정 하기전 데이터 확인 : " + oldMember);

            // oldMember.setRegDate(regDate);
            // 2) 수정하는 메서드에, 변경할 내용의 멤버 객체 전달 + 수정할 인덱스도 같이 넘기기.!@!
            service.updateMember(oldMember);
            // 수정한 데이터 반영하기.

            // 0617 , 회원 수정 후, 변경 사항 부분에 반영
            // 회원 변경 후, 디비에서 변경된 데이터를 다시 불러오기
            service.loadMembersFromDB();

            // 변경사항 새로고침, 즉 다 지우고, 전체 회원을 다시 그리기.
            service.refreshTable();
        }
    }

    // 8) 회원 삭제 기능.
    private void deleteSelectedMemberDialog() {
        // 테이블 상에서, 선택된 행의 번호를 가져와서, 수정 작업,
        int row = memberTable.getSelectedRow();
        // 유효성 체크.
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "삭제 할 회원을 선택하세요.");
            return;
        }

        // 추가 작업, 0618,
        // 삭제 작업, 기존에서 행번호가 아니라 멤버의 id 로 삭제 하기.
        // ===================================================================
        // 테이블 상에서, 선택된 실제 ID 값만 가져오기,
        Object value = memberTable.getValueAt(row, 0);
        System.out.println("삭제기능: 클릭시 가져온 값 확인 테스트 : " + value);
        // 실제 멤버의 아이디를 , int 타입으로 변환.
        // 전역으로 사용할 , 변환된 ID를 따로 선언
        int member_id;
        if (value instanceof Integer) {
            member_id = ((Integer) value).intValue();
            System.out.println("삭제기능: 선택된 ID 정수화 : " + member_id);
        }
        member_id = ((Integer) value).intValue();
        System.out.println("삭제기능: 선택된 ID 정수화 2: " + member_id);
        // ===================================================================

        // 회원 수정 확인 버튼 누를 경우, 확인 알림창 띄우기.
        // 확인 버튼 클릭 -> JOptionPane.showConfirmDialog() -> 특정 값을 반환.
        // 수락 -> 결과 OK 옵션 지정한 상수값 , 외우지, 이름으로 지정.
        // 수락 -> JOptionPane.OK_OPTION
        int result = JOptionPane.showConfirmDialog(
                this, // 이 알림창을 어디에 나타나게 할거냐? this : 현재 윈도우 창
                "정말 삭제하시겠습니까?", // 사용자에게 보여줄 콘텐츠 ( JPanel )
                "회원 삭제", // 알림 창에서의 제목
                JOptionPane.YES_NO_OPTION // 확인, 취소 버튼을 구성하는 옵션
        );

        // 확인 알림창에서 수락시, 데이터를 파일 저장 시스템.
        if (result == JOptionPane.YES_OPTION) {
            // 리스트에 해당 멤버 삭제,
            // members.remove(row);

            // 변경전, 0618, 삭제 작업
            // service.getMembers().remove(row);
            // service.saveMembersToFile();
            // // 변경사항 새로고침, 즉 다 지우고, 전체 회원을 다시 그리기.
            // service.refreshTable();

            // 변경후, 0618, 삭제 작업,
            // 1) member_id로 디비에서, 회원을 삭제후,
            // 화면에서 호출 -> 서비스 삭제기능 호출 -> dao 삭제기능 호출
            service.deleteMember(member_id);
            // 2) 다시 변경된 내용을 불러오기, 재사용.
            // 회원 변경 후, 디비에서 변경된 데이터를 다시 불러오기
            service.loadMembersFromDB();
            // 3) 새로 고침. 재사용
            // 변경사항 새로고침, 즉 다 지우고, 전체 회원을 다시 그리기.
            service.refreshTable();

        }
    }

}
// =================================================================
