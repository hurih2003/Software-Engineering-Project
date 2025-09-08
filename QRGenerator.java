package qrgenerator;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.nio.file.FileSystems;
import java.nio.file.Path;
public class QRGenerator {
    public static void main(String[] args) {
        // بيانات الطالب
        String studentName = "Ahmed Ali";
        String studentID = "20251001";
        // دمج البيانات لتوليد QR
        String data = "Name: " + studentName + ", ID: " + studentID;
        // مسار حفظ الصورة
        String filePath = "studentQR.png";
        // إعدادات QR
        int width = 300;
        int height = 300;
        try {
            BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, width, height);
            Path path = FileSystems.getDefault().getPath(filePath);
            MatrixToImageWriter.writeToPath(matrix, "PNG", path);
            System.out.println("QR Code generated and saved to: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

