package d250617.web_structure.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import d250613.member_project.util.DateUtil;
import d250617.web_structure.dto._10Member;
import d250617.web_structure.util._4DBConnectionManager;

// 순서1
// 인터페이스를 구현한 구현체 클래스, JDBC 연결한 기능들 재정의, DAO 
public class _N1OracleMemberDAOImpl implements _9DAO_Inaterface {
    // 객체를 미리 선언만 해서, 초기화를 밑에서 하고, 전역처럼 사용하기.
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    // 순서2, 전체 조회 기능 만들기,
    @Override
    public List<_10Member> findAll() {
        // JDBC의 Select 하는 부분 벤치 마킹해서, 기능을 만들기,
        // JDBC 실행 순서
        // 1. 디비 서버에 접근을 위한 준비물.
        // 1) 드라이버 위치 2) 유저명 3) 패스워드 4) 디비서버의 아이피 및 포트 번호
        // 분리

        // 디비에서 조회한 한명의 회원 -> 모델 클래스로 변환 -> 멤버를 타입으로 하는 리스트에 담기,
        // 임시로 저장할 리스트
        List<_10Member> memberList = new ArrayList<>();
        try {
            conn = _4DBConnectionManager.getConnection();
            String query = "SELECT * FROM MEMBER501 ORDER BY ID DESC";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery(query); // 실제 디비에 연결해서 실행 결과를 받아옴.
            while (rs.next()) {
                // DB에서 한명의 회원 정보를 가져오기 -> 임시 변수 담기
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password2 = rs.getString("password");
                String reg_date = rs.getString("reg_date");
                // 멤버의 인스턴스 담기
                _10Member member = new _10Member(id, name, email, password2, reg_date);
                // 멤버 -> 리스트 담기
                memberList.add(member);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);
        }
        return memberList;
    }

    @Override
    public _10Member findById(int member_id) {
        // 넘어온 회원의 아이디로 , 한명의 회원을 조회하는 작업.
        // 전체 조회 기능과 비슷한 구조임.
        _10Member member = new _10Member(); // 디비에서 조회한 한명의 회원의 정보를 담을 빈 객체.
        try {
            conn = _4DBConnectionManager.getConnection();
            String query = "SELECT * FROM MEMBER501 WHERE ID = ?";
            pstmt = conn.prepareStatement(query);
            // 0617, 회원수정에서, 한명의 회원 정보를 가져오는 기능, 변경전
            // pstmt.setInt(1, 2);

            // 0617, 회원수정에서, 한명의 회원 정보를 가져오는 기능, 변경후
            pstmt.setInt(1, member_id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password2 = rs.getString("password");
                String reg_date = rs.getString("reg_date");
                member.setId(id);
                member.setName(name);
                member.setEmail(email);
                member.setPassword(password2);
                member.setReg_date(reg_date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);
        }
        return member;

    }

    @Override
    public boolean insert(_10Member member) {// member : 화면으로 부터 입력 받은 회원 정보

        try {
            conn = _4DBConnectionManager.getConnection();

            // 만약 , 자동 인덱스 생성으로 추가 할 경우
            String query = "INSERT INTO MEMBER501 (ID,NAME,PASSWORD,EMAIL,REG_DATE)" +
                    "VALUES(MEMBER501_SEQ.NEXTVAL,?,?,?,?)";

            // 5. PreparedStatement 생성
            // 요청할 SQL 문을 데이터베이스 전송할 때 사용하는 기능(API)
            // 예) PreparedStatement pstmt = conn.prepareStatement(query)
            pstmt = conn.prepareStatement(query);
            // 추가할 데이터를 ,해당 와일드카드(?) 에 해당하는 데이터 임시로 하드코딩으로 넣고 있고,
            // 화면에서 데이터를 사용자로부터 받아서 추가 할 예정.

            // 시퀀스 이용해서, 자동 순번으로 넣을 경우.
            // 0617 , 회원 가입 변경 전
            // pstmt.setString(1, "이상용");
            // pstmt.setString(2, "1234");
            // pstmt.setString(3, "lsy@naver.com");
            // pstmt.setString(4, DateUtil.getCurrentDateTime());

            // 0617 , 회원 가입 변경 후 ->
            // 화면에서 데이터를 사용자로부터 받아서 -> member 담아져 있음. -> 여기서 꺼내서 사용하기.
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, DateUtil.getCurrentDateTime());
            System.out.println("5. PreparedStatement 생성 완료");

            // 6. SQL 문 전송 및 결과값 얻기, 1) 조회 버전: executeQuery,
            // 쓰기 버전,
            int result = pstmt.executeUpdate(); // 실제로 디비에 쓰기 작업 진행.
            System.out.println(result + " 개의 데이터가 저장됨");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);
        }
        return true;
    }

    @Override
    public boolean update(_10Member member) { // 수정할 내용도 , 여기 멤버에 담아져 있습니다.
        try {
            // 0617, 회원 수정 디버깅 3,
            System.out.println("파일명 _N1OracleMemberDAOImpl.java: ");
            System.out.println("넘어온 멤버 데이터 확인");
            System.out.println(member);
            conn = _4DBConnectionManager.getConnection();
            // 변경,
            String query = "UPDATE MEMBER501 SET NAME = ?, EMAIL = ?, " +
                    "PASSWORD = ?, REG_DATE = ? WHERE ID = ?";
            pstmt = conn.prepareStatement(query);
            // 추가할 데이터를 ,해당 와일드카드(?) 에 해당하는 데이터 임시로 하드코딩으로 넣고 있고,
            // 화면에서 데이터를 사용자로부터 받아서 추가 할 예정.
            // 수정 할 내용

            // 0617, 회원 수정, 변경 전
            // pstmt.setString(1, "이상용 수정");
            // pstmt.setString(2, "1234 수정");
            // pstmt.setString(3, "lsy@naver.com 수정");
            // pstmt.setString(4, DateUtil.getCurrentDateTime());
            // pstmt.setInt(5, 1);

            // 0617, 회원 수정, 변경 후
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, DateUtil.getCurrentDateTime());
            // 주의 사항, 수정할 , 멤버의 인덱스를 받아오기.
            // 오류, 수정할 아이디를 1 번이 아니라 -> 멤버에서 id 가져와서 사용.
            // pstmt.setInt(5, 1);
            pstmt.setInt(5, member.getId());

            // 6. SQL 문 전송 및 결과값 얻기, 1) 조회 버전: executeQuery,
            // 2) 쓰기, 수정, 삭제 :executeUpdate()
            // 조회 버전
            // 예) ResultSet rs = pstmt.executeQuery(query)
            // ResultSet : 가상의 테이블, 데이터 베이스에서 조회된 데이터를 테이블 형식으로 메모리상에 저장.
            // 0 행 부터 시작 함.
            // 예) while(rs.next()){ // 0행 시작 -> 1행의 데이터가 존재 하면, 가져올 작업한다.
            // int id = rs.getInt("id");
            // String name = rs.getString("name");

            // 쓰기 버전,
            // int result = pstmt.executeUpdate()
            System.out.println("6. 전송 전 완료");
            // 오류 업데이트 시에, 메서도 호출 방법이 다름.
            // int result = pstmt.executeUpdate(query);
            int result = pstmt.executeUpdate();
            System.out.println("6-2. 전송 후 완료");
            System.out.println(result + " 개의 데이터가 수정됨");

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            // 7. 자원 반납.
            // 객체를 생성한 역순으로 반납.
            // 1) Connection 2) PreparedStatement 3) ResultSet 객체를 순서로 만들었음.
            // 해당 객체의 자원 반납 객체.close()
            // try ~ resource 구문으로 , 자동으로 autocloseable 이용하거나,

            // 변경전,
            // try {
            // // 조회 할 때만 필요
            // // if (rs != null)
            // // rs.close();
            // if (pstmt != null)
            // pstmt.close();
            // if (conn != null)
            // conn.close();
            // } catch (Exception e) {
            // // TODO: handle exception
            // }

            // 변경후,
            _4DBConnectionManager.close(null, pstmt, conn);
        }

        return true;
    }

    @Override
    public boolean delete(int member_id) {
        // 실제 테이블에서, 회원 아이디로 삭제하기.
        // _6JDBC_Delete 파일 참고해서 작업하기.
        try {
            conn = _4DBConnectionManager.getConnection();
            String query = "DELETE FROM MEMBER501 WHERE ID = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, member_id);
            int result = pstmt.executeUpdate();
            System.out.println(result + " 개의 데이터가 삭제됨");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);
        }
        return true;
    }

    // 0618, 검색 작업 중2
    @Override
    public List<_10Member> findByName(String searchName) {
        // 디비에서 검색된 회원을 -> 멤버 모델클래스에 담고 -> 리스트에 담기.
        // 반환 : 리스트
        // 참고 파일 : _8JDBC_FindName.java, 6/16
        // 검색된 모델 회원들을 담을 임시 리스트 필요함.
        List<_10Member> searchMemberList = new ArrayList<>();
        try {
            conn = _4DBConnectionManager.getConnection();
            // 변경.
            String query = "SELECT * FROM MEMBER501 WHERE NAME LIKE ?";
            pstmt = conn.prepareStatement(query);
            // 변경,: 기존은 하드코딩으로 임의로 값을 넣기 -> 동적으로 검색어를 전달 받아서, 키워드로 검색
            // 전, 0618
            // String searchKeyword = "이상용";
            // 후, 0618
            String searchKeyword = searchName;
            pstmt.setString(1, "%" + searchKeyword + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password2 = rs.getString("password");
                String reg_date = rs.getString("reg_date");
                // 1) 멤버에 담기
                _10Member member = new _10Member(id, name, email, password2, reg_date);
                // 2) 리스트에 담기
                searchMemberList.add(member);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);
        }
        return searchMemberList;
    }

}
