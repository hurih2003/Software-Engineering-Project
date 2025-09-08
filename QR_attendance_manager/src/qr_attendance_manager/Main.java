
package qr_attendance_manager;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override

    public void start(Stage primaryStage) {
        try {
           //Download the first page - login -
            Parent root = FXMLLoader.load(getClass().getResource("login_page.fxml"));
            Scene scene = new Scene(root, 600, 400); 
            primaryStage.setTitle("QR Attendance Manager - Login");
            primaryStage.setScene(scene);
            primaryStage.show(); 
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        launch(args); // Start run program 
    }
}
    

