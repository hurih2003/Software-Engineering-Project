
package qr_attendance_manager;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudantPageController implements Initializable {

    // Labels لعرض القيم
    @FXML
    private Label lblPresent;
    @FXML
    private Label lblAbsent;
    @FXML
    private Label lblLate;

    // TextArea لرسائل التحذير
    @FXML
    private TextArea txtWarning;

    // جدول الحضور
    @FXML
    private TableView<StudantTable> tblAttendance;
    @FXML
    private TableColumn<StudantTable, String> colDate;
    @FXML
    private TableColumn<StudantTable, String> colStatus;
    @FXML
    private TableColumn<StudantTable, String> colNotes;

    // قائمة بيانات تجريبية
    private ObservableList<StudantTable> attendanceData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // ربط الأعمدة مع خصائص الكلاس Attendance
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colNotes.setCellValueFactory(new PropertyValueFactory<>("notes"));

        // ⚡ قيم تجريبية الآن (ممكن لاحقاً تجيبها من DB)
        lblPresent.setText("20");
        lblAbsent.setText("3");
        lblLate.setText("1");

        txtWarning.setText("If you are absent for 3 consecutive days, a warning message will be sent to your guardian.\n"
                + "If your total absences reach 15 days during the semester, a formal alert will be sent.");

        // بيانات جدول تجريبية
        attendanceData = FXCollections.observableArrayList(
                new StudantTable("2025-09-01", "Present", ""),
                new StudantTable("2025-09-02", "Absent", "Sick"),
                new StudantTable("2025-09-03", "Late", "Traffic")
        );

        tblAttendance.setItems(attendanceData);
    }

    /**
     * ⚡ ميثود لتحديث القيم (مثلاً عند جلب بيانات من قاعدة البيانات)
     */
    public void updateStudentData(int present, int absent, int late, ObservableList<StudantTable> newData) {
        lblPresent.setText(String.valueOf(present));
        lblAbsent.setText(String.valueOf(absent));
        lblLate.setText(String.valueOf(late));
        tblAttendance.setItems(newData);
    }
} 
    

