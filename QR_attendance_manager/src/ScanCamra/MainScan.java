
package ScanCamra;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainScan extends Application {
    @Override

    public void start(Stage primaryStage) {
        try {
           //Download the first page - login -
            Parent root = FXMLLoader.load(getClass().getResource("ButtonOpenCamra.fxml"));
            Scene scene = new Scene(root, 600, 400); 
            primaryStage.setTitle("QR Attendance Manager - ScanQR");
            primaryStage.setScene(scene);
            primaryStage.show(); 
        } catch (IOException e) {
        }
    }

  
    public static void main(String[] args) {
        launch(args);
    }
    
}
