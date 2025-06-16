package d250616.ch10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import d250616.util._4DBConnectionManager;

public class _7JDBC_SelectOne {
    public static void main(String[] args) {
        // 한명의 회원 정보 조회,
        Connection conn = null;
        PreparedStatement pstmt = null;
        // 조회라서 필요함.
        ResultSet rs = null;
        try {
            conn = _4DBConnectionManager.getConnection();
            String query = "SELECT * FROM MEMBER501 WHERE ID = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 2);
            System.out.println("확인1 , pstmt setInt 코드 후");

            // 조회,
            // int result = pstmt.executeUpdate();
            System.out.println("확인2 , pstmt.executeQuery(query); 코드 전");
            // 오류 1, 메서드에 쿼리 를 넣는 부분
            rs = pstmt.executeQuery();
            System.out.println("확인3 , pstmt.executeQuery(query); 코드 후");
            // 오류 2, rs.next() 실행을 안해서
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password2 = rs.getString("password");
                String reg_date = rs.getString("reg_date");
                // 콘솔에서, 데이터 조회 확인.
                System.out.println("데이터 조회 : ");
                System.out.println("id : " + id);
                System.out.println("name : " + name);
                System.out.println("email : " + email);
                System.out.println("password2 : " + password2);
                System.out.println("reg_date : " + reg_date);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);
        }
    }
}