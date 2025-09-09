package qrattendance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DatabaseConnection {
    // Connect to MySQL
    public static Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/qr_attendance"; // DB name
        String user = "root";    // MySQL username
        String password = "1234"; // MySQL password
        return DriverManager.getConnection(url, user, password);
    }
    // Insert attendance record
    public static void insertAttendance(String studentId) {
        String query = "INSERT INTO Attendance (student_id) VALUES (?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, studentId);
            pstmt.executeUpdate();
            System.out.println("✅ Attendance saved for Student ID: " + studentId);
        } catch (SQLException e) {
        }
    }
}
