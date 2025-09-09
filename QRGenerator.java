package qrattendance;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;
public class QRGenerator {
    // Generate QR Code for a given student ID
    public static void generateQRCode(String studentId, String filePath, int width, int height) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(studentId, BarcodeFormat.QR_CODE, width, height);
            Path path = FileSystems.getDefault().getPath(filePath);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
            System.out.println("QR Code generated for Student ID: " + studentId);
        } catch (WriterException | IOException e) {
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File directory = new File("qr_codes");
        if (!directory.exists()) {
        directory.mkdir();
        }
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        String filePath = "qr_codes/student_" + studentId + ".png";
        generateQRCode(studentId, filePath, 300, 300);
    }
}


