/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ScanCamra;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import java.util.Timer;
import java.util.TimerTask;

public class ScanCameraController {

    @FXML private ImageView cameraView;
    @FXML private Label lblResult;

    private VideoCapture capture;
    private Timer timer;

    @FXML
    private void startCamera() {
        capture = new VideoCapture(0); // 0 = الكاميرا الافتراضية
        if (!capture.isOpened()) {
            lblResult.setText("❌ Camera not found");
            return;
        }

        lblResult.setText("✅ Camera started");

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Mat frame = new Mat();
                if (capture.read(frame)) {
                    Image imageToShow = Utils.mat2Image(frame);
                    Platform.runLater(() -> cameraView.setImage(imageToShow));
                }
            }
        }, 0, 33); // ~30fps
    }

    @FXML
    private void stopCamera() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (capture != null) {
            capture.release();
        }
        lblResult.setText(" Camera stopped");
    }
}
       
    

