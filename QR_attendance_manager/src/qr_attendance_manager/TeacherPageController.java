
package qr_attendance_manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TeacherPageController implements Initializable {

    @FXML private Label lblTeacherName;
    @FXML private Label lblTeacherStatus;
    @FXML private Label lblClassName;
    @FXML private Label lblDay;

    @FXML private TableView<Student> tblStudents;
    @FXML private TableColumn<Student, String> colUsername;
    @FXML private TableColumn<Student, String> colName;
    @FXML private TableColumn<Student, String> colStatus;

    @FXML private Button btnSendReport;

    private ObservableList<Student> studentsData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // إعداد الأعمدة
        colUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        // ⚡ قيم تجريبية مؤقتة
        lblTeacherName.setText("Mr. Ahmed");
        lblTeacherStatus.setText("Present");
        lblClassName.setText("Grade 10 - A");
        lblDay.setText(LocalDate.now().toString());

        // بيانات تجريبية للطلاب
        studentsData = FXCollections.observableArrayList(
                new Student("s101", "Ali Hassan", "Present"),
                new Student("s102", "Mona Salem", "Absent"),
                new Student("s103", "Omar Nasser", "Late")
        );
        tblStudents.setItems(studentsData);

        // زر إرسال التقرير
        btnSendReport.setOnAction(e -> sendReport());
    }

    private void sendReport() {
        // ⚡ حاليا فقط يطبع في الكونسول
        System.out.println("Report Sent to Admin:");
        System.out.println("Teacher: " + lblTeacherName.getText());
        System.out.println("Class: " + lblClassName.getText());
        for (Student s : studentsData) {
            System.out.println(s.getUsername() + " - " + s.getName() + " - " + s.getStatus());
        }

        // لاحقاً: هنا تقدر ترفع البيانات لقاعدة بيانات أو ملف Excel أو PDF
    }
}
        
    

