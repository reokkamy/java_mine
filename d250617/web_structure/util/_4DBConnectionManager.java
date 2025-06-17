package d250617.web_structure.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 반복되는 코드 
// 1) 연결시 필요한 정보들, 변경이 안되니, 상수로 선언해서, 재사용. 
// 2) 드라이버 로딩 
// 3) 데이터베이스 연결 객체 얻기 
// 4) 자원 해제 
public class _4DBConnectionManager {
    // 반복되는 코드
    // 1) 연결시 필요한 정보들, 변경이 안되니, 상수로 선언해서, 재사용.
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "scott";
    private static final String PASSWORD = "tiger";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    // 2) 드라이버 로딩
    static {
        try {
            Class.forName(DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3) 데이터베이스 연결 객체 얻기
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 4) 자원 해제
    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        try {
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
