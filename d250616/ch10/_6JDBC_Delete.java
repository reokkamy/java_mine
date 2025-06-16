package d250616.ch10;

import java.sql.Connection;
import java.sql.PreparedStatement;

import d250616.util._4DBConnectionManager;

public class _6JDBC_Delete {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = _4DBConnectionManager.getConnection();
            String query = "DELETE FROM MEMBER501 WHERE ID = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 1);
            int result = pstmt.executeUpdate();
            System.out.println(result + " 개의 데이터가 저장됨");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);
        }
    }
}