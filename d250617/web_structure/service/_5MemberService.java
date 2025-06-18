package d250617.web_structure.service;

// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.File;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import d250617.web_structure.dao._9DAO_Inaterface;
import d250617.web_structure.dao._N1OracleMemberDAOImpl;
import d250617.web_structure.dto._10Member;
import d250617.web_structure.ui._4SignupFrame;
import d250617.web_structure.util.DateUtil;

import javax.swing.*;

public class _5MemberService {
    // 파일 불러오는 경로를 전역으로 설정.

    // 0617 순서1
    // 변경 전
    // private static final String FILE_NAME = "member.txt"; // 회원 정보 저장 파일명, csv 형식

    // 변경 후
    // DB에서, 데이터 가져오기 준비,_N1OracleMemberDAOImpl(전체조회, 추가, 수정, 삭제, 검색 등 기능이 탑재)
    _9DAO_Inaterface dao = new _N1OracleMemberDAOImpl();

    // 0617 순서2
    // 변경 전
    // 파일에서 불러온 멤버의 모든 정보를 담아둘 임시 공간 리스트
    // 변경 후
    // DB에서 불러온 멤버의 모든 정보를 담아둘 임시 공간 리스트
    private List<_10Member> members = new ArrayList<>();

    // 없는 부분 받아서 임시로 사용하기.
    private DefaultTableModel tableModel;

    private JTextField searchField;

    public void setSignupFrame(_4SignupFrame signupFrame) {
        this.signupFrame = signupFrame;
    }

    private _4SignupFrame signupFrame;

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void setSearchField(JTextField searchField) {
        this.searchField = searchField;
    }

    public List<_10Member> getMembers() {
        return members;
    }

    // 0617, 회원가입 변경 전, 파일에 쓰는 버전.
    public void addMember(_10Member member) {
        members.add(member);
        saveMembersToFile();
    }

    // 0617, 회원가입 변경 후
    public void addMemberDB(_10Member member) {
        // 디비에 쓰는 기능을 사용하기.
        boolean result = dao.insert(member);
        // System.out.println("회원 가입 완료");
    }

    // 0617, 회원 수정시, 한명의 회원 정보를 가져오는 기능.
    public _10Member getMemberOne(int member_id) {
        _10Member member = dao.findById(member_id);
        return member;
    }

    // 0617, 회원 수정, 디비에 반영하기.
    // 0617, 회원 수정 디버깅 2,
    public void updateMember(_10Member member) {
        System.out.println("_5MemberService 파일 회원 수정 데이터 확인 :");
        System.out.println(member);
        dao.update(member);
    }

    // 0618, , 회원 삭제
    public void deleteMember(int member_id) {
        System.out.println("삭제 진행하기. ");
        // dao에서, 삭제하는 기능 구현.
        boolean result = dao.delete(member_id);
        System.out.println("삭제 했나요? : " + result);
    }

    // 0617 순서3, 해당 기능 수정.
    // 변경 전
    // 1) csv 파일에서 회원 목록 불러오기. loadMembersFromFile()

    // 변경 후,
    // 디비에서 불러오기.
    public void loadMembersFromDB() {
        // 임시 , 멤버의 정보들을 담아두는 리스트,
        members.clear();// 모두 비우기.
        try {
            members = dao.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    // 2) 회원 목록을 CSV 파일에 저장, saveMembersToFile()
    public void saveMembersToFile() {
        // 파일에 저장시, 버퍼를 이용하고, try ~ resource ,
        // 전
        // try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
        // 후
        // try (BufferedWriter bw = new BufferedWriter(
        // new OutputStreamWriter(new FileOutputStream(FILE_NAME), "UTF-8"))) {
        // for (_10Member member : members) {
        // // bw.write(member.toCSV());
        // bw.newLine();
        // }
        // } catch (

        // Exception e) {
        // // 오류 발생시 간단히 알림 창띄우기.
        // // JOptionPane.showMessageDialog(this, "파일 저장 오류 : " + e.getMessage());
        // // JOptionPane.showMessageDialog(this, "파일 생성 오류 : " + e.getMessage());
        // // System.out.println("다른 방법으로 알림등 알려줄 예정");
        // System.out.println(e.getMessage());
        // }
    }

    // 더미 데이터 추가하는 기능.
    // 화면이 필요 없음.
    public void dummyMake() {

        // 반복문으로 더미 데이터 10개 정도 넣기.
        for (int i = 0; i < 10; i++) {
            // _10Member dummyMember = new _10Member(
            // "더미회원" + (i + 1),
            // "password" + (i + 1),
            // "dummy" + (i + 1) + "@example.com",
            // DateUtil.getCurrentDateTime());
            members.add(null);
        }

        saveMembersToFile();
        // 변경사항 새로고침, 즉 다 지우고, 전체 회원을 다시 그리기.
        refreshTable();
        // 10명의 더미 회원 추가 확인 다이얼로그창 띄우기.
        // JOptionPane.showMessageDialog(this, "10명의 더미 회원 추가!!");
        // JOptionPane.showMessageDialog(this, "파일 생성 오류 : " + e.getMessage());
        // System.out.println("다른 방법으로 알림등 알려줄 예정");
        signupFrame.showDialog("10명의 더미 회원 추가!!");

    }

    // 3) JTable에 회원 데이터 반영 (새로고침), 전체 모든 회원 조회
    // tableModel : 가상 테이블, 회원 정보를 , 테이블, 행,열 구성.
    // JTable : 출력용 테이블 연결.
    public void refreshTable() {
        tableModel.setRowCount(0); // 기존 데이터 모두 제거, 모든 행 삭제,
        for (_10Member member : members) {
            // tableModel 에, 데이터 쓰기, 기본 데이터 테이블 데이터를 쓰고, -> 출력용 테이블 연결하기.
            // System.out.println("데이터 출력시 깨지는 부분확인 이름: " + member.getName());
            tableModel.addRow(new Object[] {
                    // 0617, 변경 전
                    // member.getName(), member.getEmail(), member.getPassword(),
                    // member.getRegDate()

                    // 0617, 변경 후, 순서 표기, 테이블 출력용 맞게 , 데이터 출력하기
                    // String[] cols = { "아이디", "이름", "이메일", "패스워드", "가입일" };
                    member.getId(), member.getName(), member.getEmail(), member.getPassword(),
                    member.getReg_date()
            });
        }
    }

    // 4) 검색 결과 테이블에 반영, 기존 전체데이터를 삭제하고, 검색된 결과 멤버들만 조회,
    // 변경 전,
    // 0618, 회원 수정 부분,
    // public void showSearchResults(ArrayList<_10Member> results) {
    // tableModel.setRowCount(0);
    // for (_10Member member : results) {
    // // tableModel 에, 데이터 쓰기, 기본 데이터 테이블 데이터를 쓰고, -> 출력용 테이블 연결하기.
    // tableModel.addRow(new Object[] {
    // // member.getName(), member.getEmail(), member.getPassword(),
    // // member.getRegDate()
    // });
    // }
    // }

    // 변경 후,
    // 0618, 회원 수정 부분,
    public void showSearchResults(List<_10Member> results) {
        tableModel.setRowCount(0);
        for (_10Member member : results) {
            // tableModel 에, 데이터 쓰기, 기본 데이터 테이블 데이터를 쓰고, -> 출력용 테이블 연결하기.
            tableModel.addRow(new Object[] {
                    member.getId(), member.getName(), member.getEmail(), member.getPassword(),
                    member.getReg_date()
            });
        }
    }

    // 5) 검색 기능 (이름 또는 이메일 검색어가 포함된 회원만 표시), 검색 결과만 표기.
    // 변경 전, 파일 형식
    public void searchMembersFile() {
        // 검색어 입력창에서, 검색어를 가져오기, 양쪽 공백 제거, 영어 인경우 모두 소문자로 변경하고
        String query = searchField.getText().trim().toLowerCase();
        // 유효성 체크. 검색어 비어 있는지 체크.
        if (query.isEmpty()) {
            refreshTable(); // 기본 전체 조회가 실행이 됨.
            return;// 검색 기능 메서드 나가기,
        }
        // 임시로 담아둘 멤버 리스트 하나 정의.
        ArrayList<_10Member> resultList = new ArrayList<>();
        // members : 파일에서 읽어서, 담아둔 임시 전체 멤버 리스트,
        // resultList, 아래 반복문에서, 검색어 일치하는 멤버들만 담을 공간.
        for (_10Member member : members) {
            if (member.getName().toLowerCase().contains(query) ||
                    member.getEmail().toLowerCase().contains(query)) {
                resultList.add(member);
            }
        }
        // 검색 된 결과를, 화면에 출력하는 메서드에, 검색된 멤버 리스트를 넘겨주기.
        showSearchResults(resultList);

        // 검색된 결과가 없다면, 알림창으로 검색 결과가 없습니다.
        if (resultList.isEmpty()) {
            // JOptionPane.showMessageDialog(this, "검색 결과가 없습니다.");
            // JOptionPane.showMessageDialog(this, "파일 생성 오류 : " + e.getMessage());
            signupFrame.showDialog("검색 결과가 없습니다.");
            // System.out.println("다른 방법으로 알림등 알려줄 예정");
        }

    }

    // 0618, 디비에서 회원 정보 검색 후, 처리하기.
    // 변경 후.
    public void searchMembersDB() {
        // 검색어 입력창에서, 검색어를 가져오기, 양쪽 공백 제거, 영어 인경우 모두 소문자로 변경하고
        String query = searchField.getText().trim().toLowerCase();
        // 유효성 체크. 검색어 비어 있는지 체크.
        if (query.isEmpty()) {
            refreshTable(); // 기본 전체 조회가 실행이 됨.
            return;// 검색 기능 메서드 나가기,
        }
        // 임시로 담아둘 멤버 리스트 하나 정의.
        List<_10Member> resultList = new ArrayList<>();
        // ===========================================================
        // 1) 디비에서, 검색된 회원 정보만 있는 리스트가 필요.
        // 디비에서 회원 검색 -> 검색 된 내용을 멤버담고 -> 리스트에 담기.
        // 결론, 검색된 회원의 객체가 들어있는 리스트만 필요함.
        // 기능 구현 순서
        // 1) 서비스 만들기 -> DAO 만들기 -> DAO 를 구현 클래스 구체적으로 기능 구현.
        // 화면에서는 , 서비스를 호출 -> dao 호출.
        resultList = dao.findByName(query);
        // ===========================================================

        // 검색 된 결과를, 화면에 출력하는 메서드에, 검색된 멤버 리스트를 넘겨주기.
        showSearchResults(resultList);

        // 검색된 결과가 없다면, 알림창으로 검색 결과가 없습니다.
        if (resultList.isEmpty()) {
            // JOptionPane.showMessageDialog(this, "검색 결과가 없습니다.");
            // JOptionPane.showMessageDialog(this, "파일 생성 오류 : " + e.getMessage());
            signupFrame.showDialog("검색 결과가 없습니다.");
            // System.out.println("다른 방법으로 알림등 알려줄 예정");
        }

    }

}
