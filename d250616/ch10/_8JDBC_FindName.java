package d250616.ch10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import d250616.util._4DBConnectionManager;

public class _8JDBC_FindName {
    public static void main(String[] args) {
        // 회원 정보 검색,
        Connection conn = null;
        PreparedStatement pstmt = null;
        // 조회라서 필요함.
        ResultSet rs = null;
        try {
            conn = _4DBConnectionManager.getConnection();
            // 변경.
            String query = "SELECT * FROM MEMBER501 WHERE NAME LIKE ?";
            pstmt = conn.prepareStatement(query);
            String searchKeyword = "이상용";
            pstmt.setString(1, "%" + searchKeyword + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password2 = rs.getString("password");
                String reg_date = rs.getString("reg_date");
                // 콘솔에서, 데이터 조회 확인.
                System.out.println("데이터 검색 결과 : ");
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