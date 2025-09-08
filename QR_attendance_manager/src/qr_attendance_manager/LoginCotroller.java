
package qr_attendance_manager;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class LoginCotroller {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;
@FXML
    private void Login() {
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText().trim();
// تحقق تجريبي (Hardcoded login)
        if (username.equals("student") && password.equals("123")) {
            openPage("StudentsReport.fxml");
        } else if (username.equals("teacher") && password.equals("123")) {
            openPage("TeacherReport.fxml");
        } else if (username.equals("admin") && password.equals("123")) {
            openPage("AdminReport.fxml");
        } else if (username.equals("staff") && password.equals("123")) {
            openPage("StaffReport.fxml");
        } else {
            showAlert("Login Failed", "Invalid username or password.");
        }
    }
    private void openPage(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            Stage stage = (Stage) txtUsername.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showAlert("Error", "Could not load page: " + fxmlFile);
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}


