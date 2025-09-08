/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ScanCamra;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ButtonOpenCamraController  {

    @FXML
    private void openCamera() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ScanCamera.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();  // نافذة جديدة
            stage.setTitle("Scan QR Code");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
        }
    }
}
      
    

