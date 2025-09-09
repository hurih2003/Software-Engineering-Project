package qrattendance;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.github.sarxos.webcam.Webcam;
import java.awt.image.BufferedImage;
public class QRScanner {
    public static void main(String[] args) {
        Webcam webcam = Webcam.getDefault();
        webcam.open();
        System.out.println("📷 QR Scanner started. Show a QR Code to the camera...");
        while (true) {
            try {
                BufferedImage image = webcam.getImage();
                if (image == null) continue;
                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                try {
                    Result result = new MultiFormatReader().decode(bitmap);
                    String studentId = result.getText();
                    // Insert into database
                    DatabaseConnection.insertAttendance(studentId);
                    // Delay to avoid duplicate scans
                    Thread.sleep(2000);
                } catch (NotFoundException e) {
                    // No QR code found in frame
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

