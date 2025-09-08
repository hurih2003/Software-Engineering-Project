package qrgenerator;
import com.github.sarxos.webcam.Webcam;
import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
public class QRReaderFromCamera {
public static void main(String[] args) {
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(640, 480));
        webcam88.open();
        System.out.println("QR نحو الكاميرا...");
        while (true) {
            BufferedImage image = webcam.getImage();
            if (image == null) continue;
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            try {
                Result result = new MultiFormatReader().decode(bitmap);
                System.out.println("QR Content: " + result.getText());
                break; // اخرج من الحلقة بعد القراءة
            } catch (NotFoundException e) {
                // QR غير ظاهر بعد
            }
            try {
                Thread.sleep(100); // حتى لا تستهلك المعالج
            } catch (InterruptedException e) {
            }
        }
        webcam.close();
    }
    private static class webcam88 {
        private static void open() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        public webcam88() {
        }
    }
}
