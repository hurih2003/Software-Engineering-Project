package ScanCamra;
import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import org.opencv.core.Mat;
public class Utils {

    public static Image mat2Image(Mat frame) {
        int width = frame.width();
        int height = frame.height();
        byte[] buffer = new byte[width * height * (int) frame.elemSize()];
        frame.get(0, 0, buffer);

        WritableImage image = new WritableImage(width, height);
        PixelWriter pw = image.getPixelWriter();
        pw.setPixels(0, 0, width, height, PixelFormat.getByteBgraInstance(), buffer, 0, width * 4);

        return image;
    }
}

